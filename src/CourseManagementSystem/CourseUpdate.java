package CourseManagementSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class CourseUpdate extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField moduleNumber;
	private JTextField courseName;
	private JTextField seats;
	private JTextField batch;
	private JTextField yearsStudy;
	private JTextField courseId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CourseUpdate frame = new CourseUpdate();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CourseUpdate() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 818, 492);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblModuleName = new JLabel("Module Name");
		lblModuleName.setFont(new Font("Dialog", Font.BOLD, 14));
		lblModuleName.setBounds(55, 100, 137, 32);
		contentPane.add(lblModuleName);
		
		JLabel lblSeats = new JLabel("Seats");
		lblSeats.setFont(new Font("Dialog", Font.BOLD, 14));
		lblSeats.setBounds(55, 215, 137, 32);
		contentPane.add(lblSeats);
		
		JLabel lblBatch = new JLabel("Batch");
		lblBatch.setFont(new Font("Dialog", Font.BOLD, 14));
		lblBatch.setBounds(55, 269, 137, 32);
		contentPane.add(lblBatch);
		
		JLabel lblYearStudy = new JLabel("Years");
		lblYearStudy.setFont(new Font("Dialog", Font.BOLD, 14));
		lblYearStudy.setBounds(55, 325, 137, 32);
		contentPane.add(lblYearStudy);
		
		JLabel lblCourseName = new JLabel("Course Name");
		lblCourseName.setFont(new Font("Dialog", Font.BOLD, 14));
		lblCourseName.setBounds(55, 160, 137, 32);
		contentPane.add(lblCourseName);
		
		moduleNumber = new JTextField();
		moduleNumber.setBounds(256, 101, 147, 32);
		contentPane.add(moduleNumber);
		moduleNumber.setColumns(10);
		
		courseName = new JTextField();
		courseName.setColumns(10);
		courseName.setBounds(256, 161, 147, 32);
		contentPane.add(courseName);
		
		seats = new JTextField();
		seats.setColumns(10);
		seats.setBounds(256, 216, 147, 32);
		contentPane.add(seats);
		
		batch = new JTextField();
		batch.setColumns(10);
		batch.setBounds(256, 270, 147, 32);
		contentPane.add(batch);
		
		yearsStudy = new JTextField();
		yearsStudy.setColumns(10);
		yearsStudy.setBounds(256, 326, 147, 32);
		contentPane.add(yearsStudy);
		
		JButton btnUpdateCourse = new JButton("Update Course");
		btnUpdateCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = courseId.getText();
				String courseModule = moduleNumber.getText();
				String nameCourse =  courseName.getText();
				String courseSeat = seats.getText();
				String studentBatch = batch.getText();
				String  studyYear = yearsStudy.getText();
				CourseUpdatequery cu = new CourseUpdatequery();
				cu.updatingCourse(id,nameCourse, courseModule, studentBatch, courseSeat ,studyYear);
				Dashboard.courseData();
				dispose();
				
			}
		});
		btnUpdateCourse.setBounds(256, 383, 147, 43);
		contentPane.add(btnUpdateCourse);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(63, 63, 91, 15);
		contentPane.add(lblId);
		
		courseId = new JTextField();
		courseId.setBounds(256, 48, 147, 32);
		contentPane.add(courseId);
		courseId.setColumns(10);
	}
}
