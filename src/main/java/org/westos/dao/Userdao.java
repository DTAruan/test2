package org.westos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class Userdao {

	public boolean loginUser(String username,String password) throws SQLException {
		//c3p0连接数据库，插入数据到euser表
		ComboPooledDataSource compol = new ComboPooledDataSource() ;
		Connection conn = compol.getConnection() ;
		String sql = "insert into euser values(?,?)" ;
		PreparedStatement prepareStatement = conn.prepareStatement(sql) ;
		prepareStatement.setString(1, username);
		prepareStatement.setString(2, password);
		int i = prepareStatement.executeUpdate() ;
		return i!=0 ;
	}

	public boolean findUserName(String username) throws SQLException {
		ComboPooledDataSource compol = new ComboPooledDataSource() ;
		Connection conn = compol.getConnection() ;
		String sql = "select * from euser where username = ?" ;
		PreparedStatement prepareStatement = conn.prepareStatement(sql) ;
		prepareStatement.setString(1, username);
		ResultSet resultSet = prepareStatement.executeQuery() ;
		boolean b = false ;
		if(resultSet.next()){
			b = true ;
		}
		return b ;
	}

	public static boolean registUser(String username, String password) throws SQLException {
		ComboPooledDataSource compol = new ComboPooledDataSource() ;
		Connection conn = compol.getConnection() ;
		String sql = "select * from euser where username=? && password =?" ;
		PreparedStatement prepareStatement = conn.prepareStatement(sql) ;
		prepareStatement.setString(1, username);
		prepareStatement.setString(2, password);
		ResultSet resultSet = prepareStatement.executeQuery() ;
		boolean b = resultSet.next() ;
		return b ;
	}

}
