package com.thinking.machine.hr.servlets;
import com.thinking.machine.hr.dl.*;
import com.thinking.machine.hr.beans.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Logout extends HttpServlet
{
	
	public void doGet(HttpServletRequest request , HttpServletResponse response)
	{
		doPost(request,response);
    }
	public void doPost(HttpServletRequest request , HttpServletResponse response)
	{
		try
		{
	    
		HttpSession httpSession = request.getSession();
        httpSession.removeAttribute("username");		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/loginPage.jsp");
		requestDispatcher.forward(request,response);
		}catch(Exception exception){}
	}
}