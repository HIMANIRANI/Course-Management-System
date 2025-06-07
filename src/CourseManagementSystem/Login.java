package CourseManagementSystem;


import java.sql.*;
import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.util.regex.*;
import javax.swing.DropMode;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
public class Login extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JTextField userEmail;
	private JPasswordField userPass;
	private static JComboBox ComboField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 857, 522);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLoginPage = new JLabel("Login Page");
		lblLoginPage.setFont(new Font("Dialog", Font.BOLD, 14));
		lblLoginPage.setBounds(337, 12, 229, 27);
		contentPane.add(lblLoginPage);
		
		JButton loginBtn = new JButton("Login");
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userLogIn();
				Activitiesquery.activity();
			}
			
		});
		loginBtn.setBounds(255, 259, 117, 25);
		contentPane.add(loginBtn);
		
		userEmail = new JTextField();
		userEmail.setBounds(412, 128, 176, 34);
		contentPane.add(userEmail);
		userEmail.setColumns(10);
		
		
		
		JLabel username = new JLabel("Email");
		username.setBounds(244, 135, 128, 19);
		contentPane.add(username);
		
		JLabel Password = new JLabel("Password");
		Password.setBounds(242, 196, 102, 27);
		contentPane.add(Password);
		
		JButton singupBtn = new JButton("SignUp");
		singupBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignIn s = new SignIn();
				s.setVisible(true);
				dispose();
			}
		});
		singupBtn.setBounds(449, 259, 117, 25);
		contentPane.add(singupBtn);
		
		userPass = new JPasswordField();
		userPass.setBounds(412, 197, 176, 34);
		contentPane.add(userPass);
		
		ComboField = new JComboBox();
		ComboField.setModel(new DefaultComboBoxModel(new String[] {"--Select Mode--", "Admin", "Teacher", "Student"}));
		ComboField.setBounds(412, 65, 176, 24);
		contentPane.add(ComboField);
		
		JLabel lblNewLabel = new JLabel("User");
		lblNewLabel.setBounds(244, 60, 128, 34);
		contentPane.add(lblNewLabel);
	}
	
	public static String comboVal() {
		String combo2 = (String)ComboField.getSelectedItem();
		return combo2;
		
	}
	public static String mail() {
		String email =  userEmail.getText();
		return email;
	}
	
	public void userLogIn() {
		
		String email = userEmail.getText();
		char[] userPassword = userPass.getPassword();
		String pass = new String(userPassword);
		String comboo = (String)ComboField.getSelectedItem();
		
	
		if(!email.equals("") && !pass.equals("")) {
			
			String url = "jdbc:mysql://localhost:3306/coursemanagementsystem";
	        String baseUsername = "root";
	        String basePassword = "";
	        try {
	        	 Connection logData = DriverManager.getConnection(url, baseUsername, basePassword);
	             Statement s = logData.createStatement();
	            if(comboo.equals("Student")) {
	            	 String querry = "SELECT Password FROM student where Email = '" + email + "'";
		             ResultSet result = s.executeQuery(querry);
		             if (result.next()){
		            	 String storedPass = result.getString("Password");
		            	 if(storedPass.equals(pass)) {
		            		 JOptionPane.showMessageDialog(null, "Login successful");
		            		 dispose();
		     				StudentDashboard sd = new StudentDashboard();
		     				sd.setVisible(true);

		            	 }
		            	 else {
			            	 JOptionPane.showMessageDialog(null, "Login failed");
			             }
		            	 
		             }else {
		            	 JOptionPane.showMessageDialog(null, "User not found");
		             }
	            } else if(comboo.equals("Teacher")) {
	            	 String querry2 = "SELECT Password FROM teacher where Email = '" + email + "'";
		             ResultSet result2 = s.executeQuery(querry2);
		             if (result2.next()){
		            	 String storedPass2 = result2.getString("Password");
		            	 if(storedPass2.equals(pass)) {
		            		 JOptionPane.showMessageDialog(null, "Login sucessful");
		            		 dispose();
		     				TeacherDashboard d = new TeacherDashboard();
		     				d.setVisible(true);

		            	 }
		            	 else {
			            	 JOptionPane.showMessageDialog(null, "Login failed");
			             }
		            	 
		             }else {
		            	 JOptionPane.showMessageDialog(null, "User not found");
		             }
	            } else if(comboo.equals("Admin")) {
	            	 String querry3 = "SELECT Password FROM admin where Email = '" + email + "'";
		             ResultSet result3 = s.executeQuery(querry3);
		             if (result3.next()){
		            	 String storedPass = result3.getString("Password");
		            	 if(storedPass.equals(pass)) {
		            		 JOptionPane.showMessageDialog(null, "Login sucessful");
		            		 dispose();
		     				Dashboard d = new Dashboard();
		     				d.setVisible(true);

		            	 }
		            	 else {
			            	 JOptionPane.showMessageDialog(null, "Login failed");
			             }
		            	 
		             }else {
		            	 JOptionPane.showMessageDialog(null, "User not found");
		             }
	            }
	             
	        }catch(Exception e) {
	        	JOptionPane.showMessageDialog(null, e);
	        }
		
		} else {
			JOptionPane.showMessageDialog(null, "Fill the box");
		}
		
		
		
		
		
	}
}
