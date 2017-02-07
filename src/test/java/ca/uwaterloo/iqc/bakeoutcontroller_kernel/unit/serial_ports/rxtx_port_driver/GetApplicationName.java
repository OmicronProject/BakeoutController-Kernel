package ca.uwaterloo.iqc.bakeoutcontroller_kernel.unit.serial_ports.rxtx_port_driver;

import ca.uwaterloo.iqc.bakeoutcontroller_kernel.serial_ports.RXTXPortDriver;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Base class for {@link RXTXPortDriver#getApplicationName()}
 */
public final class GetApplicationName extends RXTXPortDriverTestCase {
    @Test
    public void getApplicationName(){
        assertEquals(
            this.applicationName, this.portDriver.getApplicationName()
        );
    }
}
