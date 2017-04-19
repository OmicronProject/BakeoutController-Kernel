package ca.uwaterloo.iqc.bakeoutcontroller_kernel.unit.variables.abstract_enumerated_variable;

import ca.uwaterloo.iqc.bakeoutcontroller_kernel.variables.Enumerated;
import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Unit tests for
 * {@link ca.uwaterloo.iqc.bakeoutcontroller_kernel.variables.AbstractEnumeratedVariable#isAllowedValue(Object)}
 */
@RunWith(JUnitQuickcheck.class)
public final class IsAllowedValue extends AbstractEnumeratedVariableTestCase {
    @Property
    public void allowedValueIsAllowed(
            @From(TestParametersGenerator.class) TestParameters parameters
    ) throws Exception {
        Enumerated<Integer> variable = createEnumeratedVariable(parameters);
        assertTrue(variable.isAllowedValue(parameters.getAllowedValue()));
    }

    @Property
    public void forbiddenValueIsForbidden(
            @From(TestParametersGenerator.class) TestParameters parameters
    ) throws Exception {
        Enumerated<Integer> variable = createEnumeratedVariable(parameters);
        assertFalse(variable.isAllowedValue(parameters.getForbiddenValue()));
    }
}
