package edu.uoc.ds.samples.module4.traversal.postorder;

import edu.uoc.ds.adt.helpers.Position;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ExpressionTest {
    private Expression tree;

    @Before
    public void setUp() {
        tree = new Expression();
        populateTree(tree);
    }

    public static void populateTree(Expression tree) {
        Position<ExpressionElem> op1 = tree.add(null, new Operation('+'));
        tree.addLeftChild(op1, new Value(3));
        Position<ExpressionElem> op2 = tree.addRightChild(op1, new Operation('*'));
        tree.addLeftChild(op2, new Value(5));
        Position<ExpressionElem> op3 = tree.addRightChild(op2, new Operation('+'));
        tree.addLeftChild(op3, new Value(6));
        tree.addRightChild(op3, new Value(1));
    }

    /**
     *
     *                             +
     *                           /   \
     *                          3     *
     *                              /   \
     *                             5     +
     *                                 /   \
     *                                6     1
     *
     */
    @Test
    public void test() {
        double result = tree.evaluate();
        Assert.assertEquals(38, result,0);
    }
}
