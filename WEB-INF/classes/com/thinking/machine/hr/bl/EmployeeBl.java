package com.thinking.machine.hr.bl;
import com.thinking.machine.hr.dl.*;
import com.thinking.machine.hr.beans.*;
import java.util.*;
import java.text.*;
public class EmployeeBl
{
	public List<EmployeeBean> getAll()
	{
		List<EmployeeBean> employees = new LinkedList<>();
		try
		{
			EmployeeDAO employeeDAO = new EmployeeDAO();
			List<EmployeeDTO> dlEmployees = employeeDAO.getAll();
			EmployeeBean employeeBean;
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			for(EmployeeDTO employeeDTO:dlEmployees)
			{
				employeeBean = new EmployeeBean();
				employeeBean.setEmployeeId(employeeDTO.getEmployeeId());
				employeeBean.setName(employeeDTO.getName());
				employeeBean.setDesignationCode(employeeDTO.getDesignationCode());
				employeeBean.setTitle(employeeDTO.getTitle());
				employeeBean.setDateOfBirth(sdf.format(employeeDTO.getDateOfBirth()));
				employeeBean.setGender(employeeDTO.getGender());
				employeeBean.setIsIndian(employeeDTO.getIsIndian());
				employeeBean.setBasicSalary(employeeDTO.getBasicSalary().toPlainString());
				employeeBean.setPanNumber(employeeDTO.getPanNumber());
				employeeBean.setAadharCardNumber(employeeDTO.getAadharCardNumber());
				employees.add(employeeBean);
			}
		}catch(DAOException daoException)
		{
			System.out.println(daoException.getMessage());
		}
			return employees; 
	}
}