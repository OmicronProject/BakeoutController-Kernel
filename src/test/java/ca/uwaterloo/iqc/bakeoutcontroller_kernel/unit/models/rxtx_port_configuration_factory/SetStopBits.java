package ca.uwaterloo.iqc.bakeoutcontroller_kernel.unit.models.rxtx_port_configuration_factory;

import ca.uwaterloo.iqc.bakeoutcontroller_kernel.models.RXTXPortConfigurationFactory;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Contains ca.uwaterloo.iqc.bakeoutcontroller_kernel.unit tests for
 * {@link RXTXPortConfigurationFactory#setStopBits(Integer)}
 */
public final class SetStopBits extends RXTXPortConfigurationFactoryTestCase {
    @Test
    public void setStopBits(){
        this.portConfigurationFactory.setStopBits(stopBits);
        finishConstruction();

        assertEquals(
                (int) stopBits,
                this.portConfigurationFactory.getConfiguration().getStopBits()
        );
    }

    private void finishConstruction(){
        this.portConfigurationFactory.setBaudRate(baudRate);
        this.portConfigurationFactory.setParityBits(parityBits);
        this.portConfigurationFactory.setDataBits(dataBits);
    }
}
