package edu.uoc.ds.samples.module6;

public class SymbolProperties {
	
	public enum Category { PROGRAM, PROC, PARAM, VAR }
	public enum Type {UNDEFINED, BOOLEAN, INT, REAL, CHAR }
	
	private final Category category;
	private final Type type;
	private final int size;
	private final int block;
	
	
	public SymbolProperties(int bloc, Category categoria, int dimensio) {
		this.block =bloc;
		this.category =categoria;
		this.type = Type.UNDEFINED;
		this.size =dimensio;
	}

	public SymbolProperties(int bloc, Category categoria, Type tipus, int dimensio) {
		this.block =bloc;
		this.category =categoria;
		this.type =tipus;
		this.size =dimensio;
	}
	
	
	public int getBlock() { return block; }
	public Category getCategory() { return category; }
	public Type getType() { return type; }
	public int getSize() { return size; }
	
	public String toString() {
		String sb = "[CAT:" + category +
				",T:" + type +
				",SIZE:" + size +
				",BLOCK:" + block + "]";
		return sb;
	}

}
