package com.pathology.action;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.pathology.entity.Users;
import com.pathology.service.IUsersService;

public class UsersAction extends BaseAction{
	private Users u = new Users();
	public IUsersService userservice;

	private List<String> usernamelist = new ArrayList<String>();
	private String idUsers;
	private HttpServletRequest request;

	private Users user;
	private List<Users> list;
	private int index;
	
	private String photoFileName;
	private String photoType;
	private File photo;

	public String login(){
		
		if(user!=null){
			String username = null;
			String adress=null;
			String realname=null;
		 //验证用户
		}
		return "loginSuccess";
	}
	
 
	public String userList(){

		String hql="";
		if(user!=null){
			String username = null;
			String adress=null;
			String realname=null;
			try {
				username = new String((user.getUsername().getBytes("ISO8859-1")),"UTF-8");
//				realname=new String((user.getRealname().getBytes("ISO8859-1")),"UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if(username!=null&&!("".equals(username)))
				hql+=" and username like '%"+username+"%'";
			if(user.getTel()!=null&&!("".equals(user.getTel())))
				hql+=" and tel = "+user.getTel();

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

	public String updateUser() throws IOException{
		HttpSession session=ServletActionContext.getRequest().getSession();
		Users userT = userservice.getUser(Users.class, user.getIdUsers());
		session.setAttribute("user",userT);
		return "edit";
	}
	public String deleteUser(){
		Users userT = userservice.getUser(Users.class, user.getIdUsers());
		userservice.deleteUser(userT);
		return "deletesuccess";
	}
	public String saveUser() throws IOException{
		userservice.updateUser(user);
		return "updatesuccess";
	}
	public String addUser() throws IOException{
		userservice.addUser(user);
		return "updatesuccess";
	}
	
	public String registUser() throws IOException{
		user.setUsername(new String(user.getUsername().getBytes("ISO8859-1"),"UTF-8"));
		user.setDoctorctfsrc(upImg());
		user.setIdUsers(getEandomId(16));
		userservice.addUser(user);
		
		return "registsuccess";
	}
	
	//图片上传
		public String upImg(){
			System.out.println("1111111");
			String img=null;
			if(photo!=null){
				String path=ServletActionContext.getServletContext().getRealPath("upload/img/")+"\\";
				System.out.println("11111"+path);
				System.out.println(photoFileName);
				String type=photoFileName.substring(photoFileName.lastIndexOf(".")+1,photoFileName.length());
				System.out.println("222"+type);
				String time=new SimpleDateFormat("yyMMddssSSS").format(new Date());
				System.out.println(time);
				String name=time+"."+type;
				System.out.println(name);
				File saveFile=new File(path,name);
				if(saveFile.getParentFile().exists()){
					saveFile.getParentFile().mkdirs();
				}
				try {
					FileUtils.copyFile(photo, saveFile);
				} catch (IOException e) {
					e.printStackTrace();
				}
				img="upload/img/"+name;
			}
			return img;
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
