package Matcher;

import StatisticalTests.TwoSameKSTest;

import java.util.List;

public class DistributionAssert extends AbstractDistributionAssert {

    private final List<Integer> actual;

    public DistributionAssert(List<Integer> actual) {
        this.actual = actual;
    }

    /***
     * See whether two arrays are likely to come from the same distribution
     *
     * @param expected The Distribution we wish to compare our list of inputs to
     * @param pValue The acceptable likelihood of this test throwing a false positive
     * @return {@code this} assertion object
     */
    public DistributionAssert comesFromSameDistributionAs(List<Integer> expected, double pValue) {

        TwoSameKSTest test = new TwoSameKSTest(actual, expected);
        double testStatistic = test.calculateTestStatistic();

        if(testStatistic > pValue) {
            throw new AssertionError(String.format("Two distributions had different distributions with likelihood %f. p-value: %f", pValue, testStatistic));
        }

        return this;
    }

}
