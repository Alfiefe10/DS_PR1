package edu.uoc.ds.adt;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PR1StackTest {

    PR1Stack pr1s;

    private void fillStack() {
        for (char c = '0'; c < '9'; c++) {
            pr1s.push(c);
        }
    }

    @Before
    public void setUp() {
        this.pr1s = new PR1Stack();

        assertNotNull(this.pr1s.getStack());
        this.fillStack();
    }

    @After
    public void release() {
        this.pr1s = null;
    }

    @org.junit.Test
    public void stackTest() {
        assertEquals(this.pr1s.CAPACITY - 1, this.pr1s.getStack().size());
        Assert.assertEquals(new Character('8'), pr1s.pop());
        Assert.assertEquals(new Character('7'), pr1s.pop());
        Assert.assertEquals(new Character('6'), pr1s.pop());
        Assert.assertEquals(new Character('5'), pr1s.pop());
        Assert.assertEquals(new Character('4'), pr1s.pop());
        Assert.assertEquals(new Character('3'), pr1s.pop());
        Assert.assertEquals(new Character('2'), pr1s.pop());
        Assert.assertEquals(new Character('1'), pr1s.pop());
        Assert.assertEquals(new Character('0'), pr1s.pop());
        assertEquals(0, this.pr1s.getStack().size());
    }

    @org.junit.Test
    public void stackTestExample() {
        assertEquals(this.pr1s.CAPACITY, this.pr1s.getStack().size());
        Assert.assertEquals(9, pr1s.pop(), 0);
        Assert.assertEquals(4, pr1s.pop(), 0);
        Assert.assertEquals(1, pr1s.pop(), 0);
        Assert.assertEquals(0, pr1s.pop(), 0);
        Assert.assertEquals(9, pr1s.pop(), 0);
        Assert.assertEquals(4, pr1s.pop(), 0);
        Assert.assertEquals(1, pr1s.pop(), 0);
        Assert.assertEquals(0, pr1s.pop(), 0);
        Assert.assertEquals(9, pr1s.pop(), 0);
        Assert.assertEquals(4, pr1s.pop(), 0);
        Assert.assertEquals(1, pr1s.pop(), 0);
        Assert.assertEquals(0, pr1s.pop(), 0);
        Assert.assertEquals(9, pr1s.pop(), 0);
        Assert.assertEquals(4, pr1s.pop(), 0);
        Assert.assertEquals(1, pr1s.pop(), 0);
        assertEquals(0, this.pr1s.getStack().size());
    }
}
