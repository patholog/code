package com.pathology.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.pathology.entity.Users;
import com.pathology.service.IUsersServ;

public class UsersAction extends ActionSupport{
	private Users u = new Users();
	private IUsersServ userserv;
	private List<String> usernamelist = new ArrayList<String>();
	private String idUsers;
	private HttpServletRequest request;
	
	public String regist() throws Exception {
		usernamelist = userserv.getAllUsername();
		for(int i=0;i<usernamelist.size();i++){
			if(u.getUsername().equals(usernamelist.get(i))){
				this.addActionError("用户名已存在，请重新填写！");
				return "regFal";
			}
		}
		u = userserv.save(u);
		if(u.getIdUsers()!=null){
		   ActionContext.getContext().getSession().put("user",u);
		   return "regSuc";
		 }
		else{
			this.addActionError("ע注册失败,请重新填写！");
			return "regFal";
		}
	}
	
	public String findAllUser(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		List<Users> list=this.userserv.findAll();
		if(list!=null){
			session.setAttribute("userList", list);
			return "userList";
		}else{
			return "failure";
		}
	}
	public String delUser(){
		Users user=this.userserv.findById(idUsers);
		Users deluser=this.userserv.del(user);
		if(deluser!=null){
			return "userList";
		}else{
			return "failure";
		}
	}
	
	public String upUser(){
		if(this.u!=null){
			userserv.update(u);
			return "userList";
		}else{
			return "failure";
		}
	}
	
	public String findById(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		Users user=this.userserv.findById(idUsers);
		if(user!=null){
			session.setAttribute("onlyuser", user);
			return "onlyuser";
		}else{
			return "failure";
		}
	}
	
	public Users getU() {
		return u;
	}
	public void setU(Users u) {
		this.u = u;
	}
	public List<String> getUsernamelist() {
		return usernamelist;
	}
	public void setUsernamelist(List<String> usernamelist) {
		this.usernamelist = usernamelist;
	}

	public String getIdUsers() {
		return idUsers;
	}

	public void setIdUsers(String idUsers) {
		this.idUsers = idUsers;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public IUsersServ getUserserv() {
		return userserv;
	}

	public void setUserserv(IUsersServ userserv) {
		this.userserv = userserv;
	}
	
	
}
