package edu.uoc.ds.exercises.module5.exercise3;

final public class PriorityDocument implements Comparable<PriorityDocument> {

    private Document document;
    private int priority;
    private int identifier;

    PriorityDocument(Document doc, int prior, int id) {
        setDocument(doc);
        setPriority(prior);
        setIdentifier(id);
    }

    private void setDocument(Document doc) {
        document = doc;
    }

    private void setPriority(int prior) {
        priority = prior;
    }

    private void setIdentifier(int id) {
        identifier = id;
    }

    public Document getDocument() {
        return (document);
    }

    public int getPriority() {
        return (priority);
    }

    public int getIdentifier() {
        return (identifier);
    }

    public int compareTo(PriorityDocument doc2) {
		/*
        if (getPriority() < doc2.getPriority()) return (-1);
        else {
            if (getPriority() > doc2.getPriority()) return (1);
            else return (0);
        }*/
		return Integer.compare(getPriority(), doc2.getPriority());
    }
}
