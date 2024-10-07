package edu.uoc.ds.samples.module1;


import edu.uoc.ds.samples.module1.generics.FiniteSet;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SetArrayImplTest {
	FiniteSet finiteSet;

	@Before
	public void setUp() {
		finiteSet = new SetArrayImpl(10);


		finiteSet.add(1);
		Assert.assertEquals(1, finiteSet.size());

		finiteSet.add(2);
		finiteSet.add(2);
		finiteSet.add(2);
		finiteSet.add(2);
		finiteSet.add(2);
		Assert.assertEquals(2, finiteSet.size());

		finiteSet.add(3);
		Assert.assertEquals(3, finiteSet.size());

		finiteSet.add(4);
		Assert.assertEquals(4, finiteSet.size());

		finiteSet.add(5);
		Assert.assertEquals(5, finiteSet.size());
	}

	@Test
	public void test() {
		Assert.assertEquals(5, finiteSet.size());

		finiteSet.add(6);
		Assert.assertEquals(6, finiteSet.size());

		finiteSet.add(7);
		Assert.assertEquals(7, finiteSet.size());

		finiteSet.add(8);
		Assert.assertEquals(8, finiteSet.size());

		finiteSet.add(9);
		Assert.assertEquals(9, finiteSet.size());

		finiteSet.add(10);
		Assert.assertEquals(10, finiteSet.size());
		Assert.assertTrue(finiteSet.isFull());

		Assert.assertThrows(ArrayIndexOutOfBoundsException.class, () -> finiteSet.add(11));

		Assert.assertTrue(finiteSet.contains(1));
		Assert.assertTrue(finiteSet.contains(2));
		Assert.assertTrue(finiteSet.contains(3));
		Assert.assertTrue(finiteSet.contains(4));
		Assert.assertTrue(finiteSet.contains(5));
		Assert.assertTrue(finiteSet.contains(6));
		Assert.assertTrue(finiteSet.contains(7));
		Assert.assertTrue(finiteSet.contains(8));
		Assert.assertTrue(finiteSet.contains(9));
		Assert.assertTrue(finiteSet.contains(10));
		Assert.assertFalse(finiteSet.contains(999));
	}


}
