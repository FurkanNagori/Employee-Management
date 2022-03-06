package com.thinking.machine.hr.servlets;
import com.thinking.machine.hr.dl.*;
import com.thinking.machine.hr.beans.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Login extends HttpServlet
{
	
	public void doPost(HttpServletRequest request , HttpServletResponse response)
	{
	 try
	 {		 
		HttpSession httpSession = request.getSession();
        
     AdminBean adminBean = (AdminBean)request.getAttribute("adminBean");
	 String username = adminBean.getUsername();
	 String password = adminBean.getPassword();
	 try
	 {
	 AdminDTO adminDTO = (new AdminDAO()).getByUsername(username); 
	 String dbPassword = adminDTO.getPassword();
	 if(dbPassword.equals(password))
	 {
		
		httpSession.setAttribute("username",username);
		RequestDispatcher requestDispatcher;
		requestDispatcher = request.getRequestDispatcher("/index.jsp");
		requestDispatcher.forward(request,response);
	 }
	 else
	 {
		 throw new DAOException("Invalid username/password");
	 }
	}catch(DAOException daoException)
	 {
		System.out.println(daoException.getMessage());
	    ErrorBean errorBean = new ErrorBean();
		errorBean.setError(daoException.getMessage());
	    RequestDispatcher requestDispatcher;
	    requestDispatcher = request.getRequestDispatcher("/loginPage.jsp");
	    request.setAttribute("errorBean",errorBean);
		requestDispatcher.forward(request,response);
	 	 
	 }	 
		 
		 
	 }catch(Exception exception)
	 {
		 System.out.println(exception.getMessage());
	 }
	 

	}
	public void doGet(HttpServletRequest request,HttpServletResponse response)
	{
		doPost(request,response);
	}
}