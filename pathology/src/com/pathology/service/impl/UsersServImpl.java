package com.pathology.service.impl;

import java.util.List;

import com.pathology.dao.IUserDao;
import com.pathology.entity.Users;
import com.pathology.service.IUsersServ;

public class UsersServImpl implements IUsersServ {

	private IUserDao<Users, Integer> udao;
	@Override
	public Users check(Users u) {
		return null;
	}

	@Override
	public Users save(Users u) {
		return udao.save(u);
	}

	@Override
	public Users update(Users u) {
		return udao.edit(u);
	}

	@Override
	public Users del(Users u) {
		return udao.delt(u);
	}

	@Override
	public List<Users> findAll() {
		return udao.getAll("select * from users");
	}
	
	@Override
	public Users findById(String id) {
		if(id.isEmpty())return null;
		List<Users> userlist = udao.getAll("select u.* from users u where u.id='"+id+"'");
		if(userlist.size()>0)return userlist.get(0);
		return null;
	}

	@Override
	public List<Users> find(String wherestrs) {
		if(wherestrs.isEmpty())return null;
		return udao.getAll("select u.* from users u where '"+wherestrs+"'");
	}
	
	public List<String> getAllUsername() {
		return udao.getAll("select u.username from Users u");
	}

	public IUserDao<Users, Integer> getUdao() {
		return udao;
	}

	public void setUdao(IUserDao<Users, Integer> udao) {
		this.udao = udao;
	}

	
}
