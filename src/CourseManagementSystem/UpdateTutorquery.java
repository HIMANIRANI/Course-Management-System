package CourseManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateTutorquery {

	public void updatingTutor(String tutorID, String tutorFName, String tutorLName, String email, String phone, String course) {
		
		String url = "jdbc:mysql://localhost:3306/CourseManagementSystem";
	    String Username = "root";
	    String Password = "";
	    String id = tutorID;
	    String fname = tutorFName;
	    String lname = tutorLName;
	    String Email = email;
	    String number = phone;
	    String module = course;
	    try {
	    	Connection c = DriverManager.getConnection(url,Username,Password);
	    	Statement s = c.createStatement();
	    	
	    	String query = " CREATE DATABASE IF NOT EXISTS CourseManagementSystem";           

	        s.executeUpdate(query);
	        
	        String updateQuery = "UPDATE CourseManagementSystem.teacher SET "
	                + "First_Name = '" + fname + "', "
	                + "Last_Name = '" + lname + "', "
	                + "Email = '" + Email + "', "
	                + "Phone = '" + number + "' ,"
	                + "Course = '"+module+"'"
	                + "WHERE ID = " + id;

	        s.executeUpdate(updateQuery);
	        s.close();
	        c.close();
	    } catch (SQLException e) {
	    	System.out.print(e);
	    }
		
		
	}
}
