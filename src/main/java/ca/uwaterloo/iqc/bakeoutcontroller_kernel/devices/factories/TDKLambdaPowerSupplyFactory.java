package ca.uwaterloo.iqc.bakeoutcontroller_kernel.devices.factories;

import ca.uwaterloo.iqc.bakeoutcontroller_kernel.devices.PowerSupply;
import ca.uwaterloo.iqc.bakeoutcontroller_kernel.devices.TDKLambdaPowerSupply;
import ca.uwaterloo.iqc.bakeoutcontroller_kernel.exceptions.DeviceNotCreatedException;
import ca.uwaterloo.iqc.bakeoutcontroller_kernel.serial_ports.SerialPort;
import org.jetbrains.annotations.Contract;

import java.io.IOException;

/**
 * Created by mkononen on 06/02/17.
 */
public class TDKLambdaPowerSupplyFactory implements
        DeviceFactory<PowerSupply> {

    private SerialPort port;
    private Integer address;

    @Override
    public PowerSupply getDevice() throws DeviceNotCreatedException {
        try {
            return createPowerSupply();
        } catch (IOException error){
            throw new DeviceNotCreatedException(error);
        }
    }

    @Override
    public SerialPort getSerialPort(){
        return this.port;
    }

    @Override
    public void setSerialPort(SerialPort port){
        this.port = port;
    }

    @Override
    public Integer getAddress(){
        return this.address;
    }

    @Override
    public void setAddress(Integer address){
        this.address = address;
    }

    @Contract(" -> !null")
    private PowerSupply createPowerSupply() throws IOException {
        return new TDKLambdaPowerSupply(port.getCommunicator(), address);
    }
}
