package com.pathology.dao;

import java.util.List;

import com.pathology.entity.RoleFunction;


public interface IRoleFunctionDao{
	public List<Object> getByPage(int index, Class clazz, String hql);
	public List<Object> getAllRoleFunction(Class clazz,String hql);
	public void deleteRoleFunction(RoleFunction em);
	public RoleFunction getRoleFunction(Class clazz,String id);
	public void updateRoleFunction(RoleFunction em);
	public void addRoleFunction(RoleFunction em);

}
