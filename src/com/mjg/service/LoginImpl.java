package com.mjg.service;

import org.springframework.stereotype.Service;

@Service("Login")
public class LoginImpl implements Login {

	@Override
	public boolean login(String userName, String password) {
		//hardcoded login - no database yet
		if(userName.toUpperCase().equals("TEST") && password.toUpperCase().equals("TEST"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
