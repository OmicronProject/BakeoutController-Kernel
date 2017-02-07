package ca.uwaterloo.iqc.bakeoutcontroller_kernel.views;

import ca.uwaterloo.iqc.bakeoutcontroller_kernel.devices.factories.DeviceFactory;
import ca.uwaterloo.iqc.bakeoutcontroller_kernel.serial_ports.PortConfiguration;

/**
 * Describes an entry in the device list containing the type of device, and
 * a user-friendly representation for the UI to display.
 */
public interface DeviceListEntry {
    Class getDeviceType();

    @Override String toString();

    PortConfiguration getDefaultConfiguration();

    Boolean requiresAddress();

    DeviceFactory getDeviceFactory();
}
