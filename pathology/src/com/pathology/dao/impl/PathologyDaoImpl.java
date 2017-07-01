package com.pathology.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.SessionFactory;

import com.pathology.dao.IPathologyDao;
import com.pathology.dao.SuperDao;
import com.pathology.entity.Pathology;

public class PathologyDaoImpl extends SuperDao implements IPathologyDao {

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


	public List<Object> getAllPathology(Class clazz,String hql) {
		return super.getAllObject(clazz,hql);
	}


	public void deletePathology(Pathology em) {
		super.delete(em);
	}
	
	public Pathology getPathology(Class clazz,String id) {
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("idCase",id);
		return (Pathology) super.findUniqueByClz(Pathology.class, param);
	}
	
	public void updatePathology(Pathology em){
		super.update(em);
	}

	public void addPathology(Pathology em){
		super.add(em);
	}



}
