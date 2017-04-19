package ca.uwaterloo.iqc.bakeoutcontroller_kernel.variables;

import ca.uwaterloo.iqc.bakeoutcontroller_kernel.exceptions.UnableToSetVariableException;

/**
 * Base class for an interactive variable that has some constraint applied
 * to it
 */
public interface Constrained<T> extends Mutable<T> {

    /**
     * @param newValue The value to be set
     * @throws UnableToSetVariableException if the value could not be set
     */
    @Override
    void setValue(T newValue) throws UnableToSetVariableException;

    /**
     * @param value The value for which the check is to be made if the value
     *              can be set
     * @return {@link Boolean#TRUE} if the value is allowed, otherwise
     * {@link Boolean#FALSE}
     */
    Boolean isAllowedValue(T value);
}
