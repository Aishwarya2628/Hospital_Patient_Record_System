package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static Connection getConnection() {
  
        try {
            // Load JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
      

            // DB connection details
            String url = "jdbc:mysql://localhost:3306/hospitalManagement";
            String user = "root";          // 👈 Your MySQL username
            String password = "pass123";   // 👈 Your MySQL password

            // Create and return the connection
            return DriverManager.getConnection(url, user, password);

        } catch (Exception e) {
            System.out.println(" Database connection failed:");
            e.printStackTrace(); // Show full error stack
            throw new RuntimeException("DB Connection Error", e);
        }
    }
}
