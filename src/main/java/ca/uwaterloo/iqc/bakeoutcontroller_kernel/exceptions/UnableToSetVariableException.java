package ca.uwaterloo.iqc.bakeoutcontroller_kernel.exceptions;

import ca.uwaterloo.iqc.bakeoutcontroller_kernel.variables.Constrained;

/**
 * Thrown if an attempt was made to set a
 * {@link Constrained}
 * to a value that was not allowed.
 */
public class UnableToSetVariableException extends Exception {
}
