package ca.uwaterloo.iqc.bakeoutcontroller_kernel.controllers;

import ca.uwaterloo.iqc.bakeoutcontroller_kernel.exceptions.DeviceNotCreatedException;
import gnu.io.PortInUseException;
import gnu.io.UnsupportedCommOperationException;
import ca.uwaterloo.iqc.bakeoutcontroller_kernel.views.ConnectionRequest;

/**
 * Factory for creating connections to ca.uwaterloo.iqc.bakeoutcontroller_kernel.devices
 */
public interface DeviceConnector {
    ConnectionRequest getConnectionRequest();
    void setConnectionRequest(ConnectionRequest request);

    DeviceRegistry getDeviceRegistry();
    void setDeviceRegistry(DeviceRegistry registry);
    Boolean canMakeConnections();

    void connect() throws DeviceNotCreatedException, PortInUseException,
            UnsupportedCommOperationException;
}
