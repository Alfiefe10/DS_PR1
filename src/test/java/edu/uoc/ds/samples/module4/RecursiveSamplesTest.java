package edu.uoc.ds.samples.module4;

import org.junit.Assert;
import org.junit.Test;

public class RecursiveSamplesTest {

    @Test
    public  void test() {
        Assert.assertTrue(RecursiveSamples.isEven(2));
        Assert.assertFalse(RecursiveSamples.isEven(3));

        Assert.assertEquals(15, RecursiveSamples.mcd(1035, 375));
    }

}
