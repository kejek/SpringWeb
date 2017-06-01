package com.mjg.service;

import com.mjg.model.UserModel;

public interface LoginSrvc {
	public UserModel login(String userName, String password);
}
