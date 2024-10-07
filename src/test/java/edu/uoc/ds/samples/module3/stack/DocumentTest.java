
package edu.uoc.ds.samples.module3.stack;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class DocumentTest {
	Document document;
	Page p1, p2, p3, p4, p5;

	@Before
	public void setUp() {
		document = new Document(5);
		p1 = new Page("Lorem Ipsum is simply dummy text of the printing ...");
		p2 = new Page("Contrary to popular belief, Lorem Ipsum is not simply random text ...");
		p3 = new Page("Contrary to popular belief, Lorem Ipsum is not simply random text ...");
		p4 = new Page("The standard chunk of Lorem Ipsum used since the 1500s is ...");
		p5 = new Page("It is a long established fact that a reader will be distracted ...");
	}

	@Test
	public void test() {
		Assert.assertFalse(document.isFull());

		document.add(p1);
		Assert.assertEquals(1, document.getNumPages());

		document.add(p2);
		Assert.assertEquals(2, document.getNumPages());

		document.add(p3);
		Assert.assertEquals(3, document.getNumPages());

		document.add(p4);
		Assert.assertEquals(4, document.getNumPages());
		Assert.assertFalse(document.isFull());

		document.add(p5);
		Assert.assertEquals(5, document.getNumPages());
		Assert.assertTrue(document.isFull());
	}

	@Test
	public void rotateTest()  {
		test();
		Document reverseDoc = document.rotate();
		Assert.assertEquals(5, reverseDoc.getNumPages());
		Assert.assertTrue(reverseDoc.isFull());

		Assert.assertEquals(p5, reverseDoc.getPage(0));
		Assert.assertEquals(p4, reverseDoc.getPage(1));
		Assert.assertEquals(p3, reverseDoc.getPage(2));
		Assert.assertEquals(p2, reverseDoc.getPage(3));
		Assert.assertEquals(p1, reverseDoc.getPage(4));

	}
	
}
