package com.flp.actions;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.flp.hib.Hospital;
import com.flp.serv.IHospitalServ;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class HospitalAction extends ActionSupport{
	private Hospital hos = new Hospital();
	private IHospitalServ hosserv;
	private String idHos;
	private HttpServletRequest request;
	
	public String addHospital() throws Exception {
		hos = hosserv.save(hos);
		if(hos.getIdHospital()!=null){
		   ActionContext.getContext().getSession().put("hospital",hos);
		   return "addHsptSuc";
		 }
		else{
			return "addHsptFal";
		}
	}
	
	public String findAllHospital(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		List<Hospital> list=this.hosserv.findAll();
		if(list!=null){
			session.setAttribute("hospitalList", list);
			return "hospitalList";
		}else{
			return "failure";
		}
	}
	public String delUser(){
		Hospital user=this.hosserv.findById(idHos);
		Hospital deluser=this.hosserv.del(user);
		if(deluser!=null){
			return "hospitalList";
		}else{
			return "failure";
		}
	}
	
	public String upUser(){
		if(this.hos!=null){
			hosserv.update(hos);
			return "hospitalList";
		}else{
			return "failure";
		}
	}
	
	public String findById(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		Hospital hospital=this.hosserv.findById(idHos);
		if(hospital!=null){
			session.setAttribute("oneHspt", hospital);
			return "oneHspt";
		}else{
			return "failure";
		}
	}
	
	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public Hospital getHos() {
		return hos;
	}

	public void setHos(Hospital hos) {
		this.hos = hos;
	}

	public String getIdHos() {
		return idHos;
	}

	public void setIdHos(String idHos) {
		this.idHos = idHos;
	}

	public IHospitalServ getHosserv() {
		return hosserv;
	}

	public void setHosserv(IHospitalServ hosserv) {
		this.hosserv = hosserv;
	}
	
	
}
