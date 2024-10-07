package edu.uoc.ds.samples.module8.academy;

import edu.uoc.ds.adt.nonlinear.graphs.Vertex;
import edu.uoc.ds.adt.sequential.LinkedList;
import org.junit.Assert;
import org.junit.Test;

public class ElectricAcademyTest {


    /**
     *                [S1]  ----- [S2] ---- [S4] ---- [S5]
     *                  |                    |
     *                  |                    |
     *                [S3]-------------------
     */
    public SubjectsGraph newSubjectsGraph() {
        SubjectsGraph subjects = new SubjectsGraphImpl();
        Vertex<Subject> vS1 = subjects.newVertex(new Subject("S1", 3.5));
        Vertex<Subject> vS2 = subjects.newVertex(new Subject("S2", 3.5));
        Vertex<Subject> vS3 = subjects.newVertex(new Subject("S3", 3.5));
        Vertex<Subject> vS4 = subjects.newVertex(new Subject("S4", 3.5));
        Vertex<Subject> vS5 = subjects.newVertex(new Subject("S5", 6));
        subjects.newEdge(vS1, vS2);
        subjects.newEdge(vS1, vS3);
        subjects.newEdge(vS2, vS4);
        subjects.newEdge(vS3, vS4);
        subjects.newEdge(vS4, vS5);
        return subjects;
    }


    public LinkedList<String> popupaleTeachers() {
        LinkedList<String> teachers = new LinkedList<>();
        teachers.insertEnd("T1");
        teachers.insertEnd("T2");
        return teachers;
    }

	@Test
    public void test() throws Exception {
        ElectricAcademyTest test = new ElectricAcademyTest();
        SubjectsGraph subjects = test.newSubjectsGraph();
        LinkedList<String> teachers = test.popupaleTeachers();
        ElectricAcademy academy = new ElectricAcademyImpl(subjects, teachers.values());
        academy.teachSubject("T1", "S1");
        academy.teachSubject("T1", "S2");
        academy.teachSubject("T1", "S5");
        academy.teachSubject("T2", "S3");
        academy.teachSubject("T2", "S4");
        academy.addStudent("ST1");

        academy.register("ST1", "S1");
		academy.passedSubject("ST1", "S1", 8.0);
        academy.register("ST1", "S2");

        academy.passedSubject("ST1", "S2", 6.0);

        Assert.assertThrows(ExceptionPrerequisiteNotSatisfied.class, () ->
                academy.register("ST1", "S4"));

        academy.register("ST1", "S3");
        academy.passedSubject("ST1", "S3", 8.0);
        academy.register("ST1", "S4");

        Assert.assertThrows(ExceptionPrerequisiteNotSatisfied.class, () ->
                academy.register("ST1", "S5"));

        academy.passedSubject("ST1", "S4", 9.5);
        academy.register("ST1", "S5");

        academy.passedSubject("ST1", "S5", 7.5);
    }

}
