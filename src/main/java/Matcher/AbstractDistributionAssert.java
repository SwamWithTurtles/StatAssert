package Matcher;

import java.util.List;

public abstract class AbstractDistributionAssert {
    public abstract DistributionAssert comesFromSameDistributionAs(List<Integer> expected, double pValue);

    public abstract DistributionAssert comesFromDifferentDistributionAs(List<Integer> expected, double pValue);
}
