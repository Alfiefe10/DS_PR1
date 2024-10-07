package edu.uoc.ds.samples.module1.generics;

import edu.uoc.ds.adt.sequential.FiniteContainer;
import edu.uoc.ds.adt.sequential.Set;
import edu.uoc.ds.traversal.Iterator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SetArrayImplTest {
    FiniteSet<Integer> setArray;

    @Before
    public void setUp() {
        setArray = new SetArrayImpl(10);
    }

    @Test
    public void test1() {
        setArray.add(1);
        Assert.assertEquals(1, setArray.size());

        setArray.add(2);
        setArray.add(2);
        setArray.add(2);
        setArray.add(2);
        setArray.add(2);
        Assert.assertEquals(2, setArray.size());

        setArray.add(3);
        Assert.assertEquals(3, setArray.size());

        setArray.add(4);
        Assert.assertEquals(4, setArray.size());

        setArray.add(5);
        Assert.assertEquals(5, setArray.size());
    }

    @Test
    public void test2() {
        test1();
        Assert.assertEquals(5, setArray.size());

        setArray.add(6);
        Assert.assertEquals(6, setArray.size());

        setArray.add(7);
        Assert.assertEquals(7, setArray.size());

        setArray.add(8);
        Assert.assertEquals(8, setArray.size());

        setArray.add(9);
        Assert.assertEquals(9, setArray.size());

        setArray.add(10);
        Assert.assertEquals(10, setArray.size());
        Assert.assertTrue(setArray.isFull());

        Assert.assertThrows(ArrayIndexOutOfBoundsException.class, () -> setArray.add(11));

        Assert.assertTrue(setArray.contains(1));
        Assert.assertTrue(setArray.contains(2));
        Assert.assertTrue(setArray.contains(3));
        Assert.assertTrue(setArray.contains(4));
        Assert.assertTrue(setArray.contains(5));
        Assert.assertTrue(setArray.contains(6));
        Assert.assertTrue(setArray.contains(7));
        Assert.assertTrue(setArray.contains(8));
        Assert.assertTrue(setArray.contains(9));
        Assert.assertTrue(setArray.contains(10));
        Assert.assertFalse(setArray.contains(999));
    }

    @Test
    public void testIterator() {
        test1();
        Iterator<Integer> it = setArray.values();
        Assert.assertEquals(1, it.next().intValue());
        Assert.assertEquals(2, it.next().intValue());
        Assert.assertEquals(3, it.next().intValue());
        Assert.assertEquals(4, it.next().intValue());
        Assert.assertEquals(5, it.next().intValue());
        Assert.assertFalse(it.hasNext());
    }
}
