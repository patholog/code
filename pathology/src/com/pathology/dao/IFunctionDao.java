package com.pathology.dao;

import java.util.List;

import com.pathology.entity.Function;


public interface IFunctionDao{
	public List<Object> getByPage(int index, Class clazz, String hql);
	public List<Object> getAllFunction(Class clazz,String hql);
	public void deleteFunction(Function em);
	public Function getFunction(Class clazz,String id);
	public void updateFunction(Function em);
	public void addFunction(Function em);

}
