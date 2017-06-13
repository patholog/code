package com.pathology.service;

import java.util.List;

import com.pathology.entity.Users;

public interface IUsersServ {
	Users check(Users u);
	Users save(Users u);
	Users update(Users u);
	Users del(Users u);
	List<Users> findAll();
	List<Users> find(String wherestrs);
	Users findById(String id);
	List<String> getAllUsername();
}
