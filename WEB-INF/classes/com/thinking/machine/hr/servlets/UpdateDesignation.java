package com.thinking.machine.hr.servlets;
import com.thinking.machine.hr.dl.*;
import com.thinking.machine.hr.beans.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class UpdateDesignation extends HttpServlet
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
			DesignationBean designationBean = (DesignationBean)request.getAttribute("designationBean");
			String title = designationBean.getTitle();
			int code = designationBean.getCode();
			DesignationDTO designationDTO = new DesignationDTO();
			designationDTO.setTitle(title);
			designationDTO.setCode(code);
				DesignationDAO designationDAO = new DesignationDAO();
			try
			{
				designationDAO.update(designationDTO);
				//designationBean.setCode(designationDTO.getCode());
				MessageBean messageBean = new MessageBean();
				messageBean.setHeading("Designation (Edit Module)");
				messageBean.setMessage("Designation Updated");
				messageBean.setGenerateButtons(true);
				//messageBean.setGenerateTwoButtons(true);
				messageBean.setButtonOneText("Ok");
				//messageBean.setButtonTwoText("No");
				messageBean.setButtonOneAction("Designations.jsp");
				//messageBean.setButtonTwoAction("Designations.jsp");
				request.setAttribute("messageBean",messageBean);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Notification.jsp");
				requestDispatcher.forward(request,response);
				
			}catch(DAOException daoException)
			{
				System.out.println(daoException.getMessage());
				ErrorBean errorBean = new ErrorBean();
				errorBean.setError(daoException.getMessage());
				request.setAttribute("errorBean",errorBean);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Designations.jsp");
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