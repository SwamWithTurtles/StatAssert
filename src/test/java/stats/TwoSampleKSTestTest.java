package stats;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TwoSampleKSTestTest {

    @Test
    public void twoSampleKSTestWithIdenticalDistribution() {
        List<Integer> array1 = Arrays.asList(1, 2, 3, 4);
        List<Integer> array2 = Arrays.asList(1, 2, 3, 4);

        TwoSampleKSTest test = new TwoSampleKSTest(array1, array2);

        assertEquals(test.calculateTestStatistic(), 1d, 0.001);
    }

    //Test cases below are designed to representative
    //Online calculate to calculate/confirm expected values: http://scistatcalc.blogspot.co.uk/2013/11/kolmogorov-smirnov-test-calculator.html

    @Test
    public void twoSampleKSTestWithSmallSampleSize() {
        List<Integer> array1 = Arrays.asList(1, 2, 3, 4);
        List<Integer> array2 = Arrays.asList(-1, 2, 3, 4);

        TwoSampleKSTest test = new TwoSampleKSTest(array1, array2);

        assertEquals(test.calculateTestStatistic(), 0.999633d, 0.001);
    }

    @Test
    public void twoSampleKSTestWithWildlyDeviatingSamples() {
        List<Integer> array1 = Arrays.asList(1, 2, 3, 4);
        List<Integer> array2 = Arrays.asList(3, 5, 8, 13, 21);

        TwoSampleKSTest test = new TwoSampleKSTest(array1, array2);

        assertEquals(test.calculateTestStatistic(), 0.116310d, 0.001);
    }

}