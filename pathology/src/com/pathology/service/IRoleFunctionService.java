package com.pathology.service;

import java.util.List;

import com.pathology.entity.RoleFunction;

public interface IRoleFunctionService {
	public List<RoleFunction> getByPage(int index,Class clazz,String hql) throws Exception;
	public List<RoleFunction> getAllRoleFunction(Class clazz,String hql) throws Exception;
	public void deleteRoleFunction(RoleFunction em) throws Exception;
	public RoleFunction getRoleFunction(Class clazz,String id) throws Exception;
	public void updateRoleFunction(RoleFunction em) throws Exception;
	public void addRoleFunction(RoleFunction em) throws Exception;
}
