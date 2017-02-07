package ca.uwaterloo.iqc.bakeoutcontroller_kernel.unit.models.rxtx_port_configuration_factory;

import ca.uwaterloo.iqc.bakeoutcontroller_kernel.controllers.RS232PortConfigurationFactory;
import ca.uwaterloo.iqc.bakeoutcontroller_kernel.models.RXTXPortConfigurationFactory;
import ca.uwaterloo.iqc.bakeoutcontroller_kernel.serial_ports.PortConfiguration;
import org.junit.Before;
import ca.uwaterloo.iqc.bakeoutcontroller_kernel.unit.models.ModelsTestCase;

/**
 * Base class for ca.uwaterloo.iqc.bakeoutcontroller_kernel.unit tests of
 * {@link RXTXPortConfigurationFactory}
 */
public abstract class RXTXPortConfigurationFactoryTestCase extends
        ModelsTestCase {
    protected RS232PortConfigurationFactory portConfigurationFactory;

    protected static final Integer baudRate = 9001;
    protected static final Integer dataBits = 8;
    protected static final Integer stopBits = 0;
    protected static final Integer parityBits = 4;


    @Before
    public void setPortConfigurationFactory(){
        this.portConfigurationFactory = new RXTXPortConfigurationFactory();
    }

    protected PortConfiguration getConstructedConfiguration(){
        return this.portConfigurationFactory.getConfiguration();
    }
}
