package com.abc.dao;

import java.util.List;

import com.abc.domain.ScheduledCourse;

public interface ScheduledCourseDAO {
	/*
	 * 初始化某学期拟开出的若干门课，这些课必须是教学计划中的课程
	 */
	void initialize(CourseDAO course);
	
	/*
	 * 返回所有的课对象
	 */
	List<ScheduledCourse> getAll();
	
	/*
	 * 根据课号查找课
	 */
	
	ScheduledCourse getByID(String id);

}
