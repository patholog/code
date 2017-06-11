package com.flp.actions;

import java.util.ArrayList;
import java.util.List;

import com.flp.bean.PageBean;
import com.flp.hib.Leaf;
import com.flp.hib.Users;
import com.flp.serv.ILeafServ;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LeafAction extends ActionSupport {
private Users u = new Users();
private Leaf l = new Leaf();
private PageBean p = new PageBean();
private ILeafServ serv;
private List<Leaf> list = new ArrayList<Leaf>();
private List<String> usernamelist = new ArrayList<String>();
public String login() throws Exception {
	u = serv.check(u);
	if(u.getIdUsers()!=null){
		ActionContext.getContext().getSession().put("user",u);
	    return this.SUCCESS;
	}
	else{
		this.addActionError("用户名或密码错误！");
		return "loginput";
	}
}
public String reg() throws Exception {
	if(!u.getPassword().equals(u.getPassword())){
		this.addActionError("两次密码不一致！");
		return "reginput";
	}
	usernamelist = serv.getAllUsername();
	for(int i=0;i<usernamelist.size();i++){
		if(u.getUsername().equals(usernamelist.get(i))){
			this.addActionError("用户名已存在，请重新填写！");
			return "reginput";
		}
	}
	u = serv.save(u);
	if(u.getIdUsers()!=null){
	   ActionContext.getContext().getSession().put("user",u);
	   return this.SUCCESS;
	 }
	else{
		this.addActionError("注册失败,请重新填写！");
		return "reginput";
	}
}
public String show() throws Exception{
	Users u = (Users)ActionContext.getContext().getSession().get("user"); 
	if(u==null){
	 this.addActionError("请您先登录！");
	 return "loginput";
	}
	list = serv.getByPage(u.getUsername(), p);
	return this.SUCCESS;
}
public String addleaf() throws Exception{
	Users u = (Users)ActionContext.getContext().getSession().get("user"); 
	if(u==null){
		this.addActionError("请您先登录！");
		return "loginput";
	}
	//l.setUsers(u);
	if("".equals(l.getContent()))
		l.setContent("所有人");
	l = serv.save(l);
	if(l.getLid()!=null)
	return this.SUCCESS;
	else{
		this.addActionError("留言失败，请重新操作！");
		return "addinput";
	}
}
public String deltleaf() throws Exception{
	serv.delt(l);
	return this.SUCCESS;
}
public Users getU() {
	return u;
}
public void setU(Users u) {
	this.u = u;
}
public Leaf getL() {
	return l;
}
public void setL(Leaf l) {
	this.l = l;
}
public PageBean getP() {
	return p;
}
public void setP(PageBean p) {
	this.p = p;
}
public ILeafServ getServ() {
	return serv;
}
public void setServ(ILeafServ serv) {
	this.serv = serv;
}
public List<Leaf> getList() {
	return list;
}
public void setList(List<Leaf> list) {
	this.list = list;
}
public List<String> getUsernamelist() {
	return usernamelist;
}
public void setUsernamelist(List<String> usernamelist) {
	this.usernamelist = usernamelist;
}
}
