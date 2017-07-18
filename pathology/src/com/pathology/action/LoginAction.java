package com.pathology.action;

import java.util.List;


import com.opensymphony.xwork2.Action;
import com.pathology.entity.Function;
import com.pathology.entity.Roles;
import com.pathology.entity.Users;
import com.pathology.service.IFunctionService;
import com.pathology.service.IRolesService;
import com.pathology.service.IUsersService;
import com.pathology.util.Constant;
import com.pathology.util.RequestUtil;
import com.pathology.util.SessionAgentManager;


public class LoginAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Users user;
	
	public IUsersService userservice;
	public IRolesService rolesservice;
	public IFunctionService functionservice;
	
	
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
		Users u = this.user;
		try {
			// String
			// hql=" and  s.username='"+user.getUsername()+"' and s.password='"+DigestMD5.getDigestPassWord(user.getPassword())+"'";
			String hql = " and  s.username='" + user.getUsername()
					+ "' and s.password='" + user.getPassword() + "'";
			List<Users> userT = userservice.getAllUser(Users.class, hql);
			
			if (userT != null && userT.size() == 1) {
				user = userT.get(0);
				Roles role = rolesservice.getRoles(Roles.class, user.getRoleId());
				user.setRoleName(role.getName());
				List<Function> functionlist = functionservice.getFunctionList(user.getRoleId());
				RequestUtil.getRequest().setAttribute("functionList", functionlist);
				SessionAgentManager.setSessionAgentBean(user, "admin");
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
	 * @return
	 */
	public String LoginOut(){
	   try{
		   SessionAgentManager.DestroySessionMember();
			/*if (u.getUsername().equals("ll")) {
				this.msg = "成功";
			} else {
				this.msg = "失败";
			}*/
			return Action.SUCCESS;
	   }catch(Exception e){
		   
	   }
		return  Constant.ERR;
	}
}
