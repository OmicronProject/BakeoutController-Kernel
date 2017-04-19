package ca.uwaterloo.iqc.bakeoutcontroller_kernel.variables;

import java.util.List;

/**
 * Base class for variables that have a set of allowed values.
 */
public interface Enumerated<T> extends Constrained<T> {
    /**
     * @return The allowed values for this variable
     */
    List<T> getAllowedValues();
}
