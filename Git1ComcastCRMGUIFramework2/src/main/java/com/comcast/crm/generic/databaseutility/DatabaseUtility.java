package com.comcast.crm.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DatabaseUtility {
	Connection conn;
	public void getDbConnection(String url,String username,String password) throws SQLException
	{
		try {
			Driver driverref=new Driver();
			DriverManager.registerDriver(driverref);
			conn=DriverManager.getConnection(url,username,password);
			}
		catch(Exception e) {}
	}
	public void getDbConnection() throws SQLException
	{
		String URL="jdbc:mysql://localhost:3306/Projects";
		String USERNAME="root";
		String PASSWORD="root";
		try {
			Driver driverref=new Driver();
			DriverManager.registerDriver(driverref);
			conn=DriverManager.getConnection(URL,USERNAME,PASSWORD);
			}
		catch(Exception e) {}
	}
	public void closeDbConnection()
	{
		try {
			conn.close();
			}
		catch(Exception e) {}
	}
	public ResultSet executeSelectQuery(String query) throws SQLException
	{
		ResultSet result=null;
		try {
			Statement stat = conn.createStatement();
			result=stat.executeQuery(query);
			}
		catch(Exception e) {}
		return result;
	}
	public int executeNonselectQuery(String query)
	{
		int result=0;
		try {
			Statement stat = conn.createStatement();
			result=stat.executeUpdate(query);
			}
		catch(Exception e) {}
		return result;
	}
}
