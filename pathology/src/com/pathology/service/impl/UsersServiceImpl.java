package com.pathology.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.pathology.dao.IUserDao;
import com.pathology.entity.Users;
import com.pathology.service.IUsersService;

public class UsersServiceImpl implements IUsersService {

	private IUserDao userdao;

	public IUserDao getUserdao() {
		return userdao;
	}

	public void setUserdao(IUserDao udao) {
		this.userdao = udao;
	}

	public List<Users> getByPage(int index, Class clazz, String hql) {

		List<Object> list = userdao.getByPage(index, clazz, hql);
		return this.obj2Empl(list);
	}

	public List<Users> getAllUser(Class clazz, String hql) {
		return this.obj2Empl(userdao.getAllUser(clazz, hql));
	}

	public void deleteUser(Users em) {
//		Users user = userdao.getUser(Users.class, em.getIdUsers());
		if(em!=null)
			userdao.deleteUser(em);

	}

	public Users getUser(Class clazz, String id) {
		
		return userdao.getUser(clazz, id);
	}

	public void updateUser(Users em) {

		userdao.updateUser(em);

	}

	public void addUser(Users em) {

		userdao.addUser(em);
	}

	public List<Users> obj2Empl(List<Object> list) {

		List<Users> elist = new ArrayList<Users>();
		for (Object obj : list) {

			Users em = (Users) obj;
			elist.add(em);
		}

		return elist;
	}
}
