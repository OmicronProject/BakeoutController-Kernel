package ca.uwaterloo.iqc.bakeoutcontroller_kernel.unit.serial_ports.rxtx_port_configuration;

import ca.uwaterloo.iqc.bakeoutcontroller_kernel.serial_ports.RXTXPortConfiguration;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Base class for ca.uwaterloo.iqc.bakeoutcontroller_kernel.unit tests of {@link RXTXPortConfiguration#getStopBits()}
 */
public final class GetStopBits extends RXTXPortConfigurationTestCase {
    @Test
    public void getStopBits(){
        assertEquals(this.stopBits, this.portConfiguration.getStopBits());
    }
}
