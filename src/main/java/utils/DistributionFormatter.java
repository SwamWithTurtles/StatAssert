package utils;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.function.Function;

public class DistributionFormatter {

    private final List<Integer> dataPoints;

    public DistributionFormatter(List<Integer> dataPoints) {
        this.dataPoints = dataPoints;
    }


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
