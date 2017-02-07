package ca.uwaterloo.iqc.bakeoutcontroller_kernel.unit.serial_ports.rxtx_port_configuration;

import ca.uwaterloo.iqc.bakeoutcontroller_kernel.serial_ports.RXTXPortConfiguration;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Contains ca.uwaterloo.iqc.bakeoutcontroller_kernel.unit tests for {@link RXTXPortConfiguration#getBaudRate()}
 */
public final class GetBaudRate extends RXTXPortConfigurationTestCase {
    @Test
    public void getBaudRate(){
        assertEquals(this.baudRate, this.portConfiguration.getBaudRate());
    }
}
