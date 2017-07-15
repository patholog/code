<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="com.pathology.entity.Users"%>
<%@ page language="java" import="com.pathology.util.SessionAgentManager" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%  
		  if(SessionAgentManager.islogin()){  
		    //out.println(bean.getUsername());
		  }else{
		  %>
		  <script type="text/javascript">
	    	var url = '<%=basePath%>';
	    	  alert('session 过期请登陆');
	    	  window.parent.location=url+"login.jsp";
		      </script>
		  <%
        }
     
 %>
