package com.abc.dao;

import java.util.List;

import com.abc.domain.Professor;

public interface ProfessorDAO {
	/*
	 * 初始化若干个教授
	 */
	void initialize();
	
	/*
	 * 返回所有的教授
	 */
	List<Professor> getAll();
	
	/*
	 * 根据工号返回教授对象
	 */
	
	Professor getByPID(String pid);

}
