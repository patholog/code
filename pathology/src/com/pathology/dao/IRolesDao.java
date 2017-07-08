package com.pathology.dao;

import java.util.List;

import com.pathology.entity.Roles;


public interface IRolesDao{
	public List<Object> getByPage(int index, Class clazz, String hql);
	public List<Object> getAllRoles(Class clazz,String hql);
	public void deleteRoles(Roles em);
	public Roles getRoles(Class clazz,String id);
	public void updateRoles(Roles em);
	public void addRoles(Roles em);

}
