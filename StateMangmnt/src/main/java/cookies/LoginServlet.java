package cookies;

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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/logincheck")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    Connection con;
	
	public void init(ServletConfig config) throws ServletException {
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

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
PrintWriter out = response.getWriter();
		
		String uid = request.getParameter("uid");
		String pwd = request.getParameter("pwd");
		
		
		PreparedStatement ps=null;
		ResultSet rs= null;
		try {
			ps=con.prepareStatement("select * from users where u_id=? and password=? ");
			
			ps.setString(1,uid);
			ps.setString(2, pwd);
			rs=ps.executeQuery();
			
			if(rs.next()) {
				
				//if loginerror cookie is present, modify it's expiration time
				Cookie [] allc = request.getCookies();
				if(allc != null)
				{
					for(Cookie c : allc)
					{
						if(c.getName().equals("loginerror"))
						{
							c.setMaxAge(0);
							response.addCookie(c);
						}							
					}
				}
				
				//generate response using home servlet
				RequestDispatcher rd = request.getRequestDispatcher("/success");
				rd.forward(request, response);
			}
			//failed login
			else
			{
				//create the cookies and add it in the response
				Cookie c = new Cookie("loginerror","Wrong_UID/PWD");
				response.addCookie(c);
				response.sendRedirect("/StateMangmnt/login.jsp");
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
