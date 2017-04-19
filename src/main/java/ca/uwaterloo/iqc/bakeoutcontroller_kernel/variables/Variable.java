package ca.uwaterloo.iqc.bakeoutcontroller_kernel.variables;

/**
 * Base class for all variables
 * @param <T> The type of value that is returned by this variable
 */
public interface Variable<T> {
    /**
     * @return The current value of the variable
     */
    T getValue();

    /**
     *
     * @return The type being managed by this variable
     */
    Class<?> getType();
}
