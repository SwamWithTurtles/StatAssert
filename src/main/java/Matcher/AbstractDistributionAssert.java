package Matcher;

import org.assertj.core.api.AbstractIntArrayAssert;

/**
 * Abstract class that defines the interface for the assertion methods
 */
public abstract class AbstractDistributionAssert extends AbstractIntArrayAssert {

    public AbstractDistributionAssert(int[] actual, Class<?> selfType) {
        super(actual, selfType);
    }

    public abstract DistributionAssert comesFromSameDistributionAs(int[] expected, double pValue);

    public abstract DistributionAssert comesFromDifferentDistributionAs(int[] expected, double pValue);

    /**
     * We're inheriting from an assertion that could contain any object, we may need to cast it to its specific type
     * @param arr the object on which we are asserting
     * @return the same object, but typed correctly
     */
    protected int[] unwrapIntArray(Object arr) {
        return (int[])arr;
    }
}
