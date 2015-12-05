package stats;

import utils.DistributionFormatter;
import org.apache.commons.math3.stat.inference.KolmogorovSmirnovTest;

import java.util.*;
import java.util.function.Function;

/**
 * Implementation of the Kolmogorov-Smirnov Test
 * Most of the specifics are handled by the Apache Math3 library
 */
public class TwoSampleKSTest {

    private static final Integer GRANULARITY = 1000;

    private final List<Integer> actual;
    private final List<Integer> expected;

    public TwoSampleKSTest(int[] actual, int[] expected) {
        this.actual = asList(actual);
        this.expected = asList(expected);
    }

    /**
     * Compares the actual and expected distribution and returns the p-value returned by the Kolmogorov-Smirnov Test
     * @return p-value, namely (1 - p), where p is the probability that the distributions are this similar by chance
     */
    public double calculateTestStatistic() {

        Function<Double, Double> actualCdf = new DistributionFormatter(actual).convertToCdf();
        Function<Double, Double> expectedCdf = new DistributionFormatter(expected).convertToCdf();

        Integer min = Collections.min(union(actual, expected));
        Integer max = Collections.max(union(actual, expected));

        Double supCdfDiff = 0d;
        Double increment = (double)(max-min)/GRANULARITY;
        for(Double i = Double.valueOf(min); i < max; i = i + increment) {
            supCdfDiff = Math.max(supCdfDiff, Math.abs(actualCdf.apply(i) - expectedCdf.apply(i)));
        }
        if(supCdfDiff == 0) {
            return 1d;
        }

        return new KolmogorovSmirnovTest().approximateP(supCdfDiff, actual.size(), expected.size());
    }

    private List<Integer> asList(int[] arr) {
        List<Integer> intList = new ArrayList<Integer>();
        for (int index = 0; index < arr.length; index++)
        {
            intList.add(arr[index]);
        }
        return intList;
    }

    private List<Integer> union(List<Integer> list1, List<Integer> list2) {
        Set<Integer> set = new HashSet<Integer>();

        set.addAll(list1);
        set.addAll(list2);

        return new ArrayList<Integer>(set);
    }
}
