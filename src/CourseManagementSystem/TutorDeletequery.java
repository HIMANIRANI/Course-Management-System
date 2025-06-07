package CourseManagementSystem;

//query to delete tutors from db
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TutorDeletequery {
	public void deletingTutors(String id) {
		String url = "jdbc:mysql://localhost:3306/CourseManagementSystem";
	    String baseUsername = "root";
	    String basePassword = "";
	    
	    try {
	    	String courseId = id;
	    	Connection c = DriverManager.getConnection(url,baseUsername,basePassword);
	    	Statement s = c.createStatement();
	    	String deleteTutor = "DELETE FROM CourseManagementSystem.teacher WHERE id = '" + courseId + "'";
	        s.executeUpdate(deleteTutor);
	    	
	    } catch (SQLException e) {
	    	System.out.println(e);
	    }
	}
}
