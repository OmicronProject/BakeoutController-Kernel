package ca.uwaterloo.iqc.bakeoutcontroller_kernel.store;

import ca.uwaterloo.iqc.bakeoutcontroller_kernel.variables.Variable;
import java.util.List;

/**
 * Describes a store.
 */
public interface Store extends Iterable<Variable> {
    /**
     *
     * @param <T> The type of variable that is being managed
     * @return A list of variables that are being managed by this store
     */
    <T extends Variable> List<Class<T>> getVariables();

    /**
     *
     * @param variableType The class of variable that is to be retrieved by this store
     * @param <T> The type of variable that is pulled
     * @return The instance of the variable managed by this store
     */
    <T extends Variable> T getVariable(Class<T> variableType);

    /**
     *
     * @param variableType The variable to get
     * @param <T> The types that belong to the class
     * @return True if the type is in the store and False if not
     */
    <T extends Variable> Boolean isTypeInStore(Class<T> variableType);
}
