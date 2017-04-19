package ca.uwaterloo.iqc.bakeoutcontroller_kernel.unit.variables.abstract_mutable_variable;

import ca.uwaterloo.iqc.bakeoutcontroller_kernel.exceptions.UnableToSetVariableException;
import ca.uwaterloo.iqc.bakeoutcontroller_kernel.variables.Mutable;
import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;

/**
 * Tests that the mutator works correctly
 */
@RunWith(JUnitQuickcheck.class)
public final class SetValue extends AbstractMutableVariableTestCase {
    private static final Logger log = LoggerFactory.getLogger(SetValue.class);

    @Property
    public void setValue(
            @From(TestParametersGenerator.class) TestParameters parameters
    ){
        Mutable<Double> variable = generateMutableVariable(parameters);
        setVariable(variable, parameters.getNewValue());
        assertEquals(parameters.getNewValue(), variable.getValue());
    }

    private static <T> void setVariable(Mutable<T> variable, T newValue){
        try {
            variable.setValue(newValue);
        } catch (UnableToSetVariableException e){
            log.error("Setting variable threw error", e);
        }
    }
}
