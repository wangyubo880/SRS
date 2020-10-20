package com.abc.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import com.abc.dao.ProfessorDAO;
import com.abc.domain.Professor;

public class ProfessorDaoImpl implements ProfessorDAO {
	private List<Professor> professors = new ArrayList<Professor>();

	@Override
	public void initialize() {
		Professor p1,p2,p3;
		p1 = new Professor("董永","123401","副教授","计算机科学与技术");
		p2 = new Professor("赵云","123402","教授","计算机科学与技术");
		p3 = new Professor("郭天","123403","教授","数学");
		
		professors.add(p1);
		professors.add(p2);
		professors.add(p3);

	}

	@Override
	public List<Professor> getAll() {
		return professors;
	}

	@Override
	public Professor getByPID(String PID) {
		ListIterator<Professor> it = professors.listIterator();
		Professor p = null;
		while(it.hasNext()) {
			p = it.next();
			if(PID.equals(p.getID())) break;
		}
		return p;
	}

}
