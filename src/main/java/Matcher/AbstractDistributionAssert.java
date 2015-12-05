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
        int[] intArray = new int[0];
        if (arr instanceof Object[]) {
            intArray = new int[((Object[])arr).length];
            for(int i = 0; i < ((Object[])arr).length; i++) {
                intArray[i] = (Integer) (((Object[])arr)[i]);
            }
        }
        return intArray;
    }
}
