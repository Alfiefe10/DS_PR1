package edu.uoc.ds.samples.module1;

import org.junit.Assert;
import org.junit.Test;

public class Figure1Test {


   @Test
    public  void test() {
        Nat n = Figure1.buildNat();
        Assert.assertEquals(0, n.get());
        n.succ();
        Assert.assertEquals(1, n.get());
        n.pred();
        Assert.assertEquals(0, n.get());
    }
}
