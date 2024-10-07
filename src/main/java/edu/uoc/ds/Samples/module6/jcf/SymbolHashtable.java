package edu.uoc.ds.samples.module6.jcf;

import java.util.*;

import edu.uoc.ds.samples.module6.SymbolProperties;

class SymbolHashtable extends HashMap<String,Stack<SymbolProperties>> {
	
	private static final int SIZE = 1023;
	
	public SymbolHashtable() {
		super(SIZE);
	}
	
}
