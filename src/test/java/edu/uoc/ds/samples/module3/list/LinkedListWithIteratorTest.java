package edu.uoc.ds.samples.module3.list;

import edu.uoc.ds.adt.sequential.List;
import edu.uoc.ds.traversal.Iterator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class LinkedListWithIteratorTest {

    List<Integer> l;

    @Before
    public void setUp() {
        l = new LinkedListWithIterator<>();
    }

    @Test
    public void test() {
        l.insertEnd(56);
        l.insertEnd(32);
        l.insertEnd(2);
        l.insertEnd(34);
        l.insertEnd(22);
        l.insertEnd(8);

        Iterator<Integer> it = l.values();
        Assert.assertEquals(56, it.next().intValue());
        Assert.assertEquals(32, it.next().intValue());
        Assert.assertEquals(2, it.next().intValue());
        Assert.assertEquals(34, it.next().intValue());
        Assert.assertEquals(22, it.next().intValue());
        Assert.assertEquals(8, it.next().intValue());
        Assert.assertFalse(it.hasNext());
    }

}
