package com.abc.dao.impl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.abc.dao.CourseDAO;
import com.abc.domain.Course;

public class CourseDaoImpl implements CourseDAO{
	private Map<String,Course> courses = new HashMap<String,Course>();
	
	@Override
	public void initialize() {
		Course c1,c2,c3,c4,c5;
		c1 = new Course("CS101","C �������",3.0);
		c2 = new Course("CS102","�������������",3.0);
		c3 = new Course("CS103","���ݽṹ���㷨",4.0);
		c4 = new Course("MAT101","������ͳ��",3.0);
		c5 = new Course("CS201","��ɢ��ѧ",3.0);
		
		courses.put(c1.getCourseNo(), c1);
		courses.put(c2.getCourseNo(), c2);
		courses.put(c3.getCourseNo(), c3);
		courses.put(c4.getCourseNo(), c4);
		courses.put(c5.getCourseNo(), c5);
	}

	@Override
	public Course getByCourseNo(String courseNo) {
		return courses.get(courseNo);
	}

	@Override
	public List<Course> getAll() {
		List<Course> c = new LinkedList<Course>();
		for(Map.Entry<String, Course> entry:courses.entrySet()) {
			c.add(entry.getValue());
		}
		return c;
	} 

}
