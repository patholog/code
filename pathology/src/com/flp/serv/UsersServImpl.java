package com.flp.serv;

import java.util.List;

import com.flp.dao.IUserDao;
import com.flp.hib.Users;

public class UsersServImpl implements IUsersServ {

	private IUserDao<Users, Integer> userDao;
	@Override
	public Users check(Users u) {
		return null;
	}

	@Override
	public Users save(Users u) {
		return userDao.save(u);
	}

	@Override
	public Users update(Users u) {
		return userDao.edit(u);
	}

	@Override
	public Users del(Users u) {
		return userDao.delt(u);
	}

	@Override
	public List<Users> findAll() {
		return userDao.getAll("select * from users");
	}
	
	@Override
	public Users findById(String id) {
		if(id.isEmpty())return null;
		List<Users> userlist = userDao.getAll("select u.* from users u where u.id='"+id+"'");
		if(userlist.size()>0)return userlist.get(0);
		return null;
	}

	@Override
	public List<Users> find(String wherestrs) {
		if(wherestrs.isEmpty())return null;
		return userDao.getAll("select u.* from users u where '"+wherestrs+"'");
	}
	
	public List<String> getAllUsername() {
		return userDao.getAll("select u.username from Users u");
	}

}
