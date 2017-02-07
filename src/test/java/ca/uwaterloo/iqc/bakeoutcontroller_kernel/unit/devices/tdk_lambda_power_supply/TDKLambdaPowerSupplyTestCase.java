package ca.uwaterloo.iqc.bakeoutcontroller_kernel.unit.devices.tdk_lambda_power_supply;

import ca.uwaterloo.iqc.bakeoutcontroller_kernel.devices.PowerSupply;
import ca.uwaterloo.iqc.bakeoutcontroller_kernel.devices.TDKLambdaPowerSupply;
import org.junit.After;
import org.junit.Before;
import ca.uwaterloo.iqc.bakeoutcontroller_kernel.unit.devices.DevicesTestCase;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * Base class for all tests of {@link ca.uwaterloo.iqc.bakeoutcontroller_kernel.devices.TDKLambdaPowerSupply}
 */
public abstract class TDKLambdaPowerSupplyTestCase extends DevicesTestCase {

    public static final int deviceAddress = 6;
    public static final String errorMessage = "E01";
    protected PowerSupply powerSupply;

    @Before
    public void setUp() throws IOException {
        setUpPowerSupply();
    }

    private void setUpPowerSupply() throws IOException {
        this.communicatorForDevice.setInputStreamData("OK");
        powerSupply = new TDKLambdaPowerSupply(communicatorForDevice,
                deviceAddress);
        this.communicatorForDevice.clear();
    }

    @After
    public void cleanUpCommunicator(){
        this.communicatorForDevice.clear();
    }

    protected void assertCorrectMessage(String expectedMessage){
        String writtenData = this.communicatorForDevice.getOutputStreamData();
        assertEquals(expectedMessage, writtenData);
    }
}
