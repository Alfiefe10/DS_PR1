package edu.uoc.ds.samples.module1;

import org.junit.Assert;
import org.junit.Test;

public class ErrorNatTest {

	@Test
	public  void test1() {
		Nat n=new NatiImpl();
		n.pred();
		Assert.assertEquals(-1, n.get());
	}

	@Test
	public  void test2() {
		Nat n=new NatbImpl();
		Assert.assertThrows(ArrayIndexOutOfBoundsException.class, ()->n.pred());
	}

}
