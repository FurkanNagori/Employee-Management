package com.thinking.machine.hr.dl;
public class AdminDTO implements java.io.Serializable,Comparable<AdminDTO>
{
	private String username;
	private String password;
	public AdminDTO()
	{
		this.username="";
		this.password="";
	}
	public void setUsername(String username)
	{
		this.username=username;
	}
	public String getUsername()
	{
		return this.username;
	}
	
	public void setPassword(String password)
	{
		this.password=password;
	}
	public String getPassword()
	{
		return this.password;
	}
	public boolean equals(Object object)
	{
		if(!(object instanceof AdminDTO)) return false;
		AdminDTO other = (AdminDTO)object;
		return this.username.equals(other.username);
	}
	public int compareTo(AdminDTO other)
	{
		return this.username.compareToIgnoreCase(other.username);
	}
	public int hashCode()
	{
		return username.hashCode();
	}
	
	
}