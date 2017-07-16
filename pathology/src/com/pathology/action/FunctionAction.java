package com.pathology.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.pathology.entity.Function;
import com.pathology.service.IFunctionService;
import com.pathology.util.Constant;
import com.pathology.util.RandomNumbers;
import com.pathology.util.SessionAgentManager;

public class FunctionAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	private final Logger logger = Logger.getLogger(FunctionAction.class);
	private IFunctionService functionservice;
	private String idFunction;
	private HttpServletRequest request;

	private Function function;
	private List<Function> functionlist;
	private int index;

	public String addFunction() throws Exception {
		try {

			if (!SessionAgentManager.islogin())
				return Constant.ERR;
			function.setIdFunction(RandomNumbers.getRandomId());
			functionservice.addFunction(function);

			return "updatesuccess";
		} catch (Exception e) {
			logger.error(e.getMessage());
			return Constant.ERR;
		}
	}

	public String functionList() {
		try {

			if (!SessionAgentManager.islogin())
				return Constant.ERR;
			String hql = "";
			if (function != null) {
				String functionname = null;
				try {
					functionname = new String(
							(function.getName().getBytes("ISO8859-1")), "UTF-8");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}

				if (functionname != null && !("".equals(functionname)))
					hql += " and name like '%" + functionname + "%'";
			}

			List<Function> list = index != 0 ? functionservice.getByPage(index,
					Function.class, hql) : functionservice.getByPage(1,
					Function.class, hql);

			HttpSession session = ServletActionContext.getRequest()
					.getSession();
			session.setAttribute("functionlist", list);
			session.setAttribute("thisindex", index == 0 ? 1 : index);

			session.setAttribute("count",
					functionservice.getAllFunction(Function.class, hql).size());
			return SUCCESS;
		} catch (Exception e) {
			logger.error(e.getMessage());
			return Constant.ERR;
		}
	}

	public String updateFunction() throws IOException {
		try {

			if (!SessionAgentManager.islogin())
				return Constant.ERR;
			HttpSession session = ServletActionContext.getRequest()
					.getSession();
			Function hospitalT = functionservice.getFunction(Function.class,
					function.getIdFunction());
			session.setAttribute("function", hospitalT);
			return "edit";
		} catch (Exception e) {
			logger.error(e.getMessage());
			return Constant.ERR;
		}
	}

	public String saveFunction() throws IOException {
		try {

			if (!SessionAgentManager.islogin())
				return Constant.ERR;
			Function functionT =functionservice.getFunction(Function.class, function.getIdFunction());
			functionT.setName(function.getName());
			functionT.setUrl(function.getUrl());
			functionT.setDescription(function.getDescription());
			functionservice.updateFunction(functionT);
			return "updatesuccess";
		} catch (Exception e) {
			logger.error(e.getMessage());
			return Constant.ERR;
		}
	}

	public String deleteFunction() {
		try {

			if (!SessionAgentManager.islogin())
				return Constant.ERR;

			Function hos = functionservice.getFunction(Function.class,
					function.getIdFunction());
			functionservice.deleteFunction(hos);
			return "deletesuccess";
		} catch (Exception e) {
			logger.error(e.getMessage());
			return Constant.ERR;
		}
	}

	public String allFunction() {
		try {

			if (!SessionAgentManager.islogin())
				return Constant.ERR;

			List<Function> list = functionservice.getAllFunction(
					Function.class, "");
			HttpSession session = ServletActionContext.getRequest()
					.getSession();
			session.setAttribute("functionlist", list);
			return "addroles";
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

	public IFunctionService getFunctionservice() {
		return functionservice;
	}

	public void setFunctionservice(IFunctionService functionservice) {
		this.functionservice = functionservice;
	}

	public String getIdFunction() {
		return idFunction;
	}

	public void setIdFunction(String idFunction) {
		this.idFunction = idFunction;
	}

	public Function getFunction() {
		return function;
	}

	public void setFunction(Function function) {
		this.function = function;
	}

	public List<Function> getFunctionlist() {
		return functionlist;
	}

	public void setFunctionlist(List<Function> functionlist) {
		this.functionlist = functionlist;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

}
