package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/getEmps")
public class GetEmps extends HttpServlet {
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
		int deptno=Integer.parseInt(request.getParameter("DEPTNO"));
		PreparedStatement ps = null;
		ResultSet rs = null;
		try
		{
			ps=con.prepareStatement("select * from emptemp where DEPTNO=?");
			ps.setInt(1,deptno);
			rs=ps.executeQuery();
			out.println("<table>");
			while(rs.next())
			{
			//	out.println("<tr>"+ +"</tr>");
			}
			out.println("</table>");
		}
		catch(Exception e)
		{
			
		}
		finally
		{
			try
			{
				rs.close();
				ps.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
	}

}
