package CourseManagementSystem;
//query to delete course use in Delete course
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CourseDeletequery {
	public void deletingCourse(String id) {
		String url = "jdbc:mysql://localhost:3306/CourseManagementSystem";
	    String Username = "root";
	    String Password = "";
	    
	    try {
	    	String courseId = id;
	    	Connection c = DriverManager.getConnection(url,Username,Password);
	    	Statement s = c.createStatement();
	    	String delete = "DELETE FROM CourseManagementSystem.course WHERE id = '" + courseId + "'";
	        s.executeUpdate(delete);
	    	
	    } catch (SQLException e) {
	    	System.out.println(e);
	    }
	}
	
}