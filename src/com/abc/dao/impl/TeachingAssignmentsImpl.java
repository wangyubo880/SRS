package com.abc.dao.impl;

import com.abc.dao.ProfessorDAO;
import com.abc.dao.ScheduledCourseDAO;
import com.abc.dao.TeachingAssignmentDAO;

public class TeachingAssignmentsImpl implements TeachingAssignmentDAO {

	@Override
	public void initialize(ProfessorDAO professors, ScheduledCourseDAO classes) {
		
		//根据工号查找教授对象，安排所任课
		classes.getByID("CS101-1").setInstructor(professors.getByPID("123403"));
		classes.getByID("CS101-2").setInstructor(professors.getByPID("123402"));
		classes.getByID("CS102-1").setInstructor(professors.getByPID("123401"));
		classes.getByID("CS102-2").setInstructor(professors.getByPID("123403"));
		classes.getByID("CS103-1").setInstructor(professors.getByPID("123401"));
		classes.getByID("MAT101-1").setInstructor(professors.getByPID("123402"));
		classes.getByID("CS201-1").setInstructor(professors.getByPID("123403"));

	}

}
