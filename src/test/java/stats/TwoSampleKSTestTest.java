package stats;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TwoSampleKSTestTest {

    @Test
    public void twoSampleKSTestWithIdenticalDistribution() {
        int[] array1 = new int[]{1, 2, 3, 4};
        int[] array2 = new int[]{1, 2, 3, 4};

        TwoSampleKSTest test = new TwoSampleKSTest(array1, array2);

        assertEquals(test.calculateTestStatistic(), 1, 0.001);
    }

    //Test cases below are designed to representative
    //Online calculate to calculate/confirm expected values: http://scistatcalc.blogspot.co.uk/2013/11/kolmogorov-smirnov-test-calculator.html

    @Test
    public void twoSampleKSTestWithSmallSampleSize() {
        int[] array1 = new int[]{1, 2, 3, 4};
        int[] array2 = new int[]{-1, 2, 3, 4};

        TwoSampleKSTest test = new TwoSampleKSTest(array1, array2);

        assertEquals(test.calculateTestStatistic(), 0.999633, 0.001);
    }

    @Test
    public void twoSampleKSTestWithWildlyDeviatingSamples() {
        int[] array1 = new int[]{1, 2, 3, 4};
        int[] array2 = new int[]{3, 5, 8, 13, 21};

        TwoSampleKSTest test = new TwoSampleKSTest(array1, array2);

        assertEquals(test.calculateTestStatistic(), 0.116310, 0.001);
    }

    @Test
    public void twoSampleKSTestWithLargeArrays() {
        int[] array1 = new int[]{1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5, 6, 6, 6, 7, 8, 8, 8, 8, 9, 9, 9, 9, 9};
        int[] array2 = new int[]{1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 8, 8, 8, 8, 8, 8, 9, 9, 9};

        TwoSampleKSTest test = new TwoSampleKSTest(array1, array2);

        assertEquals(test.calculateTestStatistic(), 0.513684, 0.001);
    }

}