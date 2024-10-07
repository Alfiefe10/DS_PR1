package edu.uoc.ds.samples.module8.academy;

import edu.uoc.ds.adt.nonlinear.Dictionary;
import edu.uoc.ds.adt.nonlinear.DictionaryAVLImpl;
import edu.uoc.ds.adt.nonlinear.graphs.DirectedEdge;
import edu.uoc.ds.adt.nonlinear.graphs.Edge;
import edu.uoc.ds.adt.nonlinear.graphs.Vertex;
import edu.uoc.ds.adt.sequential.DictionaryLinkedListImpl;
import edu.uoc.ds.traversal.Iterator;

public class ElectricAcademyImpl implements ElectricAcademy {

    private final Dictionary<String, SubjectsStudent> students;
    private final SubjectsGraph subjectsGraph;
    private final Dictionary<String, SubjectsTeacher> teachers;


    public ElectricAcademyImpl(SubjectsGraph subjectsGraph, Iterator<String> teachers) {
		this.students = new DictionaryAVLImpl<String, SubjectsStudent>();
        this.subjectsGraph = subjectsGraph;
        this.teachers = new DictionaryLinkedListImpl<String, SubjectsTeacher>();
        while (teachers.hasNext()) {
            String teacher = teachers.next();
            this.teachers.put(teacher, new SubjectsTeacher());
        }
    }


    public void addStudent(String student) {
        SubjectsStudent subjects = new SubjectsStudent();
        students.put(student, subjects);
    }


    public void register(String student, String subject) throws ExceptionPrerequisiteNotSatisfied {
        Vertex<Subject> subjectVertex = subjectsGraph.getVertex(new Subject(subject, 0));
        checkPrerequisites(student, subjectVertex);
        SubjectsStudent subjectsStudent = students.get(student);
        subjectsStudent.newSubject(subjectVertex);
    }


    public void passedSubject(String student, String subject, double mark) {
        SubjectsStudent subjectsStudent = students.get(student);
        Vertex<Subject> subjectVertex = subjectsGraph.getVertex(new Subject(subject, 0));
        subjectsStudent.passedSubject(subjectVertex, mark);
    }


    public void teachSubject(String teacher, String subject) {
        SubjectsTeacher subjectsTeacher = teachers.get(teacher);
		Vertex<Subject> subjectVertex = subjectsGraph.getVertex(new Subject(subject, 0));
        subjectsTeacher.insertEnd(subjectVertex);
    }


    public Iterator<? extends Mark> academicRecord(String student) {
        SubjectsStudent subjectsStudent = students.get(student);
        return subjectsStudent.record();
    }


    public double addTeacher(String teacher) {
        SubjectsTeacher subjectsTeacher = teachers.get(teacher);
        return subjectsTeacher.getCredits();
    }


    protected void checkPrerequisites(String student, Vertex<Subject> subject)
            throws ExceptionPrerequisiteNotSatisfied {
        SubjectsStudent passedSubjects = students.get(student);
        Iterator<Edge<EmptyLabel, Subject>> edgePrerequisites = subjectsGraph.edgedWithDestination(subject);

        while (edgePrerequisites.hasNext()) {
            DirectedEdge<EmptyLabel, Subject> edge0 = (DirectedEdge<EmptyLabel, Subject>) edgePrerequisites.next();
            Vertex<Subject> preRequisite = edge0.getVertexSrc();
            if (!passedSubjects.isPassed(preRequisite))
                throw new ExceptionPrerequisiteNotSatisfied(student, subject.getValue().getName(), preRequisite.getValue().getName());
        }


    }


}
