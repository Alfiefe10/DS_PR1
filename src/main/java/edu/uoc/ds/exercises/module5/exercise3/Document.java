package edu.uoc.ds.exercises.module5.exercise3;

public class Document {

    private final String title;

    public Document(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String toString() {
        return getTitle();
    }

}
