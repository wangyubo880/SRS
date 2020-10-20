package com.abc.dao;

import java.util.List;

import com.abc.domain.Professor;

public interface ProfessorDAO {
	/*
	 * ��ʼ�����ɸ�����
	 */
	void initialize();
	
	/*
	 * �������еĽ���
	 */
	List<Professor> getAll();
	
	/*
	 * ���ݹ��ŷ��ؽ��ڶ���
	 */
	
	Professor getByPID(String pid);

}
