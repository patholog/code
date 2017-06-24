package com.pathology.util;


import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class FilterEncoding implements Filter{

	
	protected FilterConfig fc;
	  protected String encoding;
	  protected boolean use = true;

	  /* 初始化
	   * 
	   */
	  @Override
	  public void init(FilterConfig filterConfig) throws ServletException {
	    this.fc = filterConfig;
	    this.encoding = filterConfig.getInitParameter("encoding");
	    String value = filterConfig.getInitParameter("use");
	    if(value == null){
	    	this.use = true;
	     }else if(value.equalsIgnoreCase("true")){
	    	 this.use = true;
	      }else if(value.equalsIgnoreCase("yes")) {		
	    	  this.use = true;
	      }else{
	    	  this.use = false;
	    }
	    
	  }

	  /* 过滤过程
	   * 
	   */
	 // @Override
	  public void doFilter(ServletRequest request, ServletResponse response,
	      FilterChain filterChain) throws IOException, ServletException {
	    if(use || encoding == null) {
	       String encoding = selectEncoding(request);
	       // System.out.println("encoding=1="+encoding);
	       if(encoding != null){
	    	   request.setCharacterEncoding(encoding);
	    	 
	       }
	      }
	    filterChain.doFilter(request, response);
	  }

	  /* 释放
	   * 
	   */
	  @Override
	  public void destroy() {
	    fc = null;
	    encoding = null;
	  }
	  
	 public String selectEncoding(ServletRequest request){
		 return (this.encoding);
	 }

}
