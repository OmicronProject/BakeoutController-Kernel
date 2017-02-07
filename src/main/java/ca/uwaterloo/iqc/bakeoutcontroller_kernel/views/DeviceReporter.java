package ca.uwaterloo.iqc.bakeoutcontroller_kernel.views;

import java.util.List;

/**
 * Returns a list of implemented ca.uwaterloo.iqc.bakeoutcontroller_kernel.devices
 */
public interface DeviceReporter {
    /**
     * @return A list of ca.uwaterloo.iqc.bakeoutcontroller_kernel.devices that require use of an RS232 port
     */
    List<DeviceListEntry> getRS232Devices();
}
