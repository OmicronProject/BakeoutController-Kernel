package ca.uwaterloo.iqc.bakeoutcontroller_kernel.unit.variables.abstract_variable;

import ca.uwaterloo.iqc.bakeoutcontroller_kernel.variables.AbstractVariable;
import ca.uwaterloo.iqc.bakeoutcontroller_kernel.variables.Variable;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.hamcrest.core.IsEqual;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertThat;

/**
 * Contains unit tests for {@link AbstractVariable#getValue()}
 */
@RunWith(JUnitQuickcheck.class)
public final class GetValue extends AbstractVariableTestCase {
    /**
     *
     * @param randomValue A Random value
     */
    @Property
    public void getValue(Double randomValue){
        Variable<Double> variable = new ConcreteVariable(randomValue);
        assertThat(variable.getValue(), new IsEqual<>(randomValue));
    }
}
