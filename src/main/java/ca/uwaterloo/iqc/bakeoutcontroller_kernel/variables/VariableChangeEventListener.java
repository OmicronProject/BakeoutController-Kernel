package ca.uwaterloo.iqc.bakeoutcontroller_kernel.variables;

/**
 *
 * Describes a type capable of reacting to changes in a variable of a different type through a method.
 *
 * @param <T> The type that the listener will be listening to
 */
public interface VariableChangeEventListener<T> {
    /**
     *
     * @param newValue The new value of the listener
     */
    void onChange(T newValue);
}
