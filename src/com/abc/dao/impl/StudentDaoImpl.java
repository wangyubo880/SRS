package com.abc.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import com.abc.dao.StudentDAO;
import com.abc.domain.Student;

public class StudentDaoImpl implements StudentDAO {
	private List<Student> students = new ArrayList<Student>();

	@Override
	public void initialize() {
		Student s1,s2,s3;
		s1 = new Student("张三","201901001","数学","学士");
		s2 = new Student("李四","201901002","计算机科学与技术","学士");
		s3 = new Student("王五","201901003","计算机科学与技术","学士");
		
		students.add(s1);
		students.add(s2);
		students.add(s3);

	}

	@Override
	public List<Student> getAll() {
		return students;
	}

	@Override
	public Student getByName(String name) {
		Student s = null;
		ListIterator<Student> iterator = students.listIterator();
		while(iterator.hasNext()) {
			s = iterator.next();
			if(s.getName().equals(name)) break;
		}
		return s;
	}

}
