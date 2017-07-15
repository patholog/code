package com.pathology.action;

import com.opensymphony.xwork2.Action;
import com.pathology.entity.Users;
import com.pathology.service.IUsersService;
import com.pathology.util.Constant;
import com.pathology.util.DigestMD5;
import com.pathology.util.SessionAgentManager;


public class LoginAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Users user;

	 public Users getUser() {
	  return user;
	 }

	private String msg;

	public String getMsg() {
		return msg;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public String login() {
		Users u = this.user;
		System.out.println(u.getUsername());
		if (u.getUsername().equals("ll")) {
			this.msg = "成功";
		} else {
			this.msg = "失败";
		}
		return Action.SUCCESS;
	}
	
	/**
	 * 退出登录
	 * @return
	 */
	public String LoginOut(){
	   try{
		   SessionAgentManager.DestroySessionMember();
			/*if (u.getUsername().equals("ll")) {
				this.msg = "成功";
			} else {
				this.msg = "失败";
			}*/
			return Action.SUCCESS;
	   }catch(Exception e){
		   
	   }
		return  Constant.ERR;
	}
}
