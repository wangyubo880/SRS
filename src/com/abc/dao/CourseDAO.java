package com.abc.dao;

import java.util.List;

import com.abc.domain.Course;

public interface CourseDAO {
	/*
	 * ��ʼ����ѧ�ƻ��еĿγ�
	 */
	void initialize();
	
	/*
	 * ���ݿγ̺Ų�ѯ�γ̶������û�иö����򷵻�null
	 */
	Course getByCourseNo(String courseNo);
	
	/*
	 * �������еĿγ̶���
	 */
	
	List<Course> getAll();
}

