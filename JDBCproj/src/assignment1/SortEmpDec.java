package assignment1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;
import java.util.TreeSet;

import entities.Employee;

public class SortEmpDec {

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
			Set<Employee> emps = new TreeSet<>();
			while(rs.next())
			{
				Employee e = new Employee(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getFloat(6),rs.getInt(8));
				emps.add(e);
			}
			
			rs.close();
			stmt.close();
			con.close();
			for(Employee e : emps)
				System.out.println(e);
			

		
		}
		catch(ClassNotFoundException e) {
			System.out.println("driver class not found");
		}
		catch(SQLException e) {
			System.out.println("connection rejected");
		}
	}

}
