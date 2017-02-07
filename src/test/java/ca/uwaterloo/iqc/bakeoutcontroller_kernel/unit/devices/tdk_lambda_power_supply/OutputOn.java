package ca.uwaterloo.iqc.bakeoutcontroller_kernel.unit.devices.tdk_lambda_power_supply;

import ca.uwaterloo.iqc.bakeoutcontroller_kernel.devices.PowerSupply;
import ca.uwaterloo.iqc.bakeoutcontroller_kernel.devices.TDKLambdaPowerSupply;
import org.junit.Test;

import java.io.IOException;

/**
 * Contains ca.uwaterloo.iqc.bakeoutcontroller_kernel.unit tests for {@link TDKLambdaPowerSupply#outputOn()}
 */
public final class OutputOn extends TDKLambdaPowerSupplyTestCase {
    @Test
    public void testOutputOn() throws IOException {
        this.powerSupply.outputOn();
        assertCorrectMessage(
            String.format(PowerSupply.SET_OUTPUT_COMMAND, PowerSupply.ON)
        );
    }
}
