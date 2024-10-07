package edu.uoc.ds.samples.module4.traversal.postorder;

public class Operation extends ExpressionElem {

    private final char operator;

    public Operation(char operador) {
        this.operator = operador;
    }

    public char getOperator() {
        return operator;
    }

    public String toString() {
        return String.valueOf(operator);
    }

}
