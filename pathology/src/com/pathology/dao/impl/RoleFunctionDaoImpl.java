package com.pathology.dao.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.hibernate.SessionFactory;

import com.pathology.dao.IRoleFunctionDao;
import com.pathology.dao.SuperDao;
import com.pathology.entity.RoleFunction;

public class RoleFunctionDaoImpl extends SuperDao implements IRoleFunctionDao{

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


	public List<Object> getAllRoleFunction(Class clazz,String hql) {
		return super.getAllObject(clazz,hql);
	}


	public void deleteRoleFunction(RoleFunction em) {
		super.delete(em);
	}
	
	public RoleFunction getRoleFunction(Class clazz,String id) {
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("idRoleFunction",id);
		return (RoleFunction) super.findUniqueByClz(RoleFunction.class, param);
	}
	
	public void updateRoleFunction(RoleFunction em){
		super.update(em);
	}

	public void addRoleFunction(RoleFunction em){
		super.add(em);
	}

}
