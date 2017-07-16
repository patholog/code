package com.pathology.action;

import com.pathology.dto.PathologyDTO;
import com.pathology.entity.Pathology;
import com.pathology.service.IPathologyService;
import net.sf.json.JSONObject;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class PathologyAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IPathologyService pathologyService;
	private List<PathologyDTO> pathologys;
	private PathologyDTO pathology;

	/**
	 * 保存病理
	 * 
	 * @param pathologgyjson
	 * @return
	 */
	public Pathology savePathology(String pathologgyjson) {
		JSONObject obj = JSONObject.fromObject(pathologgyjson);// 将json字符串转换为json对象
		// 将json对象转换为java对象
		Pathology jb = (Pathology) JSONObject.toBean(obj, Pathology.class);// 将建json对象转换为Person对象
		pathologyService.addPathology(jb);
		return jb;
	}

	/**
	 * 待诊断
	 * 
	 * @return
	 */
	public String getPathologyListToNeed() {
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			pathologys = pathologyService.getListPathologyToNeed(request, "");
			return "pathologysneed";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "pathologysneed";
	}

	/**
	 * 查看待诊断
	 * 
	 * @return
	 */
	public String daizhenduan() {
		HttpServletRequest request = ServletActionContext.getRequest();
		pathology = pathologyService.getPathologyToNeed(request,
				request.getParameter("id"));
		return "daizhenduan";
	}

	public String getPathologyListToHas() {
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			pathologys = pathologyService.getListPathologyToHas(request, "");
			return "pathologyshas";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "pathologyshas";
	}

	public String getPathologyListToBack() {
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			pathologys = pathologyService.getListPathologyToBack(request, "");
			return "pathologysback";
		} catch (Exception e) {
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

	public PathologyDTO getPathology() {
		return pathology;
	}

	public void setPathology(PathologyDTO pathology) {
		this.pathology = pathology;
	}
}
