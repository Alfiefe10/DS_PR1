package edu.uoc.ds.samples.module3.resize;

import org.junit.Assert;
import org.junit.Test;

public class ResizableQueueTest {


    @Test
    public void test() {
        ResizableQueue<Integer> resizableQueue = new ResizableQueue<>(5);
        resizableQueue.add(1);
        resizableQueue.add(2);
        resizableQueue.add(3);
        resizableQueue.add(4);
        resizableQueue.add(5);
        Assert.assertEquals(5, resizableQueue.size());
        resizableQueue.add(6);
        Assert.assertEquals(6, resizableQueue.size());
    }
}
