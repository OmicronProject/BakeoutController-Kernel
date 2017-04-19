package ca.uwaterloo.iqc.bakeoutcontroller_kernel.variables;

import ca.uwaterloo.iqc.bakeoutcontroller_kernel.exceptions.UnableToSetVariableException;

/**
 * Abstract class that provides helper methods for getting and setting the
 * value of a variable
 */
public abstract class AbstractMutableVariable<T> extends
        AbstractVariable<T> implements Mutable<T> {

    public AbstractMutableVariable(T value){
        super(value);
    }

    @Override
    public void setValue(T value) throws UnableToSetVariableException {
        this.value = value;
    }
}
