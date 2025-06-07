//jframe to add student
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
import javax.swing.JPasswordField;

public class AddStudent extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField firstName;
	private JTextField lastName;
	private JTextField email;
	private JTextField phone;
	private JTextField course;
	private JPasswordField pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddStudent frame = new AddStudent();
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
	public AddStudent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 657, 560);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Dialog", Font.BOLD, 14));
		lblFirstName.setBounds(35, 69, 123, 22);
		contentPane.add(lblFirstName);
		
		firstName = new JTextField();
		firstName.setBounds(186, 64, 150, 33);
		contentPane.add(firstName);
		firstName.setColumns(10);
		
		lastName = new JTextField();
		lastName.setColumns(10);
		lastName.setBounds(186, 127, 150, 33);
		contentPane.add(lastName);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(186, 191, 150, 33);
		contentPane.add(email);
		
		phone = new JTextField();
		phone.setColumns(10);
		phone.setBounds(186, 318, 150, 33);
		contentPane.add(phone);
		
		course = new JTextField();
		course.setColumns(10);
		course.setBounds(186, 380, 150, 33);
		contentPane.add(course);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Dialog", Font.BOLD, 14));
		lblLastName.setBounds(35, 136, 123, 22);
		contentPane.add(lblLastName);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Dialog", Font.BOLD, 14));
		lblEmail.setBounds(35, 200, 123, 22);
		contentPane.add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Dialog", Font.BOLD, 14));
		lblPassword.setBounds(35, 263, 123, 22);
		contentPane.add(lblPassword);
		
		JLabel lblPhone = new JLabel("Phone ");
		lblPhone.setFont(new Font("Dialog", Font.BOLD, 14));
		lblPhone.setBounds(35, 329, 123, 22);
		contentPane.add(lblPhone);
		
		JLabel lblCourse = new JLabel("Course");
		lblCourse.setFont(new Font("Dialog", Font.BOLD, 14));
		lblCourse.setBounds(35, 389, 123, 22);
		contentPane.add(lblCourse);
		
		JButton btnAddStudent = new JButton("Add Student");
		btnAddStudent.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAddStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String first = firstName.getText();
				String last = lastName.getText();
				String mail = email.getText();
				char[] pw = pass.getPassword();
				String pass = new String(pw);
				String number = phone.getText();
				String subject = course.getText();
				// Create an instance of the AddStudentquery class
				AddStudentquery st = new AddStudentquery();
				// Call the addStudent method of the AddStudentquery class to add a new student with the retrieved information
				st.addStudent(first,last, mail, pass, number, subject);
				// Update the student data displayed on the dashboard
				Dashboard.dataStudent();
				//Dispose of the current window or frame
				dispose();
				
			}
		});
		btnAddStudent.setBounds(186, 449, 150, 39);
		contentPane.add(btnAddStudent);
		
		pass = new JPasswordField();
		pass.setBounds(186, 258, 150, 33);
		contentPane.add(pass);
		
		JLabel lblNewLabel = new JLabel("Add Student ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(233, 10, 140, 22);
		contentPane.add(lblNewLabel);
	}
}
