package com.lyb.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleTest {

	
	public Connection getConn(){
		
		Connection conn = null;
		String url = "jdbc:oracle:thin:@192.168.44.161:1521:tsdboss";
		String username = "tsd";
		String password = "tsd2010psw";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public void getUsers(){
		String sql = "select userid,username,password from sys_user";
		Connection conn = getConn();
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			statement = conn.createStatement();
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()){
				System.out.println("userid = "+resultSet.getString(1));
				System.out.println("username = "+resultSet.getString(2));
				System.out.println("password = "+resultSet.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				statement.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public void updateUsers(){
		String sql = "update sys_user set username='12345'";
		Statement statement = null;
		Connection conn = getConn();
		try {
			statement = conn.createStatement();
			int a = statement.executeUpdate(sql);
			System.out.println("a = "+a);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void updateUsersPrepare(){
		String sql = "update sys_user set username=? where userid=?";
		PreparedStatement statement = null;
		Connection conn = getConn();
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, "123456");
			statement.setString(2, "123");
			statement.addBatch();
			if(statement.executeUpdate()>0){
				System.out.println("执行成功！");
			}
			statement.executeBatch();
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		OracleTest oracleTest = new OracleTest();
		//oracleTest.getUsers();
		oracleTest.updateUsersPrepare();
	}

}
