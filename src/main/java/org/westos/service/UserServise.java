package org.westos.service;

import java.sql.SQLException;

import org.westos.dao.Userdao;

public class UserServise {

	public boolean loginUser(String username,String password) throws SQLException {
		Userdao userdao = new Userdao() ;
		boolean b = userdao.loginUser(username,password) ;
		return b;
	}

	public boolean findUserName(String username) throws SQLException {
		Userdao userdao = new Userdao() ;
		boolean b = userdao.findUserName(username) ;
		return b;
	}

	public static boolean loginUserName(String username, String password) throws SQLException {
		boolean b = Userdao.registUser(username,password) ;
		return b;
	}
       
}
