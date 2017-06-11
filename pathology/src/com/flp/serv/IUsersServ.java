package com.flp.serv;

import java.util.List;

import com.flp.hib.Users;

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
