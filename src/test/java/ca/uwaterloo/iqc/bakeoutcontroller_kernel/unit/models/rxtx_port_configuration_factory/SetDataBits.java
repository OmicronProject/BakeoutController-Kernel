package ca.uwaterloo.iqc.bakeoutcontroller_kernel.unit.models.rxtx_port_configuration_factory;

import ca.uwaterloo.iqc.bakeoutcontroller_kernel.models.RXTXPortConfigurationFactory;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Contains ca.uwaterloo.iqc.bakeoutcontroller_kernel.unit tests for
 * {@link RXTXPortConfigurationFactory#setDataBits(Integer)}
 */
public final class SetDataBits extends RXTXPortConfigurationFactoryTestCase {
    @Test
    public void setDataBits(){
        this.portConfigurationFactory.setDataBits(dataBits);
        finishConstruction();

        assertEquals(
                (int) dataBits,
                this.portConfigurationFactory.getConfiguration().getDataBits()
        );
    }

    private void finishConstruction(){
        this.portConfigurationFactory.setBaudRate(baudRate);
        this.portConfigurationFactory.setStopBits(stopBits);
        this.portConfigurationFactory.setParityBits(parityBits);
    }
}
