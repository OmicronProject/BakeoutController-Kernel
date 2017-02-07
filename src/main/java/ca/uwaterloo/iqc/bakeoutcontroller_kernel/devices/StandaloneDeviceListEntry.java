package ca.uwaterloo.iqc.bakeoutcontroller_kernel.devices;

import ca.uwaterloo.iqc.bakeoutcontroller_kernel.devices.factories.DeviceFactory;
import ca.uwaterloo.iqc.bakeoutcontroller_kernel.serial_ports.PortConfiguration;
import ca.uwaterloo.iqc.bakeoutcontroller_kernel.serial_ports.RXTXPortConfiguration;
import ca.uwaterloo.iqc.bakeoutcontroller_kernel.views.DeviceListEntry;

/**
 * Implements a human-readable data structure containing a name for a
 * device, and the type to use for constructing the device.
 */
public abstract class StandaloneDeviceListEntry implements DeviceListEntry {
    private final Class deviceType;
    private final String deviceName;
    private final DeviceFactory deviceFactory;

    public StandaloneDeviceListEntry(Class deviceType, String deviceName,
                                     DeviceFactory deviceFactory){
        this.deviceType = deviceType;
        this.deviceName = deviceName;
        this.deviceFactory = deviceFactory;
    }

    @Override public Class getDeviceType(){
        return deviceType;
    }

    @Override public String toString(){
        return deviceName;
    }

    @Override public PortConfiguration getDefaultConfiguration(){
        return new RXTXPortConfiguration(
                PortConfiguration.BAUD_RATE_9600,
                PortConfiguration.STOPBITS_1,
                PortConfiguration.DATABITS_8,
                PortConfiguration.PARITY_NONE
            );
    }

    @Override public Boolean requiresAddress(){
        return true;
    }

    @Override public DeviceFactory getDeviceFactory(){
        return deviceFactory;
    }
}
