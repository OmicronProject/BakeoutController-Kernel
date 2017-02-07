package ca.uwaterloo.iqc.bakeoutcontroller_kernel.unit.devices.tdk_lambda_power_supply;

import ca.uwaterloo.iqc.bakeoutcontroller_kernel.devices.PowerSupply;
import ca.uwaterloo.iqc.bakeoutcontroller_kernel.devices.TDKLambdaPowerSupply;
import org.junit.Test;

import java.io.IOException;

/**
 * Contains ca.uwaterloo.iqc.bakeoutcontroller_kernel.unit tests for {@link TDKLambdaPowerSupply#outputOff()}
 */
public final class OutputOff extends TDKLambdaPowerSupplyTestCase {
    @Test
    public void testOutputOff() throws IOException {
        this.powerSupply.outputOff();
        assertCorrectMessage(
            String.format(PowerSupply.SET_OUTPUT_COMMAND, PowerSupply.OFF)
        );
    }
}
