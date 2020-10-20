package com.abc.console;

import com.abc.dao.CourseDAO;
import com.abc.dao.ProfessorDAO;
import com.abc.dao.ScheduledCourseDAO;
import com.abc.dao.StudentDAO;
import com.abc.dao.TeachingAssignmentDAO;
import com.abc.dao.impl.CourseDaoImpl;
import com.abc.dao.impl.ProfessorDaoImpl;
import com.abc.dao.impl.ScheduledCourseDaoImpl;
import com.abc.dao.impl.StudentDaoImpl;
import com.abc.dao.impl.TeachingAssignmentsImpl;
import com.abc.domain.EnrollmentStatus;
import com.abc.domain.Professor;
import com.abc.domain.ScheduledCourse;
import com.abc.domain.Student;

public class AppConsole {

	public static void main(String[] args) {
		ProfessorDAO professors = new ProfessorDaoImpl();
		professors.initialize();
		
		System.out.println("========教授========");
		for(Professor p:professors.getAll()) {
			System.out.println(p);
		}
		
		StudentDAO students = new StudentDaoImpl();
		students.initialize();
		System.out.println("========学生========");
		for(Student s:students.getAll()) {
			System.out.println(s);
		}
		
		CourseDAO courses = new CourseDaoImpl();
		courses.initialize();
		
		ScheduledCourseDAO ScheduledCoursees = new ScheduledCourseDaoImpl();
		ScheduledCoursees.initialize(courses);
		//安排任课教师
		TeachingAssignmentDAO ta = new TeachingAssignmentsImpl();
		ta.initialize(professors, ScheduledCoursees);
		System.out.println("========开出的课========");
		for(ScheduledCourse s:ScheduledCoursees.getAll()) {
			System.out.println(s);
		}
		System.out.println();
		
		//下面演示学生张三注册了一门容量为1的课，王五再注册则失败。
		EnrollmentStatus status;
		
		System.out.println("学生 张三 试图注册 CS201-1");
		status = ScheduledCoursees.getByID("CS201-1").enroll(students.getByName("张三"));
		System.out.println(status.value());
		
		System.out.println("学生 王五 试图注册 CS201-1");
		status = ScheduledCoursees.getByID("CS201-1").enroll(students.getByName("王五"));
		System.out.println(status.value());
	}

}
