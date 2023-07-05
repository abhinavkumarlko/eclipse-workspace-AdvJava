package assignment1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/logincheck")
public class LoginServlet extends HttpServlet {
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
    
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		
		String uid = request.getParameter("uid");
		String pwd = request.getParameter("pwd");
		
		/*if(uid.equals("object") && pwd.equals("knowit"))
			out.print("<h3>Welcome "+ uid +"<h3/>");
			else
				out.print("<h2>Login Failed</h2>");
				*/
		PreparedStatement ps=null;
		ResultSet rs= null;
		try {
			ps=con.prepareStatement("select * from users where u_id=? and password=? ");
			
			ps.setString(1,uid);
			ps.setString(2, pwd);
			rs=ps.executeQuery();
			
			if(rs.next()) {
				//while(rs.next())
				if(rs.getString(1).equals(uid)&&rs.getString(2).equals(pwd)) {
					//out.print("<h3>Success Login<h3/>");
					
					//modify to request success servlet
					RequestDispatcher rd = request.getRequestDispatcher("/success");
					rd.forward(request, response);

				}
				
			}else
			{
				//out.print("<h3>Failed login<h3/>");
				RequestDispatcher rd = request.getRequestDispatcher("/error");
				rd.forward(request, response);
			}
			
				
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try {
				rs.close();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

}
