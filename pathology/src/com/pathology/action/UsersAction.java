package com.pathology.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.pathology.entity.Users;
import com.pathology.service.IUsersService;

public class UsersAction extends ActionSupport{
	private Users u = new Users();
	public IUsersService userservice;

	private List<String> usernamelist = new ArrayList<String>();
	private String idUsers;
	private HttpServletRequest request;

	private Users user;
	private List<Users> list;
	private int index;

	public String userList(){

		String hql="";
		if(user!=null){
			String username = null;
			String adress=null;
			try {
				username = new String((user.getUsername().getBytes("ISO8859-1")),"UTF-8");
				adress= new String((user.getTel().getBytes("ISO8859-1")),"UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if(username!=null&&!("".equals(username)))
				hql+=" and s.username like '%"+username+"%'";
			if(user.getTel()!=null&&!("".equals(user.getTel())))
				hql+=" and s.tel = "+user.getTel();

			//System.out.println(hql+"000000000000000000000000000000000"+user.getUsername());
		}

		List<Users> list = index != 0 ? userservice.getByPage(index, Users.class,hql)
				:userservice.getByPage(1, Users.class,hql);

		HttpSession session=ServletActionContext.getRequest().getSession();
		session.setAttribute("list",list);
		session.setAttribute("thisindex",index==0?1:index);

		session.setAttribute("count",userservice.getAllUser(Users.class,hql).size());
		System.out.println("0000"+list.size());
		return SUCCESS;
	}


	public String updateUsersDialog(){

		Users users=userservice.getUser(Users.class, user.getIdUsers());
		//		HttpSession session=ServletActionContext.getRequest().getSession();
		//		session.setAttribute("emp",emp);
		ServletActionContext.getRequest().setAttribute("user", users);
		return "dilog";
	}
	public String updateUser() throws IOException{

		user.setUsername(new String(user.getUsername().getBytes("ISO8859-1"),"UTF-8"));
		user.setEmail(new String(user.getEmail().getBytes("ISO8859-1"),"UTF-8"));
		user.setEmail(new String(user.getEmail().getBytes("ISO8859-1"),"UTF-8"));
		user.setTel(new String(user.getTel().getBytes("ISO8859-1"),"UTF-8"));
		user.setSpecialty(new String(user.getSpecialty().getBytes("ISO8859-1"),"UTF-8"));
		userservice.updateUser(user);

		return "success";
	}
	public String deleteUser(){

		userservice.deleteUser(user);
		return "deletesuccess";
	}

	public IUsersService getUserservice() {
		return userservice;
	}

	public void setUserservice(IUsersService userservice) {
		this.userservice = userservice;
	}
	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
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

	//	public IUsersService getUserserv() {
	//		return userserv;
	//	}
	//
	//	public void setUserserv(IUsersService userserv) {
	//		this.userserv = userserv;
	//	}


}
