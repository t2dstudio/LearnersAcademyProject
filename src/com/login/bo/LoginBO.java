package com.login.bo;

import com.login.exception.BusinessException;
import com.login.model.User;

public interface LoginBO {
	public boolean isValidUser(User user) throws BusinessException;


}
