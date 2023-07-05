package assignment1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class Connect1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con =null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String jdbcUrl = "jdbc:mysql://localhost:3306/dac";
			
			 con = DriverManager.getConnection(jdbcUrl, "root", "root");
			
			System.out.println("connection established");
		}
		catch(ClassNotFoundException e) {
			System.out.println("driver class not found");
		}
		catch(SQLException e) {
			System.out.println("connection rejected");
		}

	}

}
