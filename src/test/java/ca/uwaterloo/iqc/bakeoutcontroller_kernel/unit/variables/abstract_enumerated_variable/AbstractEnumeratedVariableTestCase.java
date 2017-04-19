package ca.uwaterloo.iqc.bakeoutcontroller_kernel.unit.variables.abstract_enumerated_variable;

import ca.uwaterloo.iqc.bakeoutcontroller_kernel.exceptions.UnableToSetVariableException;
import ca.uwaterloo.iqc.bakeoutcontroller_kernel.exceptions.VariableNotAllowedException;
import ca.uwaterloo.iqc.bakeoutcontroller_kernel.unit.variables.VariablesTestCase;
import ca.uwaterloo.iqc.bakeoutcontroller_kernel.variables.AbstractEnumeratedVariable;
import ca.uwaterloo.iqc.bakeoutcontroller_kernel.variables.Enumerated;
import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;
import org.jetbrains.annotations.Contract;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

/**
 * Base class for testing {@link ca.uwaterloo.iqc.bakeoutcontroller_kernel.variables.AbstractEnumeratedVariable}
 */
public abstract class AbstractEnumeratedVariableTestCase extends VariablesTestCase {

    /**
     *
     * @param parameters The testing parameters required to create the variable
     * @return The variable
     * @throws UnableToSetVariableException if the underlying method throws the exception
     */
    @Contract(pure = true)
    protected static Enumerated<Integer> createEnumeratedVariable(TestParameters parameters) throws
            UnableToSetVariableException {
        return new ConcreteEnumeratedVariable<>(parameters.getInitialValue(), parameters.getAllowedValues());
    }

    /**
     * Instance of the variable used for testing
     *
     * @param <T> The parameter of the type that the variable is managing
     */
    protected static class ConcreteEnumeratedVariable<T> extends AbstractEnumeratedVariable<T>{
        public ConcreteEnumeratedVariable(T initialValue, Set<T> allowedValues) throws UnableToSetVariableException {
            super(initialValue, allowedValues);
        }
    }

    protected interface TestParameters extends VariablesTestCase.TestParameters {
        Set<Integer> getAllowedValues();
        Integer getInitialValue();
        Integer getAllowedValue();
        Integer getForbiddenValue();
    }

    protected static class TestParametersGenerator extends Generator<TestParameters> {
        private static final Logger log = LoggerFactory.getLogger(TestParametersGenerator.class);

        private static final Integer MINIMUM_ALLOWED_NUMBER = -9999;
        private static final Integer MAXIMUM_ALLOWED_NUMBER = 9999;
        private static final Integer MAXIMUM_LIST_SIZE = 1000;
        private static final Integer MAXIMUM_GENERATION_ATTEMPTS = 10;

        public TestParametersGenerator(){
            super(TestParameters.class);
        }

        @Override
        public TestParameters generate(SourceOfRandomness rng, GenerationStatus status) throws RuntimeException {
            Integer allowedValue = rng.nextInt();
            Set<Integer> allowedValues = createAllowedValues(rng);
            allowedValues.add(allowedValue);
            Integer forbiddenValue = rng.nextInt() + MAXIMUM_ALLOWED_NUMBER;
            Integer initialValue = rng.nextInt(MINIMUM_ALLOWED_NUMBER, MAXIMUM_ALLOWED_NUMBER);
            allowedValues.add(initialValue);

            try {
                return new Parameters(allowedValues, initialValue, allowedValue, forbiddenValue);
            } catch (VariableNotAllowedException error){
                return handleGenerationError(rng, status);
            }
        }

        private static Set<Integer> createAllowedValues(SourceOfRandomness rng){
            Integer size = rng.nextInt(0, MAXIMUM_LIST_SIZE - 1);
            Set<Integer> allowedValues = new HashSet<>();

            for (Integer i = 0; i < size; i++){
                allowedValues.add(rng.nextInt(MINIMUM_ALLOWED_NUMBER, MAXIMUM_ALLOWED_NUMBER));
            }

            return allowedValues;
        }

        private TestParameters handleGenerationError(SourceOfRandomness rng, GenerationStatus status) throws
                RuntimeException {
            log.info(
                    String.format("Failed to generate variable. Attempt %d", status.attempts())
            );

            if (status.attempts() < MAXIMUM_GENERATION_ATTEMPTS){
                return generate(rng, status);
            } else {
                throw new RuntimeException("Maximum generation attempts exceeded");
            }
        }

        private static class Parameters implements TestParameters {
            private final Set<Integer> allowedValues;
            private final Integer initialValue;
            private final Integer allowedValue;
            private final Integer forbiddenValue;

            public Parameters(
                    Set<Integer> allowedValues, Integer initialValue, Integer allowedValue, Integer forbiddenValue
            ) throws VariableNotAllowedException {
                assertValueForbidden(forbiddenValue, allowedValues);
                assertValueAllowed(allowedValue, allowedValues);
                this.allowedValues = allowedValues;
                this.forbiddenValue = forbiddenValue;
                this.initialValue = initialValue;
                this.allowedValue = allowedValue;
            }

            @Override
            public Set<Integer> getAllowedValues(){
                return allowedValues;
            }

            @Override
            public Integer getInitialValue(){
                return initialValue;
            }

            @Override
            public Integer getAllowedValue(){
                return allowedValue;
            }

            @Override
            public Integer getForbiddenValue(){
                return forbiddenValue;
            }

            private <T> void assertValueForbidden(T forbiddenValue, Set<T> allowedValues) throws
                    VariableNotAllowedException {
                if (allowedValues.contains(forbiddenValue)){
                    throw new VariableNotAllowedException();
                }
            }

            private <T> void assertValueAllowed(T allowedValue, Set<T> allowedValues) throws
                    VariableNotAllowedException {
                if (!allowedValues.contains(allowedValue)){
                    throw new VariableNotAllowedException();
                }
            }
        }
    }
}
