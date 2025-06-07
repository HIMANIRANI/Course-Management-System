package CourseManagementSystem;
//jframe to update studentdetails
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateStudent extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField First;
	private JTextField last;
	private JTextField mail;
	private JTextField number;
	private JTextField course;
	private JTextField ID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateStudent frame = new UpdateStudent();
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
	public UpdateStudent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 646, 569);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Dialog", Font.BOLD, 14));
		lblFirstName.setBounds(43, 166, 109, 15);
		contentPane.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Dialog", Font.BOLD, 14));
		lblLastName.setBounds(43, 229, 109, 15);
		contentPane.add(lblLastName);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Dialog", Font.BOLD, 14));
		lblEmail.setBounds(43, 284, 109, 15);
		contentPane.add(lblEmail);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setFont(new Font("Dialog", Font.BOLD, 14));
		lblPhone.setBounds(43, 350, 109, 15);
		contentPane.add(lblPhone);
		
		JLabel lblCourse = new JLabel("Course");
		lblCourse.setFont(new Font("Dialog", Font.BOLD, 14));
		lblCourse.setBounds(43, 411, 109, 15);
		contentPane.add(lblCourse);
		
		First = new JTextField();
		First.setBounds(170, 159, 166, 30);
		contentPane.add(First);
		First.setColumns(10);
		
		last = new JTextField();
		last.setColumns(10);
		last.setBounds(170, 222, 166, 30);
		contentPane.add(last);
		
		mail = new JTextField();
		mail.setColumns(10);
		mail.setBounds(170, 277, 166, 30);
		contentPane.add(mail);
		
		number = new JTextField();
		number.setColumns(10);
		number.setBounds(170, 343, 166, 30);
		contentPane.add(number);
		
		course = new JTextField();
		course.setColumns(10);
		course.setBounds(170, 404, 166, 30);
		contentPane.add(course);
		
		JButton update = new JButton("Update ");
		update.setFont(new Font("Tahoma", Font.PLAIN, 12));
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fname = First.getText();
				String lname = last.getText();
				String email = mail.getText();
				String phone = number.getText();
				String module = course.getText();
				UpdateStudentquery se = new UpdateStudentquery();
				String id = ID.getText();
				se.StudentEdit(id,fname,lname, email, phone, module);
				Dashboard.dataStudent();
				dispose();
			}
		});
		update.setBounds(174, 464, 162, 40);
		contentPane.add(update);
		
		JLabel lblUpdateStudentDetails = new JLabel("Update Student Details");
		lblUpdateStudentDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdateStudentDetails.setFont(new Font("Arial", Font.PLAIN, 22));
		lblUpdateStudentDetails.setBounds(10, 10, 578, 67);
		contentPane.add(lblUpdateStudentDetails);
		
		ID = new JTextField();
		ID.setColumns(10);
		ID.setBounds(170, 111, 166, 30);
		contentPane.add(ID);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Dialog", Font.BOLD, 14));
		lblId.setBounds(43, 118, 109, 15);
		contentPane.add(lblId);
	}

}
