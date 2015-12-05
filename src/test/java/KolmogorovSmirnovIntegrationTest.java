import Matcher.AbstractDistributionAssert;
import Matcher.DistributionAssert;
import Matcher.StatAssertEntry;
import org.junit.Test;

import static Matcher.StatAssertEntry.assertThat;
import static junit.framework.Assert.assertTrue;


public class KolmogorovSmirnovIntegrationTest {
    @Test
    public void StatAssertEntryCanBeInstantiated() {
        //Mainly here to ensure 100% coverage
        StatAssertEntry entry = new StatAssertEntry();

        assertTrue(entry instanceof StatAssertEntry);
    }

    @Test
    public void identicalDistributionsShouldHaveTheSame() {
        assertThat(new int[]{1, 1, 1, 1}).comesFromSameDistributionAs(new int[]{1, 1, 1, 1}, 0.01);
    }

    @Test
    public void identicalDistributionsShouldThrowErrorWhenAssertedToBeDifferent() {
        try {
            assertThat(new int[]{1, 1, 1, 1}).comesFromDifferentDistributionAs(new int[]{1, 1, 1, 1}, 0.01);
        } catch (AssertionError e) {
            return;
        }

        throw new AssertionError("Assertion should have thrown error when asserting two identical distributions are different");
    }

    @Test
    public void wildlyDeviatingDistributionsShouldReportDifferentDistribution() {
        assertThat(new int[]{1, 1, 1, 1}).comesFromDifferentDistributionAs(new int[]{3, 5, 8, 13, 21}, 0.01);
    }

    @Test
    public void canUseStandardAssertJAssertions() {
        assertThat(new int[]{1, 2, 3}).comesFromSameDistributionAs(new int[]{1, 2, 3}, 0.01).hasSize(3);
    }

    @Test
    public void wildlyDeviatingDistributionsShouldThrowErrorWhenAssertedToBeSame() {
        try {
            assertThat(new int[]{1, 1, 1, 1}).comesFromSameDistributionAs(new int[]{3, 5, 8, 13, 21}, 0.01);
        } catch (AssertionError e) {
            return;
        }

        throw new AssertionError("Assertion should have thrown error when asserting two different distributions are identical");
    }


}
