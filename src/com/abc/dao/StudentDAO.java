package com.abc.dao;

import java.util.List;

import com.abc.domain.Student;

public interface StudentDAO {
	/*
	 * ��ʼ�����ɸ�ѧ��
	 */
	void initialize();
	
	/*
	 * ��������ѧ������
	 */
	List<Student> getAll();
	
	/*
	 * ������������ѧ������
	 */
	Student getByName(String name);

}
