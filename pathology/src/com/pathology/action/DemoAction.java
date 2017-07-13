package com.pathology.action;

import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.Action;

public class DemoAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	private Demo param;

	private Map<String, Object> result = new HashMap<String, Object>();

	public Map<String, Object> getResult() {
		return result;
	}

	public Demo getParam() {
		return param;
	}

	public void setParam(Demo param) {
		this.param = param;
	}

	public void setResult(Map<String, Object> result) {
		this.result = result;
	}

	public String demo() {
		if (this.param.getTest().equals("ff")) {
			this.result.put("success", 1);
			this.result.put("rt", this.param);
		} else {
			this.param.setTest_tip("验证失败");
			this.result.put("success", 0);
			this.result.put("rt", this.param);
		}
		return Action.SUCCESS;

	}
}
