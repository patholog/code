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

	public String addRoles() throws Exception {
		try {

			if (!SessionAgentManager.islogin())
				return Constant.ERR;
			roles.setIdRoles(getEandomId(16));
			rolesservice.addRoles(roles);

			return "updatesuccess";
		} catch (Exception e) {
			logger.error(e.getMessage());
			return Constant.ERR;
		}
	}

	public String rolesList() {
		try {

			if (!SessionAgentManager.islogin())
				return Constant.ERR;
			String hql = "";
			if (roles != null) {
				String rolesname = null;
				try {
					rolesname = new String(
							(roles.getName().getBytes("ISO8859-1")), "UTF-8");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}

				if (rolesname != null && !("".equals(rolesname)))
					hql += " and name like '%" + rolesname + "%'";

			}

			List<Roles> list = index != 0 ? rolesservice.getByPage(index,
					Roles.class, hql) : rolesservice.getByPage(1, Roles.class,
					hql);

			HttpSession session = ServletActionContext.getRequest()
					.getSession();
			session.setAttribute("roleslist", list);
			session.setAttribute("thisindex", index == 0 ? 1 : index);

			session.setAttribute("count",
					rolesservice.getAllRoles(Roles.class, hql).size());
			return SUCCESS;
		} catch (Exception e) {
			logger.error(e.getMessage());
			return Constant.ERR;
		}
	}

	public String updateRoles() throws IOException {
		try {

			if (!SessionAgentManager.islogin())
				return Constant.ERR;
			HttpSession session = ServletActionContext.getRequest()
					.getSession();
			Roles hospitalT = rolesservice.getRoles(Roles.class,
					roles.getIdRoles());
			session.setAttribute("roles", hospitalT);
			return "edit";
		} catch (Exception e) {
			logger.error(e.getMessage());
			return Constant.ERR;
		}
	}

	public String saveRoles() throws IOException {
		try {

			if (!SessionAgentManager.islogin())
				return Constant.ERR;

			rolesservice.updateRoles(roles);
			return "updatesuccess";
		} catch (Exception e) {
			logger.error(e.getMessage());
			return Constant.ERR;
		}
	}

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
