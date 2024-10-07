package edu.uoc.ds.exercises.module6.exercise12;

import edu.uoc.ds.adt.sequential.LinkedList;
import edu.uoc.ds.adt.sequential.List;
import edu.uoc.ds.traversal.Iterator;

public class Student {

    private final String dni;
    private final String name;
    private final String firstSurname;
    private final String secondSurname;
    private String address;
    private String email;
    private String age;
    private final List<Subject> subjects;

    public Student(String dni, String name, String firstSurname, String secondSurname) {
        this.dni = dni;
        this.name = name;
        this.firstSurname = firstSurname;
        this.secondSurname = secondSurname;
        subjects = new LinkedList<>();
    }


    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getDNI() {
        return dni;
    }

    public String getName() {
        return name;
    }

    public String getFirstSurname() {
        return firstSurname;
    }

    public String getSecondSurname() {
        return secondSurname;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getAge() {
        return age;
    }

    void register(Subject subject) {
        subjects.insertEnd(subject);
    }

    Iterator<Subject> subjects() {
        return subjects.values();
    }

}
