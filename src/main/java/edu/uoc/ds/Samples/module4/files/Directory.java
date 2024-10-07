package edu.uoc.ds.samples.module4.files;


import edu.uoc.ds.adt.helpers.Position;

public class Directory extends FSEntry {

	public Directory(String nombre, Position<FSEntry> padre) {
		super(nombre, padre);
	}

	public boolean isDirectory() { return true; }

}
