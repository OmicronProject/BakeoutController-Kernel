package ca.uwaterloo.iqc.bakeoutcontroller_kernel.unit.variables.abstract_observable_variable;

import ca.uwaterloo.iqc.bakeoutcontroller_kernel.unit.variables.VariablesTestCase;
import ca.uwaterloo.iqc.bakeoutcontroller_kernel.variables.AbstractObservableVariable;
import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;
import org.jetbrains.annotations.Contract;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;

import java.util.concurrent.Executor;

/**
 * Base class for testing {@link ca.uwaterloo.iqc.bakeoutcontroller_kernel.variables.AbstractObservableVariable}
 */
public abstract class AbstractObservableVariableTestCase extends VariablesTestCase {

    /**
     *
     * Helper method for generating an observable variable from the test parameters
     *
     * @param parameters The generated test parameters
     * @return An instance of an observable variable based on the test parameters
     */
    @Contract(pure = true)
    protected static ConcreteObservableVariable generateVariable(TestParameters parameters){
        return new ConcreteObservableVariable(
                parameters.getInitialValue(), parameters.getExecutor()
        );
    }

    /**
     * An implementation of an observable variable that manages a single {@link Double}
     */
    protected static class ConcreteObservableVariable extends AbstractObservableVariable<Double> {
        /**
         *
         * @param initialValue The initial value of the variable
         * @param variableUpdateExecutor The executor for running update listeners. When the value of the variable
         *                               changes, this executor is used to run
         *                               {@link ca.uwaterloo.iqc.bakeoutcontroller_kernel.variables.VariableChangeEventListener#onChange(Object)}
         *                               for each listener
         */
        public ConcreteObservableVariable(
                Double initialValue, Executor variableUpdateExecutor
        ){
            super(initialValue, variableUpdateExecutor);
        }
    }

    /**
     * Describes the test parameters required to test the variable
     */
    protected interface TestParameters {
        /**
         *
         * @return The JMock context used to create stubs for various interfaces
         */
        Mockery getMockingContext();

        /**
         *
         * @return The executor stub used to send data
         */
        Executor getExecutor();

        /**
         *
         * @return The initial value of the variable
         */
        Double getInitialValue();

        SourceOfRandomness getSourceOfRandomness();
    }

    /**
     * Generates the test parameters
     */
    protected static class TestParametersGenerator extends Generator<TestParameters> {
        public TestParametersGenerator(){
            super(TestParameters.class);
        }

        @Override
        public TestParameters generate(SourceOfRandomness rng, GenerationStatus status){
            Mockery context = new JUnit4Mockery();
            Executor executor = context.mock(Executor.class);
            Double initialValue = rng.nextDouble();

            return new Parameters(context, executor, initialValue, rng);
        }

        /**
         * The generated parameters
         */
        private class Parameters implements TestParameters {

            /**
             * The mocking context used for checking the test
             */
            private final Mockery context;

            /**
             * The executor
             */
            private final Executor executor;

            /**
             * The initial value of the variable
             */
            private final Double initialValue;

            /**
             * The random number generator used to create the parameters
             */
            private final SourceOfRandomness sourceOfRandomness;

            /**
             *
             * @param context The mocking context
             * @param executor The executor
             * @param initialValue The variable's initial value
             */
            public Parameters(
                    Mockery context, Executor executor, Double initialValue, SourceOfRandomness sourceOfRandomness
            ){
                this.context = context;
                this.executor = executor;
                this.initialValue = initialValue;
                this.sourceOfRandomness = sourceOfRandomness;
            }

            /**
             *
             * @return The mocking context
             */
            @Override
            public Mockery getMockingContext(){
                return this.context;
            }

            /**
             *
             * @return The variable's initial value
             */
            @Override
            public Double getInitialValue(){
                return this.initialValue;
            }

            /**
             *
             * @return The executor
             */
            @Override
            public Executor getExecutor(){
                return this.executor;
            }

            @Override
            public SourceOfRandomness getSourceOfRandomness(){
                return this.sourceOfRandomness;
            }
        }
    }
}
