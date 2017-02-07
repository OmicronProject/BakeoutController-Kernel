package ca.uwaterloo.iqc.bakeoutcontroller_kernel.exceptions;

import ca.uwaterloo.iqc.bakeoutcontroller_kernel.Kernel;
import ca.uwaterloo.iqc.bakeoutcontroller_kernel.KernelFactory;

/**
 * Thrown if the {@link KernelFactory} cannot create a
 * {@link Kernel}
 */
public class UnableToCreateKernelException extends IllegalStateException {
    public UnableToCreateKernelException(String message){
        super(message);
    }
}
