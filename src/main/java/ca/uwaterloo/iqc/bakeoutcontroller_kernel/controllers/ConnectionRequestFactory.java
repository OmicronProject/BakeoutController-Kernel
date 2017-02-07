package ca.uwaterloo.iqc.bakeoutcontroller_kernel.controllers;

import ca.uwaterloo.iqc.bakeoutcontroller_kernel.serial_ports.PortConfiguration;
import ca.uwaterloo.iqc.bakeoutcontroller_kernel.views.ConnectionRequest;
import ca.uwaterloo.iqc.bakeoutcontroller_kernel.views.DeviceListEntry;

/**
 * Created by mkononen on 07/02/17.
 */
public interface ConnectionRequestFactory {
    void setDeviceListEntry(DeviceListEntry entry);
    void setAddress(Integer address);
    void setPortName(String portName);
    void setPortConfiguration(PortConfiguration configuration);

    ConnectionRequest getConnectionRequest();
}
