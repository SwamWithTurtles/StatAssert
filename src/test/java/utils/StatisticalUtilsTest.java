package utils;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.function.Function;

import static org.junit.Assert.*;

public class StatisticalUtilsTest {

    @Test
    public void cdfWorksForSimpleExample() {
        Function<Double, Double> sampleCdf = StatisticalUtils.convertToCdf(Arrays.asList(1, 2, 3, 4, 5));

        assertTrue(sampleCdf.apply(0.5d).equals(0d));
        assertTrue(sampleCdf.apply(1.5d).equals(0.2d));
        assertTrue(sampleCdf.apply(2.5d).equals(0.4d));
        assertTrue(sampleCdf.apply(3.5d).equals(0.6d));
        assertTrue(sampleCdf.apply(4.5d).equals(0.8d));
        assertTrue(sampleCdf.apply(5.5d).equals(1d));
        assertTrue(sampleCdf.apply(6d).equals(1d));
    }
}
