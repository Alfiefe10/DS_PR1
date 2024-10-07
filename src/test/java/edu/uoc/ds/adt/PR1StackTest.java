package edu.uoc.ds.adt;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PR1StackTest {

    PR1Stack pr1s;

    private void fillStack() {
        for (int i = 0; i < 15; i++) {          // Se llena con los primeros 15 valores de N
            pr1s.push(PeriodicFunction.f(i));   // Inserta f(i) en la cola
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
        assertEquals(this.pr1s.CAPACITY, this.pr1s.getStack().size());

        // Orden de salida INVERSO al de entrada: {4, 1, 0, 9, 4, 1, 0, 9, 4, 1, 0, 9, 4, 1, 0}
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
        Assert.assertEquals(0, pr1s.pop(), 0);

//        {0, 1, 4, 9, 0, 1, 4, 9, 0, 1, 4, 9, 0, 1, 4,}
        assertEquals(0, this.pr1s.getStack().size());
    }
}
