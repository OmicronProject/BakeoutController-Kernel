package ca.uwaterloo.iqc.bakeoutcontroller_kernel.unit.serial_ports.rxtx_port_driver;

import ca.uwaterloo.iqc.bakeoutcontroller_kernel.serial_ports.RXTXPortDriver;
import gnu.io.NoSuchPortException;
import gnu.io.PortInUseException;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Contains ca.uwaterloo.iqc.bakeoutcontroller_kernel.unit tests for
 * {@link RXTXPortDriver#getPortByName(String)}
 */
public final class GetPortByName extends RXTXPortDriverTestCase {
    private final String portName = "/dev/null";

    @Test
    public void getPortbyName() throws NoSuchPortException,
            PortInUseException {
        assertNotNull(portDriver.getPortByName(portName));
    }
}
