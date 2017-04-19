package ca.uwaterloo.iqc.bakeoutcontroller_kernel.store;

import ca.uwaterloo.iqc.bakeoutcontroller_kernel.variables.Variable;

/**
 * The collection of variables in the store is immutable. This interface describes a type
 * to which variables can be added, and the store can thus be built
 */
public interface StoreBuilder {
    /**
     *
     * @param variable The variable to add
     */
    void addVariable(Variable variable);

    /**
     *
     * @param variable The variable to add
     */
    void removeVariable(Variable variable);

    /**
     *
     * @return The instance of the store
     */
    Store getStore();
}
