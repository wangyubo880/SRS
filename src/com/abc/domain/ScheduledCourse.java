package com.abc.domain;

import java.util.HashMap;
import java.util.Map;

public class ScheduledCourse {
	
	private int classNo;  //�κ�
	private String dayOfWeek;//�ܼ�
	private String timeOfDay;//ʱ��
	private String room;//����
	private int seatingCapacity;//������
	private Course representedCourse;//�γ�
	private Professor instructor;//�ον�ʦ
	private Map<String,Student> enrolledStudents;//ѡ������
	
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
	 * �������¸�ʽ��<br>CS101-1,��һ������8:00-10:00���Խ��ڣ�2
	 */
	public String toString() {
		return getRepresentedCourse().getCourseNo()+"-"+getClassNo()+","+getDayOfWeek()+","+getTimeOfDay()+","+getInstructor()
				+","+getSeatingCapacity();
	}
	
	/*
	 * �γ̺ţ�course no.���� ��ţ�class no.��ʹ�����ϳ�Ϊ"��ȫ��"������"CS101-1".
	 * *
	 */
	public String getFullScheduledCourseNo() {
		return getRepresentedCourse().getCourseNo()+"-"+getClassNo();
	}
	
	/**
	 * ������������򷵻�ö�ٶ���"secFull"
	 * �����ǰ�γ���û�����ѧ������Ѹ�ѧ�����뵽ѡ��������
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
	 * �˿�
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
	 * �ж��Ƿ��Ѿ�ѡ������
	 */
	public boolean isEnrolledIn(Student s) {
		if(enrolledStudents.values().contains(s))
			return true;
		else
			return false;
	}

}
