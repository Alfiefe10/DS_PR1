package edu.uoc.ds.samples.module8.academy;

import edu.uoc.ds.adt.helpers.Position;
import edu.uoc.ds.adt.nonlinear.graphs.Vertex;
import edu.uoc.ds.adt.sequential.LinkedList;


class SubjectsTeacher extends LinkedList<Vertex<Subject>> {

    private double creditos;


    public SubjectsTeacher() {
        creditos = 0;
    }


    public double getCredits() {
        return creditos;
    }


    public Vertex<Subject> borrarPrimero() {
        Vertex<Subject> asig = super.deleteFirst();
        creditos -= asig.getValue().getCredits();
        return asig;
    }


    public Vertex<Subject> delete(Position<Vertex<Subject>> node) {
        Vertex<Subject> subject = super.delete(node);
        creditos -= subject.getValue().getCredits();
        return subject;
    }


    public Vertex<Subject> deleteNext(Position<Vertex<Subject>> nodo) {
        Vertex<Subject> asig = super.deleteNext(nodo);
        creditos -= asig.getValue().getCredits();
        return asig;
    }


    public Vertex<Subject> update(Position<Vertex<Subject>> nodo, Vertex<Subject> elem) {
		Vertex<Subject> old = super.update(nodo, elem);
        creditos = creditos - old.getValue().getCredits() + elem.getValue().getCredits();
        return old;
    }


    protected LinkedNode<Vertex<Subject>> nuevaPosicion(LinkedNode<Vertex<Subject>> node, Vertex<Subject> elem) {
        creditos += elem.getValue().getCredits();
        return super.newPosition(node, elem);
    }

}
