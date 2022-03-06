package com.thinking.machine.hr.dl;
import java.util.*;
import java.sql.*;

public class DesignationDAO
{
	public List<DesignationDTO> getAll() throws DAOException
	{
		List<DesignationDTO> designations = new LinkedList<>();
		
		try
		{
			Connection connection = DAOConnection.getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("Select *from designation order by title");
			int code;
			String title;
			DesignationDTO designationDTO;
			while(resultSet.next())
			{
				code = resultSet.getInt("code");
				title = resultSet.getString("title");
				designationDTO = new DesignationDTO();
				designationDTO.setCode(code);
				designationDTO.setTitle(title);
				designations.add(designationDTO);
			}
			connection.close();
			statement.close();
			resultSet.close();
			return designations;
			
		}catch(Exception exception)
		{
			throw new DAOException(exception.getMessage());
		}
	}
	
	public void add(DesignationDTO designationDTO) throws DAOException
	{
		try
		{
			
			Connection connection = DAOConnection.getConnection();
			PreparedStatement preparedStatement;
			preparedStatement = connection.prepareStatement("Select * from designation where title=?");
			preparedStatement.setString(1,designationDTO.getTitle());
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next())
			{
				resultSet.close();
				connection.close();
				preparedStatement.close();
				throw new DAOException("Designation "+designationDTO.getTitle()+" Exists.");
			}
			resultSet.close();
			
			connection = DAOConnection.getConnection();
			preparedStatement = connection.prepareStatement("insert into designation (title) values (?)",Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1,designationDTO.getTitle());
			preparedStatement.executeUpdate();
			resultSet = preparedStatement.getGeneratedKeys();
			resultSet.next();
			int code = resultSet.getInt(1);
			resultSet.close();
			preparedStatement.close();
			resultSet.close();
			designationDTO.setCode(code);
			
		}catch(SQLException sqlException)
		{
			throw new DAOException(sqlException.getMessage());
		}
		
	}
	
	public DesignationDTO getByCode(int code) throws DAOException
	{
		try
		{
			
			Connection connection = DAOConnection.getConnection();
			PreparedStatement preparedStatement;
			preparedStatement = connection.prepareStatement("select * from designation where code =?");
			preparedStatement.setInt(1,code);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()==false)
			{
				connection.close();
				preparedStatement.close();
				resultSet.close();
				throw new DAOException("Invalid Designation code : "+code);
			}
			DesignationDTO designationDTO = new DesignationDTO();
			designationDTO.setCode(resultSet.getInt("code"));
			designationDTO.setTitle(resultSet.getString("title").trim());
			resultSet.close();
            preparedStatement.close();
            connection.close();
            return designationDTO;			
			
			
		}catch(Exception exception)
		{
			throw new DAOException(exception.getMessage());
		}
		
	}
	
	
	public void update(DesignationDTO designationDTO) throws DAOException
	{
		try
		{
		int code = designationDTO.getCode();
		String title = designationDTO.getTitle();
		Connection connection = DAOConnection.getConnection();
		PreparedStatement preparedStatement;
		preparedStatement = connection.prepareStatement("select * from designation where code=?");
		preparedStatement.setInt(1,code);
		ResultSet resultSet = preparedStatement.executeQuery();
		if(resultSet.next()==false)
		{
			    connection.close();
				preparedStatement.close();
				resultSet.close();
				throw new DAOException("Invalid Designation code : "+code);
		}
		preparedStatement.close();
		resultSet.close();
		preparedStatement = connection.prepareStatement("select * from designation where title=? and code!=?");
		preparedStatement.setString(1,title);
		preparedStatement.setInt(2,code);
		resultSet = preparedStatement.executeQuery();
		if(resultSet.next())
		{
			    connection.close();
				preparedStatement.close();
				resultSet.close();
				throw new DAOException(title+" exists.");
		}
		resultSet.close();
		preparedStatement = connection.prepareStatement("update designation set title=? where code=?");
		preparedStatement.setString(1,title);
		preparedStatement.setInt(2,code);
		preparedStatement.executeUpdate();
		connection.close();
		preparedStatement.close();
		
		
		
		}catch(Exception exception)
		{
			throw new DAOException(exception.getMessage());
		}
	}
	
	public void deleteByCode(int code) throws DAOException
	{
		try
		{
		
		Connection connection = DAOConnection.getConnection();
		PreparedStatement preparedStatement;
		preparedStatement = connection.prepareStatement("select code from designation where code=?");
		preparedStatement.setInt(1,code);
		ResultSet resultSet = preparedStatement.executeQuery();
		if(resultSet.next()==false)
		{
			    connection.close();
				preparedStatement.close();
				resultSet.close();
				throw new DAOException("Invalid Designation code : "+code);
		}
		preparedStatement.close();
		resultSet.close();
		preparedStatement = connection.prepareStatement("select id from employee where designation_code=?");
		preparedStatement.setInt(1,code);
		resultSet=preparedStatement.executeQuery();
		if(resultSet.next())
		{
			    connection.close();
				preparedStatement.close();
				throw new DAOException("code already alotted to any employee");
		}
		resultSet.close();
		preparedStatement.close();
		preparedStatement = connection.prepareStatement("delete from designation where code=?");
		preparedStatement.setInt(1,code);
		preparedStatement.executeUpdate();
			    connection.close();
				preparedStatement.close();
				
		
		
		
		}catch(Exception exception)
		{
			throw new DAOException(exception.getMessage());
		}
	}
	
	
	public boolean designationCodeExist(int code) throws DAOException
	{
		try
		{
	    boolean exist=false;	
		Connection connection = DAOConnection.getConnection();
		PreparedStatement preparedStatement;
		preparedStatement = connection.prepareStatement("select code from designation where code=?");
		preparedStatement.setInt(1,code);
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
}