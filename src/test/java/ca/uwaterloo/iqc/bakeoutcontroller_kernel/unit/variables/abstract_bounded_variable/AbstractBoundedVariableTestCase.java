package ca.uwaterloo.iqc.bakeoutcontroller_kernel.unit.variables.abstract_bounded_variable;

import ca.uwaterloo.iqc.bakeoutcontroller_kernel.unit.variables.VariablesTestCase;
import ca.uwaterloo.iqc.bakeoutcontroller_kernel.variables.AbstractBoundedVariable;
import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * Base class for unit tests of
 * {@link AbstractBoundedVariable}
 */
public abstract class AbstractBoundedVariableTestCase extends VariablesTestCase {

    /**
     *
     * @param parameters The parameters to use for creating a bounded variable
     * @return The bounded variable
     */
    @Contract("_ -> !null")
    public static ConcreteBoundedVariable createBoundedVariable(ConstructorParameters parameters){
        return new ConcreteBoundedVariable(
                parameters.getValue(), parameters.getLowerBound(), parameters.getUpperBound());
    }

    /**
     * An implementation of a bounded variable
     */
    public static class ConcreteBoundedVariable extends AbstractBoundedVariable<Double> {
        /**
         *
         * @param value The initial value of the variable
         * @param lowerBound The lower bound of the variable
         * @param upperBound The uppre bound of the variable
         */
        public ConcreteBoundedVariable(Double value, Double lowerBound, Double upperBound){
            super(value, lowerBound, upperBound);
        }
    }

    public static class ComparableVariableGenerator extends Generator<ConcreteBoundedVariable> {
        private static final ConstructorParametersGenerator generator = new ConstructorParametersGenerator();

        public ComparableVariableGenerator(){
            super(ConcreteBoundedVariable.class);
        }

        @Override
        public ConcreteBoundedVariable generate(SourceOfRandomness rng, GenerationStatus status){
            ConstructorParameters parameters = generator.generate(rng, status);

            return new ConcreteBoundedVariable(
                    parameters.getValue(), parameters.getLowerBound(), parameters.getUpperBound()
            );
        }
    }

    public static class ConstructorParameters {
        private final Double lowerBound;
        private final Double value;
        private final Double upperBound;

        public ConstructorParameters(Double value, Double lowerBound, Double upperBound){
            this.value = value;
            this.lowerBound = lowerBound;
            this.upperBound = upperBound;
        }

        public Double getLowerBound(){
            return lowerBound;
        }

        public Double getValue(){
            return value;
        }

        public Double getUpperBound(){
            return upperBound;
        }
    }

    public static class ConstructorParametersGenerator extends Generator<ConstructorParameters> {
        public ConstructorParametersGenerator(){
            super(ConstructorParameters.class);
        }

        @Override
        public ConstructorParameters generate(SourceOfRandomness rng, GenerationStatus status){
            Double lowerBound = rng.nextDouble();
            Double upperBound = lowerBound + rng.nextDouble();
            Double value = getMidpoint(lowerBound, upperBound);

            return new ConstructorParameters(value, lowerBound, upperBound);
        }

        @NotNull
        @Contract(pure = true)
        private static Double getMidpoint(Double lowerBound, Double upperBound){
            return (lowerBound + upperBound) / 2;
        }
    }
}
