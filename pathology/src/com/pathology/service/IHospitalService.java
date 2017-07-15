package com.pathology.service;

import java.util.List;

import com.pathology.entity.Hospital;


public interface IHospitalService {
	public List<Hospital> getByPage(int index,Class clazz,String hql) throws Exception;
	public List<Hospital> getAllHospital(Class clazz,String hql) throws Exception;
	public void deleteHospital(Hospital em) throws Exception;
	public Hospital getHospital(Class clazz,String id) throws Exception;
	public void updateHospital(Hospital em) throws Exception;
	public void addHospital(Hospital em) throws Exception;
}
