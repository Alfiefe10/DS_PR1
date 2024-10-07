package edu.uoc.ds.samples.module8.academy;

import edu.uoc.ds.adt.nonlinear.graphs.Vertex;

public class PassedSubject implements Mark {
	
	private final Vertex<Subject> subject;
	private final double mark;
	
	
	public PassedSubject(Vertex<Subject> subject, double mark) {
		this.subject =subject;
		this.mark =mark;
	}
	
	
	public Vertex<Subject> getVerticeAsignatura() { return subject; }
	public Subject getSubject() { return subject.getValue(); }
	public double getMark() { return mark; }
	
	public String toString() { return "["+ subject +","+ mark +"]"; }

}
