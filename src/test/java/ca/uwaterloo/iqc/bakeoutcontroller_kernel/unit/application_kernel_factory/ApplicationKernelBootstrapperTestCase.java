package ca.uwaterloo.iqc.bakeoutcontroller_kernel.unit.application_kernel_factory;

import ca.uwaterloo.iqc.bakeoutcontroller_kernel.exceptions.UnableToCreateKernelException;
import ca.uwaterloo.iqc.bakeoutcontroller_kernel.ApplicationKernelFactory;
import ca.uwaterloo.iqc.bakeoutcontroller_kernel.KernelFactory;
import ca.uwaterloo.iqc.bakeoutcontroller_kernel.controllers.VoltageController;
import ca.uwaterloo.iqc.bakeoutcontroller_kernel.models.Kernel;
import ca.uwaterloo.iqc.bakeoutcontroller_kernel.serial_ports.PortDriver;
import ca.uwaterloo.iqc.bakeoutcontroller_kernel.views.VoltageReporter;
import org.junit.Before;
import ca.uwaterloo.iqc.bakeoutcontroller_kernel.unit.KernelTestCase;

import static org.junit.Assert.fail;

/**
 * Base class for all ca.uwaterloo.iqc.bakeoutcontroller_kernel.unit tests of {@link Kernel}
 */
public abstract class ApplicationKernelBootstrapperTestCase
        extends KernelTestCase {
    protected VoltageReporter mockVoltageReporter;
    protected VoltageController mockVoltageController;
    protected PortDriver mockPortDriver;
    protected KernelFactory applicationKernelBootstrapper;

    @Before
    public void setUp(){
        setupMockVoltageReporter();
        setupMockVoltageController();
        setupMockPortDriver();
        setupBootstrapper();
    }

    protected void assertKernelConstructionFails(){
        try {
            this.applicationKernelBootstrapper.getKernelInstance();
            fail("Expected an exception to be thrown");
        } catch (UnableToCreateKernelException error){
            error.printStackTrace();
        }
    }

    private void setupMockVoltageReporter(){
        mockVoltageReporter = context.mock(VoltageReporter.class);
    }

    private void setupMockVoltageController(){
        mockVoltageController = context.mock(VoltageController.class);
    }

    private void setupMockPortDriver(){
        mockPortDriver = context.mock(PortDriver.class);
    }

    private void setupBootstrapper(){
        applicationKernelBootstrapper = new ApplicationKernelFactory();
    }
}
