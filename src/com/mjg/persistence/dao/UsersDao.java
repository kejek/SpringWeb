package com.mjg.persistence.dao;

import java.util.List;

import com.mjg.persistence.entity.Users;

public interface UsersDao {
	public Users saveUser(Users user);
	public void deleteUser(Users user);
	public Users getUserByUserName(String userName);
	public Users getUserByEmail(String email);
	public List<Users> getAllUsers();
}
