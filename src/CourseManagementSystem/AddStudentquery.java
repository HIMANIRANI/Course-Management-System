//query to add student in database
package CourseManagementSystem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class AddStudentquery {
	 // Method to add a new student to the database
	public void addStudent(String fName, String lName, String Email, String password, String phone, String course ) {
		 // Database connection details
		String url = "jdbc:mysql://localhost:3306/CourseManagementSystem";
        String Username = "root";
        String Password = "";
        // Retrieving parameters for the new student
       String first = fName;
       String last = lName;
       String mail = Email;
       String pass = password;
       String user = "Student";
       String number = phone;
       String module = course;
        try {
        	 // Establishing a connection to the database
        	Connection con = DriverManager.getConnection(url,Username,Password);
        	Statement s = con.createStatement();
        	 // Creating student table if not exists
        	String studentTable = "CREATE TABLE IF NOT EXISTS CourseManagementSystem.student(ID INT AUTO_INCREMENT PRIMARY KEY, FirstName varchar(50), LastName varchar(50), Email varchar(120), Password varchar(50), User varchar(50), Phone varchar(120), Course varchar(1000))";
        	s.execute(studentTable);
        	 // Preparing SQL statement to insert a new student
        	String insertCourse = "INSERT INTO CourseManagementSystem.student (FirstName, LastName, Email, Password, User, Phone , Course) VALUES (?, ?, ?, ?, ?,?,?)";
        	PreparedStatement pstmt = con.prepareStatement(insertCourse); 
        	// Setting values for the parameters in the SQL statement
        	pstmt.setString(1, first);
        	pstmt.setString(2, last);
        	pstmt.setString(3, mail);
        	pstmt.setString(4, pass);
        	pstmt.setString(5, user);
        	pstmt.setString(6, number);
        	pstmt.setString(7, module);
        	 // Executing the SQL statement
        	pstmt.executeUpdate(); 
        	 // Catching and printing any exceptions that occur
        } catch(Exception e) {
        	System.out.print(e);
        }
        
		
	}
}
