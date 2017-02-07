package ca.uwaterloo.iqc.bakeoutcontroller_kernel.devices.factories;

import ca.uwaterloo.iqc.bakeoutcontroller_kernel.devices.RS232Device;
import ca.uwaterloo.iqc.bakeoutcontroller_kernel.exceptions.DeviceNotCreatedException;
import ca.uwaterloo.iqc.bakeoutcontroller_kernel.serial_ports.SerialPort;

/**
 * Created by mkononen on 06/02/17.
 */
public interface DeviceFactory<T extends RS232Device> {
    T getDevice() throws DeviceNotCreatedException;

    SerialPort getSerialPort();

    void setSerialPort(SerialPort port);

    Integer getAddress();

    void setAddress(Integer address);
}
