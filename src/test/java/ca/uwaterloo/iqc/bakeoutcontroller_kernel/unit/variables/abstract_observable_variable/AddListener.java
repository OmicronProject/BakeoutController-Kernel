package ca.uwaterloo.iqc.bakeoutcontroller_kernel.unit.variables.abstract_observable_variable;

import ca.uwaterloo.iqc.bakeoutcontroller_kernel.exceptions.UnableToSetVariableException;
import ca.uwaterloo.iqc.bakeoutcontroller_kernel.variables.Mutable;
import ca.uwaterloo.iqc.bakeoutcontroller_kernel.variables.Observable;
import ca.uwaterloo.iqc.bakeoutcontroller_kernel.variables.VariableChangeEventListener;
import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.jmock.Expectations;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Executor;

/**
 * Contains unit tests for
 * {@link ca.uwaterloo.iqc.bakeoutcontroller_kernel.variables.AbstractObservableVariable#addListener(VariableChangeEventListener)}
 */
@RunWith(JUnitQuickcheck.class)
public final class AddListener extends AbstractObservableVariableTestCase {
    private static final Logger log = LoggerFactory.getLogger(AddListener.class);

    /**
     * Tests that, when a listener is added, a call is made to the executor to run the method that describes a
     * variable change handler
     *
     * @param parameters Randomly-generated testing parameters
     */
    @Property
    public void addListener(
            @From(TestParametersGenerator.class) TestParameters parameters
    ){
        parameters.getMockingContext().checking(new ExpectationsForTest(parameters.getExecutor()));
        Double newValue = parameters.getSourceOfRandomness().nextDouble();
        Observable<Double> variable = generateVariable(parameters);

        Listener<Double> listener = new Listener<>();

        variable.addListener(listener);
        modifyVariableWithNewValue(variable, newValue);

        parameters.getMockingContext().assertIsSatisfied();
    }

    /**
     * @param variable The variable to mutate
     * @param newValue The new value of the variable
     * @param <T> The type of the new mutable variable.
     */
    private static <T> void modifyVariableWithNewValue(Mutable<T> variable, T newValue){
        try {
            variable.setValue(newValue);
        } catch (UnableToSetVariableException e){
            log.error("Modifying variable threw error", e);
        }
    }

    /**
     * The listener to register with the service
     *
     * @param <T> The type of variable managed by this listener
     */
    private final class Listener<T> implements VariableChangeEventListener<T> {

        /**
         * Create an empty constructor
         */
        public Listener(){
        }

        /**
         *
         * @param newValue The new value of the listener
         */
        @Override
        public void onChange(T newValue){
        }
    }

    private final class ExpectationsForTest extends Expectations {
        public ExpectationsForTest(Executor mockExecutor){
            oneOf(mockExecutor).execute(with(any(Runnable.class)));
        }
    }
}
