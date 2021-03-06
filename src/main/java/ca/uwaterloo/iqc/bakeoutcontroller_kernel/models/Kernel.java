package ca.uwaterloo.iqc.bakeoutcontroller_kernel.models;

import ca.uwaterloo.iqc.bakeoutcontroller_kernel.devices.DeviceList;
import ca.uwaterloo.iqc.bakeoutcontroller_kernel.controllers.ConnectionRequestFactory;
import ca.uwaterloo.iqc.bakeoutcontroller_kernel.controllers.RS232PortConfigurationFactory;
import ca.uwaterloo.iqc.bakeoutcontroller_kernel.serial_ports.PortDriver;
import ca.uwaterloo.iqc.bakeoutcontroller_kernel.serial_ports.SerialPort;
import ca.uwaterloo.iqc.bakeoutcontroller_kernel.views.CommPortReporter;
import ca.uwaterloo.iqc.bakeoutcontroller_kernel.views.DeviceReporter;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Contains methods for working with application hardware, getting the
 * necessary views and controllers for working with the UI
 */
public final class Kernel implements ca.uwaterloo.iqc.bakeoutcontroller_kernel.Kernel, CommPortReporter {

    /**
     * The driver responsible for managing serial ports
     */
    private PortDriver portDriver;

    /**
     * @param portDriver The driver to be used for managing the RS232 serial
     *                   port
     */
    public Kernel(PortDriver portDriver){
        this.portDriver = portDriver;
    }

    /**
     * @return An implementation of {@link CommPortReporter} that can report
     * serial port names
     */
    @Contract(pure = true)
    @Override public CommPortReporter getCommPortReporter(){
        return this;
    }

    /**
     * @return The names of serial ports available on this machine
     */
    @Override public List<String> getSerialPortNames(){
        return this.portDriver.getSerialPortNames();
    }

    /**
     * @return The list of available ca.uwaterloo.iqc.bakeoutcontroller_kernel.devices that can be instantiated
     */
    @Contract(" -> !null")
    @Override public DeviceReporter getDeviceReporter(){
        return new DeviceList();
    }

    /**
     * @param portName The name of the port to be determined whether it is
     *                 open or not
     * @return True if the port is in use, otherwise false
     */
    @NotNull
    @Override public Boolean isPortInUse(String portName){
        SerialPort port = portDriver.getPortByName(portName);
        return port.isPortOpen();
    }

    /**
     * @return A factory capable of constructing port configurations for an
     * RS232 port
     */
    @Contract(" -> !null")
    @Override public RS232PortConfigurationFactory
    getRS232PortConfigurationFactory(){
        return new RXTXPortConfigurationFactory();
    }

    @Contract(" -> !null")
    @Override
    public ca.uwaterloo.iqc.bakeoutcontroller_kernel.controllers.DeviceConnector getDeviceConnector(){
        return new DeviceConnector();
    }

    @Override
    public PortDriver getPortDriver(){
        return this.portDriver;
    }

    @Contract(" -> !null")
    @Override
    public ConnectionRequestFactory getConnectionRequestFactory(){
        return new StandaloneConnectionRequest();
    }
}
