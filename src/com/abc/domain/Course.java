package com.abc.domain;

public class Course {
	private String courseNo;
	private String courseName;
	private double credits;
	public Course(String cNo,String cName,double credits) {
		setCourseNo(cNo);
		setCourseName(cName);
		setCredits(credits);
	}
	
	public String getCourseNo() {
		return courseNo;
	}
	public void setCourseNo(String cNo) {
		courseNo = cNo;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String cName) {
		courseName = cName;
	}
	public double getCredits() {
		return credits;
	}
	public void setCredits(double c) {
		credits = c;
	}

	public String toString() {
		return getCourseNo()+":"+getCourseName()+","+getCredits()+"ังทึ";
	}
	public ScheduledCourse getScheduledCourse(String day,String time,String room,int capacity,int classNo) {
		ScheduledCourse s=new ScheduledCourse(classNo,day,time,this,room,capacity);
		
		return s;
	}
	

}
