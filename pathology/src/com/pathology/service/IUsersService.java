package com.pathology.service;

import java.util.List;

import com.pathology.entity.Users;

public interface IUsersService {
	
	public List<Users> getByPage(int index,Class clazz,String hql);
	public List<Users> getAllUser(Class clazz,String hql);
	public void deleteUser(Users em);
	public Users getUser(Class clazz,String id);
	public void updateUser(Users em);
	public void addUser(Users em);
	public Boolean findUser (String id)throws Exception;
}
