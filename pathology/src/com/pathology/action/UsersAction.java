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

import com.opensymphony.xwork2.ActionContext;
import com.pathology.entity.Users;
import com.pathology.service.IUsersService;
import com.pathology.util.DigestMD5;
import com.pathology.util.SessionAgentManager;

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
			//String adress=null;
			//String realname=null;
			//验证用户
		}

		SessionAgentManager.setSessionAgentBean( user,"admin"); 
		return "loginSuccess";
	}


	public String userList(){

		String hql="";
		if(user!=null){
			String username = null;
			String adress=null;
			String realname=null;
			if(username!=null&&!("".equals(username)))
				hql+=" and username like '%"+username+"%'";
			if(user.getTel()!=null&&!("".equals(user.getTel())))
				hql+=" and tel = "+user.getTel();
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
	public String checkUser() throws IOException{
		HttpSession session=ServletActionContext.getRequest().getSession();
		Users userT = userservice.getUser(Users.class, user.getIdUsers());
		session.setAttribute("user",userT);
		return "check";
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
		user.setIdUsers(getEandomId(16));
		user.setUserstatus("0");
		userservice.addUser(user);
		return "updatesuccess";
	}

	public String registUser() throws IOException{
		user.setPassword(DigestMD5.getDigestPassWord(user.getPassword()));
		user.setDoctorctfsrc(upImg());
		user.setIdUsers(getEandomId(16));
		user.setUserstatus("0");
		userservice.addUser(user);

		return "registsuccess";
	}

	//图片上传
	public String upImg(){
		String img=null;
		if(photo!=null){
			String realpath=ServletActionContext.getServletContext().getRealPath("upload/img/")+"\\";
			System.out.println("11111"+realpath);
			System.out.println(photoFileName);
			String type=photoFileName.substring(photoFileName.lastIndexOf(".")+1,photoFileName.length());
			System.out.println("222"+type);
			String time=new SimpleDateFormat("yyMMddssSSS").format(new Date());
			System.out.println(time);
			String name=time+"."+type;
			System.out.println(name);
			File saveFile=new File(realpath,name);
			if(saveFile.getParentFile().exists()){
				saveFile.getParentFile().mkdirs();
			}
			try {
				FileUtils.copyFile(photo, saveFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
			request=ServletActionContext.getRequest();
			String path = request.getContextPath();  
            String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
            String picturePath = basePath +"upload/img"+"/"+name;  
			img=picturePath;
		}
		return img;
	}

	public String checkUserStatus(){
		Users userT = userservice.getUser(Users.class, user.getIdUsers());
		userT.setUserstatus("1");
		userservice.updateUser(userT);
		return "updatesuccess";
	}
	
	public String refuseCheck(){
		Users userT = userservice.getUser(Users.class, this.idUsers);
		userT.setUserstatus("2");
		userservice.updateUser(userT);
		return "updatesuccess";
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


	public String getPhotoFileName() {
		return photoFileName;
	}


	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}


	public String getPhotoType() {
		return photoType;
	}


	public void setPhotoType(String photoType) {
		this.photoType = photoType;
	}


	public File getPhoto() {
		return photo;
	}


	public void setPhoto(File photo) {
		this.photo = photo;
	}

	//	public IUsersService getUserserv() {
	//		return userserv;
	//	}
	//
	//	public void setUserserv(IUsersService userserv) {
	//		this.userserv = userserv;
	//	}


}
