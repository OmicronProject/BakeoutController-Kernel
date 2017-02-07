package ca.uwaterloo.iqc.bakeoutcontroller_kernel.models;

import ca.uwaterloo.iqc.bakeoutcontroller_kernel.devices.factories.DeviceFactory;
import ca.uwaterloo.iqc.bakeoutcontroller_kernel.exceptions.DeviceNotCreatedException;
import gnu.io.PortInUseException;
import gnu.io.UnsupportedCommOperationException;
import ca.uwaterloo.iqc.bakeoutcontroller_kernel.Kernel;
import ca.uwaterloo.iqc.bakeoutcontroller_kernel.controllers.DeviceRegistry;
import ca.uwaterloo.iqc.bakeoutcontroller_kernel.serial_ports.SerialPort;
import ca.uwaterloo.iqc.bakeoutcontroller_kernel.views.ConnectionRequest;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;

/**
 */
public final class DeviceConnector implements
        ca.uwaterloo.iqc.bakeoutcontroller_kernel.controllers.DeviceConnector {
    private ConnectionRequest request;
    private DeviceRegistry deviceRegistry;

    @Autowired
    private Kernel kernel;

    @Override
    public ConnectionRequest getConnectionRequest(){
        return request;
    }

    @Override
    public void setConnectionRequest(ConnectionRequest request){
        this.request = request;
    }

    @Override
    public DeviceRegistry getDeviceRegistry(){
        return this.deviceRegistry;
    }

    @Override
    public void setDeviceRegistry(DeviceRegistry registry){
        this.deviceRegistry = registry;
    }

    @Override
    public Boolean canMakeConnections(){
        return (this.hasConnectionRequest() && this.hasRegistry());
    }

    @Override
    public void connect() throws DeviceNotCreatedException,
            PortInUseException, UnsupportedCommOperationException
    {
        DeviceFactory factory = request.getDeviceListEntry()
                .getDeviceFactory();
        configureDeviceFactory(factory);

        deviceRegistry.registerRS232Device(factory.getDevice());
    }

    private void configureDeviceFactory(DeviceFactory factory) throws
            PortInUseException, UnsupportedCommOperationException {
        SerialPort port = openSerialPort(request.getPortName());
        port.setConfig(request.getPortConfiguration());

        factory.setAddress(request.getAddress());
        factory.setSerialPort(
                port
        );
    }

    private SerialPort openSerialPort(String portName) throws
            PortInUseException {
        SerialPort port = kernel.getPortDriver().getPortByName(portName);

        port.open();

        return port;
    }

    @NotNull
    @Contract(pure = true)
    private Boolean hasConnectionRequest(){
        return this.request != null;
    }

    @NotNull
    @Contract(pure = true)
    private Boolean hasRegistry(){
        return this.deviceRegistry != null;
    }
}
