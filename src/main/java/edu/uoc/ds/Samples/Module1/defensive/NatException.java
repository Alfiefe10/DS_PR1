package edu.uoc.ds.samples.module1.defensive;

/**
 * Exception that it will be thrown when any of the operations
 * of the ADT Nat do not meet the conditions to run.
 */
public class NatException extends Exception {
	
	public NatException(String message) {
		super(message);
	}

}
