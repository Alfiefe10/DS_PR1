package edu.uoc.ds.samples.module4.traversal.levels;

public class Employee {

    private final String name;
    private String parkingArea;

    public Employee(String nom) {
        this.name = nom;
    }

    public String getName() {
        return name;
    }

    public String getParkingArea() {
        return parkingArea;
    }

    public void setParkingArea(String placaParking) {
        this.parkingArea = placaParking;
    }

    public String toString() {
        return "[" + name + "," + parkingArea + "]";
    }

}
