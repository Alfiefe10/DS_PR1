package edu.uoc.ds.samples.module2;

import org.junit.Test;

public class MatrixTest {

    @Test
    public void test() {
        Matrix m = new Matrix(2, 3);
        Matrix n = new Matrix(3, 2);
        m.set(0, 0, 2);
        m.set(0, 1, -3);
        m.set(0, 2, 1);
        m.set(1, 0, 6);
        m.set(1, 1, 5);
        m.set(1, 2, 3);
        n.set(0, 0, 1);
        n.set(0, 1, -2);
        n.set(1, 0, 5);
        n.set(1, 1, 8);
        n.set(2, 0, 3);
        n.set(2, 1, 4);
        System.out.println("M = " + m);
        System.out.println("N = " + n);
        Matrix result = m.multiplyBy(n);
        System.out.println("M x N = " + result);
    }
}
