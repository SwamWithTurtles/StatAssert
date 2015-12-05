package Matcher;

import stats.TwoSampleKSTest;


/**
 * Implementation of integer array assertions
 */
public class DistributionAssert extends AbstractDistributionAssert {

    public DistributionAssert(int[] actual) {
        super(actual, DistributionAssert.class);
    }

    /***
     * See whether two arrays are likely to come from the same distribution
     *
     * @param expected The Distribution we wish to compare our list of inputs to
     * @param pValue The acceptable likelihood of this test throwing a false positive
     * @return {@code this} assertion object
     */
    public DistributionAssert comesFromSameDistributionAs(int[] expected, double pValue) {
        TwoSampleKSTest test = new TwoSampleKSTest(unwrapIntArray(actual), expected);
        double testStatistic = test.calculateTestStatistic();

        if(testStatistic < (1 - pValue)) {
            throw new AssertionError(String.format("Two distributions had different distributions with likelihood %f. p-value: %f", pValue, testStatistic));
        }

        return this;
    }

    /**
     * Confirm that two arrays come from different distributions
     *
     * @param expected The Distribution we wish to compare our list of inputs to
     * @param pValue The likelihood, below which we assume the distributions are different
     * @return {@code this} assertion object
     */
    @Override
    public DistributionAssert comesFromDifferentDistributionAs(int[] expected, double pValue) {
        TwoSampleKSTest test = new TwoSampleKSTest(unwrapIntArray(actual), expected);
        double testStatistic = test.calculateTestStatistic();

        if(testStatistic >= (1 - pValue)) {
            throw new AssertionError(String.format("Two distributions had different distributions with likelihood %f. p-value: %f", pValue, testStatistic));
        }

        return this;
    }

}
