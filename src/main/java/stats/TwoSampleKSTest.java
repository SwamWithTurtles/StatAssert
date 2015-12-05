package stats;

import utils.StatisticalUtils;
import org.apache.commons.math3.stat.inference.KolmogorovSmirnovTest;

import java.util.*;
import java.util.function.Function;


public class TwoSampleKSTest {

    private static final Integer GRANULARITY = 1000;

    private final List<Integer> actual;
    private final List<Integer> expected;

    public TwoSampleKSTest(int[] actual, int[] expected) {
        this.actual = asList(actual);
        this.expected = asList(expected);
    }

    public double calculateTestStatistic() {

        Function<Double, Double> actualCdf = StatisticalUtils.convertToCdf(actual);
        Function<Double, Double> expectedCdf = StatisticalUtils.convertToCdf(expected);

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
