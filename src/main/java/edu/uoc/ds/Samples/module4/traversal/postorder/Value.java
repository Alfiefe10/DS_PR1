package edu.uoc.ds.samples.module4.traversal.postorder;

public class Value extends ExpressionElem {
	
	public Value(double value) { setResult(value); }

	public String toString() { return String.valueOf(getResult()); }

}
