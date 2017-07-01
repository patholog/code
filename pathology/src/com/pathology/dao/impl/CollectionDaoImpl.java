package com.pathology.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.SessionFactory;

import com.pathology.dao.ICollectionDao;
import com.pathology.dao.SuperDao;
import com.pathology.entity.Collection;

public class CollectionDaoImpl extends SuperDao implements ICollectionDao {

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


	public List<Object> getAllCollection(Class clazz,String hql) {
		return super.getAllObject(clazz,hql);
	}


	public void deleteCollection(Collection em) {
		super.delete(em);
	}
	
	public Collection getCollection(Class clazz,String id) {
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("idCollection",id);
		return (Collection) super.findUniqueByClz(Collection.class, param);
	}
	
	public void updateCollection(Collection em){
		super.update(em);
	}

	public void addCollection(Collection em){
		super.add(em);
	}



}
