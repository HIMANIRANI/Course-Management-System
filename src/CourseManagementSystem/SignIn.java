package CourseManagementSystem;

import java.util.regex.Matcher;


import java.util.regex.Pattern;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;

public class SignIn extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField first;
	private JPasswordField pass;
	private static JComboBox<String> ComboBox;
	private JTextField phoneNumber;
	private JTextField courseText;
	private JTextField last;
	private JTextField email;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignIn frame = new SignIn();
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
	public SignIn() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 891, 528);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel firstName = new JLabel("First Name");
		firstName.setFont(new Font("Dialog", Font.PLAIN, 14));
		firstName.setBounds(542, 84, 155, 28);
		contentPane.add(firstName);
		
		
		JLabel LastName = new JLabel("Last Name");
		LastName.setFont(new Font("Dialog", Font.PLAIN, 14));
		LastName.setBounds(542, 115, 155, 33);
		contentPane.add(LastName);
		
		JLabel userPassword = new JLabel("Password");
		userPassword.setFont(new Font("Dialog", Font.PLAIN, 14));
		userPassword.setBounds(542, 187, 155, 33);
		contentPane.add(userPassword);
		
		JLabel userEmail = new JLabel("Email");
		userEmail.setFont(new Font("Dialog", Font.PLAIN, 14));
		userEmail.setBounds(542, 151, 114, 33);
		contentPane.add(userEmail);
		
		ComboBox = new JComboBox();
		ComboBox.setModel(new DefaultComboBoxModel(new String[]{"--Select Mode--","Admin", "Teacher", "Student"}));
		ComboBox.setBounds(701, 310, 114, 39);
		contentPane.add(ComboBox);
		
		first = new JTextField();
		first.setBounds(658, 89, 193, 24);
		contentPane.add(first);
		first.setColumns(10);
		
		
		pass = new JPasswordField();
		pass.setBounds(658, 194, 193, 24);
		contentPane.add(pass);
		
		JButton btnSignUp = new JButton("Sign In");
		btnSignUp.setBackground(new Color(128, 255, 128));
		btnSignUp.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignInAction();			
			}
		});
		btnSignUp.setBounds(621, 359, 178, 33);
		contentPane.add(btnSignUp);
		
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBackground(new Color(255, 255, 255));
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login l = new Login();
				l.setVisible(true);
				dispose();
			}
		});
		btnLogin.setBounds(763, 402, 71, 19);
		contentPane.add(btnLogin);
		
		JLabel WelcomeSignup = new JLabel("Signin Page");
		WelcomeSignup.setForeground(new Color(0, 128, 192));
		WelcomeSignup.setFont(new Font("Arial", Font.BOLD, 34));
		WelcomeSignup.setBounds(598, 10, 236, 39);
		contentPane.add(WelcomeSignup);
		
		JLabel lblUser = new JLabel("User Mode");
		lblUser.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblUser.setBounds(542, 318, 93, 19);
		contentPane.add(lblUser);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblPhoneNumber.setBounds(542, 230, 139, 24);
		contentPane.add(lblPhoneNumber);
		
		phoneNumber = new JTextField();
		phoneNumber.setBounds(658, 230, 193, 24);
		contentPane.add(phoneNumber);
		phoneNumber.setColumns(10);
		
		courseText = new JTextField();
		courseText.setBounds(658, 264, 193, 24);
		contentPane.add(courseText);
		courseText.setColumns(10);
		
		JLabel lblCourse = new JLabel("Module");
		lblCourse.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblCourse.setBounds(542, 264, 114, 23);
		contentPane.add(lblCourse);
		
		last = new JTextField();
		last.setColumns(10);
		last.setBounds(658, 122, 193, 24);
		contentPane.add(last);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(658, 158, 193, 24);
		contentPane.add(email);
		
		JLabel lblNewLabel = new JLabel("If you have an account already?");
		lblNewLabel.setBounds(590, 406, 225, 13);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(154, 205, 50));
		panel.setBounds(0, 0, 508, 530);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(6, 30, 0, 0);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\ACER\\Downloads\\icons8-course-100.png"));
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("System");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 44));
		lblNewLabel_3.setBounds(145, 331, 179, 60);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("Course Management ");
		lblNewLabel_2.setBounds(33, 278, 446, 51);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 44));
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\ACER\\Desktop\\OOP\\CMS\\src\\CourseManagementSystem\\Icons\\icons8-course-100.png"));
		lblNewLabel_5.setBounds(168, 103, 135, 194);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_2_1 = new JLabel("Welcome To");
		lblNewLabel_2_1.setFont(new Font("Arial", Font.BOLD, 44));
		lblNewLabel_2_1.setBounds(108, 55, 446, 51);
		panel.add(lblNewLabel_2_1);
		
	}
	public void SignInAction() {
		// Retrieve input values from text fields
		String firstName = first.getText();
		String LastName = last.getText();
		String userEmail = email.getText();
		char[] pa = pass.getPassword();
		String password = new String(pa);
		String combo = (String)ComboBox.getSelectedItem();
		String number = phoneNumber.getText();
		String course = courseText.getText();
		
		// Regular expressions to validate input fields
		String fn = "[A-Z]{1}[a-zA-Z]+";
		Pattern f = Pattern.compile(fn);
		Matcher fna = f.matcher(firstName);
		boolean fp = fna.matches();
		
		String ln = "[A-Z]{1}[a-zA-Z]+";
		Pattern l = Pattern.compile(ln);
		Matcher lna = l.matcher(LastName);
		boolean lp = lna.matches();
		
		String ema = "[a-z]{1}[a-zA-Z1-9]+[@]gmail[.]com";
		Pattern em = Pattern.compile(ema);
		Matcher emaa = em.matcher(userEmail);
		boolean ma = emaa.matches();
		
		String pn = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^a-zA-Z\\d]).{4,}$";
		Pattern pan = Pattern.compile(pn);
		Matcher mp = pan.matcher(new String(password));
		boolean mpa = mp.matches();
		
		// Check if all required fields are filled and inputs are valid
		if(!firstName.equals("") && !LastName.equals("") && !userEmail.equals("") && !(new String(password)).equals("") && number.length()<=10) {
			//Check if the inputed values meet the specific pattern or not
			if( fp==true && lp==true && ma==true && mpa==true) {
				// Print input values 
				System.out.println(firstName);
				System.out.println(LastName);
				System.out.println(userEmail);
				System.out.println(password);
				System.out.println(combo);
				System.out.print(number);
				
				// Establish database connection
				String url = "jdbc:mysql://localhost:3306";
		        String dbUsername = "root";
		        String dbPassword = "";
		         try {
		             Connection con = DriverManager.getConnection(url, dbUsername, dbPassword);
		             Statement stn = (Statement) con.createStatement();
		             System.out.println("Connection established");
		             
		             // Create database if not exists
		             String a = "CREATE DATABASE IF NOT EXISTS CourseManagementSystem";
		             stn.execute(a); 
		             
		             // Handle different user types and create corresponding tables
		             if(combo.equals("Student")) {
		             	// Create student table if not exists
		            	String table = "CREATE TABLE IF NOT EXISTS CourseManagementSystem.student(ID INT AUTO_INCREMENT PRIMARY KEY, FirstName varchar(50), LastName varchar(50), Email varchar(120), Password varchar(50), User varchar(50), Phone varchar(120), Course varchar(1000))";
		            	stn.execute(table);
		            	
		            	// Insert values into student table
		            	String ValueInserting = "INSERT INTO CourseManagementSystem.student (FirstName, LastName, Email, Password, User, Phone, course ) VALUES (?, ?, ?, ?, ?, ?, ?)";
		            	PreparedStatement pstmt = con.prepareStatement(ValueInserting);
		            	pstmt.setString(1, firstName);
		            	pstmt.setString(2, LastName);
		            	pstmt.setString(3, userEmail);
		            	pstmt.setString(4, password);
		            	pstmt.setString(5, combo);
		            	pstmt.setString(6, number);
		            	pstmt.setString(7, course);
		            	pstmt.executeUpdate();
		                 if(table!=null) {
		                	 System.out.println("Table created");
		                 }
		                 System.out.println("values inserted");
		            } else if(combo.equals("Teacher")) {
		            	// Create teacher table if not exists
		            	String teacherTable = "CREATE TABLE IF NOT EXISTS CourseManagementSystem.teacher(ID INT AUTO_INCREMENT PRIMARY KEY, First_Name varchar(100), Last_Name varchar(1000), Email varchar(1000), Password varchar(1200), User varchar(50), Phone varchar(120), Course varchar(1000))";
		            	stn.execute(teacherTable);
		            	
		            	// Insert values into teacher table
		            	String ValueInserting = "INSERT INTO CourseManagementSystem.teacher (First_Name, Last_Name, Email, Password, User, Phone, Course) VALUES (?, ?, ?, ?, ?, ?, ?)";
		            	PreparedStatement p = con.prepareStatement(ValueInserting);
		            	p.setString(1, firstName);
		            	p.setString(2, LastName);
		            	p.setString(3, userEmail);
		            	p.setString(4, password);
		            	p.setString(5, combo);
		            	p.setString(6, number);
		            	p.setString(7, course);
		            	p.executeUpdate();
		                     if(teacherTable!=null) {
		                    	 System.out.println("Table created");
		                     }
		                     System.out.println("values inserted");
		            } else if(combo.equals("Admin")) {
		            	// Create admin table if not exists
		            	String adminTable = "CREATE TABLE IF NOT EXISTS CourseManagementSystem.admin(ID INT AUTO_INCREMENT PRIMARY KEY,FirstName varchar(50), LastName varchar(50), Email varchar(120), Password varchar(50), User varchar(50), Phone varchar(20))";
		            	stn.execute(adminTable);
		            	
		            	// Insert values into admin table
		            	String insertValues = "INSERT INTO CourseManagementSystem.admin (FirstName, LastName, Email, Password, User, Phone) VALUES (?, ?, ?, ?, ?, ?)";
		            	PreparedStatement p2 = con.prepareStatement(insertValues);
		            	p2.setString(1, firstName);
		            	p2.setString(2, LastName);
		            	p2.setString(3, userEmail);
		            	p2.setString(4, password);
		            	p2.setString(5, combo);
		            	p2.setString(6, number);
		            	p2.executeUpdate();
		                     if(adminTable!=null) {
		                    	 System.out.println("Table created");
		                     }
		                     System.out.println("values inserted");
		            }
		           
		         } catch (SQLException e) {
		             System.out.println("Connection not established");
		             e.printStackTrace();
		         }
				
				// Display success message
				JOptionPane.showMessageDialog(null, "Sign Up success");
			} else {
				// Display error message for incorrect input format
				JOptionPane.showMessageDialog(null, "Incorrect format of Password or email or phone number");
			}
		} else {
			// Display error message for unfilled input fields
			JOptionPane.showMessageDialog(null, "Please fill the box");
		}
		
		 
	}
}



