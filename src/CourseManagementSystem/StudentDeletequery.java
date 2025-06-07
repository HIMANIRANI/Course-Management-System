package CourseManagementSystem;
//query to delete student from db
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentDeletequery {
	public void deleteing(String id) {
		String url = "jdbc:mysql://localhost:3306/CourseManagementSystem";
	    String baseUsername = "root";
	    String basePassword = "";
	    
	    try {
	    	String studentId = id;
	    	Connection c = DriverManager.getConnection(url,baseUsername,basePassword);
	    	Statement s = c.createStatement();
	    	String deleteTutor = "DELETE FROM CourseManagementSystem.student WHERE id = '" + studentId + "'";
	        s.executeUpdate(deleteTutor);
	    	
	    } catch (SQLException e) {
	    	System.out.println(e);
	    }
	}
}
