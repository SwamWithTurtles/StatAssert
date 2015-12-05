package Matcher;

/**
 * Helper class to expose the 'assertThat' method where needed
 */
public class StatAssertEntry {
    public static AbstractDistributionAssert assertThat(int[] array) {
        return new DistributionAssert(array);
    }
}
