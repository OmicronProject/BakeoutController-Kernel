package ca.uwaterloo.iqc.bakeoutcontroller_kernel.unit.application_kernel_factory;

import ca.uwaterloo.iqc.bakeoutcontroller_kernel.exceptions.UnableToCreateKernelException;
import ca.uwaterloo.iqc.bakeoutcontroller_kernel.ApplicationKernelFactory;
import ca.uwaterloo.iqc.bakeoutcontroller_kernel.Kernel;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Contains ca.uwaterloo.iqc.bakeoutcontroller_kernel.unit tests for
 * {@link ApplicationKernelFactory#getKernelInstance()}
 */
public final class GetKernelInstance extends
        ApplicationKernelBootstrapperTestCase {

    @Test(expected = UnableToCreateKernelException.class)
    public void unfinishedKernel(){
        this.applicationKernelBootstrapper.getKernelInstance();
    }

    @Test
    public void finishedKernel(){
        constructKernelFactory();
        Kernel kernel = this.applicationKernelBootstrapper.getKernelInstance();
        assertNotNull(kernel);
    }

    private void constructKernelFactory(){
        applicationKernelBootstrapper.setPortDriver(mockPortDriver);
    }
}
