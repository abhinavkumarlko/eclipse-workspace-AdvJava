package assignment1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	  Connection con;
      public void init(ServletConfig config) throws ServletException{
   	   super.init(config);
   	   try {
  			Class.forName("com.mysql.cj.jdbc.Driver");
  			
  			String jdbcUrl = "jdbc:mysql://localhost:3306/shoppingdb";
  			
  			 con = DriverManager.getConnection(jdbcUrl, "root", "root");
  			
  			System.out.println("connection established");
  		}
   	   catch(Exception e) {
   		   e.printStackTrace();
   	   }
      }
    
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	PrintWriter out = response.getWriter();
		
		String uid = request.getParameter("uid");
		String pwd = request.getParameter("pwd");
		String fname = request.getParameter("fname");
		String mname = request.getParameter("mname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String cnumber = request.getParameter("cnumber");
		
		
		PreparedStatement ps=null;
		
		try {
			ps=con.prepareStatement("insert into users values(?,?,?,?,?,?,?) ");
			
			ps.setString(1,uid);
			ps.setString(2, pwd);
			ps.setString(3, fname);
			ps.setString(4, mname);
			ps.setString(5, lname);
			ps.setString(6, email);
			ps.setString(7, cnumber);
			int n=ps.executeUpdate();
			
			if(n>0) {
				out.print("<h3>Inserted Succesfully<h3/>");
				
			}else
				out.print("<h3>Failed Insertion<h3/>");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try {
				
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
