package edu.uoc.ds.samples.module3.stack;

import edu.uoc.ds.adt.sequential.Stack;
import edu.uoc.ds.adt.sequential.StackArrayImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StackTest {
    Stack<Integer> stack;

    @Before
    public void setUp(){
        stack = new StackArrayImpl<>(5);
    }

    @Test
    public void test() {
        stack.push(7);
        Assert.assertEquals(7, stack.peek().intValue());

        stack.push(4);

        Assert.assertEquals(4, stack.pop().intValue());

        stack.push(2);
        stack.push(8);
        Assert.assertEquals(3, stack.size());
        Assert.assertEquals(8, stack.peek().intValue());

    }
}
