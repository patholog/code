package com.pathology.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.opensymphony.xwork2.Action;
import com.pathology.entity.Function;
import com.pathology.entity.Roles;
import com.pathology.entity.Users;
import com.pathology.service.IFunctionService;
import com.pathology.service.IRolesService;
import com.pathology.service.IUsersService;
import com.pathology.util.Constant;
import com.pathology.util.DigestMD5;
import com.pathology.util.RequestUtil;
import com.pathology.util.SessionAgentManager;

public class LoginAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	  private String basicCountSql = "SELECT count(1) FROM pathology a "
		      + " LEFT JOIN result  c ON a.id_case = c.case_id"
		      + " LEFT JOIN hospital  d ON a.hospitalcode = d.id_hospital"
		      + " LEFT JOIN COLLECTION E ON A.ID_CASE=E.CASE_ID AND A.ID_DOCTOR=E.ID_DOCTOR";
	public Users user;
	private JdbcTemplate jdbcTemplate;
	public IUsersService userservice;
	public IRolesService rolesservice;
	public IFunctionService functionservice;
	  public JdbcTemplate getJdbcTemplate() {
		    return jdbcTemplate;
		  }

		  public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		    this.jdbcTemplate = jdbcTemplate;
		  }
	public IUsersService getUserservice() {
		return userservice;
	}

	public void setUserservice(IUsersService userservice) {
		this.userservice = userservice;
	}

	public IRolesService getRolesservice() {
		return rolesservice;
	}

	public void setRolesservice(IRolesService rolesservice) {
		this.rolesservice = rolesservice;
	}

	public IFunctionService getFunctionservice() {
		return functionservice;
	}

	public void setFunctionservice(IFunctionService functionservice) {
		this.functionservice = functionservice;
	}

	public Users getUser() {
		return user;
	}

	private String msg;

	public String getMsg() {
		return msg;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public String login() {
		try {
			Users u = SessionAgentManager.getSessionAgentBean();
			if(u!=null) {
				HttpServletRequest request = ServletActionContext.getRequest();
				getFirstPage(request,u.getIdUsers());
				return "loginSuccess";
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		try {
			String hql = " and s.userstatus='1' and  s.username='"
					+ user.getUsername() + "' and s.password='"
					+ DigestMD5.getDigestPassWord(user.getPassword()) + "'";
			// String hql = " and  s.username='" + user.getUsername()
			// + "' and s.password='" + user.getPassword() + "'";
			List<Users> userT = userservice.getAllUser(Users.class, hql);

			if (userT != null && userT.size() == 1) {
				user = userT.get(0);
				Roles role = rolesservice.getRoles(Roles.class,
						user.getRoleId());
				user.setRoleName(role.getName());
				List<Function> functionlist = functionservice
						.getFunctionList(user.getRoleId());
				SessionAgentManager.setSessionAgentFunctionList("functionList",
						functionlist);
				SessionAgentManager.setSessionAgentBean(user, "admin");
				HttpServletRequest request = ServletActionContext.getRequest();
				getFirstPage(request,user.getIdUsers());
				return "loginSuccess";
			} else {
				return "err";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "err";
		}
	}

	/**
	 * 退出登录
	 * 
	 * @return
	 */
	public String LoginOut() {
		try {
			SessionAgentManager.DestroySessionMember();
			/*
			 * if (u.getUsername().equals("ll")) { this.msg = "成功"; } else {
			 * this.msg = "失败"; }
			 */
			return Action.SUCCESS;
		} catch (Exception e) {

		}
		return Constant.ERR;
	}
	  public void getFirstPage(HttpServletRequest request, String name) {
		  	// TODO Auto-generated method stub
			 // int needcount=0;
//			  int hascount=0;
//			  int backcount=0;
		      String needcountSql = basicCountSql + " WHERE a.diag_status='2' and ifnull(a.id_doctor,'" + name + "')='" + name + "'";
		      String hascountSql = basicCountSql + " WHERE a.diag_status='7' and a.id_doctor='" + name + "'";
		      String callcountSql = basicCountSql + " WHERE a.diag_status='3' and a.LAST_UPD_USER_ID='" + name +  "'";
		      int needcount = jdbcTemplate.queryForInt(needcountSql);
		      int hascount = jdbcTemplate.queryForInt(hascountSql);
			  int backcount = jdbcTemplate.queryForInt(callcountSql);
			  request.setAttribute("needcount", needcount);
			  request.setAttribute("hascount", hascount);
			  request.setAttribute("backcount", backcount);
		  }
}
