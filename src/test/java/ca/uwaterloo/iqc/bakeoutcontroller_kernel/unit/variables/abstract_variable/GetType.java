package ca.uwaterloo.iqc.bakeoutcontroller_kernel.unit.variables.abstract_variable;

import ca.uwaterloo.iqc.bakeoutcontroller_kernel.variables.Variable;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * Check that the type returned by the variable is correct
 */
@RunWith(JUnitQuickcheck.class)
public final class GetType extends AbstractVariableTestCase {
    @Property
    public void getType(Double randomDouble){
        Variable<Double> variable = new ConcreteVariable(randomDouble);

        assertEquals(
                Double.class,
                variable.getType()
        );
    }
}
