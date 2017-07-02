package com.pathology.action;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.pathology.dto.PathologyDTO;
import com.pathology.service.IPathologyService;

public class PathologyAction extends BaseAction{

	public IPathologyService pathologyService;
	private List<PathologyDTO> pathologys;
	
	
	public String  getPathologyListToNeed(){
		try{
		
			HttpServletRequest
			 request = ServletActionContext.getRequest();	
			
			pathologys =  pathologyService.getListPathologyToNeed(request,"");
		
		return "pathologysneed";
	  }catch(Exception e){
		
	   }
		return "pathologysneed";
	}
	public String  getPathologyListToHas(){
		try{
		
			HttpServletRequest
			 request = ServletActionContext.getRequest();	
			
			pathologys =  pathologyService.getListPathologyToHas(request,"");
		
		return "pathologyshas";
	  }catch(Exception e){
		
	   }
		return "pathologyshas";
	}
	public String  getPathologyListToBack(){
		try{
		
			HttpServletRequest
			 request = ServletActionContext.getRequest();	
			
			pathologys =  pathologyService.getListPathologyToBack(request,"");
		
		return "pathologysback";
	  }catch(Exception e){
		e.printStackTrace();
	   }
		return "pathologysback";
	}
	public IPathologyService getPathologyService() {
		return pathologyService;
	}


	public void setPathologyService(IPathologyService shareService) {
		this.pathologyService = shareService;
	}


	public List<PathologyDTO> getPathologys() {
		return pathologys;
	}


	public void setPathologys(List<PathologyDTO> pathologys) {
		this.pathologys = pathologys;
	}
	
	
	
}
