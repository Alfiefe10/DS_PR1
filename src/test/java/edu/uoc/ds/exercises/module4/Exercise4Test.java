package edu.uoc.ds.exercises.module4;

import edu.uoc.ds.samples.module4.traversal.postorder.Expression;
import edu.uoc.ds.samples.module4.traversal.postorder.ExpressionTest;
import org.junit.Assert;
import org.junit.Test;

public class Exercise4Test {


    @Test
    public void test() {
        Expression expression = new Exercise4.PrintableExpression();
        ExpressionTest.populateTree(expression);
        /*
         *                             +
         *                           /   \
         *                          3     *
         *                              /   \
         *                             5     +
         *                                 /   \
         *                                6     1
         */
        double resultado = expression.evaluate();
        Assert.assertEquals(38, resultado, 0);
    }
}
