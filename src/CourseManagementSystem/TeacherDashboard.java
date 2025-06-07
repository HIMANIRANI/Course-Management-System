package CourseManagementSystem;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;

public class TeacherDashboard extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private static JTable tableCourse;
	private JTextField searchCourse;
	
	private static JTable tutorTable;
	private JTextField fName;
	private JTextField LName;
	private static JTable studentTable;
	private JTextField studentSearch;
	private JTextField studentUserName;
	private JTextField studentNumber;
	private JTextField StudentIdentity;
	private JTextField StudentLastName;
	private JTextField StudentEmail;
	private JPasswordField previous;
	private JPasswordField present;
	private JTextField emailTeacher;
	private static JTable activityTable;
	private static JLabel totalStudent;
	private static JLabel totalCourse;
	private static JLabel totalTeachers;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeacherDashboard frame = new TeacherDashboard();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void dataCourse(){
		
		DefaultTableModel model = (DefaultTableModel)tableCourse.getModel();
		model.setRowCount(0);			
		String url = "jdbc:mysql://localhost:3306/CourseManagementSystem";
        String dbUsername = "root";
        String dbPassword = "";
        try {
	           Connection con = DriverManager.getConnection(url, dbUsername, dbPassword);
	           Statement stmt = con.createStatement();
	           String query = "select * from CourseManagementSystem.Course";
	           ResultSet rs = stmt.executeQuery(query);
	    	   boolean check = false;    
	           while(rs.next()){
	        	   String id = rs.getString(1);
	        	   String course_name = rs.getString(2);
	        	   String course_seat= rs.getString(3);
	        	   String course_batch = rs.getString(4);
	        	   String course_year= rs.getString(5);
	        	   String course_pass = rs.getString(6);
	        	   String data[]= {id,course_name, course_seat, course_batch, course_year,course_pass	};
	        	   model.addRow(data);
	        	   
	           }

	       }
			catch (SQLException e1) {
	           e1.printStackTrace();
	       }	
}

public static void DataTutors() {
DefaultTableModel model2 = (DefaultTableModel)tutorTable.getModel();
model2.setRowCount(0);			
String url = "jdbc:mysql://localhost:3306/CourseManagementSystem";
String dbUsername = "root";
String dbPassword = "";
try {
       Connection con2 = DriverManager.getConnection(url, dbUsername, dbPassword);
       Statement stmt2 = con2.createStatement();
       String query2 = "select * from CourseManagementSystem.teacher";
       ResultSet rs2 = stmt2.executeQuery(query2);
       while(rs2.next()){
    	   String id = rs2.getString(1);
    	   String firstName = rs2.getString(2);
    	   String lastName = rs2.getString(3);
    	   String email= rs2.getString(4);
    	   String phone = rs2.getString(7);
    	   String course = rs2.getString(8);
    	  
    	   String data[]= {id,firstName, lastName, email, phone,course};
    	   model2.addRow(data);
    	   
       }

   }
	catch (SQLException e1) {
       e1.printStackTrace();
   }	
}


public static void courseSearch(String courseName){
String url = "jdbc:mysql://localhost:3306/CourseManagementSystem";
String dbusername = "root";
String dbpassword = "";
String course = courseName;
DefaultTableModel model3 = (DefaultTableModel)tableCourse.getModel();
model3.setRowCount(0);

try {
    Connection con = DriverManager.getConnection(url, dbusername, dbpassword);
    Statement stmt = con.createStatement();
    String query = "SELECT * FROM CourseManagementSystem.Course WHERE Course_Name = '" + course + "'";
    ResultSet rss = stmt.executeQuery(query);
    if (rss.next()) {
    	String id = rss.getString(1);
 	   String course_name = rss.getString(2);
 	   String course_seat= rss.getString(3);
 	   String course_batch = rss.getString(4);
 	   String course_year= rss.getString(5);
 	   String course_pass = rss.getString(6);
 	   String data[]= {id,course_name, course_seat, course_batch, course_year,course_pass	};
 	   model3.addRow(data);
    }
    rss.close();
    stmt.close();
    con.close();			                    
} catch (SQLException e) {
	System.out.println(e);
}
}

public static void tutorSearch(String userName, String lname) {
String url = "jdbc:mysql://localhost:3306/CourseManagementSystem";
String username = "root";
String password = "";
String tutor = userName;
String last = lname;
DefaultTableModel model4 = (DefaultTableModel)tutorTable.getModel();
model4.setRowCount(0);

try {
    Connection con = DriverManager.getConnection(url, username, password);
    Statement stmt = con.createStatement();
    String query = "SELECT * FROM CourseManagementSystem.teacher WHERE First_Name = '" + tutor + "' AND Last_Name = '"+last+"'";
    ResultSet rs3 = stmt.executeQuery(query);
    if (rs3.next()) {
    	 String id = rs3.getString(1);
  	   String firstName = rs3.getString(2);
  	   String lastName = rs3.getString(3);
  	   String email= rs3.getString(4);
  	   String phone = rs3.getString(7);
  	   String course = rs3.getString(8);
  	  
  	   String data[]= {id,firstName, lastName, email, phone,course};
  	   model4.addRow(data);
    }
    rs3.close();
    stmt.close();
    con.close();			                    
} catch (SQLException e) {
	System.out.println(e);
}
}


public static void DataStudent() {
DefaultTableModel model5 = (DefaultTableModel)studentTable.getModel();
model5.setRowCount(0);			
String url = "jdbc:mysql://localhost:3306/CourseManagementSystem";
String dbUsername = "root";
String dbPassword = "";
try {
       Connection co = DriverManager.getConnection(url, dbUsername, dbPassword);
       Statement stmt = co.createStatement();
       String query = "select * from CourseManagementSystem.student";
       ResultSet rs = stmt.executeQuery(query);
	      
       while(rs.next()){
    	   String id = rs.getString(1);
    	   String first_name = rs.getString(2);
    	   String last_name= rs.getString(3);
    	   String email = rs.getString(4);
    	   String course= rs.getString(8);
    	  
    	   String data[]= {id,first_name, last_name, email,course};
    	   model5.addRow(data);
    	   
       }

   }
	catch (SQLException e1) {
       e1.printStackTrace();
   }	
}

public static void StudentSearchEnter(String student){
DefaultTableModel mo = (DefaultTableModel)studentTable.getModel();
mo.setRowCount(0);
String enteredStudent = student;
String url = "jdbc:mysql://localhost:3306/CourseManagementSystem";
String dbUsername = "root";
String dbPassword = "";
try {
       Connection con = DriverManager.getConnection(url, dbUsername, dbPassword);
       Statement stmt = con.createStatement();
       String query = "select * from CourseManagementSystem.student WHERE FirstName ='"+enteredStudent+"'";
       ResultSet r = stmt.executeQuery(query);   
       while(r.next()){
    	   String id = r.getString(1);
    	   String first_name = r.getString(2);
    	   String last_name= r.getString(3);
    	   String email = r.getString(4);
    	   String course= r.getString(8);
    	  
    	   String data[]= {id,first_name, last_name, email,course};
    	   mo.addRow(data);
    	   
       }

   }
	catch (SQLException e1) {
       e1.printStackTrace();
   }	   

System.out.println("Text entered: " + enteredStudent);
}
public static void StudentDisplayDashboard(){
DefaultTableModel model2 = (DefaultTableModel)activityTable.getModel();
model2.setRowCount(0);			
String url = "jdbc:mysql://localhost:3306/CourseManagementSystem";
String dbUsername = "root";
String dbPassword = "";
try {
       Connection con2 = DriverManager.getConnection(url, dbUsername, dbPassword);
       Statement stmt2 = con2.createStatement();
       String query2 = "select * from CourseManagementSystem.activity";
       ResultSet rs2 = stmt2.executeQuery(query2);
       while(rs2.next()){
    	   String id = rs2.getString(1);
    	   String activity= rs2.getString(2);
    	   String data[]= {id,activity};
    	   model2.addRow(data);
       }
   }
	catch (SQLException e1) {
       e1.printStackTrace();
   }	
}


public static String Together(String tableName) {
String url = "jdbc:mysql://localhost:3306/CourseManagementSystem";
String dbusername = "root";
String dbpassword = "";
int count = 0;
try {
    Connection con = DriverManager.getConnection(url, dbusername, dbpassword);
    Statement stmt = con.createStatement();
    String data = "SELECT * FROM CourseManagementSystem." + tableName;
    ResultSet rs = stmt.executeQuery(data);
    while (rs.next()) {
        count++;
    }
    System.out.println(count);
    stmt.close();
    con.close(); 
    return String.valueOf(count);

} catch (SQLException e) {
    System.out.println(e);
    return String.valueOf(count);

}

}
	
	/**
	 * Create the frame.
	 */
	public TeacherDashboard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1346, 723);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 12, 236, 681);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton dashboardBtn = new JButton("Dashboard");
		dashboardBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		dashboardBtn.setBackground(new Color(222, 221, 218));
		dashboardBtn.setIcon(new ImageIcon("C:\\Users\\ACER\\AppData\\Local\\Microsoft\\Windows\\INetCache\\IE\\FVR5Z58T\\icons8-home-20[1].png"));
		dashboardBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(0);
				StudentDisplayDashboard();
				String studentTotal = Together("student");
				totalStudent.setText(studentTotal);
				String totalTutor =Together("teacher");
				totalTeachers.setText(totalTutor);
				String courseTotal =Together("Course");
				totalCourse.setText(courseTotal);
			}
		});
		dashboardBtn.setBounds(23, 171, 190, 52);
		panel.add(dashboardBtn);
		
		JButton coursesBtn = new JButton("Courses");
		coursesBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		coursesBtn.setBackground(new Color(222, 221, 218));
		coursesBtn.setIcon(new ImageIcon("C:\\Users\\ACER\\Desktop\\OOP\\CMS\\src\\CourseManagementSystem\\Icons\\icons8-course-assign-20.png"));
		coursesBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(1);
				dataCourse();
			}
		});
		coursesBtn.setBounds(23, 241, 190, 52);
		panel.add(coursesBtn);
		
		JButton tutorBtn = new JButton("Tutors");
		tutorBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tutorBtn.setBackground(new Color(222, 221, 218));
		tutorBtn.setIcon(new ImageIcon("C:\\Users\\ACER\\Desktop\\OOP\\CMS\\src\\CourseManagementSystem\\Icons\\icons8-tutor-20.png"));
		tutorBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(2);			
				DataTutors();
			}
			
		});
		tutorBtn.setBounds(23, 313, 190, 60);
		panel.add(tutorBtn);
		
		JButton studentBtn = new JButton("Students");
		studentBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		studentBtn.setBackground(new Color(222, 221, 218));
		studentBtn.setIcon(new ImageIcon("C:\\Users\\ACER\\Desktop\\OOP\\CMS\\src\\CourseManagementSystem\\Icons\\icons8-students-20.png"));
		studentBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(3);
				DataStudent();
				
				
				
			}
		});
		studentBtn.setBounds(23, 397, 190, 52);
		panel.add(studentBtn);
		
		JButton settingBtn = new JButton("Setting\r\n");
		settingBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		settingBtn.setBackground(new Color(222, 221, 218));
		settingBtn.setIcon(new ImageIcon("C:\\Users\\ACER\\Desktop\\OOP\\CMS\\src\\CourseManagementSystem\\Icons\\icons8-setting-20.png"));
		settingBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(4);
				
				
			}
		});
		settingBtn.setBounds(23, 485, 190, 52);
		panel.add(settingBtn);
		
		JButton logoutBtn = new JButton("Logout");
		logoutBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		logoutBtn.setBackground(new Color(222, 221, 218));
		logoutBtn.setIcon(new ImageIcon("C:\\Users\\ACER\\Desktop\\OOP\\CMS\\src\\CourseManagementSystem\\Icons\\icons8-logout-20.png"));
		logoutBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login l = new Login();
				l.setVisible(true);
				dispose();
			}
		});
		logoutBtn.setBounds(23, 562, 190, 52);
		panel.add(logoutBtn);
		
		JLabel lblNewLabel = new JLabel("Course Management System");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 17));
		lblNewLabel.setBounds(10, 117, 216, 44);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\ACER\\Downloads\\icons8-course-50.png"));
		lblNewLabel_1.setBounds(89, 90, 86, 60);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\ACER\\Desktop\\OOP\\CMS\\src\\CourseManagementSystem\\Icons\\icons8-course-50.png"));
		lblNewLabel_2.setBounds(98, 75, 77, 52);
		panel.add(lblNewLabel_2);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(260, 97, 838, 584);
		contentPane.add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Dashboard", null, panel_1, null);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(12, 222, 809, 302);
		panel_1.add(scrollPane_3);
		
		activityTable = new JTable();
		scrollPane_3.setViewportView(activityTable);
		activityTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Activity"
			}
		));	
		
		activityTable.getColumnModel().getColumn(0).setPreferredWidth(30);
		activityTable.getColumnModel().getColumn(0).setMinWidth(80);
		activityTable.getColumnModel().getColumn(0).setMaxWidth(80);
		activityTable.getColumnModel().getColumn(1).setPreferredWidth(316);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(22, 28, 203, 153);
		panel_1.add(panel_6);
		panel_6.setBorder(BorderFactory.createRaisedBevelBorder());
		panel_6.setLayout(null);
		
		JLabel lblTotalStudents = new JLabel("Total Students");
		lblTotalStudents.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalStudents.setFont(new Font("Dialog", Font.BOLD, 16));
		lblTotalStudents.setBounds(12, 12, 168, 29);
		panel_6.add(lblTotalStudents);
		
		totalStudent = new JLabel("0");
		totalStudent.setHorizontalAlignment(SwingConstants.CENTER);
		totalStudent.setFont(new Font("Dialog", Font.BOLD, 20));
		totalStudent.setBounds(49, 60, 99, 40);
		panel_6.add(totalStudent);
		
		JPanel panel_6_1 = new JPanel();
		panel_6_1.setBounds(272, 28, 198, 153);
		panel_1.add(panel_6_1);
		panel_6_1.setBorder(BorderFactory.createRaisedBevelBorder());
		panel_6_1.setLayout(null);
		
		JLabel lblTotalCourse = new JLabel("Total Courses");
		lblTotalCourse.setBounds(34, 12, 131, 19);
		lblTotalCourse.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalCourse.setFont(new Font("Dialog", Font.BOLD, 16));
		panel_6_1.add(lblTotalCourse);
		
		totalCourse = new JLabel("0");
		totalCourse.setHorizontalAlignment(SwingConstants.CENTER);
		totalCourse.setFont(new Font("Dialog", Font.BOLD, 20));
		totalCourse.setBounds(50, 59, 99, 40);
		panel_6_1.add(totalCourse);
		
		JPanel panel_6_2 = new JPanel();
		panel_6_2.setBounds(544, 28, 188, 153);
		panel_1.add(panel_6_2);
		panel_6_2.setBorder(BorderFactory.createRaisedBevelBorder());
		panel_6_2.setLayout(null);
		
		JLabel lblTotalTeachers = new JLabel("Total Tutors");
		lblTotalTeachers.setBounds(12, 12, 148, 19);
		lblTotalTeachers.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalTeachers.setFont(new Font("Dialog", Font.BOLD, 16));
		panel_6_2.add(lblTotalTeachers);
		
		totalTeachers = new JLabel("0");
		totalTeachers.setHorizontalAlignment(SwingConstants.CENTER);
		totalTeachers.setFont(new Font("Dialog", Font.BOLD, 20));
		totalTeachers.setBounds(38, 54, 99, 40);
		panel_6_2.add(totalTeachers);
		
		
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Courses", null, panel_3, null);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 133, 809, 412);
		panel_3.add(scrollPane_1);
		
		tableCourse = new JTable();
		tableCourse.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				"Id","Course Name", "Seats", "Batch", "No. of Years", "Module"
			}
		));
		scrollPane_1.setViewportView(tableCourse);
		
		searchCourse = new JTextField();
		searchCourse.setToolTipText("");
		searchCourse.setBounds(12, 84, 601, 37);
		panel_3.add(searchCourse);
		searchCourse.setColumns(10);
		
		JButton searchBtn = new JButton("Search");
		searchBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		searchBtn.setBackground(new Color(222, 221, 218));
		searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String courseSearch = searchCourse.getText();
				courseSearch(courseSearch);
				
			}
		});
		searchBtn.setBounds(646, 84, 175, 37);
		panel_3.add(searchBtn);
		
		JLabel lblCourseInformation = new JLabel("Course Information");
		lblCourseInformation.setHorizontalAlignment(SwingConstants.CENTER);
		lblCourseInformation.setFont(new Font("Dialog", Font.BOLD, 20));
		lblCourseInformation.setBounds(12, 12, 809, 55);
		panel_3.add(lblCourseInformation);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(12, 62, 809, 10);
		panel_3.add(separator_3);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Tutors", null, panel_4, null);
		
		JButton btnDeleteTutors = new JButton("Search Tutor");
		btnDeleteTutors.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnDeleteTutors.setBackground(new Color(222, 221, 218));
		btnDeleteTutors.setBounds(643, 83, 178, 34);
		btnDeleteTutors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String firstName =  fName.getText();
				String lastName = LName.getText();
				tutorSearch(firstName,lastName);
				
			}
		});
		panel_4.setLayout(null);
		panel_4.add(btnDeleteTutors);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 129, 809, 416);
		panel_4.add(scrollPane);
		
		tutorTable = new JTable();
		scrollPane.setViewportView(tutorTable);
		tutorTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID","First_Name", "Last_Name", "Email", "Course"
			}
		));
		
		fName = new JTextField();
		fName.setBounds(129, 86, 158, 29);
		panel_4.add(fName);
		fName.setColumns(10);
		
		LName = new JTextField();
		LName.setBounds(460, 86, 150, 29);
		panel_4.add(LName);
		LName.setColumns(10);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(12, 89, 135, 22);
		lblFirstName.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_4.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(320, 86, 122, 28);
		lblLastName.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_4.add(lblLastName);
		
		JLabel lblTeacherInformation = new JLabel("Tutors Information");
		lblTeacherInformation.setHorizontalAlignment(SwingConstants.CENTER);
		lblTeacherInformation.setFont(new Font("Dialog", Font.BOLD, 20));
		lblTeacherInformation.setBounds(12, 12, 809, 55);
		panel_4.add(lblTeacherInformation);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(12, 61, 809, 10);
		panel_4.add(separator_2);
		
		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("Students", null, panel_5, null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(12, 145, 809, 400);
		
		studentTable = new JTable();
		studentTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "First_Name", "Last_Name", "Email", "Course"
			}
		));
		scrollPane_2.setViewportView(studentTable);
		
		studentSearch = new JTextField();
		studentSearch.setBounds(12, 79, 356, 40);
		studentSearch.setColumns(10);
		
		JButton btnSearchStudent = new JButton("Search Student");
		btnSearchStudent.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSearchStudent.setBackground(new Color(222, 221, 218));
		btnSearchStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String student = studentSearch.getText();
;				StudentSearchEnter(student);
			}
		});
		btnSearchStudent.setBounds(380, 79, 210, 40);
		panel_5.setLayout(null);
		panel_5.add(studentSearch);
		panel_5.add(btnSearchStudent);
		panel_5.add(scrollPane_2);
		
		JLabel lblStudentInformation = new JLabel("Student Information");
		lblStudentInformation.setFont(new Font("Dialog", Font.BOLD, 20));
		lblStudentInformation.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudentInformation.setBounds(12, 12, 809, 55);
		panel_5.add(lblStudentInformation);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(12, 66, 809, 10);
		panel_5.add(separator_1);
		
		JButton btnViewReport = new JButton("Student Result");
		btnViewReport.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnViewReport.setBackground(new Color(222, 221, 218));
		btnViewReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddStudentReport asr = new AddStudentReport();
				asr.setVisible(true);
				asr.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			}
		});
		btnViewReport.setBounds(618, 79, 203, 40);
		panel_5.add(btnViewReport);
		
		
		
		JPanel panel_7 = new JPanel();
		tabbedPane.addTab("Setting", null, panel_7, null);
		panel_7.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(1110, 25, 214, 656);
		contentPane.add(panel_2);
		
		JLabel lblSetting = new JLabel("Setting");
		lblSetting.setIcon(new ImageIcon("C:\\Users\\ACER\\Desktop\\OOP\\CMS\\src\\CourseManagementSystem\\Icons\\icons8-setting-20.png"));
		lblSetting.setBounds(12, 12, 231, 24);
		lblSetting.setFont(new Font("Dialog", Font.BOLD, 20));
		panel_7.add(lblSetting);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 48, 809, 10);
		panel_7.add(separator);
		
		JLabel lblUsername = new JLabel("First Name");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblUsername.setBounds(12, 70, 108, 15);
		panel_7.add(lblUsername);
		
		studentUserName = new JTextField();
		studentUserName.setBounds(150, 70, 141, 24);
		panel_7.add(studentUserName);
		studentUserName.setColumns(10);
		
		JLabel lblPhone = new JLabel("Phone ");
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPhone.setBounds(12, 127, 108, 15);
		panel_7.add(lblPhone);
		
		JLabel lblLastName_1 = new JLabel("Last Name");
		lblLastName_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLastName_1.setBounds(374, 70, 108, 15);
		panel_7.add(lblLastName_1);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEmail.setBounds(374, 127, 108, 15);
		panel_7.add(lblEmail);
		
		JLabel lblUsername_3_1 = new JLabel("ID");
		lblUsername_3_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblUsername_3_1.setBounds(12, 176, 108, 15);
		panel_7.add(lblUsername_3_1);
		
		studentNumber = new JTextField();
		studentNumber.setColumns(10);
		studentNumber.setBounds(150, 123, 141, 24);
		panel_7.add(studentNumber);
		
		StudentIdentity = new JTextField();
		StudentIdentity.setColumns(10);
		StudentIdentity.setBounds(150, 172, 141, 24);
		panel_7.add(StudentIdentity);
		
		StudentLastName = new JTextField();
		StudentLastName.setColumns(10);
		StudentLastName.setBounds(512, 66, 141, 24);
		panel_7.add(StudentLastName);
		
		StudentEmail = new JTextField();
		StudentEmail.setColumns(10);
		StudentEmail.setBounds(512, 123, 141, 24);
		panel_7.add(StudentEmail);
		
		JButton btnEditProfile = new JButton("Edit Profile");
		btnEditProfile.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnEditProfile.setBackground(new Color(222, 221, 218));
		btnEditProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String fname = studentUserName.getText();
			String lname = StudentLastName.getText();
			String email = StudentEmail.getText();
			String id = StudentIdentity.getText();
			String number = studentNumber.getText();
			String table = "teacher";
			EditProTeacher dc = new EditProTeacher();
			dc.changeTeacherData(fname, lname, email,id, number,table);
			JOptionPane.showMessageDialog(null, "Data edited");
			
			}
			
		});
		btnEditProfile.setBounds(512, 171, 141, 31);
		panel_7.add(btnEditProfile);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(12, 277, 809, 10);
		panel_7.add(separator_4);
		
		JLabel lblSecurityLogin = new JLabel("Security & Login");
		lblSecurityLogin.setIcon(new ImageIcon("C:\\Users\\ACER\\AppData\\Local\\Microsoft\\Windows\\INetCache\\IE\\B673EW3S\\icons8-private-lock-20[1].png"));
		lblSecurityLogin.setFont(new Font("Dialog", Font.BOLD, 20));
		lblSecurityLogin.setBounds(12, 241, 244, 24);
		panel_7.add(lblSecurityLogin);
		
		JLabel lblOldPassword = new JLabel("Old Password");
		lblOldPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblOldPassword.setBounds(12, 300, 134, 15);
		panel_7.add(lblOldPassword);
		
		previous = new JPasswordField();
		previous.setBounds(164, 300, 166, 24);
		panel_7.add(previous);
		
		JLabel lblNewPassword = new JLabel("New Password");
		lblNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewPassword.setBounds(413, 300, 134, 15);
		panel_7.add(lblNewPassword);
		
		present = new JPasswordField();
		present.setBounds(597, 300, 166, 24);
		panel_7.add(present);
		
		emailTeacher = new JTextField();
		emailTeacher.setColumns(10);
		emailTeacher.setBounds(164, 355, 166, 24);
		panel_7.add(emailTeacher);
		
		JLabel lblEmail_1 = new JLabel("Email");
		lblEmail_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEmail_1.setBounds(12, 359, 108, 15);
		panel_7.add(lblEmail_1);
		
		JButton btnChangePassword = new JButton("Change Password");
		btnChangePassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnChangePassword.setBackground(new Color(222, 221, 218));
		btnChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				char[] pres = previous.getPassword();
				String old = new String(pres);
				char[] press = present.getPassword();
				String newest = new String(press);
				String table = "teacher";
				String passEmail = emailTeacher.getText();
				PWChangequery cp = new PWChangequery();
				cp.passChange(newest,old,passEmail,table);
				JOptionPane.showMessageDialog(null, "Password changed");
				System.out.println(old);
				System.out.println(newest);
			}
		});
		btnChangePassword.setBounds(582, 348, 181, 37);
		panel_7.add(btnChangePassword);
		
		JLabel lblHelpServices = new JLabel("Help & Services");
		lblHelpServices.setFont(new Font("Dialog", Font.BOLD, 20));
		lblHelpServices.setBounds(12, 412, 244, 24);
		panel_7.add(lblHelpServices);
		
		JSeparator separator_4_1 = new JSeparator();
		separator_4_1.setBounds(12, 445, 809, 10);
		panel_7.add(separator_4_1);
		
		JLabel lblCmsSupportHotline = new JLabel("CMS Support Hotline");
		lblCmsSupportHotline.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCmsSupportHotline.setBounds(521, 455, 193, 15);
		panel_7.add(lblCmsSupportHotline);
		
		JLabel lblEmailHeraldcollegegmailcom = new JLabel("Email: HeraldCollege@gmail.com");
		lblEmailHeraldcollegegmailcom.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblEmailHeraldcollegegmailcom.setBounds(519, 486, 244, 15);
		panel_7.add(lblEmailHeraldcollegegmailcom);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number: 0000000000");
		lblPhoneNumber.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblPhoneNumber.setBounds(519, 513, 244, 15);
		panel_7.add(lblPhoneNumber);
		
		JLabel lblStudentDashboard = new JLabel("Teacher Dashboard");
		lblStudentDashboard.setBounds(263, 29, 808, 49);
		contentPane.add(lblStudentDashboard);
		lblStudentDashboard.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudentDashboard.setForeground(Color.BLACK);
		lblStudentDashboard.setFont(new Font("Dialog", Font.BOLD, 24));
		lblStudentDashboard.setBackground(Color.BLACK);
		
		JLabel lblNotifications = new JLabel("Notifications");
		lblNotifications.setIcon(new ImageIcon("C:\\Users\\ACER\\Desktop\\OOP\\CMS\\src\\CourseManagementSystem\\Icons\\icons8-notification-24.png"));
		lblNotifications.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNotifications.setBounds(1110, 0, 166, 30);
		contentPane.add(lblNotifications);
		
		
		
		
	}
}
