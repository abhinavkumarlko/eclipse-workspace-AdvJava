package controllers;

import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Comment;



@WebServlet("/getComments")
public class GetCommentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	Connection con;
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		con = (Connection)config.getServletContext().getAttribute("jdbccon");
		System.out.println("Get con obj");
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int tid=Integer.parseInt(request.getParameter("tid"));
		
		PreparedStatement ps=null;
		
		ResultSet rs = null;
		try
		{
			
			ps = con.prepareStatement("select * from comments where topicid=?");
			
			ps.setInt(1, tid);
			rs = ps.executeQuery();
			
			List<Comment> comments = new ArrayList<>();
			while(rs.next())
			{
				
				Comment cm = new Comment(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4));
				comments.add(cm);
			}
			getServletContext().setAttribute("comments", comments);
			
			RequestDispatcher rd = request.getRequestDispatcher("/comments.jsp");
			rd.forward(request, response);
		}
		catch(Exception e)
		{
			e.printStackTrace();
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

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
