package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.User;


@WebServlet(name = "ConfirmCartServlet", urlPatterns = { "/confirmcart" })
public class ConfirmCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
		Connection con;
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		con = (Connection)config.getServletContext().getAttribute("jdbccon");

	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		User u=(User)session.getAttribute("loggedinuser");
		//insert info into database
		
		
		String uid = u.getUid();
		//out.print(uid);
		java.sql.Timestamp ts = new java.sql.Timestamp(new java.util.Date().getTime());
		//out.print(ts);
		float tprice = (Float)session.getAttribute("tprice");
		//out.print(tprice);
		
		//create a query - insert into shopping( , , ) values(?,?,?)
				//query executed
		PreparedStatement ps= null;
		//ResultSet rs= null;
		
		try {
			ps= con.prepareStatement("insert into shopping(user_id,shoppingDate,totalprice) values(?,?,?)");
			
			ps.setString(1, uid);
			ps.setTimestamp(2, ts);
			ps.setFloat(3, tprice);
			
			int n=ps.executeUpdate();
			
			//display the response
			out.print("<p> Order is confirmed </p>");
			out.print("<p> Your bill will be emailed at "+ u.getEmail()+"</p>");
			out.print("<p> You will receive message on"+ u.getContact() +" before order delivery </p>");
			
			out.print("<br/> <br/> <a href='logout'> Logout <a/>");
			//out.print("<br/> <br/> <a href='home'> Want to set new order? <a/>");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally
		{
			try {
				
				ps.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
