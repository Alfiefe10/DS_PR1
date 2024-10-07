package edu.uoc.ds.samples.module1.defensive;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DefensiveiNatTest {
    DefensiveNat defensiveNat;

    @Before
    public void setUp() {
        defensiveNat = new DefensiveiNatImpl();
    }

    @Test
    public void defensiveiNatTest1() {
        Assert.assertThrows(NatException.class, () ->
                defensiveNat.pred());

        defensiveNat.succ();
        Assert.assertEquals(1, defensiveNat.get());
        defensiveNat.succ();
        Assert.assertEquals(2, defensiveNat.get());
    }

    @Test
    public void defensiveiNatTest2() {
        defensiveNat.succ();
        Assert.assertEquals(1, defensiveNat.get());
        defensiveNat.succ();
        Assert.assertEquals(2, defensiveNat.get());

        DefensiveNat defensiveNatAux = new DefensiveiNatImpl();
        defensiveNatAux.succ();
        defensiveNatAux.succ();
        defensiveNatAux.succ();
        defensiveNatAux.succ();
        defensiveNatAux.succ();
        Assert.assertEquals(5, defensiveNatAux.get());

        defensiveNat.addAmount(defensiveNatAux);
        Assert.assertEquals(7, defensiveNat.get());
    }

}
