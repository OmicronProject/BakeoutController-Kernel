package ca.uwaterloo.iqc.bakeoutcontroller_kernel.devices.factories;

import ca.uwaterloo.iqc.bakeoutcontroller_kernel.devices.RS232Device;
import ca.uwaterloo.iqc.bakeoutcontroller_kernel.exceptions.DeviceNotCreatedException;
import ca.uwaterloo.iqc.bakeoutcontroller_kernel.serial_ports.SerialPort;

/**
 * Created by mkononen on 06/02/17.
 */
public interface DeviceFactory<DeviceType extends RS232Device> {
    DeviceType getDevice() throws DeviceNotCreatedException;

    SerialPort getSerialPort();

    void setSerialPort(SerialPort port);

    Integer getAddress();

    void setAddress(Integer address);
}
