package ca.uwaterloo.iqc.bakeoutcontroller_kernel.unit.variables.abstract_bounded_variable;

import ca.uwaterloo.iqc.bakeoutcontroller_kernel.variables.AbstractBoundedVariable;
import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * Contains unit tests for {@link AbstractBoundedVariable#getUpperBound()}
 */
@RunWith(JUnitQuickcheck.class)
public final class GetUpperBound extends AbstractBoundedVariableTestCase {
    @Property
    public void getUpperBound(
            @From(ConstructorParametersGenerator.class) ConstructorParameters parameters
    ){
        AbstractBoundedVariable<Double> variable = createBoundedVariable(parameters);
        assertEquals(parameters.getLowerBound(), variable.getLowerBound());
    }
}
