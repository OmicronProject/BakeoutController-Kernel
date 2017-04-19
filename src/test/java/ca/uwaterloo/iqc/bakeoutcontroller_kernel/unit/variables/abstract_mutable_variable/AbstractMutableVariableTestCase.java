package ca.uwaterloo.iqc.bakeoutcontroller_kernel.unit.variables.abstract_mutable_variable;

import ca.uwaterloo.iqc.bakeoutcontroller_kernel.unit.variables.VariablesTestCase;
import ca.uwaterloo.iqc.bakeoutcontroller_kernel.variables.AbstractMutableVariable;
import ca.uwaterloo.iqc.bakeoutcontroller_kernel.variables.Mutable;
import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;
import org.jetbrains.annotations.Contract;

/**
 * Base class for unit tests of {@link ca.uwaterloo.iqc.bakeoutcontroller_kernel.variables.AbstractMutableVariable}
 */
public abstract class AbstractMutableVariableTestCase extends VariablesTestCase {

    /**
     *
     * @param parameters The parameters required to generate the variable
     * @return The mutable variable
     */
    @Contract(pure = true)
    protected static Mutable<Double> generateMutableVariable(TestParameters parameters){
        return new ConcreteMutableVariable<>(parameters.getInitialValue());
    }

    /**
     * Describes the type for testing parameters
     */
    protected interface TestParameters {
        /**
         *
         * @return The initial value of the variable
         */
        Double getInitialValue();

        /**
         * @return The value to which the variable will be set
         */
        Double getNewValue();
    }

    /**
     * @param <T> The type of variable managed by this variable
     */
    protected static final class ConcreteMutableVariable<T> extends AbstractMutableVariable<T> {
        /**
         *
         * @param initialValue The initial value of the variable
         */
        public ConcreteMutableVariable(T initialValue){
            super(initialValue);
        }
    }

    /**
     * The generator for test parameters
     */
    protected static final class TestParametersGenerator extends Generator<TestParameters> {
        public TestParametersGenerator(){
            super(TestParameters.class);
        }

        /**
         *
         * @param rng The random number generator
         * @param status The status of generation
         * @return An instance of the test parameters
         */
        @Override
        public TestParameters generate(SourceOfRandomness rng, GenerationStatus status){
            Double initialValue = rng.nextDouble();
            Double newValue = rng.nextDouble();

            return new Parameters(initialValue, newValue);
        }

        /**
         * The testing parameters
         */
        private static final class Parameters implements TestParameters {
            /**
             * The initial value to be used in the test
             */
            private final Double initialValue;

            /**
             * The value to which the variable will be set in the test
             */
            private final Double newValue;

            /**
             *
             * @param initialValue The initial value
             * @param newValue The final value
             */
            public Parameters(Double initialValue, Double newValue){
                this.initialValue = initialValue;
                this.newValue = newValue;
            }

            /**
             *
             * @return The initial value
             */
            @Override
            public Double getInitialValue(){
                return this.initialValue;
            }

            /**
             *
             * @return The final value
             */
            @Override
            public Double getNewValue(){
                return this.newValue;
            }
        }
    }
}
