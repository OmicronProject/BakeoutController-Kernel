package ca.uwaterloo.iqc.bakeoutcontroller_kernel.exceptions;

/**
 * Thrown if a bounded variable is initialized with a value lower than its
 * lower bound.
 */
public class InitialValueLessThanLowerBoundException extends IllegalArgumentException {
    public InitialValueLessThanLowerBoundException(String message){
        super(message);
    }
}
