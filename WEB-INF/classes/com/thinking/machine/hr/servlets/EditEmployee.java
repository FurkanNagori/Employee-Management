package com.thinking.machine.hr.servlets;
import com.thinking.machine.hr.dl.*;
import java.util.*;
import java.math.*;
import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.text.*;
import com.thinking.machine.hr.beans.*;
public class EditEmployee extends HttpServlet
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)
	{
		
		
		try
		{
			String employeeId = request.getParameter("employeeId");
			EmployeeDAO employeeDAO = new EmployeeDAO();
			EmployeeDTO employeeDTO;
			employeeDTO = employeeDAO.getByEmployeeId(employeeId);
    		
			String name = employeeDTO.getName();
			int designationCode = employeeDTO.getDesignationCode();
			DesignationDTO designationDTO= new DesignationDAO().getByCode(designationCode);
			String title = designationDTO.getTitle();
			String gender = employeeDTO.getGender();
			java.util.Date dateOfBirth = employeeDTO.getDateOfBirth();
			boolean isIndian = employeeDTO.getIsIndian();
			BigDecimal basicSalary = employeeDTO.getBasicSalary();
			String panNumber = employeeDTO.getPanNumber();
			String aadharCardNumber = employeeDTO.getAadharCardNumber();
           
		    EmployeeBean employeeBean = new EmployeeBean();
			employeeBean.setEmployeeId(employeeId);
			employeeBean.setName(name);
			employeeBean.setDesignationCode(designationCode);
			employeeBean.setTitle(title);
			employeeBean.setGender(gender);
			SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
			employeeBean.setDateOfBirth(sdf.format(dateOfBirth));
            employeeBean.setIsIndian(isIndian);
            employeeBean.setBasicSalary(basicSalary.toPlainString());
            employeeBean.setPanNumber(panNumber);
            employeeBean.setAadharCardNumber(aadharCardNumber);			
			request.setAttribute("employeeBean",employeeBean);
	    	RequestDispatcher requestDispatcher = request.getRequestDispatcher("/EditEmployee.jsp");
			requestDispatcher.forward(request,response);
			
		  
		}catch(DAOException daoException)
		{
		        System.out.println(daoException.getMessage());
				ErrorBean errorBean = new ErrorBean();
				errorBean.setError(daoException.getMessage());
				request.setAttribute("errorBean",errorBean);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/EmployeeAddForm.jsp");
			try
		   {
			requestDispatcher.forward(request,response);
		   }catch(Exception e)	
		   {
			   
		   }
		}
        catch(Exception exception)
		{
			System.out.println(exception.getMessage());
		    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ErrorPage.jsp");
		   try
		   {
			requestDispatcher.forward(request,response);
		   }catch(Exception e)	
		   {
			   
		   }
		}
		
		
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response)
	{
		doGet(request,response);
	}
}
