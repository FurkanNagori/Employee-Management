package com.thinking.machine.hr.servlets;
import com.thinking.machine.hr.beans.*;
import com.thinking.machine.hr.dl.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.text.*;
import java.math.*;
public class ConfirmDeleteEmployee extends HttpServlet
{
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	{
		doGet(request,response);
	}
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
			String employeeId = request.getParameter("employeeId");
			try
			{
			EmployeeDAO employeeDAO = new EmployeeDAO();
			EmployeeDTO employeeDTO  = employeeDAO.getByEmployeeId(employeeId);
			
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
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			employeeBean.setDateOfBirth(sdf.format(dateOfBirth));
            employeeBean.setIsIndian(isIndian);
            employeeBean.setBasicSalary(basicSalary.toPlainString());
            employeeBean.setPanNumber(panNumber);
            employeeBean.setAadharCardNumber(aadharCardNumber);
			request.setAttribute("employeeBean",employeeBean);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ConfirmDeleteEmployee.jsp");
			try
			{
			requestDispatcher.forward(request,response);
			}catch(Exception e){}
			System.out.println(employeeBean.getPanNumber());			
			
			}catch(DAOException daoException)
			{
				System.out.println(daoException.getMessage());
			
			}
			
		}catch(Exception exception)
		{
				System.out.println("ye h "+exception.getMessage());
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ErrorPage.jsp");
            try{
			requestDispatcher.forward(request,response);
			}catch(Exception e){}
		}
	}
}