package ca.uwaterloo.iqc.bakeoutcontroller_kernel.variables;

import ca.uwaterloo.iqc.bakeoutcontroller_kernel.exceptions.InitialValueGreaterThanUpperBoundException;
import ca.uwaterloo.iqc.bakeoutcontroller_kernel.exceptions.InitialValueLessThanLowerBoundException;
import ca.uwaterloo.iqc.bakeoutcontroller_kernel.exceptions.UnableToSetVariableException;

/**
 * Base class for providing a lower and upper bounds for a variable
 */
public abstract class AbstractBoundedVariable<T extends Comparable<T>>
        extends AbstractVariable<T> implements Bounded<T> {

    /**
     * The lower bound on the variable
     */
    private final T lowerBound;

    /**
     * The upper bound on the variable
     */
    private final T upperBound;

    /**
     *
     * @param initialValue The value that the variable has at its inception
     * @param lowerBound The lower bound on the variable
     * @param upperBound The upper bound on the variable
     * @throws IllegalArgumentException If the values are not allowed
     */
    public AbstractBoundedVariable(T initialValue, T lowerBound, T upperBound)
            throws IllegalArgumentException {
        super(initialValue);
        checkLowerBoundLessThanUpperBound(lowerBound, upperBound);
        checkInitialValueInBound(initialValue, lowerBound, upperBound);
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    /**
     *
     * @return The lower bound
     */
    @Override
    public T getLowerBound(){
        return this.lowerBound;
    }

    /**
     *
     * @return The upper bound
     */
    @Override
    public T getUpperBound(){
        return this.upperBound;
    }

    /**
     *
     * @param value The value to set
     * @throws UnableToSetVariableException if the value cannot be set
     */
    @Override
    public void setValue(T value) throws UnableToSetVariableException {
        if (isAllowedValue(value)){
            this.value = value;
        } else {
            throw new UnableToSetVariableException(
                    String.format(
                            "The value %s could not be set",
                            value.toString()
                    )
            );
        }
    }

    /**
     *
     * @param value The value for which the check is to be made if the value
     *              can be set
     * @return True if the value is allowed and False if not
     */
    @Override
    public Boolean isAllowedValue(T value){
        int valueGreaterThanLowerBound = value.compareTo(lowerBound);
        int valueLessThanUpperBound = value.compareTo(upperBound);

        return (
                valueGreaterThanLowerBound >= 0
        ) && (
                valueLessThanUpperBound <= 0
        );
    }

    @Override
    public Class<? extends Comparable> getType(){
        return this.value.getClass();
    }

    /**
     * This is run during construction, in order to check that the bounds
     * for the variable are well-specified. If they are not, an
     * {@link IllegalArgumentException} is thrown
     *
     * @param lowerBound The lower bound
     * @param upperBound The upper bound
     * @throws IllegalArgumentException If the check fails
     */
    private static <T extends Comparable<T>> void checkLowerBoundLessThanUpperBound(T lowerBound, T upperBound) throws
            IllegalArgumentException {
        int comparison = lowerBound.compareTo(upperBound);
        if (comparison >= 0){
            throw new IllegalArgumentException(
                    makeMessage(lowerBound, upperBound)
            );
        }
    }

    /**
     * Prepare a nice error message if the bound check failed on construction
     *
     * @param lowerBound The lower bound
     * @param upperBound The upper bound
     * @return A message indicating why an exception was thrown
     */
    private static <T> String makeMessage(T lowerBound, T upperBound){
        return String.format(
                "The lower bound %s is greater than the upper bound %s of this variable",
                lowerBound.toString(), upperBound.toString()
        );
    }

    /**
     *
     * @param value The value to check
     * @throws InitialValueGreaterThanUpperBoundException If the value is greater than the upper bound
     * @throws InitialValueLessThanLowerBoundException If the value is less than the lower bound
     */
    private static <T extends Comparable<T>> void checkInitialValueInBound(T value, T lowerBound, T upperBound) throws
            InitialValueGreaterThanUpperBoundException, InitialValueLessThanLowerBoundException {
        int lowerBoundComparison = value.compareTo(lowerBound);
        int upperBoundComparison = value.compareTo(upperBound);

        if (lowerBoundComparison < 0){
            throw new InitialValueLessThanLowerBoundException(
                String.format(
                        "The value %s is less than the lower bound %s",
                        value.toString(), lowerBound.toString()
                )
            );
        }

        if (upperBoundComparison > 0){
            throw new InitialValueGreaterThanUpperBoundException(
                    String.format(
                            "The value %s is greater than the upper bound %s",
                            value.toString(), upperBound.toString()
                    )
            );
        }
    }
}
