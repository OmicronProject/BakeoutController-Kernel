package ca.uwaterloo.iqc.bakeoutcontroller_kernel.unit.devices.tdk_lambda_power_supply;

import ca.uwaterloo.iqc.bakeoutcontroller_kernel.devices.TDKLambdaPowerSupply;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Contains ca.uwaterloo.iqc.bakeoutcontroller_kernel.unit tests for {@link TDKLambdaPowerSupply#getDeviceAddress()}
 */
public final class GetDeviceAddress extends TDKLambdaPowerSupplyTestCase {
    @Test
    public void getDeviceAddress(){
        assertEquals(
            this.deviceAddress, this.powerSupply.getDeviceAddress()
        );
    }
}
