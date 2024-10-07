package edu.uoc.ds.samples.module6;

import edu.uoc.ds.samples.module6.SymbolProperties.Category;
import edu.uoc.ds.samples.module6.SymbolProperties.Type;

public interface SymbolTable {
	
	void getIn();
	void goOut();
	void register(String id, Category category, Type type, int size);
	SymbolProperties get(String id);

}
