package com.thinking.machine.hr.servlets;
import com.thinking.machine.hr.dl.*;
import com.thinking.machine.hr.beans.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.text.*;
import java.util.*;
import java.math.*;
public class UpdateEmployee extends HttpServlet
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
			String name = employeeBean.getName();
			int designationCode = employeeBean.getDesignationCode();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
			Date dateOfBirth = simpleDateFormat.parse(employeeBean.getDateOfBirth());
			String gender = employeeBean.getGender();
			boolean isIndian = employeeBean.getIsIndian();
			if(isIndian!=true) isIndian=false;
			BigDecimal basicSalary = new BigDecimal(employeeBean.getBasicSalary());
			String panNumber = employeeBean.getPanNumber();
			String aadharCardNumber = employeeBean.getAadharCardNumber();
			try
			{
			EmployeeDAO employeeDAO = new EmployeeDAO();
			//System.out.println(title);
			EmployeeDTO employeeDTO = new EmployeeDTO();
			employeeDTO.setEmployeeId(employeeId);
			employeeDTO.setName(name);
			employeeDTO.setDesignationCode(designationCode);
			employeeDTO.setDateOfBirth(dateOfBirth);
			employeeDTO.setGender(gender);
			employeeDTO.setIsIndian(isIndian);
			employeeDTO.setBasicSalary(basicSalary);
			employeeDTO.setPanNumber(panNumber);
			employeeDTO.setAadharCardNumber(aadharCardNumber);
				employeeDAO.update(employeeDTO);
				MessageBean messageBean = new MessageBean();
				messageBean.setHeading("Employee (Edit Module)");
				messageBean.setMessage("Employee Updated !");
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
				ErrorBean errorBean = new ErrorBean();
				errorBean.setError(daoException.getMessage());
				request.setAttribute("errorBean",errorBean);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/EditEmployee.jsp");
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