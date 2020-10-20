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
		
		System.out.println("========����========");
		for(Professor p:professors.getAll()) {
			System.out.println(p);
		}
		
		StudentDAO students = new StudentDaoImpl();
		students.initialize();
		System.out.println("========ѧ��========");
		for(Student s:students.getAll()) {
			System.out.println(s);
		}
		
		CourseDAO courses = new CourseDaoImpl();
		courses.initialize();
		
		ScheduledCourseDAO ScheduledCoursees = new ScheduledCourseDaoImpl();
		ScheduledCoursees.initialize(courses);
		//�����ον�ʦ
		TeachingAssignmentDAO ta = new TeachingAssignmentsImpl();
		ta.initialize(professors, ScheduledCoursees);
		System.out.println("========�����Ŀ�========");
		for(ScheduledCourse s:ScheduledCoursees.getAll()) {
			System.out.println(s);
		}
		System.out.println();
		
		//������ʾѧ������ע����һ������Ϊ1�ĿΣ�������ע����ʧ�ܡ�
		EnrollmentStatus status;
		
		System.out.println("ѧ�� ���� ��ͼע�� CS201-1");
		status = ScheduledCoursees.getByID("CS201-1").enroll(students.getByName("����"));
		System.out.println(status.value());
		
		System.out.println("ѧ�� ���� ��ͼע�� CS201-1");
		status = ScheduledCoursees.getByID("CS201-1").enroll(students.getByName("����"));
		System.out.println(status.value());
	}

}
