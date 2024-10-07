package edu.uoc.ds.samples.module3.list;

import edu.uoc.ds.adt.sequential.Set;
import edu.uoc.ds.traversal.Iterator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class SetLinkedListImplTest {
    private Set<Integer> set;

    @Before
    public void setUp() {
        set = new SetLinkedListImpl<>();
    }

    @Test
    public void test() {
        set.add(56);
        Assert.assertEquals(1, set.size());
        set.add(56);
        Assert.assertEquals(1, set.size());
        set.add(56);
        Assert.assertEquals(1, set.size());
        set.add(56);
        Assert.assertEquals(1, set.size());
        set.add(32);
        Assert.assertEquals(2, set.size());
        set.add(2);
        Assert.assertEquals(3, set.size());
        set.add(34);
        Assert.assertEquals(4, set.size());
        set.add(22);
        Assert.assertEquals(5, set.size());
        set.add(8);
        Assert.assertEquals(6, set.size());

        Iterator<Integer> it = set.values();
        Assert.assertEquals(56, it.next().intValue());
        Assert.assertEquals(32, it.next().intValue());
        Assert.assertEquals(2, it.next().intValue());
        Assert.assertEquals(34, it.next().intValue());
        Assert.assertEquals(22, it.next().intValue());
        Assert.assertEquals(8, it.next().intValue());
        Assert.assertFalse(it.hasNext());
    }
}
