package com.login.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dbutil.OracleConnection;
import com.login.dao.loginDao;
import com.login.exception.BusinessException;
import com.login.model.User;

public class LoginDaoImpl implements loginDao {

	@Override
	public boolean isValidUser(User user) throws BusinessException {
	boolean b=false;
	try (Connection connection=OracleConnection.getConnection()){
		String sql="Select userid from loginmaster where userid=? and password=?";
		PreparedStatement preparedstatement = connection.prepareStatement(sql);
		preparedstatement.setString(1, user.getUserid());
		preparedstatement.setString(2, user.getPassword());
		ResultSet resultset=preparedstatement.executeQuery();
		if(resultset.next()) {
			b=true;
		}else {
			throw new BusinessException("Invalid Userid/password from DAO");
		}
		
	} catch (ClassNotFoundException | SQLException e) {
	System.out.println(e);
		throw new BusinessException("Internal Error Occured pls contact SYSADMIN");
	}
		return b;
	}

}
