package ca.uwaterloo.iqc.bakeoutcontroller_kernel.unit.serial_ports;

import ca.uwaterloo.iqc.bakeoutcontroller_kernel.serial_ports.comm_port_wrapper.PortIdentifierGetter;
import org.junit.Before;
import ca.uwaterloo.iqc.bakeoutcontroller_kernel.unit.KernelTestCase;

/**
 * Base class for ca.uwaterloo.iqc.bakeoutcontroller_kernel.unit tests of {@link kernel.serial_ports}
 */
public abstract class SerialPortsTestCase extends KernelTestCase {
    protected PortIdentifierGetter mockJavaCommAPI;

    @Before
    public final void setUpMockJavaCommunicationsAPI(){
        this.mockJavaCommAPI = this.context.mock(PortIdentifierGetter.class);
    }
}
