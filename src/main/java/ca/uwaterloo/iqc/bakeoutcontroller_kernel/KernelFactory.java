package ca.uwaterloo.iqc.bakeoutcontroller_kernel;

import ca.uwaterloo.iqc.bakeoutcontroller_kernel.exceptions.UnableToCreateKernelException;
import ca.uwaterloo.iqc.bakeoutcontroller_kernel.serial_ports.PortDriver;

/**
 * Describes methods for a bean to bootstrap the application kernel. This is
 * a singleton factory.
 */
public interface KernelFactory {
    /**
     * @param newPortDriver The new {@link PortDriver} to be used. The
     *                      purpose of the {@link PortDriver} is to manage
     *                      calls to RXTX, and to retrieve serial ports
     */
    void setPortDriver(PortDriver newPortDriver);

    /**
     * @return The instance of the kernel that is being managed here
     * @throws UnableToCreateKernelException if the kernel cannot be created
     */
    Kernel getKernelInstance() throws UnableToCreateKernelException;

    /**
     * @return True if the kernel can be started, otherwise False.
     */
    Boolean canKernelBeStarted();
}
