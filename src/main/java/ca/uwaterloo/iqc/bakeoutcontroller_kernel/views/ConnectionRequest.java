package ca.uwaterloo.iqc.bakeoutcontroller_kernel.views;

import ca.uwaterloo.iqc.bakeoutcontroller_kernel.serial_ports.PortConfiguration;

/**
 * Created by mkononen on 07/02/17.
 */
public interface ConnectionRequest {
    DeviceListEntry getDeviceListEntry();

    Integer getAddress();

    String getPortName();

    PortConfiguration getPortConfiguration();
}
