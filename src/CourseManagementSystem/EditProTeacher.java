package CourseManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class EditProTeacher {
    public void changeTeacherData(String name, String cast, String mail, String userId, String number, String tableName) {
        String url = "jdbc:mysql://localhost:3306/CourseManagementSystem";
        String Username = "root";
        String Password = "";
        String table = tableName;
        String userName = name;
        String lname = cast;
        String email = mail;
        String phone = number;
        String id = userId;
       
        try {
            Connection c = DriverManager.getConnection(url, Username, Password);
            Statement s = c.createStatement();
            String query = " CREATE DATABASE IF NOT EXISTS CourseManagementSystem";
            s.executeUpdate(query);
            String updateQuery = "UPDATE CourseManagementSystem." + table + " SET " +
                    "First_Name = '" + userName + "', " +
                    "Last_Name = '" + lname + "', " +
                    "Email = '" + email + "', " +
                    "Phone = '" + phone + "' " + 
                    "WHERE ID = " + id;
            s.executeUpdate(updateQuery);
            s.close();
            c.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
