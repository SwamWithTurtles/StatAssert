package stats;

import utils.StatisticalUtils;
import org.apache.commons.math3.stat.inference.KolmogorovSmirnovTest;

import java.util.*;
import java.util.function.Function;


public class TwoSameKSTest {

    private static final Long GRANULARITY = 1000l;

    private final List<Integer> actual;
    private final List<Integer> expected;

    public TwoSameKSTest(List<Integer> actual, List<Integer> expected) {
        this.actual = actual;
        this.expected = expected;
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
            return 1;
        }

        return new KolmogorovSmirnovTest().approximateP(supCdfDiff, actual.size(), expected.size());
    }

    public List<Integer> union(List<Integer> list1, List<Integer> list2) {
        Set<Integer> set = new HashSet<Integer>();

        set.addAll(list1);
        set.addAll(list2);

        return new ArrayList<Integer>(set);
    }
}
