package edu.uoc.ds.exercises.module6.exercise12;

import edu.uoc.ds.traversal.Iterator;

public interface AcademicCourse {
	
	void addStudent(Student student);
	void addSubject(Subject subject);
	void register(String studentId, int subjectId);
	Iterator<Subject> subjects(String studentId);

}
