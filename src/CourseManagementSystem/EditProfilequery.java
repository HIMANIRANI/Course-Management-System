package CourseManagementSystem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//change database ma bhako info haru setting maa aafno profile change garni
public class EditProfilequery {
    public void changeUserData(String namefirst, String namelast, String mail, String userId, String number, String tableName) {
        String url = "jdbc:mysql://localhost:3306";
        String dbUsername = "root";
        String dbPassword = "";
        String table = tableName;
        String userName = namefirst;
        String lname = namelast;
        String email = mail;
        String phone = number;
        String id = userId;
       
        try {
            Connection c = DriverManager.getConnection(url, dbUsername, dbPassword);
            Statement s = c.createStatement();
            String query = " CREATE DATABASE IF NOT EXISTS CourseManagementSystem";
            s.executeUpdate(query);
            String updateQuery = "UPDATE CourseManagementSystem." + table + " SET " +
                    "FirstName = '" + userName + "', " +
                    "LastName = '" + lname + "', " +
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