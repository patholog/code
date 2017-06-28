package com.pathology.action;

import java.util.Map;

import com.opensymphony.xwork2.Action;

public class EmailAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	private Map<String, String> p;

	// public Map<String, String> getP() {
	// return this.p;
	// }

	public void setP(Map<String, String> p) {
		this.p = p;
	}

	public String checkEmail() {
		String email = this.p.get("email");
		if (email.equals("fff")) {
			return Action.ERROR;
		} else {
			return Action.SUCCESS;
		}
	}

}
