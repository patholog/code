package com.pathology.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.pathology.dto.PathologyDTO;
import com.pathology.service.IPathologyReportService;

/**
 * 获取病理报告单
 * @author yangyang
 */
public class DiaReportAction extends BaseAction{
	
	private IPathologyReportService pathologyreportService;
	public IPathologyReportService getPathologyreportService() {
		return pathologyreportService;
	}
	public void setPathologyreportService(IPathologyReportService pathologyreportService) {
		this.pathologyreportService = pathologyreportService;
	}
	public PathologyDTO getDianosisReport()
	{
		try{
			HttpServletRequest
			 request = ServletActionContext.getRequest();	
			
			String strId=request.getParameter("caseid").toString();
//			return pathologyreportService.getPatholgyReportDto(strId);
			return null;
	  }catch(Exception e){
		
	   }
		return null;
	}
}
