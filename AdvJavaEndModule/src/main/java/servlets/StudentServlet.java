package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/student")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public StudentServlet() {
        super();
       
    }

	Connection con;
	String grade;
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		con = (Connection)config.getServletContext().getAttribute("jdbccon");
		System.out.println("Get con obj");
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		
		
		String sname = request.getParameter("sname");
		String email = request.getParameter("email");
		String contact = request.getParameter("contact");
		
		Float sem1 = Float.parseFloat( request.getParameter("sem1"));
		Float sem2 = Float.parseFloat( request.getParameter("sem2"));
		Float sem3 = Float.parseFloat( request.getParameter("sem3"));
		Float sem4 = Float.parseFloat( request.getParameter("sem4"));
		
		float avg=(sem1+sem2+sem3+sem4)/4;
		
		if(avg>=90) {
			grade ="Excelent";
		}else
			if(avg>=80 && avg <90) {
				grade="Very Good";
			}else
				if(avg>=70 && avg <80) {
					grade="Good";
				}else
					if(avg>=60 && avg <70) {
						grade="Average";
					}else
						if(avg>=40 && avg <60) {
							grade="Pass";
						}else
							if( avg < 40) {
								grade="Fail";
							}
				
		
		
		PreparedStatement ps=null;
		
		try {
			ps=con.prepareStatement("insert into students(sname,email,contact,average,grade) values(?,?,?,?,?) ");
			
			
			
			ps.setString(1, sname);
			ps.setString(2, email);
			ps.setString(3, contact);
			ps.setFloat(4, avg);
			ps.setString(5, grade);
			
			
			int n=ps.executeUpdate();
			
			if(n>0) {
				
				out.print("<table border=1>");
				out.print("<tr>");

				out.print("<td>"+ sname+ "</td>");
				out.print("<td>"+ email+ "</td>");
				out.print("<td>"+ contact+ "</td>");
				out.print("<td>"+ avg+ "</td>");
				out.print("<td>"+ grade +" </td>");
				
				out.print("</tr>");
				out.print("</table >");
				
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
