package edu.uoc.ds.samples.module4.files;

import edu.uoc.ds.adt.helpers.Position;

public abstract class FSEntry {

    private String name;
    private final Position<FSEntry> parent;

    public FSEntry(String nombre, Position<FSEntry> parent) {
        this.name = nombre;
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Position<FSEntry> getParent() {
        return parent;
    }

    public abstract boolean isDirectory();

    public String toString() {
        return name;
    }

}
