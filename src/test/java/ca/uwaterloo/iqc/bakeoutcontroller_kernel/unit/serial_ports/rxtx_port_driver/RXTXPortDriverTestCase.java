package ca.uwaterloo.iqc.bakeoutcontroller_kernel.unit.serial_ports.rxtx_port_driver;

import ca.uwaterloo.iqc.bakeoutcontroller_kernel.serial_ports.RXTXPortDriver;
import org.junit.Before;
import ca.uwaterloo.iqc.bakeoutcontroller_kernel.unit.serial_ports.SerialPortsTestCase;

/**
 * Base class for {@link RXTXPortDriver}
 */
public abstract class RXTXPortDriverTestCase extends SerialPortsTestCase {
    protected final String applicationName = "Unit Testing";
    protected RXTXPortDriver portDriver;

    @Before
    public void setUpRXTXPortDriver(){
        this.portDriver = new RXTXPortDriver(
            this.applicationName, this.mockJavaCommAPI
        );
    }
}
