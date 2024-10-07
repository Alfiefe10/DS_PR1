package edu.uoc.ds.samples.module8.academy;

public class Subject {
	
	private final String name;
	private final double credits;
	
	
	public Subject(String nom, double credits) {
		this.name =nom;
		this.credits =credits;
	}
	
	
	public String getName() { return name; }
	public double getCredits() { return credits; }
	
	public boolean equals(Object asignatura) {
		return getName().equals(((Subject)asignatura).getName());
	}

	public String toString() { return "["+ name +","+ credits +"]"; }

}
