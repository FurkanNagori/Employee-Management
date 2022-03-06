package com.thinking.machine.hr.dl;
import java.util.*;
import java.sql.*;

public class EmployeeDAO
{
	public List<EmployeeDTO> getAll() throws DAOException
	{
		List<EmployeeDTO> employees = new LinkedList<>();
		
		try
		{
			Connection connection = DAOConnection.getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("Select employee.id,employee.name,employee.designation_code,designation.title,employee.date_of_birth,employee.gender,employee.is_indian,employee.basic_salary,employee.pan_number,employee.aadhar_card_number from employee inner join designation on employee.designation_code=designation.code order by employee.name");
			EmployeeDTO employeeDTO;
			while(resultSet.next())
			{
				employeeDTO = new EmployeeDTO();
				employeeDTO.setEmployeeId("A"+resultSet.getString("id"));
				employeeDTO.setName(resultSet.getString("name").trim());
				employeeDTO.setDesignationCode(resultSet.getInt("designation_code"));
				employeeDTO.setTitle(resultSet.getString("title").trim());
				employeeDTO.setDateOfBirth(resultSet.getDate("date_of_birth"));
				employeeDTO.setGender(resultSet.getString("gender"));
				employeeDTO.setIsIndian(resultSet.getBoolean("is_indian"));
				employeeDTO.setBasicSalary(resultSet.getBigDecimal("basic_salary"));
				employeeDTO.setPanNumber(resultSet.getString("pan_number").trim());
				employeeDTO.setAadharCardNumber(resultSet.getString("aadhar_card_number").trim());
				employees.add(employeeDTO);
			}
			connection.close();
			statement.close();
			resultSet.close();
			return employees;
			
		}catch(Exception exception)
		{
			throw new DAOException(exception.getMessage());
		}
	}
	
	public EmployeeDTO getByEmployeeId(String employeeId) throws DAOException
	{
		EmployeeDTO employeeDTO=null;
		int actualEmployeeId=0;
		try
		{
		
		actualEmployeeId = Integer.parseInt(employeeId.substring(1));
			
			Connection connection = DAOConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("select * from employee where id=?");
			preparedStatement.setInt(1,actualEmployeeId);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()==false)
			{
				connection.close();
				preparedStatement.close();
				resultSet.close();
				throw new DAOException("Invalid Employee id : "+employeeId);
			}
			employeeDTO = new EmployeeDTO();
			
	            employeeDTO.setEmployeeId("A"+resultSet.getString("id"));
				employeeDTO.setName(resultSet.getString("name").trim());
				employeeDTO.setDesignationCode(resultSet.getInt("designation_code"));
				//employeeDTO.setTitle(resultSet.getString("title").trim());
				employeeDTO.setDateOfBirth(resultSet.getDate("date_of_birth"));
				employeeDTO.setGender(resultSet.getString("gender"));
				employeeDTO.setIsIndian(resultSet.getBoolean("is_indian"));
				employeeDTO.setBasicSalary(resultSet.getBigDecimal("basic_salary"));
				employeeDTO.setPanNumber(resultSet.getString("pan_number").trim());
				employeeDTO.setAadharCardNumber(resultSet.getString("aadhar_card_number").trim());
				
        	connection.close();
			resultSet.close();
			preparedStatement.close();
			
		}catch(Exception exception)
		{
			throw new DAOException(exception.getMessage());
		}
			return employeeDTO;
	}
	
	
	public boolean EmployeeIdExist(String employeeId) throws DAOException
	{
        boolean exist=false;
		int actualEmployeeId=0;
		try
		{
		
		actualEmployeeId = Integer.parseInt(employeeId.substring(1));
			
			Connection connection = DAOConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("select gender from employee where id=?");
			preparedStatement.setInt(1,actualEmployeeId);
			ResultSet resultSet = preparedStatement.executeQuery();
			exist = resultSet.next();
			connection.close();
			resultSet.close();
			preparedStatement.close();
			return exist; 
		}catch(Exception exception)
		{
			return false;
		}
			
	}
	
	public void add(EmployeeDTO employeeDTO) throws DAOException
	{
		try
		{
			
			Connection connection = DAOConnection.getConnection();
			PreparedStatement preparedStatement;
			preparedStatement = connection.prepareStatement("Select id from employee where pan_number=?");
			preparedStatement.setString(1,employeeDTO.getPanNumber());
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next())
			{
				resultSet.close();
				preparedStatement.close();
				throw new DAOException("pan number "+employeeDTO.getPanNumber()+" Exists.");
			}
			resultSet.close();
			
			preparedStatement = connection.prepareStatement("Select id from employee where aadhar_card_number=?");
			preparedStatement.setString(1,employeeDTO.getAadharCardNumber());
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next())
			{
				resultSet.close();
				preparedStatement.close();
				throw new DAOException("Aadhar card number "+employeeDTO.getAadharCardNumber()+" Exists.");
			}
			resultSet.close();

			preparedStatement = connection.prepareStatement("insert into employee (name,designation_code,date_of_birth,gender,is_indian,basic_salary,pan_number,aadhar_card_number) values (?,?,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1,employeeDTO.getName());
			preparedStatement.setInt(2,employeeDTO.getDesignationCode());
			
			java.sql.Date dateOfBirth = new java.sql.Date(employeeDTO.getDateOfBirth().getYear(),employeeDTO.getDateOfBirth().getMonth(),employeeDTO.getDateOfBirth().getDate());
			preparedStatement.setDate(3,dateOfBirth);
			preparedStatement.setString(4,employeeDTO.getGender());
			preparedStatement.setBoolean( 5,employeeDTO.getIsIndian());
			preparedStatement.setBigDecimal(6,employeeDTO.getBasicSalary());
			preparedStatement.setString(7,employeeDTO.getPanNumber());
			preparedStatement.setString(8,employeeDTO.getAadharCardNumber());
			preparedStatement.executeUpdate();
			resultSet = preparedStatement.getGeneratedKeys();
			resultSet.next();
			int id = resultSet.getInt(1);
			resultSet.close();
			preparedStatement.close();
			connection.close();
			employeeDTO.setEmployeeId("A"+id);
			
		}catch(SQLException sqlException)
		{
			throw new DAOException(sqlException.getMessage());
		}
		
	}

	public void update(EmployeeDTO employeeDTO) throws DAOException
	{
		String employeeId = employeeDTO.getEmployeeId();
		int actualEmployeeId=0;
		try
		{
		try
		{
			
		     actualEmployeeId = Integer.parseInt(employeeId.substring(1));
		}
		catch(Exception exception)
		{
			throw new DAOException("Invalid employee id : "+employeeId);
		}
		Connection connection = DAOConnection.getConnection();
		PreparedStatement preparedStatement;
		preparedStatement = connection.prepareStatement("select gender from employee where id=?");
		preparedStatement.setInt(1,actualEmployeeId);
		ResultSet resultSet = preparedStatement.executeQuery();
		if(resultSet.next()==false)
		{
			    connection.close();
				preparedStatement.close();
				resultSet.close();
				throw new DAOException("Invalid Employee id : "+employeeId);
		}
		resultSet.close();
		preparedStatement.close();
		
			
			preparedStatement = connection.prepareStatement("Select id from employee where pan_number=? and id!=?");
			preparedStatement.setString(1,employeeDTO.getPanNumber());
			preparedStatement.setInt(2,actualEmployeeId);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next())
			{
				resultSet.close();
				preparedStatement.close();
				throw new DAOException("pan number "+employeeDTO.getPanNumber()+" Exists.");
			}
			resultSet.close();
			preparedStatement.close();
			
			preparedStatement = connection.prepareStatement("Select id from employee where aadhar_card_number=? and id!=?");
			preparedStatement.setString(1,employeeDTO.getAadharCardNumber());
			preparedStatement.setInt(2,actualEmployeeId);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next())
			{
				resultSet.close();
				preparedStatement.close();
				throw new DAOException("Aadhar card number "+employeeDTO.getAadharCardNumber()+" Exists.");
			}
			resultSet.close();
            preparedStatement.close();
			preparedStatement = connection.prepareStatement("update employee set name=?,designation_code=?,date_of_birth=?,gender=?,is_indian=?,basic_salary=?,pan_number=?,aadhar_card_number=? where id=?");
			preparedStatement.setString(1,employeeDTO.getName());
			preparedStatement.setInt(2,employeeDTO.getDesignationCode());
			
			java.sql.Date dateOfBirth = new java.sql.Date(employeeDTO.getDateOfBirth().getYear(),employeeDTO.getDateOfBirth().getMonth(),employeeDTO.getDateOfBirth().getDate());
			preparedStatement.setDate(3,dateOfBirth);
			preparedStatement.setString(4,employeeDTO.getGender());
			preparedStatement.setBoolean(5,employeeDTO.getIsIndian());
			preparedStatement.setBigDecimal(6,employeeDTO.getBasicSalary());
			preparedStatement.setString(7,employeeDTO.getPanNumber());
			preparedStatement.setString(8,employeeDTO.getAadharCardNumber());
			preparedStatement.setInt(9,actualEmployeeId);
			preparedStatement.executeUpdate();
			
			resultSet.close();
			preparedStatement.close();
			connection.close();
			
			
		}catch(SQLException sqlException)
		{
			throw new DAOException(sqlException.getMessage());
		}
		
	}


	
	public boolean panNumberExist(String panNumber) throws DAOException
	{
		try
		{
	    boolean exist=false;	
		Connection connection = DAOConnection.getConnection();
		PreparedStatement preparedStatement;
		preparedStatement = connection.prepareStatement("select id from employee where pan_number=?");
		preparedStatement.setString(1,panNumber);
		ResultSet resultSet = preparedStatement.executeQuery();
		exist = resultSet.next();
		
			connection.close();
			preparedStatement.close();
			resultSet.close();
	    return exist; 
		
		}catch(Exception exception)
		{
			throw new DAOException(exception.getMessage());
		}
	}
	public boolean aadharCardNumberExist(String aadharCardNumber) throws DAOException
	{
		try
		{
	    boolean exist=false;	
		Connection connection = DAOConnection.getConnection();
		PreparedStatement preparedStatement;
		preparedStatement = connection.prepareStatement("select id from employee where aadhar_card_number=?");
		preparedStatement.setString(1,aadharCardNumber);
		ResultSet resultSet = preparedStatement.executeQuery();
		exist = resultSet.next();
		
			connection.close();
			preparedStatement.close();
			resultSet.close();
	    return exist; 
		
		}catch(Exception exception)
		{
			throw new DAOException(exception.getMessage());
		}
	}
	
	public EmployeeDTO getByPanNumber(String panNumber) throws DAOException
	{
		EmployeeDTO employeeDTO=null;
		
		try
		{
					
			Connection connection = DAOConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("select * from employee where pan_number=?");
			preparedStatement.setString(1,panNumber);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()==false)
			{
				connection.close();
				preparedStatement.close();
				resultSet.close();
				throw new DAOException("Invalid pan number : "+panNumber);
			}
			employeeDTO = new EmployeeDTO();
			
	            employeeDTO.setEmployeeId("A"+resultSet.getString("id"));
				employeeDTO.setName(resultSet.getString("name").trim());
				employeeDTO.setDesignationCode(resultSet.getInt("designation_code"));
				//employeeDTO.setTitle(resultSet.getString("title").trim());
				employeeDTO.setDateOfBirth(resultSet.getDate("date_of_birth"));
				employeeDTO.setGender(resultSet.getString("gender"));
				employeeDTO.setIsIndian(resultSet.getBoolean("is_indian"));
				employeeDTO.setBasicSalary(resultSet.getBigDecimal("basic_salary"));
				employeeDTO.setPanNumber(resultSet.getString("pan_number").trim());
				employeeDTO.setAadharCardNumber(resultSet.getString("aadhar_card_number").trim());
				
        	connection.close();
			resultSet.close();
			preparedStatement.close();
			
		}catch(Exception exception)
		{
			throw new DAOException(exception.getMessage());
		}
			return employeeDTO;
	}
	
	public EmployeeDTO getByAadharCardNumber(String aadharCardNumber) throws DAOException
	{
		EmployeeDTO employeeDTO=null;
		
		try
		{
					
			Connection connection = DAOConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("select * from employee where aadhar_card_number=?");
			preparedStatement.setString(1,aadharCardNumber);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()==false)
			{
				connection.close();
				preparedStatement.close();
				resultSet.close();
				throw new DAOException("Invalid aadhar card number : "+aadharCardNumber);
			}
			employeeDTO = new EmployeeDTO();
			
	            employeeDTO.setEmployeeId("A"+resultSet.getString("id"));
				employeeDTO.setName(resultSet.getString("name").trim());
				employeeDTO.setDesignationCode(resultSet.getInt("designation_code"));
				//employeeDTO.setTitle(resultSet.getString("title").trim());
				employeeDTO.setDateOfBirth(resultSet.getDate("date_of_birth"));
				employeeDTO.setGender(resultSet.getString("gender"));
				employeeDTO.setIsIndian(resultSet.getBoolean("is_indian"));
				employeeDTO.setBasicSalary(resultSet.getBigDecimal("basic_salary"));
				employeeDTO.setPanNumber(resultSet.getString("pan_number").trim());
				employeeDTO.setAadharCardNumber(resultSet.getString("aadhar_card_number").trim());
				
        	connection.close();
			resultSet.close();
			preparedStatement.close();
			
		}catch(Exception exception)
		{
			throw new DAOException(exception.getMessage());
		}
			return employeeDTO;
	}
	
	public void deleteByEmployeeId(String employeeId) throws DAOException
	{
		int actualEmployeeId=0;
		try
		{
			
		     actualEmployeeId = Integer.parseInt(employeeId.substring(1));
		}
		catch(Exception exception)
		{
			throw new DAOException("Invalid employee id : "+employeeId);
		}
		try
		{
		Connection connection = DAOConnection.getConnection();
		PreparedStatement preparedStatement;
		preparedStatement = connection.prepareStatement("select gender from employee where id=?");
		preparedStatement.setInt(1,actualEmployeeId);
		ResultSet resultSet = preparedStatement.executeQuery();
		if(resultSet.next()==false)
		{
			    connection.close();
				preparedStatement.close();
				resultSet.close();
				throw new DAOException("Invalid Employee id : "+employeeId);
		}
		preparedStatement.close();
		resultSet.close();
		
		preparedStatement = connection.prepareStatement("delete from employee where id=?");
		preparedStatement.setInt(1,actualEmployeeId);
		preparedStatement.executeUpdate();
			    connection.close();
				preparedStatement.close();
				
		
		
		
		}catch(Exception exception)
		{
			throw new DAOException("Invalid employee id "+employeeId);
		}
	}
	
}