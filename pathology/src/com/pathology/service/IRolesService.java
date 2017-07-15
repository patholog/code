package com.pathology.service;

import java.util.List;

import com.pathology.entity.Roles;


public interface IRolesService {
	public List<Roles> getByPage(int index,Class clazz,String hql) throws Exception;
	public List<Roles> getAllRoles(Class clazz,String hql) throws Exception;
	public void deleteRoles(Roles em) throws Exception;
	public Roles getRoles(Class clazz,String id) throws Exception;
	public void updateRoles(Roles em) throws Exception;
	public void addRoles(Roles em) throws Exception;
}
