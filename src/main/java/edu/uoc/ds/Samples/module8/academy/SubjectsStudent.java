package edu.uoc.ds.samples.module8.academy;

import edu.uoc.ds.adt.helpers.Position;
import edu.uoc.ds.adt.nonlinear.graphs.Vertex;
import edu.uoc.ds.adt.sequential.LinkedList;
import edu.uoc.ds.traversal.Iterator;
import edu.uoc.ds.traversal.Traversal;

class SubjectsStudent {

    private final LinkedList<Vertex<Subject>> currentSubjects;
    private final LinkedList<PassedSubject> passedSubjects;


    public SubjectsStudent() {
        currentSubjects = new LinkedList<>();
        passedSubjects = new LinkedList<PassedSubject>();
    }


    public void newSubject(Vertex<Subject> subject) {
        currentSubjects.insertEnd(subject);
    }


    public void passedSubject(Vertex<Subject> subject, double mark) {
        PassedSubject passedSubject = new PassedSubject(subject, mark);
        deleteCurrentSubject(subject);
        passedSubjects.insertEnd(passedSubject);
    }


    public Iterator<PassedSubject> record() {
        return passedSubjects.values();
    }


    public double averageRecord() {
        double totalMarks = 0;
        double nCredits = 0;
        Iterator<PassedSubject> marks = record();
        while (marks.hasNext()) {
            Mark mark = marks.next();
            totalMarks += mark.getMark() * mark.getSubject().getCredits();
            nCredits += mark.getSubject().getCredits();
        }
        return totalMarks / nCredits;
    }


    public boolean isPassed(Vertex<Subject> asignatura) {
        Iterator<PassedSubject> asignaturas = record();
        boolean found = false;
        while (asignaturas.hasNext() && !found) {
            PassedSubject aprobada = asignaturas.next();
            found = asignatura == aprobada.getVerticeAsignatura();
        }
        return found;
    }


    protected void deleteCurrentSubject(Vertex<Subject> asignatura) {
        Traversal<Vertex<Subject>> positions = currentSubjects.positions();
        Position<Vertex<Subject>> position = null;
        boolean found = false;
        while (positions.hasNext() && !found) {
            position = positions.next();
            found = position.getElem() == asignatura;
        }
        currentSubjects.delete(position);
    }


    public String toString() {
        return "{" + currentSubjects + ";" + passedSubjects + "}";
    }


}
