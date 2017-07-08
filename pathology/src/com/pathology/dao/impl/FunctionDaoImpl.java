package com.pathology.dao.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.hibernate.SessionFactory;

import com.pathology.dao.IFunctionDao;
import com.pathology.dao.SuperDao;
import com.pathology.entity.Function;

public class FunctionDaoImpl extends SuperDao implements IFunctionDao{

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


	public List<Object> getAllFunction(Class clazz,String hql) {
		return super.getAllObject(clazz,hql);
	}


	public void deleteFunction(Function em) {
		super.delete(em);
	}
	
	public Function getFunction(Class clazz,String id) {
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("idFunction",id);
		return (Function) super.findUniqueByClz(Function.class, param);
	}
	
	public void updateFunction(Function em){
		super.update(em);
	}

	public void addFunction(Function em){
		super.add(em);
	}

}
