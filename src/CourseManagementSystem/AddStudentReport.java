//jframe to add student report by teacher
package CourseManagementSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Panel;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddStudentReport extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField fullName;
	private JTextField userEmail;
	private JTextField module;
	private JTextField courseName;
	private JTextField studentMarks;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddStudentReport frame = new AddStudentReport();
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
	public AddStudentReport() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 572, 542);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Full Name");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel.setBounds(35, 110, 92, 15);
		contentPane.add(lblNewLabel);
		
		fullName = new JTextField();
		fullName.setBounds(161, 102, 172, 31);
		contentPane.add(fullName);
		fullName.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Dialog", Font.BOLD, 14));
		lblEmail.setBounds(35, 182, 92, 15);
		contentPane.add(lblEmail);
		
		userEmail = new JTextField();
		userEmail.setColumns(10);
		userEmail.setBounds(161, 174, 172, 31);
		contentPane.add(userEmail);
		
		module = new JTextField();
		module.setColumns(10);
		module.setBounds(161, 244, 172, 31);
		contentPane.add(module);
		
		JLabel lblNewLabel_1_1 = new JLabel("Module");
		lblNewLabel_1_1.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(35, 252, 92, 15);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Course Name");
		lblNewLabel_1_2.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(35, 317, 108, 15);
		contentPane.add(lblNewLabel_1_2);
		
		courseName = new JTextField();
		courseName.setColumns(10);
		courseName.setBounds(161, 309, 172, 31);
		contentPane.add(courseName);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Marks");
		lblNewLabel_1_2_1.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_1_2_1.setBounds(35, 383, 108, 15);
		contentPane.add(lblNewLabel_1_2_1);
		
		studentMarks = new JTextField();
		studentMarks.setColumns(10);
		studentMarks.setBounds(161, 375, 172, 31);
		contentPane.add(studentMarks);
		
		JButton btnAddResult = new JButton("Add Result");
		btnAddResult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = fullName.getText();
				String email = userEmail.getText();
				String m = module.getText();
				String course = courseName.getText();
				String mark = studentMarks.getText(); 
				 // Call the StudentResult method of the StudentReportquery class and pass the retrieved data as parameters
				StudentReportquery.StudentResult(name,email, m, course,mark);
				// Dispose or close the current window or frame
				dispose();
				
			}
		});
		btnAddResult.setBounds(161, 432, 172, 38);
		contentPane.add(btnAddResult);
		
		Panel pannel = new Panel();
		pannel.setLayout(null);
		pannel.setBackground(new Color(246, 97, 81));
		pannel.setBounds(24, 23, 220, 35);
		contentPane.add(pannel);
		
		JLabel lblResult_1 = new JLabel("Result");
		lblResult_1.setForeground(Color.WHITE);
		lblResult_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblResult_1.setFont(new Font("Dialog", Font.BOLD, 16));
		lblResult_1.setBackground(Color.WHITE);
		lblResult_1.setBounds(28, 0, 151, 35);
		pannel.add(lblResult_1);
	}
}
