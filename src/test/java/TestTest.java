import Matcher.AbstractDistributionAssert;
import Matcher.DistributionAssert;
import org.junit.Test;

import java.util.Arrays;


public class TestTest {
    @Test
    public void identicalDistributionsShouldHaveTheSame() {
        AbstractDistributionAssert foo = new DistributionAssert(Arrays.asList(1, 1, 1));

        foo.comesFromSameDistributionAs(Arrays.asList(1, 1, 1), 0.01);
    }
}
