package CourseManagementSystem;
//jframe to add tutor 
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TutorAdd extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField firstName;
	private JTextField lastName;
	private JTextField email;
	private JTextField number;
	private JTextField courseTeaching;
	private JPasswordField teacherPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TutorAdd frame = new TutorAdd();
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
	public TutorAdd() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 767, 580);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFirstname = new JLabel("FirstName");
		lblFirstname.setFont(new Font("Dialog", Font.BOLD, 14));
		lblFirstname.setBounds(71, 75, 110, 24);
		contentPane.add(lblFirstname);
		
		JLabel lblLastname = new JLabel("LastName");
		lblLastname.setFont(new Font("Dialog", Font.BOLD, 14));
		lblLastname.setBounds(71, 133, 110, 24);
		contentPane.add(lblLastname);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Dialog", Font.BOLD, 14));
		lblEmail.setBounds(71, 188, 110, 24);
		contentPane.add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Dialog", Font.BOLD, 14));
		lblPassword.setBounds(71, 252, 110, 24);
		contentPane.add(lblPassword);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setFont(new Font("Dialog", Font.BOLD, 14));
		lblPhone.setBounds(71, 307, 110, 24);
		contentPane.add(lblPhone);
		
		JLabel lblCourse = new JLabel("Course");
		lblCourse.setFont(new Font("Dialog", Font.BOLD, 14));
		lblCourse.setBounds(71, 366, 110, 24);
		contentPane.add(lblCourse);
		
		firstName = new JTextField();
		firstName.setBounds(215, 73, 140, 29);
		contentPane.add(firstName);
		firstName.setColumns(10);
		
		lastName = new JTextField();
		lastName.setColumns(10);
		lastName.setBounds(215, 131, 140, 29);
		contentPane.add(lastName);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(215, 186, 140, 29);
		contentPane.add(email);
		
		number = new JTextField();
		number.setColumns(10);
		number.setBounds(215, 305, 140, 29);
		contentPane.add(number);
		
		courseTeaching = new JTextField();
		courseTeaching.setColumns(10);
		courseTeaching.setBounds(215, 364, 140, 29);
		contentPane.add(courseTeaching);
		
		teacherPass = new JPasswordField();
		teacherPass.setBounds(214, 252, 141, 29);
		contentPane.add(teacherPass);
		
		JButton addTeacher = new JButton("Add Tutor");
		addTeacher.setFont(new Font("Tahoma", Font.PLAIN, 12));
		addTeacher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fname = firstName.getText();
				String lname = lastName.getText();
				String userEmail = email.getText();
				String phone = number.getText();
				String module = courseTeaching.getText();
				char[] pass = teacherPass.getPassword();
				String password = new String(pass);
				TutorAddquery t = new TutorAddquery();
				t.tutors(fname,lname,userEmail, module, password, phone);
				Dashboard.tutorsData();
				dispose();
				
				
			}
		});
		addTeacher.setBounds(215, 429, 140, 35);
		contentPane.add(addTeacher);
		
		JLabel lblNewLabel = new JLabel("Tutor Add Details");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 25));
		lblNewLabel.setBounds(214, 10, 199, 29);
		contentPane.add(lblNewLabel);
	}
}
