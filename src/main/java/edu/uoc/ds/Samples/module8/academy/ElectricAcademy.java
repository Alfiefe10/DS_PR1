package edu.uoc.ds.samples.module8.academy;

import edu.uoc.ds.traversal.Iterator;

public interface ElectricAcademy {

    void addStudent(String student);

    void register(String student, String subject) throws ExceptionPrerequisiteNotSatisfied;

    void passedSubject(String student, String subject, double mark);

    void teachSubject(String teacher, String subject);

    Iterator<? extends Mark> academicRecord(String student);

    double addTeacher(String teacher);

}
