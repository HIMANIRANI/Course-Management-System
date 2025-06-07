package CourseManagementSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;

public class CourseAdd extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField courseName;
	private JTextField batch;
	private JTextField seats;
	private JTextField studyYear;
	private JTextField moduleNumber;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CourseAdd frame = new CourseAdd();
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
	public CourseAdd() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 896, 663);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String nameCourse = courseName.getText();
				String year = batch.getText();
				String seat = seats.getText();
				String study = studyYear.getText();
				String module = moduleNumber.getText();
				CourseAddquery cs = new CourseAddquery();
				cs.course(nameCourse,year,seat, study, module);
				Dashboard.courseData();
				dispose();
			}
		});
		btnAdd.setBounds(309, 482, 136, 35);
		contentPane.add(btnAdd);
		
		JLabel lblCourseName = new JLabel("Course Name");
		lblCourseName.setBounds(146, 133, 136, 30);
		lblCourseName.setFont(new Font("Dialog", Font.BOLD, 14));
		contentPane.add(lblCourseName);
		
		courseName = new JTextField();
		courseName.setBounds(309, 131, 136, 35);
		contentPane.add(courseName);
		courseName.setColumns(10);
		
		batch = new JTextField();
		batch.setBounds(309, 202, 136, 35);
		contentPane.add(batch);
		batch.setColumns(10);
		
		JLabel lblBatch = new JLabel("Batch");
		lblBatch.setBounds(146, 208, 97, 23);
		lblBatch.setFont(new Font("Dialog", Font.BOLD, 14));
		contentPane.add(lblBatch);
		
		JLabel lblNoOfSeats = new JLabel("No. of seats");
		lblNoOfSeats.setBounds(146, 279, 117, 23);
		contentPane.add(lblNoOfSeats);
		
		seats = new JTextField();
		seats.setBounds(309, 273, 136, 35);
		contentPane.add(seats);
		seats.setColumns(10);
		
		JLabel lblTotalYears = new JLabel("Total years");
		lblTotalYears.setFont(new Font("Dialog", Font.BOLD, 14));
		lblTotalYears.setBounds(146, 341, 117, 30);
		contentPane.add(lblTotalYears);
		
		studyYear = new JTextField();
		studyYear.setBounds(309, 339, 136, 35);
		contentPane.add(studyYear);
		studyYear.setColumns(10);
		
		JLabel lblModuleNumber = new JLabel("Module Number");
		lblModuleNumber.setBounds(139, 410, 137, 15);
		contentPane.add(lblModuleNumber);
		
		moduleNumber = new JTextField();
		moduleNumber.setBounds(309, 400, 134, 35);
		contentPane.add(moduleNumber);
		moduleNumber.setColumns(10);
		
		JLabel lblAddNewCourse = new JLabel("Add New Course");
		lblAddNewCourse.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddNewCourse.setFont(new Font("Dialog", Font.BOLD, 20));
		lblAddNewCourse.setBackground(new Color(0, 191, 255));
		lblAddNewCourse.setBounds(12, 0, 820, 74);
		contentPane.add(lblAddNewCourse);
	}
}
