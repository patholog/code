package com.pathology.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.pathology.dao.IHospitalDao;
import com.pathology.entity.Hospital;
import com.pathology.service.IHospitalService;

public class HospitalServiceImpl implements IHospitalService {

	private IHospitalDao hospitaldao;
	
	public IHospitalDao getHospitaldao() {
		return hospitaldao;
	}

	public void setHospitaldao(IHospitalDao hospitaldao) {
		this.hospitaldao = hospitaldao;
	}

	public List<Hospital> getByPage(int index, Class clazz, String hql)  throws Exception{

		List<Object> list = hospitaldao.getByPage(index, clazz, hql);
		return this.obj2Empl(list);
	}

	public List<Hospital> getAllHospital(Class clazz, String hql)  throws Exception{
		return this.obj2Empl(hospitaldao.getAllHospital(clazz, hql));
	}

	public void deleteHospital(Hospital em) {
//		Hospital Hospital = hospitaldao.getHospital(Hospital.class, em.getIdHospitals());
		if(em!=null)
			hospitaldao.deleteHospital(em);

	}

	public Hospital getHospital(Class clazz, String id)  throws Exception{
		
		return hospitaldao.getHospital(clazz, id);
	}

	public void updateHospital(Hospital em)  throws Exception{

		hospitaldao.updateHospital(em);

	}

	public void addHospital(Hospital em)  throws Exception{

		hospitaldao.addHospital(em);
	}

	public List<Hospital> obj2Empl(List<Object> list) {

		List<Hospital> elist = new ArrayList<Hospital>();
		for (Object obj : list) {

			Hospital em = (Hospital) obj;
			elist.add(em);
		}

		return elist;
	}
	
	

}
