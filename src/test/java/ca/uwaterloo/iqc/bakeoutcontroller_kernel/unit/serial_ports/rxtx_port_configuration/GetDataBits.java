package ca.uwaterloo.iqc.bakeoutcontroller_kernel.unit.serial_ports.rxtx_port_configuration;

import ca.uwaterloo.iqc.bakeoutcontroller_kernel.serial_ports.RXTXPortConfiguration;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Contains ca.uwaterloo.iqc.bakeoutcontroller_kernel.unit tests for {@link RXTXPortConfiguration#getDataBits()}
 */
public final class GetDataBits extends RXTXPortConfigurationTestCase {
    @Test
    public void getDataBits(){
        assertEquals(this.dataBits, this.portConfiguration.getDataBits());
    }
}
