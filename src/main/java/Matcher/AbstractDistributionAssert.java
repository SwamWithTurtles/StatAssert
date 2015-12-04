package Matcher;

import java.util.List;

/**
 * Created by DAS on 01/12/2015.
 */
public abstract class AbstractDistributionAssert {
    public abstract DistributionAssert comesFromSameDistributionAs(List<Integer> expected, double pValue);
}
