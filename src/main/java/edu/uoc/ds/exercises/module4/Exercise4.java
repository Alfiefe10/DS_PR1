package edu.uoc.ds.exercises.module4;


import edu.uoc.ds.adt.helpers.Position;
import edu.uoc.ds.samples.module4.traversal.postorder.Expression;
import edu.uoc.ds.samples.module4.traversal.postorder.ExpressionElem;

public class Exercise4 {


    protected static class PrintableExpression extends Expression {

        public String toString() {
            return toString(root());
        }


        protected String toString(Position<ExpressionElem> subExpression) {
            String res;
            if (isLeaf(subExpression))
                res = subExpression.getElem().toString();
            else
                res = "(" + toString(leftChild(subExpression)) + subExpression.getElem() + toString(rightChild(subExpression)) + ")";
            return res;
        }
    }




}
