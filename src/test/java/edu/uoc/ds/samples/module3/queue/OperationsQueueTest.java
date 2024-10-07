package edu.uoc.ds.samples.module3.queue;

import org.junit.Assert;
import org.junit.Test;

public class OperationsQueueTest {
    @Test
    public  void test() {
        OperationsQueue operationsQueue = new OperationsQueue();
        operationsQueue.addOperation(new Add(1,1));
        operationsQueue.addOperation(new Add(2,1));
        operationsQueue.addOperation(new Add(100,100));
        Assert.assertEquals(3, operationsQueue.numOperations());

        operationsQueue.createProcessor();
    }
}
