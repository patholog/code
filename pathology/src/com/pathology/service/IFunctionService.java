package com.pathology.service;

import java.util.List;

import com.pathology.entity.Function;

public interface IFunctionService {
	public List<Function> getByPage(int index,Class clazz,String hql);
	public List<Function> getAllFunction(Class clazz,String hql);
	public void deleteFunction(Function em);
	public Function getFunction(Class clazz,String id);
	public void updateFunction(Function em);
	public void addFunction(Function em);
}
