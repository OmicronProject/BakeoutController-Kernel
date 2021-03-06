package ca.uwaterloo.iqc.bakeoutcontroller_kernel.unit.models.rxtx_port_configuration_factory;

import ca.uwaterloo.iqc.bakeoutcontroller_kernel.models.RXTXPortConfigurationFactory;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Contains ca.uwaterloo.iqc.bakeoutcontroller_kernel.unit tests for
 * {@link RXTXPortConfigurationFactory#setBaudRate(Integer)}
 */
public final class SetBaudRate extends RXTXPortConfigurationFactoryTestCase {

    @Test
    public void setBaudRate(){
        this.portConfigurationFactory.setBaudRate(baudRate);
        finishConstruction();

        assertEquals((int) baudRate, getBaudRateFromConfiguration());

    }

    private void finishConstruction(){
        this.portConfigurationFactory.setStopBits(stopBits);
        this.portConfigurationFactory.setDataBits(dataBits);
        this.portConfigurationFactory.setParityBits(parityBits);
    }

    private int getBaudRateFromConfiguration(){
        return this.portConfigurationFactory.getConfiguration().getBaudRate();
    }

}
