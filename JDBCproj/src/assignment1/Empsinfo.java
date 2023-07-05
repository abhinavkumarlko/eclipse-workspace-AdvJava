package assignment1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Empsinfo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con =null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String jdbcUrl = "jdbc:mysql://localhost:3306/dac";
			
			 con = DriverManager.getConnection(jdbcUrl, "root", "root");
			
			System.out.println("connection established");
			
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("select * from emptemp");
			
			
			while(rs.next()) {
				System.out.println("Empno" +":"+rs.getInt(1));
				System.out.println("Ename" +":"+rs.getString(2));
				System.out.println("Job" +":"+rs.getString(3));
				System.out.println("Salary" +":"+rs.getFloat(6));
				System.out.println("Deptno" +":"+rs.getInt(8));
				System.out.println();
			}
			rs.close();
			stmt.close();
			con.close();
		}
		catch(ClassNotFoundException e) {
			System.out.println("driver class not found");
		}
		catch(SQLException e) {
			System.out.println("connection rejected");
		}
	}

}
