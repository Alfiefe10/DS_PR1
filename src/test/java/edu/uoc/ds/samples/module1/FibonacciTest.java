package edu.uoc.ds.samples.module1;

import org.junit.Assert;
import org.junit.Test;

public class FibonacciTest {

    @Test
    public void test() {
        int[] res = Fibonacci.showNumbers(10);

        Assert.assertArrayEquals(new int[]{0, 1, 1, 2, 3, 5, 8, 13, 21, 34}, res);
    }
}

