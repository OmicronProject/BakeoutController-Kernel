package ca.uwaterloo.iqc.bakeoutcontroller_kernel.variables;

/**
 * Base class for a variable that provides a getter method
 */
public abstract class AbstractVariable<T> implements Variable<T> {
    /**
     * The current value of the variable
     */
    protected T value;

    /**
     * @param value The initial value of the variable
     */
    public AbstractVariable(T value){
        this.value = value;
    }

    /**
     *
     * @return The current value of the variable
     */
    @Override
    public T getValue(){
        return value;
    }

    /**
     *
     * @return The type managed by this variable
     */
    @Override
    public Class<?> getType(){
        return value.getClass();
    }
}
