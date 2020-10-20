package com.abc.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;

public class Test {

	private JFrame frame;
	private final JScrollPane scrollPane_1 = new JScrollPane();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test window = new Test();
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
	public Test() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u5B66\u751F\u9009\u8BFE\u7CFB\u7EDF");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lableClass = new JLabel("\u4F9B\u9009\u62E9\u7684\u8BFE");
		lableClass.setBounds(14, 13, 88, 18);
		frame.getContentPane().add(lableClass);
		
		JLabel labelStudent = new JLabel("\u5B66\u751F");
		labelStudent.setBounds(398, 13, 72, 18);
		frame.getContentPane().add(labelStudent);
		
		JButton buttonRegist = new JButton("\u9009\u8BFE");
		buttonRegist.setBounds(309, 193, 113, 27);
		frame.getContentPane().add(buttonRegist);
		
		JButton buttonExit = new JButton("\u7ED3\u675F");
		buttonExit.setBounds(309, 226, 113, 27);
		frame.getContentPane().add(buttonExit);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 52, 463, 314);
		frame.getContentPane().add(scrollPane);
		scrollPane_1.setBounds(504, 47, 159, 319);
		frame.getContentPane().add(scrollPane_1);
	}
}
