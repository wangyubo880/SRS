package com.abc.gui;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import com.abc.dao.CourseDAO;
import com.abc.dao.ProfessorDAO;
import com.abc.dao.ScheduledCourseDAO;
import com.abc.dao.StudentDAO;
import com.abc.dao.TeachingAssignmentDAO;
import com.abc.dao.impl.CourseDaoImpl;
import com.abc.dao.impl.ProfessorDaoImpl;
import com.abc.dao.impl.ScheduledCourseDaoImpl;
import com.abc.dao.impl.StudentDaoImpl;
import com.abc.dao.impl.TeachingAssignmentsImpl;
import com.abc.domain.EnrollmentStatus;
import com.abc.domain.ScheduledCourse;
import com.abc.domain.Student;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppGUI2 {

	private JFrame frame;
	private final JScrollPane scrollPane_1 = new JScrollPane();
	private JTable tableClass;
	private JTable tableStudent;
	ProfessorDAO professors=new ProfessorDaoImpl();
	StudentDAO students=new StudentDaoImpl();
	CourseDAO courses=new CourseDaoImpl();
	ScheduledCourseDAO scheduledClasses=new ScheduledCourseDaoImpl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppGUI2 window = new AppGUI2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AppGUI2() {
		//���ȴ���ҵ�����
		professors.initialize();
		students.initialize();
		courses.initialize();
		scheduledClasses.initialize(courses);
		TeachingAssignmentDAO ta=new TeachingAssignmentsImpl();
		ta.initialize(professors, scheduledClasses);
		
		//Ȼ�󴴽��������
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u5B66\u751F\u9009\u8BFE\u7CFB\u7EDF");
		frame.setBounds(100, 100, 815, 446);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel labelStudent = new JLabel("\u5B66\u751F");
		labelStudent.setBounds(491, 21, 72, 18);
		frame.getContentPane().add(labelStudent);
		
		JLabel lableClass = new JLabel("\u4F9B\u9009\u62E9\u7684\u8BFE");
		lableClass.setBounds(59, 21, 88, 18);
		frame.getContentPane().add(lableClass);
		
		JButton buttonRegist = new JButton("ѡ��");
		buttonRegist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel tableModel=(DefaultTableModel)tableClass.getModel();
				//�����γ̺�
				String fullClassNo=null;
				fullClassNo=(String)tableModel.getValueAt(tableClass.getSelectedRow(), 0);
				
				DefaultTableModel tableModelStudent=(DefaultTableModel)tableStudent.getModel();
				//�����γ̺�
				String studentName=null;
				studentName=(String)tableModelStudent.getValueAt(tableStudent.getSelectedRow(), 1);
				
				//ѡ�β���
				EnrollmentStatus enroll=scheduledClasses.getByID(fullClassNo).enroll(students.getByName(studentName));
				JOptionPane.showMessageDialog(null, enroll.value());
			}
		});
		buttonRegist.setBounds(671, 285, 113, 27);
		frame.getContentPane().add(buttonRegist);
		
		JButton buttonExit = new JButton("\u7ED3\u675F");
		buttonExit.setBounds(671, 339, 113, 27);
		frame.getContentPane().add(buttonExit);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 52, 463, 314);
		frame.getContentPane().add(scrollPane);
		
		tableClass = new JTable();
		tableClass.setBackground(new Color(204, 232, 207));
		tableClass.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setColumnHeaderView(tableClass);
		scrollPane_1.setBounds(504, 47, 159, 319);
		frame.getContentPane().add(scrollPane_1);
		
		tableStudent = new JTable();
		tableStudent.setBackground(new Color(204, 232, 207));
		tableStudent.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_1.setColumnHeaderView(tableStudent);
		tableStudent.setBounds(513, 51, 157, 315);
		
		DefaultTableModel tableModel=(DefaultTableModel)tableClass.getModel();
		
		//�ѿ����Ŀ����뵽��ģ����
		
		String[] columnNames= {"�����γ̺�","�γ���","ѧ��","�ܼ�","�Ͽ�ʱ��","�ص�","��ʦ����","ְ��","����"};
		tableModel.setColumnIdentifiers(columnNames);
		for(ScheduledCourse sc:scheduledClasses.getAll()) {
			String fullClassNo=sc.getFullScheduledCourseNo();
			String courseName=sc.getRepresentedCourse().getCourseName();
			Double credits=sc.getRepresentedCourse().getCredits();
			String dayOfWeek=sc.getDayOfWeek();
			String timeOfDay=sc.getTimeOfDay();
			String roomNo=sc.getRoom();
			String proName=sc.getInstructor().getName();
			int capacity=sc.getSeatingCapacity();
			int size=sc.getTotalEnrollment();
			tableModel.addRow(new Object[] {fullClassNo,courseName,credits,dayOfWeek,timeOfDay,roomNo,
					proName,capacity,size});
		}
		
		DefaultTableModel tableModelStudent=(DefaultTableModel)tableStudent.getModel();
		
		String[] studentColumnNames= {"ѧ��","����"};
		tableModelStudent.setColumnIdentifiers(studentColumnNames);
		
		for(Student s:students.getAll()) {
			String id=s.getID();
			String name=s.getName();
			
			tableModelStudent.addRow(new Object[] {id,name});
		}
		
	}

}
