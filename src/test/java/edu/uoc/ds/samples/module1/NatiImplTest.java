package edu.uoc.ds.samples.module1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NatiImplTest {
    private Nat n;

    @Before
    public void setUp() {
        n = new NatiImpl(); // (1)
        // (2) @post n = 0
        Assert.assertEquals(0, n.get());
    }

    @Test
    public void test() {
        Assert.assertEquals(0, n.get()); // (4)
        n.succ(); // (4)
        // (5) @post $old(get()) + 1
        Assert.assertEquals(1, n.get());

        n.pred(); // (7)
        // (8) @post $old(get()) - 1
        Assert.assertEquals(0, n.get());
    }
}
