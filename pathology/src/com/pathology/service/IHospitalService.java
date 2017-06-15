package com.pathology.service;

import java.util.List;

import com.pathology.entity.Hospital;


public interface IHospitalService {
	public List<Hospital> getByPage(int index,Class clazz,String hql);
	public List<Hospital> getAllHospital(Class clazz,String hql);
	public void deleteHospital(Hospital em);
	public Hospital getHospital(Class clazz,String id);
	public void updateHospital(Hospital em);
	public void addHospital(Hospital em);
}
