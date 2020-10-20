package com.abc.dao.impl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.abc.dao.CourseDAO;
import com.abc.dao.ScheduledCourseDAO;
import com.abc.domain.Course;
import com.abc.domain.ScheduledCourse;

public class ScheduledCourseDaoImpl implements ScheduledCourseDAO {
	private Map<String,ScheduledCourse> ScheduledCourses = new HashMap<String,ScheduledCourse>();
	
	/*
	 * 从课程(Course)安排某学期开出的课(scheduled class)
	 * 
	 */
	@Override
	public void initialize(CourseDAO course) {
		ScheduledCourse class1,class2,class3,class4,class5,class6,class7;
		Course c = course.getByCourseNo("CS101");
		class1 = c.getScheduledCourse("周一", "上午8:00-10:00", "A101", 30, 1);
		class2 = c.getScheduledCourse("周二", "上午8:00-10:00", "C202", 30, 2);
		
		c = course.getByCourseNo("CS102");
		class3 = c.getScheduledCourse("周三", "下午2:00-4:00", "C105", 25, 1);
		class4 = c.getScheduledCourse("周四", "下午4:00-6:00", "D330", 25, 2);
		
		c = course.getByCourseNo("CS103");
		class5 = c.getScheduledCourse("周一", "下午6:00-8:00", "E101", 20, 1);
		
		c = course.getByCourseNo("MAT101");
		class6 = c.getScheduledCourse("周五", "下午4:00-6:00", "D241", 15, 1);
		
		c = course.getByCourseNo("CS201");
		class7 = c.getScheduledCourse("周一", "下午4:00-6:00", "A205", 1, 1);
		
		ScheduledCourses.put(class1.getFullScheduledCourseNo(), class1);
		ScheduledCourses.put(class2.getFullScheduledCourseNo(), class2);
		ScheduledCourses.put(class3.getFullScheduledCourseNo(), class3);
		ScheduledCourses.put(class4.getFullScheduledCourseNo(), class4);
		ScheduledCourses.put(class5.getFullScheduledCourseNo(), class5);
		ScheduledCourses.put(class6.getFullScheduledCourseNo(), class6);
		ScheduledCourses.put(class7.getFullScheduledCourseNo(), class7);

	}

	@Override
	public List<ScheduledCourse> getAll() {
		List<ScheduledCourse> c = new LinkedList<ScheduledCourse>();
		for(Map.Entry<String, ScheduledCourse> entry:ScheduledCourses.entrySet()) {
			c.add(entry.getValue());
		}
		return c;
	}

	@Override
	public ScheduledCourse getByID(String id) {
		return ScheduledCourses.get(id);
	}

}
