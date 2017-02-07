package ca.uwaterloo.iqc.bakeoutcontroller_kernel.devices;

import ca.uwaterloo.iqc.bakeoutcontroller_kernel.views.DeviceListEntry;
import ca.uwaterloo.iqc.bakeoutcontroller_kernel.views.DeviceReporter;

import java.util.List;
import java.util.Vector;

/**
 * Implements a list that states which ca.uwaterloo.iqc.bakeoutcontroller_kernel.devices are available to this
 * application
 */
public final class DeviceList implements DeviceReporter {
    private final List<DeviceListEntry> deviceList;

    public DeviceList(){
        deviceList = new Vector<>();
        deviceList.add(
                new TDKLambdaPowerSupplyListEntry()
        );
    }

    @Override public List<DeviceListEntry> getRS232Devices(){
        return deviceList;
    }
}
