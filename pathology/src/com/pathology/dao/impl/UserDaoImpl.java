package com.pathology.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;

import com.pathology.dao.IUserDao;
import com.pathology.dao.SuperDao;
import com.pathology.entity.Users;

public class UserDaoImpl extends SuperDao implements IUserDao {

	private SessionFactory osessionFactory;


	public SessionFactory getOsessionFactory() {
		return osessionFactory;
	}


	public void setOsessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}


	public List<Object> getByPage(int index, Class clazz, String hql) {
		return super.selectPage(index, clazz, hql);
	}


	public List<Object> getAllUser(Class clazz,String hql) {
		return super.getAllObject(clazz,hql);
	}


	public void deleteUser(Users em) {
		super.delete(em);
	}
	
	public Users getUser(Class clazz,String id) {
		return (Users) super.select(clazz, id);
	}
	
	public void updateUser(Users em){
		super.update(em);
	}

	public void addUser(Users em){
		super.add(em);
	}

}
