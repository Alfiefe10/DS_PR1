package edu.uoc.ds.samples.module1;

import org.junit.Assert;
import org.junit.Test;

public class NatTest {

    public static Nat multiply(Nat a, Nat b) {
        Nat c = new NatiImpl();
        for (int i = 0; i < b.get(); i++)
            c.addAmount(a);
        return c;
    }

    @Test
    public void test() {
        Nat n1 = new NatbImpl();
        Nat n2 = new NatiImpl();
        n1.succ();
        n1.succ();
        Assert.assertEquals(2, n1.get());

        n2.succ();
        n2.succ();
        n2.succ();
        Assert.assertEquals(3, n2.get());

        Nat n3 = multiply(n1, n2);
        Assert.assertEquals( 6, n3.get());
    }
}
