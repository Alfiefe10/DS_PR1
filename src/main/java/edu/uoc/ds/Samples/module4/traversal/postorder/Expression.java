package edu.uoc.ds.samples.module4.traversal.postorder;

import edu.uoc.ds.adt.helpers.Position;
import edu.uoc.ds.adt.nonlinear.BinaryTreeLinkedImpl;
import edu.uoc.ds.samples.module4.traversal.TreeTraversals;


public class Expression extends BinaryTreeLinkedImpl<ExpressionElem> {

    public double evaluate() {
        Eval eval = new Eval();
        eval.postOrder(this);
        return root().getElem().getResult();
    }


    protected class Eval extends TreeTraversals<ExpressionElem> {

        protected void processPosition(Position<ExpressionElem> position) {
            if (!isLeaf(position)) {
                Operation op = (Operation) position.getElem();
                double leftChild = leftChild(position).getElem().getResult();
                double rightChild = rightChild(position).getElem().getResult();
                switch (op.getOperator()) {
                    case '+':
                        op.setResult(leftChild + rightChild);
                        break;
                    case '-':
                        op.setResult(leftChild - rightChild);
                        break;
                    case '*':
                        op.setResult(leftChild * rightChild);
                        break;
                    case '/':
                        op.setResult(leftChild / rightChild);
                        break;
                }
            }
        }
    }


}
