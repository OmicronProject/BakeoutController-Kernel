package ca.uwaterloo.iqc.bakeoutcontroller_kernel.exceptions;

/**
 * Thrown if a bounded variable is initialized with a value bigger than the upper bound
 */
public class InitialValueGreaterThanUpperBoundException extends IllegalArgumentException {
    public InitialValueGreaterThanUpperBoundException(String message){
        super(message);
    }
}
