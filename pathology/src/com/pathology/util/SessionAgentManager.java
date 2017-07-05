package com.pathology.util;

import java.util.Map;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionContext;
import com.pathology.entity.Users;

/**
 * session 管理
 * @author lizheng
 *
 */
public class SessionAgentManager {

	
	private final static Logger logger = Logger.getLogger(SessionAgentManager.class);

	/**
	 * 禁止构造
	 *
	 */
	private SessionAgentManager(){
		
	}

	/**
	 * 写入session
	 * @param session
	 * @param loginAgentBean
	 * @return
	 */
	public static void setSessionAgentBean(Users users, String admin ){
		
		if(admin != null &&admin.equals("admin")){
			 
			//System.out.println("dddddddddd");
			ActionContext.getContext().getSession().put("users", users);
		}else{
			//System.out.println("xxxxxxxxxxxxxxx");
			ActionContext.getContext().getSession().put("users", users);
		}
		
		//System.out.println("seession =1="+session.getId());
	}

	/**
	 * 从Session中获取当前登陆的信息
	 * @return 当前登陆的信息,如果为空表示没有登陆
	 */
	public static Users getSessionAgentBean(){
	   Map<String,Object> session = ActionContext.getContext().getSession();
	   return (Users)session.get("users"); 
		}
    
	
/**
 * 
 * @return
 */
  public static  boolean islogin(){
	  try{
	  Map<String,Object> session = ActionContext.getContext().getSession();
	    Users user =  (Users)session.get("users"); 
	    if(user != null && user.getUsername() != null){
	    	return true;
	    }else{
	    	return false;
	    }
	  }catch(Exception e){
		  return false;
	  }
  }

	/**
	 *  退出销毁session
	 * @return 
	 * @return 
	 */
	/*public static void DestroySessionAgentBean(, String flag ){
		  System.out.println("注销--------");
		  if(  flag !=null && flag.equals("9")){
			  session.removeAttribute("moniBean");
			  //System.out.println("注销-----moniBean---");
			  logger.info("DestroySessionAgentBean:注销-----moniBean---");
		  }else{
			  session.removeAttribute("adminBean");
			  //System.out.println("注销-----adminBean---");
			  logger.info("DestroySessionAgentBean:注销-----adminBean---");
		  } 
//		  session.removeAttribute("adminBean1");
//		  session.invalidate();
	}*/
	
	
	
	/*public static void setSessionMember(HttpSession session,MemberBean memberBean){
		  System.out.println("memberBean-----会员登陆---");
			session.setAttribute("memberBean",memberBean);
		//System.out.println("seession =1="+session.getId());
	}
	*/
	
/*	public static MemberBean getSessionMember( HttpSession session ){
		   return (MemberBean)session.getAttribute("memberBean");
	}
 */
	
//	public static void DestroySessionMember(HttpSession session){
//		      System.out.println("memberBean-----注销---");
//			  session.removeAttribute("memberBean");
//			  logger.info("DestroySessionMember:注销-----memberBean---");
//		  } 
//		  session.removeAttribute("adminBean1");
//		  session.invalidate();
}
