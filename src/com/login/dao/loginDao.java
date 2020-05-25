package com.login.dao;

import com.login.exception.BusinessException;
import com.login.model.User;

public interface loginDao {
	public boolean isValidUser(User user) throws BusinessException;
}
