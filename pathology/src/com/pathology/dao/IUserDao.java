package com.pathology.dao;
import java.util.List;

import com.pathology.entity.Users;
public interface IUserDao{
	public List<Object> getByPage(int index, Class clazz, String hql);
	public List<Object> getAllUser(Class clazz,String hql);
	public void deleteUser(Users em);
	public Users getUser(Class clazz,String id);
	public void updateUser(Users em);
	public void addUser(Users em);
}
