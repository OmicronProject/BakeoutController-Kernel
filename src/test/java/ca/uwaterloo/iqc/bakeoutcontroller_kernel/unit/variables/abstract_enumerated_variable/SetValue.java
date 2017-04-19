package ca.uwaterloo.iqc.bakeoutcontroller_kernel.unit.variables.abstract_enumerated_variable;

import ca.uwaterloo.iqc.bakeoutcontroller_kernel.exceptions.UnableToSetVariableException;
import ca.uwaterloo.iqc.bakeoutcontroller_kernel.variables.Enumerated;
import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * Contains unit tests for
 * {@link ca.uwaterloo.iqc.bakeoutcontroller_kernel.variables.AbstractEnumeratedVariable#setValue(Object)}
 */
@RunWith(JUnitQuickcheck.class)
public final class SetValue extends AbstractEnumeratedVariableTestCase {
    /**
     * Rule used for checking that an exception was thrown
     */
    @Rule
    public final ExpectedException expectedException = ExpectedException.none();

    /**
     * @param parameters Randomly generated test parameters
     * @throws Exception if the underlying method throws an exception. This shouldn't happen, so let the results be
     * catastrophic if they do
     */
    @Property
    public void validSetter(
            @From(TestParametersGenerator.class) TestParameters parameters
    ) throws Exception {
        Enumerated<Integer> variable = createEnumeratedVariable(parameters);
        variable.setValue(parameters.getAllowedValue());
        assertEquals(parameters.getAllowedValue(), variable.getValue());
    }

    /**
     *
     * @param parameters Randomly-generated test parameters
     * @throws Exception If the underlying method throws an exception
     */
    @Property
    public void setToInvalidValue(
            @From(TestParametersGenerator.class) TestParameters parameters
    ) throws Exception {
        Enumerated<Integer> variable = createEnumeratedVariable(parameters);

        expectedException.expect(UnableToSetVariableException.class);
        variable.setValue(parameters.getForbiddenValue());
    }
}
