package com.mjg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mjg.persistence.dao.UsersDao;
import com.mjg.persistence.entity.Users;

@Service("UsersSrvc")
@Transactional
public class UsersSrvcImpl implements UsersSrvc {

	@Autowired
	UsersDao usersDao;

	@Override
	public Users saveUser(Users user) {	
		return usersDao.saveUser(user);
	}

	@Override
	public void deleteUser(Users user) {
		usersDao.deleteUser(user);

	}

	@Override
	public Users getUserByUserName(String userName) {
		return usersDao.getUserByUserName(userName);
	}

	@Override
	public Users getUserByEmail(String email) {
		return usersDao.getUserByEmail(email);
	}
	@Override
	public List<Users> getAllUsers() {
		return usersDao.getAllUsers();
	}

}
