package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/home")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  Connection con;
	public void init(ServletConfig config) throws ServletException {
		con = (Connection)config.getServletContext().getAttribute("jdbccon");
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out =response.getWriter();
		
		Statement st = null;
		ResultSet rs = null;
		try
		{
			st = con.createStatement();
			rs = st.executeQuery("select * from dept");
			while(rs.next())
			{
				out.println("<a href='getEmps?DEPTNO="+ rs.getInt(1) +"'> "+ rs.getString(2)+" </a> <br/>");
			}
		}
		catch(Exception e)
		{
			
		}
		finally
		{
			try
			{
				rs.close();
				st.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}

}
