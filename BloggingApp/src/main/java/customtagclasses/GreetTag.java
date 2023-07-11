package customtagclasses;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class GreetTag extends SimpleTagSupport
{
	//specify all the attributes - properties
	String user; //name of the attribute in the greet tag

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	@Override
	public void doTag() throws JspException, IOException {
		getJspContext().getOut().print("<h1 style='text-shadow:2px 2px 2px grey;color:black'> Welcome "+user+"</h1>");
	}
	
	
	
	
}
