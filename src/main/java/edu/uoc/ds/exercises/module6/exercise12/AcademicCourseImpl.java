package edu.uoc.ds.exercises.module6.exercise12;


import edu.uoc.ds.traversal.Iterator;

public class AcademicCourseImpl implements AcademicCourse {

    StudentsTable students;
    SubjectsTable subjects;


    public AcademicCourseImpl() {
        students = new StudentsTable();
        subjects = new SubjectsTable();
    }


    public void addStudent(Student student) {
        students.put(student.getDNI(), student);
    }


    public void addSubject(Subject subject) {
        subjects.put(subject.getCode(), subject);
    }


    public void register(String studentId, int subjectId) {
        Student student = students.get(studentId);
        Subject subject = subjects.get(subjectId);
        student.register(subject);
    }


    public Iterator<Subject> subjects(String studentId) {
        Student student = students.get(studentId);
        return student.subjects();
    }

}
