package ca.uwaterloo.iqc.bakeoutcontroller_kernel.unit.models.device_connector;

import ca.uwaterloo.iqc.bakeoutcontroller_kernel.models.DeviceConnector;
import ca.uwaterloo.iqc.bakeoutcontroller_kernel.controllers.DeviceRegistry;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Contains ca.uwaterloo.iqc.bakeoutcontroller_kernel.unit tests for
 * {@link DeviceConnector#getDeviceRegistry()}
 */
public final class GetDeviceRegistry extends DeviceConnectorTestCase {
    private final DeviceRegistry registry = context.mock(DeviceRegistry.class);

    @Before
    public void setDeviceRegistry(){
        deviceConnector.setDeviceRegistry(registry);
    }

    @Test
    public void getDeviceRegistry(){
        assertEquals(
                registry,
                deviceConnector.getDeviceRegistry()
        );
    }
}
