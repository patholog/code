package com.pathology.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.pathology.dto.PathologyDTO;
import com.pathology.entity.Pathology;
import com.pathology.service.IPathologyService;
import com.pathology.util.Constant;
import com.pathology.util.SessionAgentManager;

public class PathologyAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	private final Logger logger = Logger.getLogger(PathologyAction.class);
	public IPathologyService pathologyService;
	private List<PathologyDTO> pathologys;
	
	/**
	 * 保存病理
	 * @param pathologgyjson
	 * @return
	 */
   public   Pathology  savePathology(String pathologgyjson){

	   JSONObject obj = JSONObject.fromObject(pathologgyjson);//将json字符串转换为json对象
	    // 将json对象转换为java对象
	   Pathology jb = (Pathology)JSONObject.toBean(obj,Pathology.class);//将建json对象转换为Person对象
	     try {
			pathologyService.addPathology(jb);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   return  jb;
   }


	/**
	 * 待诊断
	 * @return
	 */
  public String getPathologyListToNeed(){
		try {

			if (!SessionAgentManager.islogin())
				return Constant.ERR;
      HttpServletRequest request = ServletActionContext.getRequest();
      pathologys =  pathologyService.getListPathologyToNeed(request,"");
      return "pathologysneed";
		} catch (Exception e) {
			logger.error(e.getMessage());
			return Constant.ERR;
		}
  }

  /**
   * 查看待诊断
   * @return
   */
  public String daizhenduan() {

    return "daizhenduan";
  }
  
	public String  getPathologyListToHas(){
		try {

			if (!SessionAgentManager.islogin())
				return Constant.ERR;
			HttpServletRequest
			 request = ServletActionContext.getRequest();	
			
			pathologys =  pathologyService.getListPathologyToHas(request,"");
		
		return "pathologyshas";
		} catch (Exception e) {
			logger.error(e.getMessage());
			return Constant.ERR;
		}
	}
	public String  getPathologyListToBack(){
		try {

			if (!SessionAgentManager.islogin())
				return Constant.ERR;
			HttpServletRequest
			 request = ServletActionContext.getRequest();	
			
			pathologys =  pathologyService.getListPathologyToBack(request,"");
		
		return "pathologysback";
		} catch (Exception e) {
			logger.error(e.getMessage());
			return Constant.ERR;
		}
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
