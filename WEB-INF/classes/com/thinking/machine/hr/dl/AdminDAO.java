package com.thinking.machine.hr.dl;
import java.io.*;
import java.sql.*;
public class AdminDAO 
{
	public AdminDTO getByUsername(String username) throws DAOException
	{
		try
		{
		Connection connection = DAOConnection.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("select * from administor where username=?");
		preparedStatement.setString(1,username);
		ResultSet resultSet = preparedStatement.executeQuery();
		if(!resultSet.next())
		{
			preparedStatement.close();
			resultSet.close();
		    connection.close();
			throw new DAOException("Invalid username/password");
		}
		AdminDTO adminDTO=new AdminDTO();
		adminDTO.setUsername(resultSet.getString("username").trim());
		adminDTO.setPassword(resultSet.getString("password").trim());
		resultSet.close();
		preparedStatement.close();
		connection.close();
		return adminDTO;
		}catch(SQLException sqlException)
		{
			throw new DAOException(sqlException.getMessage());
		}
	}
}