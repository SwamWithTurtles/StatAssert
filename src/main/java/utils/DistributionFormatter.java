package utils;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.function.Function;

/**
 * Class that takes a series of integers, and returns its in formats that may be needed by statistical tests
 */
public class DistributionFormatter {

    private final List<Integer> dataPoints;

    /**
     * Constructor
     * @param dataPoints series of integer data points
     */
    public DistributionFormatter(List<Integer> dataPoints) {
        this.dataPoints = dataPoints;
    }

    /**
     * The cumulative distribution function - i.e. cdf(x) = Probability that this a number x or less will appear
     * @return cumulative distribution function
     */
    public Function<Double, Double> convertToCdf() {
        return new Function<Double, Double>() {
            public Double apply(final Double aDouble) {
                List<Integer> filteredActual = Lists.newArrayList(Iterables.filter(dataPoints, new Predicate<Integer>() {
                    public boolean apply(Integer integer) {
                        return integer <= aDouble;
                    }
                }));

                return (double) filteredActual.size() / dataPoints.size();
            };
        };

    }

}
