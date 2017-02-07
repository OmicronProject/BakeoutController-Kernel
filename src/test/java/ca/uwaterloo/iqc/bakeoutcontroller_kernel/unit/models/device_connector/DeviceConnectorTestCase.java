package ca.uwaterloo.iqc.bakeoutcontroller_kernel.unit.models.device_connector;

import ca.uwaterloo.iqc.bakeoutcontroller_kernel.models.DeviceConnector;
import ca.uwaterloo.iqc.bakeoutcontroller_kernel.views.DeviceListEntry;
import org.junit.Before;
import ca.uwaterloo.iqc.bakeoutcontroller_kernel.unit.models.ModelsTestCase;

/**
 * Base class for tests of {@link ca.uwaterloo.iqc.bakeoutcontroller_kernel.models.DeviceConnector}
 */
public abstract class DeviceConnectorTestCase extends ModelsTestCase {
    protected DeviceConnector deviceConnector;
    protected DeviceListEntry deviceListEntry;

    @Before
    public void setDeviceConnector(){
        deviceConnector = new DeviceConnector();
    }

    @Before
    public void setDeviceListEntry(){
        deviceListEntry = context.mock(DeviceListEntry.class);
    }
}
