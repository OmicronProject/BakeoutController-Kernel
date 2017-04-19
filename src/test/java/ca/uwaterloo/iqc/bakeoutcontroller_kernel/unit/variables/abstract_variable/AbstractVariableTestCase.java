package ca.uwaterloo.iqc.bakeoutcontroller_kernel.unit.variables.abstract_variable;

import ca.uwaterloo.iqc.bakeoutcontroller_kernel.unit.variables.VariablesTestCase;
import ca.uwaterloo.iqc.bakeoutcontroller_kernel.variables.AbstractVariable;
import ca.uwaterloo.iqc.bakeoutcontroller_kernel.variables.Variable;

/**
 * Base class for unit tests of
 * {@link ca.uwaterloo.iqc.bakeoutcontroller_kernel.variables.AbstractVariable}
 */
public abstract class AbstractVariableTestCase extends VariablesTestCase {
    protected Variable<Double> concreteVariable;

    protected class ConcreteVariable extends AbstractVariable<Double> {
        public ConcreteVariable(Double value){
            super(value);
        }
    }
}
