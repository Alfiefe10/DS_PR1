package edu.uoc.ds.adt;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PR1QueueTest {

    PR1Queue pr1q;

    private void fillQueue() {
        for (int i = 0; i < 15; i++) {          // Se llena con los primeros 15 valores de N
            pr1q.add(PeriodicFunction.f(i));    // Inserta f(i) en la cola
        }
    }

    @Before
    public void setUp() {
        this.pr1q = new PR1Queue();
        assertNotNull(this.pr1q.getQueue());
        this.fillQueue();
    }

    @After
    public void release() {
        this.pr1q = null;
    }

    @org.junit.Test
    public void queueTest() {
        assertEquals(this.pr1q.CAPACITY, this.pr1q.getQueue().size());

        // Orden de salida IGUAL al de entrada: {0, 1, 4, 9, 0, 1, 4, 9, 0, 1, 4, 9, 0, 1, 4}
        Assert.assertEquals(0, pr1q.poll(), 0);
        Assert.assertEquals(1, pr1q.poll(), 0);
        Assert.assertEquals(4, pr1q.poll(), 0);
        Assert.assertEquals(9, pr1q.poll(), 0);
        Assert.assertEquals(0, pr1q.poll(), 0);
        Assert.assertEquals(1, pr1q.poll(), 0);
        Assert.assertEquals(4, pr1q.poll(), 0);
        Assert.assertEquals(9, pr1q.poll(), 0);
        Assert.assertEquals(0, pr1q.poll(), 0);
        Assert.assertEquals(1, pr1q.poll(), 0);
        Assert.assertEquals(4, pr1q.poll(), 0);
        Assert.assertEquals(9, pr1q.poll(), 0);
        Assert.assertEquals(0, pr1q.poll(), 0);
        Assert.assertEquals(1, pr1q.poll(), 0);
        Assert.assertEquals(4, pr1q.poll(), 0);

        assertEquals(0, this.pr1q.getQueue().size());
    }
}
