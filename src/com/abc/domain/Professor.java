package com.abc.domain;

public class Professor extends Person{
	private String title;
	private String department;
	
	public Professor(String name, String pid,String title,String dept) {
		super(name, pid);
		setTitle(title);
		setDepartment(dept);
		}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String dept) {
		department = dept;
	}
	
	@Override
	public String toString() {
		return getName()+"("+getTitle()+","+getDepartment()+")";
	}
	
	
}
