package utils;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.function.Function;

public abstract class StatisticalUtils {

    public static Function<Double, Double> convertToCdf(final List<Integer> actual) {
        return new Function<Double, Double>() {
            public Double apply(final Double aDouble) {
                List<Integer> filteredActual = Lists.newArrayList(Iterables.filter(actual, new Predicate<Integer>() {
                    public boolean apply(Integer integer) {
                        return integer <= aDouble;
                    }
                }));

                return (double) filteredActual.size() / actual.size();
            };
        };

    }

}
