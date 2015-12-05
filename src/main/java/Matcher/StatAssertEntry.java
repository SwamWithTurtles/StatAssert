package Matcher;

public class StatAssertEntry {
    public static AbstractDistributionAssert assertThat(int[] array) {
        return new DistributionAssert(array);
    }
}
