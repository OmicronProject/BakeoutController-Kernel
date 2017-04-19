package ca.uwaterloo.iqc.bakeoutcontroller_kernel.unit.variables.abstract_bounded_variable;

import ca.uwaterloo.iqc.bakeoutcontroller_kernel.variables.AbstractBoundedVariable;
import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Base class for unit tests of
 * {@link ca.uwaterloo.iqc.bakeoutcontroller_kernel.variables.AbstractBoundedVariable#isAllowedValue(Comparable)}
 */
@RunWith(JUnitQuickcheck.class)
public final class IsAllowedValue extends AbstractBoundedVariableTestCase {
    @Property
    public void testIsAllowedValueTrue(
            @From(ConstructorParametersGenerator.class) ConstructorParameters constructorParameters
    ){
        AbstractBoundedVariable<Double> variable = createBoundedVariable(constructorParameters);
        assertTrue(variable.isAllowedValue(constructorParameters.getValue()));
    }

    @Property
    public void testIsAllowedValueTooBig(
            @From(ConstructorParametersGenerator.class) ConstructorParameters parameters
    ){
        Double veryBigValue = parameters.getValue() + parameters.getUpperBound() + parameters.getLowerBound();
        AbstractBoundedVariable<Double> variable = createBoundedVariable(parameters);
        assertFalse(variable.isAllowedValue(veryBigValue));
    }

    @Property
    public void testIsAllowedValueTooSmall(
            @From(ConstructorParametersGenerator.class) ConstructorParameters parameters
    ){
        Double verySmallValue = parameters.getValue() - parameters.getUpperBound() - parameters.getLowerBound();
        AbstractBoundedVariable<Double> variable = createBoundedVariable(parameters);
        assertFalse(variable.isAllowedValue(verySmallValue));
    }
}
