package com.pathology.dao.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.SessionFactory;

import com.pathology.dao.IHospitalDao;
import com.pathology.dao.SuperDao;
import com.pathology.entity.Hospital;

public class HospitalDaoImpl extends SuperDao implements IHospitalDao{

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


	public List<Object> getAllHospital(Class clazz,String hql) {
		return super.getAllObject(clazz,hql);
	}


	public void deleteHospital(Hospital em) {
		super.delete(em);
	}
	
	public Hospital getHospital(Class clazz,String id) {
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("idHospital",id);
		return (Hospital) super.findUniqueByClz(Hospital.class, param);
	}
	
	public void updateHospital(Hospital em){
		super.update(em);
	}

	public void addHospital(Hospital em){
		super.add(em);
	}

}
