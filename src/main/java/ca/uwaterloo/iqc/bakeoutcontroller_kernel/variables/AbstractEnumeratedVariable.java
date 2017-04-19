package ca.uwaterloo.iqc.bakeoutcontroller_kernel.variables;

import ca.uwaterloo.iqc.bakeoutcontroller_kernel.exceptions.UnableToSetVariableException;

import java.util.Collection;
import java.util.Set;

/**
 *
 * @param <T> The type managed by the variable
 */
public abstract class AbstractEnumeratedVariable<T> extends AbstractMutableVariable<T> implements Enumerated<T> {
    /**
     * The allowed values
     */
    private final Set<T> allowedValues;

    /**
     *
     * @param initialValue The initial value
     * @param allowedValues The allowed values
     * @throws UnableToSetVariableException if the initial value is not an allowed value of this variable
     */
    public AbstractEnumeratedVariable(T initialValue, Set<T> allowedValues) throws UnableToSetVariableException {
        super(initialValue);
        assertAllowedValue(initialValue, allowedValues);
        this.allowedValues = allowedValues;
    }

    @Override
    public void setValue(T value) throws UnableToSetVariableException {
        assertAllowedValue(value, getAllowedValues());
        this.value = value;
    }

    /**
     *
     * @return The allowed values for this variable
     */
    @Override
    public Set<T> getAllowedValues(){
        return this.allowedValues;
    }

    @Override
    public Boolean isAllowedValue(T value){
        return this.getAllowedValues().contains(value);
    }

    private static <T> void assertAllowedValue(T value, Collection<T> allowedValues) throws
            UnableToSetVariableException {
        if (!allowedValues.contains(value)){
            throw new UnableToSetVariableException(
                    String.format("The value %s is not allowed", value)
            );
        }
    }
}
