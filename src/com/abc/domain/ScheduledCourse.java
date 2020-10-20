package com.abc.domain;

import java.util.HashMap;
import java.util.Map;

public class ScheduledCourse {
	
	private int classNo;  //课号
	private String dayOfWeek;//周几
	private String timeOfDay;//时间
	private String room;//教室
	private int seatingCapacity;//课容量
	private Course representedCourse;//课程
	private Professor instructor;//任课教师
	private Map<String,Student> enrolledStudents;//选课名单
	
	public ScheduledCourse(int sNo,String day,String time,Course course,String room,int capacity) {
		setClassNo(sNo);
		setDayOfWeek(day);
		setTimeOfDay(time);
		setRepresentedCourse(course);
		setRoom(room);
		setSeatingCapacity(capacity);
		
		setInstructor(null);
		enrolledStudents = new HashMap<String,Student>();
	}
	
	public int getClassNo() {
		return classNo;
	}
	public void setClassNo(int no) {
		classNo = no;
	}
	public String getDayOfWeek() {
		return dayOfWeek;
	}
	public void setDayOfWeek(String day) {
		dayOfWeek = day;
	}
	public String getTimeOfDay() {
		return timeOfDay;
	}
	public void setTimeOfDay(String time) {
		timeOfDay = time;
	}
	public String getRoom() {
		return room;
	}
	public void setRoom(String r) {
		room = r;
	}
	public int getSeatingCapacity() {
		return seatingCapacity;
	}
	public void setSeatingCapacity(int c) {
		seatingCapacity = c;
	}
	public Course getRepresentedCourse() {
		return representedCourse;
	}
	public void setRepresentedCourse(Course c) {
		representedCourse = c;
	}
	public Professor getInstructor() {
		return instructor;
	}
	public void setInstructor(Professor prof) {
		instructor = prof;
	}
//	public Map<String, Student> getEnrolledStudents() {
//		return enrolledStudents;
//	}
	public void setEnrolledStudents(Map<String, Student> enrolledStudents) {
		this.enrolledStudents = enrolledStudents;
	}
	
	/**
	 * 返回如下格式：<br>CS101-1,周一，上午8:00-10:00，赵教授，2
	 */
	public String toString() {
		return getRepresentedCourse().getCourseNo()+"-"+getClassNo()+","+getDayOfWeek()+","+getTimeOfDay()+","+getInstructor()
				+","+getSeatingCapacity();
	}
	
	/*
	 * 课程号（course no.）和 班号（class no.）使用联合称为"完全号"。例，"CS101-1".
	 * *
	 */
	public String getFullScheduledCourseNo() {
		return getRepresentedCourse().getCourseNo()+"-"+getClassNo();
	}
	
	/**
	 * 如果容量满，则返回枚举对象"secFull"
	 * 如果当前课程里没有这个学生，则把该学生加入到选课名单中
	 * 
	 * @see EnrollmentStatus
	 */
	public EnrollmentStatus enroll(Student s) {
		EnrollmentStatus status = EnrollmentStatus.SUCCESS;
		if(enrolledStudents.size()>=getSeatingCapacity()) {
			status=EnrollmentStatus.SECTIONFULL;
		}
		if(!enrolledStudents.containsValue(s)) {
			enrolledStudents.put(s.getID(), s);
		}
		return status;
	}
	
	/**
	 * 退课
	 */
	public boolean drop(Student s) {
		if(!isEnrolledIn(s))
			return false;
		else {
			enrolledStudents.remove(s.getID());
			return true;
		}
	}
	public int getTotalEnrollment() {
		return enrolledStudents.size();
	}
	public Map<String,Student>getEnrolledStudents(){
		return enrolledStudents;
	}
	public boolean isScheduledCourseOf(Course c) {
		if(c==representedCourse)
			return true;
		else
			return false;
	}
	
	/**
	 * 判断是否已经选过本课
	 */
	public boolean isEnrolledIn(Student s) {
		if(enrolledStudents.values().contains(s))
			return true;
		else
			return false;
	}

}
