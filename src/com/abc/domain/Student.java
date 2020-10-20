package com.abc.domain;

public class Student extends Person{
	
	private String major;
	private String degree;
	
	public Student(String name, String sid,String major,String degree) {
		super(name, sid);
		
		this.setMajor(major);
		this.setDegree(degree);
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	/*
	 * 返回如下格式的字符串表示：<br>张三（201901001）[硕士-计算机科学与技术]
	 * 
	 * @see com.abc.domain.Person#toString()
	 */
	public String toString() {
		return this.getName()+"("+this.getID()+")["+this.getDegree()+"-"+this.getMajor()+"]";
	}

	@Override
	public int hashCode() {
		return this.getID().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if(obj==null)
			return false;
		Student s = (Student) obj;
		if(this.getID().equals(s.getID())) {
			return true;
		}
		return false;
	}
}
