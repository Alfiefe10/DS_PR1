package edu.uoc.ds.samples.module5;

import edu.uoc.ds.adt.nonlinear.PriorityQueue;
import org.junit.Assert;
import org.junit.Test;

public class PriorityQueueTest {


	@Test
	public void test() {
		PriorityQueue<Integer> priorityQueue=new PriorityQueue<>();
		Integer e;
		priorityQueue.add(Integer.valueOf(5));
		priorityQueue.add(3); 	// Because autoboxing has the same effect as boxing the Integer(3)
		priorityQueue.add(4);
		priorityQueue.add(1);
		priorityQueue.add(2);
		Assert.assertEquals(5, priorityQueue.size());

		// The contents of the queue after previous inserts
		// is: 1, 2, 3, 4, 5
		Assert.assertFalse(priorityQueue.isEmpty());
		Assert.assertEquals(1, priorityQueue.poll().intValue());
		Assert.assertEquals(2, priorityQueue.peek().intValue());

		Assert.assertEquals(2, priorityQueue.poll().intValue());
		Assert.assertEquals(3, priorityQueue.peek().intValue());

		Assert.assertEquals(3, priorityQueue.poll().intValue());
		Assert.assertEquals(4, priorityQueue.peek().intValue());

		Assert.assertEquals(4, priorityQueue.poll().intValue());
		Assert.assertEquals(5, priorityQueue.peek().intValue());

		Assert.assertEquals(5, priorityQueue.poll().intValue());
		Assert.assertTrue(priorityQueue.isEmpty());

	}

}
