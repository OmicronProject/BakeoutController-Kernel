package ca.uwaterloo.iqc.bakeoutcontroller_kernel.unit.devices.tdk_lambda_power_supply;

import ca.uwaterloo.iqc.bakeoutcontroller_kernel.devices.TDKLambdaPowerSupply;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * Contains ca.uwaterloo.iqc.bakeoutcontroller_kernel.unit tests for {@link TDKLambdaPowerSupply#getVoltage()}
 */
public final class GetVoltage extends TDKLambdaPowerSupplyTestCase {
    private final Double voltage = 3.0;

    @Before
    public void setUpCommunicator(){
        this.communicatorForDevice.setInputStreamData(voltage.toString());
    }

    @Test
    public void getVoltageHappyPath() throws IOException {
        Double voltage = this.powerSupply.getVoltage();
        assertEquals(this.voltage, voltage);
    }
}
