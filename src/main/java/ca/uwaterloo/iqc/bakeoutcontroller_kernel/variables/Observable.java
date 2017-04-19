package ca.uwaterloo.iqc.bakeoutcontroller_kernel.variables;

/**
 * Describes a variable to which listeners can subscribe, and will be
 * notified of any change in variable.
 *
 * @apiNote Observable variables extend Mutable variables, as the listeners are notified when the variable changes.
 * There isn't much point in adding a listener to a variable that doesn't change
 */
public interface Observable<T> extends Mutable<T> {
    /**
     *
     * @param listener The listener to add
     * @implNote There is no way to remove listeners, as listeners should be
     * written in as a weak reference. Listening to a variable should not impede
     * garbage collection
     */
    void addListener(VariableChangeEventListener<T> listener);
}
