package ca.uwaterloo.iqc.bakeoutcontroller_kernel.variables;

import ca.uwaterloo.iqc.bakeoutcontroller_kernel.exceptions.UnableToSetVariableException;

/**
 * Describes a variable that, in addition to being retrieved, can also be
 * set at runtime. An example of this is a control parameter, like the
 * output current of a device.
 *
 * @param <T> the type of variable
 */
public interface Mutable<T> extends Variable<T> {

    /**
     * @param newValue The desired new value of the variable
     */
    void setValue(T newValue) throws UnableToSetVariableException;
}
