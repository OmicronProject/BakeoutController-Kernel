package ca.uwaterloo.iqc.bakeoutcontroller_kernel.unit.devices.tdk_lambda_power_supply;

import ca.uwaterloo.iqc.bakeoutcontroller_kernel.devices.PowerSupply;
import ca.uwaterloo.iqc.bakeoutcontroller_kernel.exceptions.ResponseNotOKException;
import org.junit.Test;

import java.io.IOException;

/**
 * Contains ca.uwaterloo.iqc.bakeoutcontroller_kernel.unit tests for
 * {@link ca.uwaterloo.iqc.bakeoutcontroller_kernel.devices.TDKLambdaPowerSupply#setCurrent(double)}
 */
public final class SetCurrent extends TDKLambdaPowerSupplyTestCase {
    private final Double currentToSet = 3.0;

    @Test
    public void testSetCurrent() throws IOException {
        this.powerSupply.setCurrent(currentToSet);
        assertCorrectMessage(
            String.format(PowerSupply.SET_CURRENT_COMMAND, currentToSet)
        );
    }

    @Test(expected = ResponseNotOKException.class)
    public void testResponseNotOK() throws IOException {
        this.communicatorForDevice.setInputStreamData(errorMessage);
        this.powerSupply.setCurrent(currentToSet);
    }
}
