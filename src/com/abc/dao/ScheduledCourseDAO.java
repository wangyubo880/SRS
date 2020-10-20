package com.abc.dao;

import java.util.List;

import com.abc.domain.ScheduledCourse;

public interface ScheduledCourseDAO {
	/*
	 * ��ʼ��ĳѧ���⿪���������ſΣ���Щ�α����ǽ�ѧ�ƻ��еĿγ�
	 */
	void initialize(CourseDAO course);
	
	/*
	 * �������еĿζ���
	 */
	List<ScheduledCourse> getAll();
	
	/*
	 * ���ݿκŲ��ҿ�
	 */
	
	ScheduledCourse getByID(String id);

}
