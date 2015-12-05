# StatAssert
Statistical Assertion library for Java

This library sits on top of the AssertJ core library for integer arrays, and is intended to provide statistical tests for non-deterministic data sets, and whether they match the desired distribution.

If you add the static import to the entry point of this library, then you have the ability to assert that your integer arrays come from the same distribution as another integer array.

```java
import static Matcher.StatAssertEntry.assertThat;

    @Test
    public void identicalDistributionsShouldHaveTheSame() {
        assertThat(new int[]{1, 1, 1, 1}).comesFromSameDistributionAs(new int[]{1, 1, 1, 1}, 0.01);
    }
```

It's fairly basic for now - desired future features include specific distributions (e.g. "isPowerLaw") and extending it to non-integer distributions.