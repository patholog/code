package com.pathology.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.pathology.dto.PathologyDTO;
import com.pathology.dto.PathologyReportDTO;
import com.pathology.service.IPathologyReportService;
import com.pathology.util.Constant;
import com.pathology.util.SessionAgentManager;

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
	public PathologyReportDTO getDianosisReport()
	{
		try{
//			if(!SessionAgentManager.islogin())
//				return Constant.ERR;
			
			HttpServletRequest request = ServletActionContext.getRequest();	
			
			String strCaseId=request.getParameter("caseid").toString();
			return pathologyreportService.getPatholgyReportDto(strCaseId);
	  }catch(Exception e){
		
	   }
		return null;
	}
}
