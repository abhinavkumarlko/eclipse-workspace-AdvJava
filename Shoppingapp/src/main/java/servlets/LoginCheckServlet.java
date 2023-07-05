package servlets;

import java.io.IOException;
import java.sql.Connection;
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
public class LoginCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    	Connection con;
	
	public void init(ServletConfig config) throws ServletException {
		con = (Connection)config.getServletContext().getAttribute("jdbccon");
		
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//check login is successful
				String uid = request.getParameter("uid");
				String pwd = request.getParameter("pwd");
				
				//create and execute query
				PreparedStatement ps = null;
				ResultSet rs= null;
				try
				{
					ps = con.prepareStatement("select * from users where u_id=? and password = ?");
					ps.setString(1, uid);
					ps.setString(2, pwd);
					rs = ps.executeQuery();   
					
					//login is successful
					if(rs.next())   // record pointer - first record
					{
						//generate response using home servlet
						RequestDispatcher rd = request.getRequestDispatcher("/home");
						rd.forward(request, response);
					}
					else
					{
						
						response.sendRedirect("/Shoppingapp/login.jsp");
					}
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				finally
				{
					try {
						rs.close();
						ps.close();
					} catch (SQLException e) {
						
						e.printStackTrace();
					}
					
				}
		
	}

}
