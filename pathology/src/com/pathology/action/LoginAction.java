package com.pathology.action;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.pathology.entity.Users;
import com.pathology.service.IUsersService;
import com.pathology.util.DigestMD5;
import com.pathology.util.SessionAgentManager;

public class LoginAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Users user;

	// public Users getUser() {
	// return user;
	// }

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
}
