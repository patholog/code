package com.pathology.service;

import java.util.List;

import com.pathology.entity.Function;

public interface IFunctionService {
	public List<Function> getByPage(int index,Class clazz,String hql) throws Exception;
	public List<Function> getAllFunction(Class clazz,String hql) throws Exception;
	public void deleteFunction(Function em) throws Exception;
	public Function getFunction(Class clazz,String id) throws Exception;
	public void updateFunction(Function em) throws Exception;
	public void addFunction(Function em) throws Exception;
	
	public List<Function> getFunctionList(String id_role)throws Exception;
}
