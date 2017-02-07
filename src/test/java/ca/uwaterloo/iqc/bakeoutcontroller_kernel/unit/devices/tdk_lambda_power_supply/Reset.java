package ca.uwaterloo.iqc.bakeoutcontroller_kernel.unit.devices.tdk_lambda_power_supply;

import ca.uwaterloo.iqc.bakeoutcontroller_kernel.devices.PowerSupply;
import ca.uwaterloo.iqc.bakeoutcontroller_kernel.devices.TDKLambdaPowerSupply;
import org.junit.Test;

import java.io.IOException;

/**
 * Contains ca.uwaterloo.iqc.bakeoutcontroller_kernel.unit tests for {@link TDKLambdaPowerSupply#reset()}
 */
public final class Reset extends TDKLambdaPowerSupplyTestCase {
    @Test
    public void testReset() throws IOException {
        this.powerSupply.reset();
        assertCorrectMessage(PowerSupply.RESET_COMMAND);
    }
}
