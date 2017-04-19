package ca.uwaterloo.iqc.bakeoutcontroller_kernel.variables;

/**
 * Base class for variables that have a lower and upper bound on their value
 * @param <T> The type of value. This must implement {@link Comparable} in
 *           order to allow comparisons between lower and upper bounds to be
 *           made.
 */
public interface Bounded<T extends Comparable<T>> extends
        Constrained<T> {
    /**
     * @return The lower bound for this variable
     */
    T getLowerBound();

    /**
     * @return The upper bound for this variable
     */
    T getUpperBound();
}
