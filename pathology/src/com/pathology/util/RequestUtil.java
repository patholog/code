package com.pathology.util;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.pathology.entity.Function;

public class RequestUtil {
  
	/**  
	 * 获取requeat
	 * @return
	 */
	public static HttpServletRequest getRequest(){
		 HttpServletRequest request =ServletActionContext.getRequest();
		 try {
			 request.setCharacterEncoding("utf-8");
			return request;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return request;
	}
	
 
	
	/**
	 * 获取response
	 * @return
	 */
	public static HttpServletResponse getResponse(){
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("text/html;charset=utf-8");
		return response;
	}
}
