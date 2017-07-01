package com.pathology.action;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.pathology.dto.ShareDTO;
import com.pathology.service.IShareService;

public class ShareAction extends BaseAction{

	public IShareService shareService;
	private List<ShareDTO> shares;
	
	
	public String  getShareList(){
		try{
		
			HttpServletRequest
			 request = ServletActionContext.getRequest();	
			
			shares =  shareService.getListShare(request,"");
		
		return "shares";
	  }catch(Exception e){
		
	   }
		return "shares";
	}


	public IShareService getShareService() {
		return shareService;
	}


	public void setShareService(IShareService shareService) {
		this.shareService = shareService;
	}


	public List<ShareDTO> getShares() {
		return shares;
	}


	public void setShares(List<ShareDTO> shares) {
		this.shares = shares;
	}
	
	
	
}
