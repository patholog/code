package com.pathology.service;

import java.util.List;

import com.pathology.entity.Users;

public interface IUsersService {
	
	public List<Users> getByPage(int index,Class clazz,String hql) throws Exception;
	public List<Users> getAllUser(Class clazz,String hql) throws Exception;
	public void deleteUser(Users em) throws Exception;
	public Users getUser(Class clazz,String id) throws Exception;
	public void updateUser(Users em) throws Exception;
	public void addUser(Users em) throws Exception;
	public Boolean findUser (String id)throws Exception;
	public List<Users> getUsersByPage(int index,Class clazz,String hql) throws Exception;
}
