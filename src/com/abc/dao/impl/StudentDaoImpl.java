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
		s1 = new Student("����","201901001","��ѧ","ѧʿ");
		s2 = new Student("����","201901002","�������ѧ�뼼��","ѧʿ");
		s3 = new Student("����","201901003","�������ѧ�뼼��","ѧʿ");
		
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
