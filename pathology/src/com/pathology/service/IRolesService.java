package com.pathology.service;

import java.util.List;

import com.pathology.entity.Roles;


public interface IRolesService {
	public List<Roles> getByPage(int index,Class clazz,String hql);
	public List<Roles> getAllRoles(Class clazz,String hql);
	public void deleteRoles(Roles em);
	public Roles getRoles(Class clazz,String id);
	public void updateRoles(Roles em);
	public void addRoles(Roles em);
}
