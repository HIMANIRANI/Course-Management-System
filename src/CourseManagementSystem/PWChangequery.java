package CourseManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PWChangequery {
    public void passChange(String newP, String oldP, String userMail, String tableName) {
        String url = "jdbc:mysql://localhost:3306/coursemanagementsystem";
        String baseUsername = "root";
        String basePassword = "";
        String table = tableName;
        String oldPassword = oldP;
        String newPassword = newP;
        String passEmail = userMail;

        try {
            Connection c = DriverManager.getConnection(url, baseUsername, basePassword);
            Statement s = c.createStatement();
            String query = "CREATE DATABASE IF NOT EXISTS coursemanagementsystem";
            s.executeUpdate(query);
            System.out.println(oldPassword);
            System.out.println(newPassword);
            
            String updateQuery = "UPDATE coursemanagementsystem." + table + " SET " +
                    "Password = '" + newPassword + "' " + 
                    "WHERE Email = '" + passEmail + "'"; 
            s.executeUpdate(updateQuery);
            s.close();
            c.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}