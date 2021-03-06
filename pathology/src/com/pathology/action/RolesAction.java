package com.pathology.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.pathology.entity.Roles;
import com.pathology.service.IRolesService;
import com.pathology.util.Constant;
import com.pathology.util.RandomNumbers;
import com.pathology.util.SessionAgentManager;

public class RolesAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	private final Logger logger = Logger.getLogger(RolesAction.class);
	private IRolesService rolesservice;
	private String idRoles;
	private HttpServletRequest request;

	private Roles roles;
	private List<Roles> roleslist;
	private int index;
	private String function;

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	/**
	 * 新增角色
	 * 
	 * @return
	 * @throws Exception
	 */
	public String addRoles() throws Exception {
		try {

			if (!SessionAgentManager.islogin())
				return Constant.ERR;

			roles.setIdRoles(RandomNumbers.getRandomId());
			rolesservice.addRoles(roles, function);

			return "updatesuccess";
		} catch (Exception e) {
			logger.error(e.getMessage());
			return Constant.ERR;
		}
	}

	/**
	 * 获取所有角色
	 * 
	 * @return
	 */
	public String rolesList() {
		try {

			if (!SessionAgentManager.islogin())
				return Constant.ERR;
			HttpServletRequest request = ServletActionContext.getRequest();
			String managerolesname = request.getParameter("managerolesname");
			String hql = "";

			if (managerolesname != null){
				hql += " and name like '%" + managerolesname + "%'";
				request.setAttribute("managerolesname",managerolesname);
			}
			
			List<Roles> list = index != 0 ? rolesservice.getByPage(index,
					Roles.class, hql) : rolesservice.getByPage(1, Roles.class,
					hql);

			HttpSession session = ServletActionContext.getRequest()
					.getSession();
			session.setAttribute("roleslist", list);
			session.setAttribute("thisindex", index == 0 ? 1 : index);
			int size = rolesservice.getAllRoles(Roles.class, hql).size();
			session.setAttribute("count", size);

			int pageCount = 0;
			if (size % 10 > 0) {
				pageCount = size / 10 + 1;
			} else {
				pageCount = size / 10;
			}

			session.setAttribute("pageCount", pageCount);
			return SUCCESS;
		} catch (Exception e) {
			logger.error(e.getMessage());
			return Constant.ERR;
		}
	}

	/**
	 * 编辑角色
	 * 
	 * @return
	 * @throws IOException
	 */
	public String updateRoles() throws IOException {
		try {

			if (!SessionAgentManager.islogin())
				return Constant.ERR;
			Boolean result = rolesservice.findRoles(roles.getIdRoles());
			if (result) {
				return "edit";
			} else {
				return Constant.ERR;
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			return Constant.ERR;
		}
	}

	/**
	 * 编辑保存
	 * 
	 * @return
	 * @throws IOException
	 */
	public String saveRoles() throws IOException {
		try {

			if (!SessionAgentManager.islogin())
				return Constant.ERR;
			Roles rolesT = rolesservice.getRoles(Roles.class,
					roles.getIdRoles());
			rolesT.setName(roles.getName());
			rolesT.setDescription(roles.getDescription());
			rolesT.setMemo(roles.getMemo());
			rolesservice.updateRoles(rolesT, function);
			return "updatesuccess";
		} catch (Exception e) {
			logger.error(e.getMessage());
			return Constant.ERR;
		}
	}

	/**
	 * 删除角色
	 * 
	 * @return
	 */
	public String deleteRoles() {
		try {

			if (!SessionAgentManager.islogin())
				return Constant.ERR;

			Roles hos = rolesservice.getRoles(Roles.class, roles.getIdRoles());
			rolesservice.deleteRoles(hos);
			return "deletesuccess";
		} catch (Exception e) {
			logger.error(e.getMessage());
			return Constant.ERR;
		}
	}

	/**
	 * 所有角色
	 * 
	 * @return
	 */
	public String allRoles() {
		try {

			if (!SessionAgentManager.islogin())
				return Constant.ERR;

			List<Roles> list = rolesservice.getAllRoles(Roles.class, "");
			HttpSession session = ServletActionContext.getRequest()
					.getSession();
			session.setAttribute("roleslist", list);
			return "regist";
		} catch (Exception e) {
			logger.error(e.getMessage());
			return Constant.ERR;
		}
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public IRolesService getRolesservice() {
		return rolesservice;
	}

	public void setRolesservice(IRolesService rolesservice) {
		this.rolesservice = rolesservice;
	}

	public String getIdRoles() {
		return idRoles;
	}

	public void setIdRoles(String idRoles) {
		this.idRoles = idRoles;
	}

	public Roles getRoles() {
		return roles;
	}

	public void setRoles(Roles roles) {
		this.roles = roles;
	}

	public List<Roles> getRoleslist() {
		return roleslist;
	}

	public void setRoleslist(List<Roles> roleslist) {
		this.roleslist = roleslist;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

}
