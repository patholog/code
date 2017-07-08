package com.pathology.dao.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.SessionFactory;

import com.pathology.dao.IRolesDao;
import com.pathology.dao.SuperDao;
import com.pathology.entity.Roles;

public class RolesDaoImpl extends SuperDao implements IRolesDao{

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


	public List<Object> getAllRoles(Class clazz,String hql) {
		return super.getAllObject(clazz,hql);
	}


	public void deleteRoles(Roles em) {
		super.delete(em);
	}
	
	public Roles getRoles(Class clazz,String id) {
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("idRoles",id);
		return (Roles) super.findUniqueByClz(Roles.class, param);
	}
	
	public void updateRoles(Roles em){
		super.update(em);
	}

	public void addRoles(Roles em){
		super.add(em);
	}

}
