package com.abc.dao;

import java.util.List;

import com.abc.domain.Course;

public interface CourseDAO {
	/*
	 * 初始化教学计划中的课程
	 */
	void initialize();
	
	/*
	 * 根据课程号查询课程对象，如果没有该对象则返回null
	 */
	Course getByCourseNo(String courseNo);
	
	/*
	 * 返回所有的课程对象
	 */
	
	List<Course> getAll();
}

