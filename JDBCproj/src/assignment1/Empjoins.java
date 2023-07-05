package assignment1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Empjoins {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con =null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String jdbcUrl = "jdbc:mysql://localhost:3306/dac";
			
			 con = DriverManager.getConnection(jdbcUrl, "root", "root");
			
			System.out.println("connection established");
			
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("select d.dname,avg(sal) from emptemp e,dept d where (e.deptno=d.deptno) group by d.dname order by avg(sal) desc");
			
			
			while(rs.next()) {
				
				System.out.println("Dept name" +":"+rs.getString(1));
			
				System.out.println("Avg sal" +":"+rs.getInt(2));
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
