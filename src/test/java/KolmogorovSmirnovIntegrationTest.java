import Matcher.AbstractDistributionAssert;
import Matcher.DistributionAssert;
import org.junit.Test;

import java.util.Arrays;


public class KolmogorovSmirnovIntegrationTest {
    @Test
    public void identicalDistributionsShouldHaveTheSame() {
        AbstractDistributionAssert foo = new DistributionAssert(Arrays.asList(1, 1, 1, 1));

        foo.comesFromSameDistributionAs(Arrays.asList(1, 1, 1, 1), 0.01);
    }

    @Test
    public void identicalDistributionsShouldThrowErrorWhenAssertedToBeDifferent() {
        AbstractDistributionAssert foo = new DistributionAssert(Arrays.asList(1, 1, 1, 1));

        try {
            foo.comesFromDifferentDistributionAs(Arrays.asList(1, 1, 1, 1), 0.01);
        } catch (AssertionError e) {
            return;
        }

        throw new AssertionError("Assertion should have thrown error when asserting two identical distributions are different");
    }

    @Test
    public void wildlyDeviatingDistributionsShouldReportDifferentDistribution() {
        AbstractDistributionAssert foo = new DistributionAssert(Arrays.asList(1, 1, 1, 1));

        foo.comesFromDifferentDistributionAs(Arrays.asList(3, 5, 8, 13, 21), 0.01);
    }

    @Test
    public void wildlyDevatingDistributionsShouldThrowErrorWhenAssertedToBeSame() {
        AbstractDistributionAssert foo = new DistributionAssert(Arrays.asList(1, 1, 1, 1));

        try {
            foo.comesFromSameDistributionAs(Arrays.asList(3, 5, 8, 13, 21), 0.01);
        } catch (AssertionError e) {
            return;
        }

        throw new AssertionError("Assertion should have thrown error when asserting two identical distributions are different");
    }


}
