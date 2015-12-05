package Matcher;

import org.assertj.core.api.AbstractIntArrayAssert;

import java.util.List;

public abstract class AbstractDistributionAssert extends AbstractIntArrayAssert {

    public AbstractDistributionAssert(int[] actual, Class<?> selfType) {
        super(actual, selfType);
    }

    public abstract DistributionAssert comesFromSameDistributionAs(int[] expected, double pValue);

    public abstract DistributionAssert comesFromDifferentDistributionAs(int[] expected, double pValue);

    protected int[] unwrapIntArray(Object arr) {
        return (int[])arr;
    }
}
