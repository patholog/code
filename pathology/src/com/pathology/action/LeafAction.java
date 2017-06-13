package com.pathology.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.pathology.bean.PageBean;
import com.pathology.entity.Leaf;
import com.pathology.entity.Users;
import com.pathology.service.ILeafServ;

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
		this.addActionError("�û�����������");
		return "loginput";
	}
}
public String reg() throws Exception {
	if(!u.getPassword().equals(u.getPassword())){
		this.addActionError("�������벻һ�£�");
		return "reginput";
	}
	usernamelist = serv.getAllUsername();
	for(int i=0;i<usernamelist.size();i++){
		if(u.getUsername().equals(usernamelist.get(i))){
			this.addActionError("�û����Ѵ��ڣ���������д��");
			return "reginput";
		}
	}
	u = serv.save(u);
	if(u.getIdUsers()!=null){
	   ActionContext.getContext().getSession().put("user",u);
	   return this.SUCCESS;
	 }
	else{
		this.addActionError("ע��ʧ��,��������д��");
		return "reginput";
	}
}
public String show() throws Exception{
	Users u = (Users)ActionContext.getContext().getSession().get("user"); 
	if(u==null){
	 this.addActionError("�����ȵ�¼��");
	 return "loginput";
	}
	list = serv.getByPage(u.getUsername(), p);
	return this.SUCCESS;
}
public String addleaf() throws Exception{
	Users u = (Users)ActionContext.getContext().getSession().get("user"); 
	if(u==null){
		this.addActionError("�����ȵ�¼��");
		return "loginput";
	}
	//l.setUsers(u);
	if("".equals(l.getContent()))
		l.setContent("������");
	l = serv.save(l);
	if(l.getLid()!=null)
	return this.SUCCESS;
	else{
		this.addActionError("����ʧ�ܣ������²�����");
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
