package CourseManagementSystem;
//query to add student to db 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateStudentquery {
	public void StudentEdit(String id,String fName, String lName, String Email, String phone, String course){
		String url = "jdbc:mysql://localhost:3306/CourseManagementSystem";
	    String dbUsername = "root";
	    String dbPassword = "";
	    String ID = id;
	    String first = fName;
	    String last = lName;
	    String mail = Email;
	    String number = phone;
	    String module = course;
	    
	    try {
	    	Connection c = DriverManager.getConnection(url,dbUsername,dbPassword);
	    	Statement s = c.createStatement();
	    	
	    	String query = " CREATE DATABASE IF NOT EXISTS CourseManagementSystem";           

	        s.executeUpdate(query);
	        
	        String studentTable = "CREATE TABLE IF NOT EXISTS CourseManagementSystem.student(ID INT AUTO_INCREMENT PRIMARY KEY, FirstName varchar(50), LastName varchar(50), Email varchar(120), Password varchar(50), User varchar(50), Phone varchar(120), Course varchar(1000))";
        	s.execute(studentTable);
	        String updateQuery = "UPDATE CourseManagementSystem.student SET "
	                + "FirstName = '" + first + "', "
	                + "LastName = '" + last + "', "
	                + "Email = '" + mail + "', "
	                + "Phone = '" + number + "' ,"
	                + "Course = '"+module+"'"
	                + "WHERE ID = " + ID;

	        s.executeUpdate(updateQuery);
	        s.close();
	        c.close();
	    } catch (SQLException e) {
	    	System.out.print(e);
	    }
		
		
	}
		
	
	
}
