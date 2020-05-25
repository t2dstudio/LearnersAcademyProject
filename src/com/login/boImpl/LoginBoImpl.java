package com.login.boImpl;

import com.login.bo.LoginBO;
import com.login.daoimpl.LoginDaoImpl;
import com.login.exception.BusinessException;
import com.login.model.User;

public class LoginBoImpl implements LoginBO {
	
	private LoginDaoImpl loginDao=new LoginDaoImpl();

	@Override
	public boolean isValidUser(User user) throws BusinessException {
	boolean b = false;
	if(user !=null && user.getUserid().endsWith("usa.com")&& user.getPassword().matches("[A-Z]{2}[0-9]{4}#[0-9]{4}") ) {
		//Code here for Dao
		b=loginDao.isValidUser(user);
	}else {
		throw new BusinessException("Invalid UserId or Password");
	}
		return b;
	}

}
