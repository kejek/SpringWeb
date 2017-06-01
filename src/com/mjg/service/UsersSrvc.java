package com.mjg.service;

import java.util.List;

import com.mjg.persistence.entity.Users;

public interface UsersSrvc {
	
	public Users saveUser(Users user) throws Exception;

	public void deleteUser(Users user);

	public Users getUserByUserName(String userName);
	
	public Users getUserByEmail(String email);

	public List<Users> getAllUsers();
}
