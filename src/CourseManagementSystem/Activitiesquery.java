//Query to insert activities in database

package CourseManagementSystem;

// Importing necessary Java libraries
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Activitiesquery {
    // Method for activity
    public static void activity() {
        // Database connection 
        String url = "jdbc:mysql://localhost:3306/coursemanagementsystem";
        String username = "root";
        String password = "";
        String email = Login.mail(); // Getting user email from Login class
        String user = Login.comboVal(); // Getting user type from Login class

        try {
            // Establishing database connection
            Connection con = DriverManager.getConnection(url, username, password);
            Statement s = con.createStatement();

            // Creating database if not exists
            String q = " CREATE DATABASE IF NOT EXISTS coursemanagementsystem";
            s.executeUpdate(q);

            // Creating activity table if not exists
            String activityTable = "CREATE TABLE IF NOT EXISTS CourseManagementSystem.activity(ID INT AUTO_INCREMENT PRIMARY KEY, Activities varchar(500))";
            s.execute(activityTable);

            // Getting current time
            String time = currentTime();
            String activity = "logged in by:'" + user + "' ,email: '" + email + "' at '" + time + "'";
            // SQL query to insert activity into database
            String valueinserting = "INSERT INTO CourseManagementSystem.activity (Activities) VALUES (?)";
            PreparedStatement pstmt = con.prepareStatement(valueinserting);
            pstmt.setString(1, activity);
            pstmt.executeUpdate();

        } catch (SQLException E) {
            // Catching and handling SQL exceptions
            System.out.println(E);
        }
    }

    // Method to get current time
    public static String currentTime() {
        // Get the current date and time
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = currentDateTime.format(formatter);
        return formattedDateTime;
    }
}
