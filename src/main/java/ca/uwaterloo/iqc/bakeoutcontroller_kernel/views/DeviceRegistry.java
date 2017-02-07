package ca.uwaterloo.iqc.bakeoutcontroller_kernel.views;

import ca.uwaterloo.iqc.bakeoutcontroller_kernel.devices.RS232Device;

/**
 * Created by mkononen on 07/02/17.
 */
public interface DeviceRegistry {
    <DeviceType extends RS232Device> DeviceType getRS232Device(
        Class<DeviceType> deviceType
    );
}
