package com.thinking.machine.hr.servlets;
import com.thinking.machine.hr.dl.*;
import com.thinking.machine.hr.beans.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class NotifyOnResubmit extends HttpServlet
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
				MessageBean messageBean = new MessageBean();
				messageBean.setHeading("Notification");
				messageBean.setMessage("Forms are not to be resubmit");
				messageBean.setGenerateButtons(true);
				//messageBean.setGenerateTwoButtons(true);
				messageBean.setButtonOneText("Ok");
				//messageBean.setButtonTwoText("No");
				messageBean.setButtonOneAction("index.jsp");
				//messageBean.setButtonTwoAction("Designations.jsp");
				request.setAttribute("messageBean",messageBean);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Notification.jsp");
				requestDispatcher.forward(request,response);
							
			
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