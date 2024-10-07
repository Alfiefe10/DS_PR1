package edu.uoc.ds.exercises.module6.exercise12;

import edu.uoc.ds.traversal.Iterator;
import org.junit.Assert;
import org.junit.Test;

public class AcademicCourseImplTest {

	@Test
    public  void test() {
        AcademicCourse course = new AcademicCourseImpl();
        course.addSubject(new Subject(301, "Statistics", 9));
        course.addSubject(new Subject(302, "Analysis", 6));
        course.addSubject(new Subject(303, "Operating systems", 6));
        course.addSubject(new Subject(304, "Data Structures", 6));
        course.addSubject(new Subject(305, "English III", 4.5));
        course.addStudent(new Student("33333333", "Juan", "Pérez", "Mir"));
        course.addStudent(new Student("20761234", "Ana", "Estrada", "Gimper"));
        course.addStudent(new Student("57980110", "Maria", "Gombren", "Josafat"));
        course.register("33333333", 301);
        course.register("33333333", 302);
        course.register("33333333", 303);
        course.register("33333333", 304);
        course.register("33333333", 305);
        course.register("20761234", 303);
        course.register("20761234", 305);
        course.register("57980110", 301);

        Iterator<Subject> it = course.subjects("33333333");
        Assert.assertEquals("Statistics", it.next().getName());
        Assert.assertEquals("Analysis", it.next().getName());
        Assert.assertEquals("Operating systems", it.next().getName());
        Assert.assertEquals("Data Structures", it.next().getName());
        Assert.assertEquals("English III", it.next().getName());
        Assert.assertFalse(it.hasNext());

        it = course.subjects("20761234");
        Assert.assertEquals("Operating systems", it.next().getName());
        Assert.assertEquals("English III", it.next().getName());
        Assert.assertFalse(it.hasNext());


        it = course.subjects("57980110");
        Assert.assertEquals("Statistics", it.next().getName());
        Assert.assertFalse(it.hasNext());

    }

}
