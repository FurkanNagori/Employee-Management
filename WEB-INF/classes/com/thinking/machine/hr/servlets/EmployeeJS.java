package com.thinking.machine.hr.servlets;
import java.io.*;
import java.util.*;
import com.thinking.machine.hr.beans.*;
import com.thinking.machine.hr.bl.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class EmployeeJS extends HttpServlet
{
	public void doPost(HttpServletRequest request,HttpServletResponse response)
	{
		doGet(request,response);
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response)
	{
		try
		{
			PrintWriter pw = response.getWriter();
			response.setContentType("text/javascript");
			ServletContext servletContext = getServletContext();
			File file = new File(servletContext.getRealPath("")+File.separator+"WEB-INF"+File.separator+"js"+File.separator+"Employees.js");
			RandomAccessFile randomAccessFile = new RandomAccessFile(file,"r");
			while(randomAccessFile.getFilePointer()<randomAccessFile.length())
			{
				pw.println(randomAccessFile.readLine());
			}
			randomAccessFile.close();
				int index=0;
				List<EmployeeBean> list = new EmployeeBl().getAll();
				pw.println("var employee;");
				for(EmployeeBean employeeBean:list)
				{
				pw.println("employee = new Employee();");
				pw.println("employee.employeeId=\""+employeeBean.getEmployeeId()+"\";");
				pw.println("employee.name=\""+employeeBean.getName()+"\";");
				pw.println("employee.designationCode="+employeeBean.getDesignationCode()+";");
				pw.println("employee.designation=\""+employeeBean.getTitle()+"\";");
				pw.println("employee.dateOfBirth=\""+employeeBean.getDateOfBirth()+"\";");
				pw.println("employee.gender=\""+employeeBean.getGender()+"\";");
				pw.println("employee.isIndian="+employeeBean.getIsIndian()+";");
				pw.println("employee.basicSalary="+employeeBean.getBasicSalary()+";");
				pw.println("employee.panNumber=\""+employeeBean.getPanNumber()+"\";");
				pw.println("employee.aadharCardNumber=\""+employeeBean.getAadharCardNumber()+"\";");
				pw.println("employees["+index+"] = employee;");
				index++;
				}
		}catch(Exception exception)
		{
			RequestDispatcher requestDispatcher;
			requestDispatcher = request.getRequestDispatcher("/Error.jsp");
			try
			{
			requestDispatcher.forward(request,response);
			}catch(Exception e)
			{
				//do nothing
			}
		}
		
	}
}