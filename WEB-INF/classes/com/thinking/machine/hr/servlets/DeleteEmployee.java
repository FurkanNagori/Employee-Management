package com.thinking.machine.hr.servlets;
import com.thinking.machine.hr.dl.*;
import com.thinking.machine.hr.beans.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.text.*;
import java.util.*;
import java.math.*;
public class DeleteEmployee extends HttpServlet
{
	public void doPost(HttpServletRequest request , HttpServletResponse response)
	{
		try
		{
		HttpSession httpSession = request.getSession();
		String username=(String)httpSession.getAttribute("username");
        if(username==null)
		{
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/loginPage.jsp");
        requestDispatcher.forward(request,response);
		}
			EmployeeBean employeeBean = (EmployeeBean)request.getAttribute("employeeBean");
			String employeeId = employeeBean.getEmployeeId();
				System.out.println(employeeId);
			try
			{
			EmployeeDAO employeeDAO = new EmployeeDAO();
			//System.out.println(title);
				employeeDAO.deleteByEmployeeId(employeeId);
				MessageBean messageBean = new MessageBean();
				messageBean.setHeading("Employee (Delete Module)");
				messageBean.setMessage("Employee Deleted !");
				messageBean.setGenerateButtons(true);
				//messageBean.setGenerateTwoButtons(true);
				messageBean.setButtonOneText("Ok");
				//messageBean.setButtonTwoText("No");
				messageBean.setButtonOneAction("Employees.jsp");
				//messageBean.setButtonTwoAction("Employees.jsp");
				request.setAttribute("messageBean",messageBean);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Notification.jsp");
				requestDispatcher.forward(request,response);
				
			}catch(DAOException daoException)
			{
				System.out.println(daoException.getMessage());
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Employees.jsp");
				requestDispatcher.forward(request,response);
			}
			
			
		}catch(Exception exception)
		{
			System.out.println(exception.getMessage());
		    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ErrorPage.jsp");
		try{
				requestDispatcher.forward(request,response);
		   }catch(Exception e)	
		   {
			   
		   }
		}
		
		
	}
	
}