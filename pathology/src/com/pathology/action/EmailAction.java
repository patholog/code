package com.pathology.action;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.pathology.entity.Users;
import com.pathology.service.IUsersService;

public class EmailAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	private Map<String, String> p;

	public IUsersService userservice;
	// public Map<String, String> getP() {
	// return this.p;
	// }

	public void setP(Map<String, String> p) {
		this.p = p;
	}

	public String checkEmail() {
		String email = this.p.get("email");
		String hql=" and s.email='"+email+"'";
		List<Users> userT = userservice.getAllUser(Users.class, hql);
		if (userT!=null && userT.size()>0) {
			return Action.ERROR;
		} else {
			return Action.SUCCESS;
		}
	}
	
	public String checkUserName(){
		String name = this.p.get("username");
		String hql=" and s.username='"+name+"'";
		List<Users> userT = userservice.getAllUser(Users.class, hql);
		if (userT!=null && userT.size()>0) {
			return Action.ERROR;
		} else {
			return Action.SUCCESS;
		}
	}

	public IUsersService getUserservice() {
		return userservice;
	}

	public void setUserservice(IUsersService userservice) {
		this.userservice = userservice;
	}
	

}
