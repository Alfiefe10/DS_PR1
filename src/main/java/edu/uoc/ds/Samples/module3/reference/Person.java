package edu.uoc.ds.samples.module3.reference;


public class Person {

    private final String name;
    private final Person father;
    private final Person mother;


    public Person(String nom) {
        this.name = nom;
        mother = null;
        father = null;
    }

    public Person(String nom, Person father, Person mother) {
        this.name = nom;
        this.father = father;
        this.mother = mother;
    }

    public String getName() {
        return name;
    }

    public Person getMother() {
        return mother;
    }

    public Person getFather() {
        return father;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(""+name);
        if (father!=null) sb.append(" father: "+father.getName());
        if (mother!=null) sb.append(" mother: "+mother.getName());
        return sb.toString();
    }

}
