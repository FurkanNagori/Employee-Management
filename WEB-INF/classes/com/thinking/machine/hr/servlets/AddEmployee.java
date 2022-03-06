package com.thinking.machine.hr.servlets;
import com.thinking.machine.hr.dl.*;
import com.thinking.machine.hr.beans.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.text.*;
import java.util.*;
import java.math.*;
public class AddEmployee extends HttpServlet
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
			DesignationDAO designationDAO = new DesignationDAO();
			if(designationDAO.designationCodeExist(designationCode)==false || employeeDAO.panNumberExist(panNumber) || employeeDAO.aadharCardNumberExist(aadharCardNumber))
			{                 
				throw new DAOException("pan or adhar exist");
			}//System.out.println(title);
			EmployeeDTO employeeDTO = new EmployeeDTO();
			employeeDTO.setName(name);
			employeeDTO.setDesignationCode(designationCode);
			employeeDTO.setDateOfBirth(dateOfBirth);
			employeeDTO.setGender(gender);
			employeeDTO.setIsIndian(isIndian);
			employeeDTO.setBasicSalary(basicSalary);
			employeeDTO.setPanNumber(panNumber);
			employeeDTO.setAadharCardNumber(aadharCardNumber);
				employeeDAO.add(employeeDTO);
				MessageBean messageBean = new MessageBean();
				messageBean.setHeading("Employee (Add Module)");
				messageBean.setMessage("Employee Added , Add more ?");
				messageBean.setGenerateButtons(true);
				messageBean.setGenerateTwoButtons(true);
				messageBean.setButtonOneText("Yes");
				messageBean.setButtonTwoText("No");
				messageBean.setButtonOneAction("EmployeeAddForm.jsp");
				messageBean.setButtonTwoAction("Employees.jsp");
				request.setAttribute("messageBean",messageBean);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Notification.jsp");
				requestDispatcher.forward(request,response);
				
			}catch(DAOException daoException)
			{
				System.out.println(daoException.getMessage());
				ErrorBean errorBean = new ErrorBean();
				errorBean.setError(daoException.getMessage());
				request.setAttribute("errorBean",errorBean);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/EmployeeAddForm.jsp");
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