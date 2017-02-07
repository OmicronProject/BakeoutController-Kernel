package ca.uwaterloo.iqc.bakeoutcontroller_kernel.unit.devices.factories.tdk_lambda_power_supply_factory;

import ca.uwaterloo.iqc.bakeoutcontroller_kernel.devices.PowerSupply;
import ca.uwaterloo.iqc.bakeoutcontroller_kernel.devices.factories.DeviceFactory;
import ca.uwaterloo.iqc.bakeoutcontroller_kernel.devices.factories.TDKLambdaPowerSupplyFactory;
import ca.uwaterloo.iqc.bakeoutcontroller_kernel.serial_ports.SerialPort;
import org.junit.Before;
import ca.uwaterloo.iqc.bakeoutcontroller_kernel.unit.devices.factories.FactoriesTestCase;

/**
 * Base class for test cases of
 * {@link ca.uwaterloo.iqc.bakeoutcontroller_kernel.devices.factories.TDKLambdaPowerSupplyFactory}
 */
public abstract class TDKLambdaPowerSupplyFactoryTestCase extends
        FactoriesTestCase {
    protected SerialPort mockSerialPort;
    protected Integer address = 6;
    protected DeviceFactory<PowerSupply> deviceFactory;

    @Before
    public void setDeviceFactory(){
        deviceFactory = new TDKLambdaPowerSupplyFactory();
    }

    @Before
    public void setMockSerialPort(){
        mockSerialPort = context.mock(SerialPort.class);
    }

    @Before
    public void setMockCommunicator(){
        communicatorForDevice.setInputStreamData("OK");
    }
}
