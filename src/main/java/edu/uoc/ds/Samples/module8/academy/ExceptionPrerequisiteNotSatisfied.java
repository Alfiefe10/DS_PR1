package edu.uoc.ds.samples.module8.academy;

public class ExceptionPrerequisiteNotSatisfied extends Exception {

    private final String student;
    private final String subject;
    private final String prerequisite;


    public ExceptionPrerequisiteNotSatisfied(String student, String subject, String prerequisite) {
        this.student = student;
        this.subject = subject;
        this.prerequisite = prerequisite;
    }


    public String toString() {
        return "Student " + student + " can not enroll the subject " + subject + " since he does not have the subject " + prerequisite + " passed";
    }

}
