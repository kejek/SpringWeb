package com.mjg.persistence.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.mjg.aspect.Loggable;
import com.mjg.persistence.entity.Users;

@Repository("UsersDao")
public class UsersDaoImpl extends AbstractDao<Integer, Users> implements UsersDao {

	@Loggable
	@Override
	public Users saveUser(Users user) {
		persist(user);
		return user;
	}

	@Loggable
	@Override
	public void deleteUser(Users user) {
		delete(user);

	}

	@Loggable
	@Override
	public Users getUserByUserName(String userName) {
		Criteria criteria = getSession().createCriteria(Users.class);
		criteria.add(Restrictions.eq("userName", userName));
		return (Users) criteria.uniqueResult();
	}
	
	@Loggable
	@Override
	public Users getUserByEmail(String email) {
		Criteria criteria = getSession().createCriteria(Users.class);
		criteria.add(Restrictions.eq("email", email));
		return (Users) criteria.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Loggable
	@Override
	public List<Users> getAllUsers() {
		Criteria criteria = getSession().createCriteria(Users.class);
		return (List<Users>) criteria.list();
	}

}
