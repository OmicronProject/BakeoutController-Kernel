package ca.uwaterloo.iqc.bakeoutcontroller_kernel.unit.variables;

import ca.uwaterloo.iqc.bakeoutcontroller_kernel.unit.UnitTestCase;
import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

/**
 * Base class for unit tests of
 * {@link ca.uwaterloo.iqc.bakeoutcontroller_kernel.variables}
 */
public abstract class VariablesTestCase extends UnitTestCase {

    protected interface TestParameters {

    }

    protected static abstract class TestParametersGenerator extends Generator<TestParameters>{
        public TestParametersGenerator(){
            super(TestParameters.class);
        }

        @Override
        public abstract TestParameters generate(SourceOfRandomness rng, GenerationStatus status);
    }
}
