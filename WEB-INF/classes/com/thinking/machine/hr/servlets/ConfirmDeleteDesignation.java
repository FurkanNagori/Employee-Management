package com.thinking.machine.hr.servlets;
import com.thinking.machine.hr.beans.*;
import com.thinking.machine.hr.dl.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ConfirmDeleteDesignation extends HttpServlet
{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
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
			int code = Integer.parseInt(request.getParameter("code"));
			try
			{
			DesignationDAO designationDAO = new DesignationDAO();
			DesignationDTO designationDTO  = designationDAO.getByCode(code);
			String title = designationDTO.getTitle();
			DesignationBean designationBean = new DesignationBean();
			designationBean.setCode(code);
			designationBean.setTitle(title);
			request.setAttribute("designationBean",designationBean);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ConfirmDeleteDesignation.jsp");
			requestDispatcher.forward(request,response);
			}catch(DAOException daoException)
			{
				//System.out.println(daoException.getMessage());
				ErrorBean errorBean = new ErrorBean();
				errorBean.setError(daoException.getMessage());
				request.setAttribute("errorBean",errorBean);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Designations.jsp");
				requestDispatcher.forward(request,response);
			}
			
		}catch(Exception exception)
		{
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ErrorPage.jsp");
            try{
			requestDispatcher.forward(request,response);
			}catch(Exception e){}
		}
	}
}