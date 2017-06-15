package com.pathology.dao;

import java.util.List;

import com.pathology.entity.Hospital;

public interface IHospitalDao{
	public List<Object> getByPage(int index, Class clazz, String hql);
	public List<Object> getAllHospital(Class clazz,String hql);
	public void deleteHospital(Hospital em);
	public Hospital getHospital(Class clazz,String id);
	public void updateHospital(Hospital em);
	public void addHospital(Hospital em);

}
