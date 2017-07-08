package com.pathology.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.pathology.dao.IFunctionDao;
import com.pathology.entity.Function;
import com.pathology.service.IFunctionService;

public class FunctionServiceImpl implements IFunctionService {

	private IFunctionDao functiondao;
	
	public IFunctionDao getFunctiondao() {
		return functiondao;
	}

	public void setFunctiondao(IFunctionDao hospitaldao) {
		this.functiondao = hospitaldao;
	}

	public List<Function> getByPage(int index, Class clazz, String hql) {

		List<Object> list = functiondao.getByPage(index, clazz, hql);
		return this.obj2Empl(list);
	}

	public List<Function> getAllFunction(Class clazz, String hql) {
		return this.obj2Empl(functiondao.getAllFunction(clazz, hql));
	}

	public void deleteFunction(Function em) {
//		Hospital Hospital = hospitaldao.getHospital(Hospital.class, em.getIdHospitals());
		if(em!=null)
			functiondao.deleteFunction(em);

	}

	public Function getFunction(Class clazz, String id) {
		
		return functiondao.getFunction(clazz, id);
	}

	public void updateFunction(Function em) {

		functiondao.updateFunction(em);

	}

	public void addFunction(Function em) {

		functiondao.addFunction(em);
	}

	public List<Function> obj2Empl(List<Object> list) {

		List<Function> elist = new ArrayList<Function>();
		for (Object obj : list) {

			Function em = (Function) obj;
			elist.add(em);
		}

		return elist;
	}
	
	

}
