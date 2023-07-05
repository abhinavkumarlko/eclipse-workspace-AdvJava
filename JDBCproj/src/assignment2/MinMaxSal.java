package assignment2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MinMaxSal {

	public static void main(String[] args) throws Exception  {
		// TODO Auto-generated method stub
		Connection con =null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String jdbcUrl = "jdbc:mysql://localhost:3306/dac";
			
			 con = DriverManager.getConnection(jdbcUrl, "root", "root");
			
			System.out.println("connection established");
			
			PreparedStatement ps = con.prepareStatement("select * from emp where sal BETWEEN ? and ?");
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter min sal : ");
			float minsal = Float.parseFloat(br.readLine());
			System.out.println("Enter max sal : ");
			float maxsal = Float.parseFloat(br.readLine());
			
			ps.setFloat(1, minsal);
			ps.setFloat(2, maxsal);
			ResultSet rs = ps.executeQuery();
			
			
			
			while(rs.next()) {
				System.out.println("Empno" +":"+rs.getInt(1));
				System.out.println("Ename" +":"+rs.getString(2));
				System.out.println("Job" +":"+rs.getString(3));
				System.out.println("Salary" +":"+rs.getFloat(6));
				System.out.println("Deptno" +":"+rs.getInt(8));
				System.out.println();
			}
			
			rs.close();
			ps.close();
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
