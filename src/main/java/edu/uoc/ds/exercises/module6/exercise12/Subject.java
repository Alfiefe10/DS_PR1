package edu.uoc.ds.exercises.module6.exercise12;

public class Subject {

    private final int code;
    private final String name;
    private final double credits;


    public Subject(int code, String name, double credits) {
        this.code = code;
        this.name = name;
        this.credits = credits;
    }


    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public double getCredits() {
        return credits;
    }

    public String toString() {
        return "[" + code + "," + name + "," + credits + "]";
    }

}
