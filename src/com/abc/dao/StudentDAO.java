package com.abc.dao;

import java.util.List;

import com.abc.domain.Student;

public interface StudentDAO {
	/*
	 * 初始化若干个学生
	 */
	void initialize();
	
	/*
	 * 返回所有学生对象
	 */
	List<Student> getAll();
	
	/*
	 * 根据姓名返回学生对象
	 */
	Student getByName(String name);

}
