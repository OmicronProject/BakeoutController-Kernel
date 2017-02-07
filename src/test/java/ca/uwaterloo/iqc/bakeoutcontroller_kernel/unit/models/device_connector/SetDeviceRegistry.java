package ca.uwaterloo.iqc.bakeoutcontroller_kernel.unit.models.device_connector;

import ca.uwaterloo.iqc.bakeoutcontroller_kernel.controllers.DeviceRegistry;
import ca.uwaterloo.iqc.bakeoutcontroller_kernel.models.DeviceConnector;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Contains ca.uwaterloo.iqc.bakeoutcontroller_kernel.unit tests for
 * {@link DeviceConnector#setDeviceRegistry(DeviceRegistry)}
 *
 */
public final class SetDeviceRegistry extends DeviceConnectorTestCase {
    private DeviceRegistry registry = context.mock(DeviceRegistry.class);

    @Test
    public void setDeviceRegistry(){
        deviceConnector.setDeviceRegistry(registry);

        assertEquals(
                registry,
                deviceConnector.getDeviceRegistry()
        );
    }
}
