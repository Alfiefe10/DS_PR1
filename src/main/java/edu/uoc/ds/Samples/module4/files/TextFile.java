package edu.uoc.ds.samples.module4.files;


import edu.uoc.ds.adt.helpers.Position;

public class TextFile extends FSEntry {

    private String content;

    public TextFile(String name, Position<FSEntry> parent) {
        super(name, parent);
    }

    public boolean isDirectory() {
        return false;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

}
