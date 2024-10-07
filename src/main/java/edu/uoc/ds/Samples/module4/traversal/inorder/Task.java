package edu.uoc.ds.samples.module4.traversal.inorder;

import java.util.Date;

public class Task {

    private final String name;
    private final long minDuration;
    private Date start;


    public Task(String name, int minDuration) {
        this.name = name;
        this.minDuration = minDuration;
    }


    public String getName() {
        return name;
    }

    public long getMinDuration() {
        return minDuration;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date inici) {
        this.start = inici;
    }

    public String toString() {
        return "[" + name + "," + minDuration +
                (start == null ? "]"
                        : "," + start + "]");
    }

}
