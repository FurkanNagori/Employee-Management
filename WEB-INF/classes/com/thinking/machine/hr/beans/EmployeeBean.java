package com.thinking.machine.hr.beans;
import java.math.*;
import java.util.*;

public class EmployeeBean implements java.io.Serializable,Comparable<EmployeeBean>
{
	private String employeeId;
	private String name;
	private int designationCode;
	private String title;
	private String dateOfBirth;
	private String gender;
	private boolean isIndian;
	private String basicSalary;
	private String panNumber;
	private String aadharCardNumber;
	
	public EmployeeBean()
	{
	 this.employeeId="";
	 this.name="";
	 this.designationCode=0;
	 this.title="";
	 this.dateOfBirth="";
	 this.gender="";
	 this.isIndian=false;
	 this.basicSalary="";
	 this.panNumber="";
	 this.aadharCardNumber="";
	}
	
	public void setEmployeeId(String employeeId)
	{
		this.employeeId=employeeId;
	}
	public String getEmployeeId()
	{
		return this.employeeId;
	}
	
	public void setName(String name)
	{
		this.name=name;
	}
	public String getName()
	{
		return this.name;
	}
	
	public void setDesignationCode(int designationCode)
	{
		this.designationCode=designationCode;
	}
	public int getDesignationCode()
	{
		return this.designationCode;
	}
	
	public void setTitle(String title)
	{
		this.title=title;
	}
	public String getTitle()
	{
		return this.title;
	}
	
	public void setDateOfBirth(String dateOfBirth)
	{
		this.dateOfBirth=dateOfBirth;
	}
	public String getDateOfBirth()
	{
		return this.dateOfBirth;
	}
	
	public void setGender(String gender)
	{
		this.gender=gender;
	}
	public String getGender()
	{
		return this.gender;
	}
	public boolean isMale()
	{
		return gender.equals("M");
	}
	public boolean isFemale()
	{
		return gender.equals("F");
	}
	
	public void setIsIndian(boolean isIndian)
	{
		this.isIndian=isIndian;
	}
	public boolean getIsIndian()
	{
		return this.isIndian;
	}
    
	public void setBasicSalary(String basicSalary)
	{
		this.basicSalary=basicSalary;
	}
	public String getBasicSalary()
	{
		return this.basicSalary;
	}
	
	public void setPanNumber(String panNumber)
	{
		this.panNumber=panNumber;
	}
	public String getPanNumber()
	{
		return this.panNumber;
	}
	
	public void setAadharCardNumber(String aadharCardNumber)
	{
		this.aadharCardNumber=aadharCardNumber;
	}
	public String getAadharCardNumber()
	{
		return this.aadharCardNumber;
	}
	
	public boolean equals(Object object)
	{
		if(!(object instanceof EmployeeBean)) return false;
		EmployeeBean employee = (EmployeeBean)object;
		return this.employeeId.equalsIgnoreCase(employee.employeeId);
	}
	public int compareTo(EmployeeBean other)
	{
		return this.employeeId.compareTo(other.employeeId);
	}
	public int hashCode()
	{
		return employeeId.hashCode();
	}
	
}