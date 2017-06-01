package com.mjg.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mjg.model.UserModel;
import com.mjg.persistence.entity.Users;

@Service("LoginSrvc")
public class LoginSrvcImpl implements LoginSrvc {

	@Autowired
	UsersSrvc usersSrvc;
	@Autowired
	PasswordSrvc passwordSrvc;
	@Autowired
	ModelMapper modelMapper;

	@Override
	public UserModel login(String userName, String password) {
		UserModel model = new UserModel();
		try{
			Users user = usersSrvc.getUserByUserName(userName);
			
			if(user.getPassword().equals(passwordSrvc.hashPassword(password))){
				model = modelMapper.map(user, UserModel.class);
				model.setAuthenticated(true);
			}
		}
		catch(Exception e){
			return null;
		}
		return model;
	}

}
