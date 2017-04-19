package ca.uwaterloo.iqc.bakeoutcontroller_kernel.unit.variables.abstract_bounded_variable;

import ca.uwaterloo.iqc.bakeoutcontroller_kernel.exceptions.UnableToSetVariableException;
import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.Assume;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by mkononen on 26/02/17.
 */
@RunWith(JUnitQuickcheck.class)
public final class SetValue extends AbstractBoundedVariableTestCase {
    @Rule
    public final ExpectedException expectedException = ExpectedException.none();

    @Property
    public void setAllowedValueTrue(
            @From(ComparableVariableGenerator.class) AbstractBoundedVariableTestCase.ConcreteBoundedVariable variable, Double value
    ){
        Assume.assumeTrue(variable.isAllowedValue(value));

        try {
            variable.setValue(value);
        } catch (UnableToSetVariableException error){
            fail();
        }
        assertEquals(value, variable.getValue());
    }

    @Property
    public void setAllowedValueFalse(
            @From(ComparableVariableGenerator.class) AbstractBoundedVariableTestCase.ConcreteBoundedVariable variable, Double value
    ) throws UnableToSetVariableException {
        Assume.assumeFalse(variable.isAllowedValue(value));
        expectedException.expect(UnableToSetVariableException.class);

        variable.setValue(value);
    }
}
