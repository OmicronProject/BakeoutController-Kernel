package ca.uwaterloo.iqc.bakeoutcontroller_kernel.unit.devices.tdk_lambda_power_supply;

import ca.uwaterloo.iqc.bakeoutcontroller_kernel.devices.TDKLambdaPowerSupply;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * Contains ca.uwaterloo.iqc.bakeoutcontroller_kernel.unit tests for {@link TDKLambdaPowerSupply#getCurrent()}
 */
public final class GetCurrent extends TDKLambdaPowerSupplyTestCase {
    private final Double current = 1.0;

    @Before
    public void setUpCommunicator(){
        this.communicatorForDevice.setInputStreamData(current.toString());
    }

    @Test
    public void testGetCurrent() throws IOException {
        Double current = this.powerSupply.getCurrent();
        assertEquals(this.current, current);
    }
}
