package com.thinking.machine.hr.servlets;
import com.thinking.machine.hr.dl.*;
import com.thinking.machine.hr.beans.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class AddDesignation extends HttpServlet
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
			//System.out.println(title);
			DesignationDTO designationDTO = new DesignationDTO();
			designationDTO.setTitle(title);
			DesignationDAO designationDAO = new DesignationDAO();
			try
			{
				designationDAO.add(designationDTO);
				designationBean.setCode(designationDTO.getCode());
				MessageBean messageBean = new MessageBean();
				messageBean.setHeading("Designation (Add Module)");
				messageBean.setMessage("Designation Added , Add more ?");
				messageBean.setGenerateButtons(true);
				messageBean.setGenerateTwoButtons(true);
				messageBean.setButtonOneText("Yes");
				messageBean.setButtonTwoText("No");
				messageBean.setButtonOneAction("DesignationAddForm.jsp");
				messageBean.setButtonTwoAction("Designations.jsp");
				request.setAttribute("messageBean",messageBean);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Notification.jsp");
				requestDispatcher.forward(request,response);
				
			}catch(DAOException daoException)
			{
				System.out.println(daoException.getMessage());
				ErrorBean errorBean = new ErrorBean();
				errorBean.setError(daoException.getMessage());
				request.setAttribute("errorBean",errorBean);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/DesignationAddForm.jsp");
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