<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="com.pathology.entity.Users"%>
<%@ page language="java" import="com.pathology.util.SessionAgentManager" %>
<%String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";%>
	<div class="top-thickline"><img src="${path}/css/img-blue/spacer.gif" width="5" height="5" /></div>
	<ul class="quickbar">
		<li style="float:right;">Logout </li>
		    <%
       if(SessionAgentManager.getSessionAgentBean()==null){
              %>
  <script type="text/javascript">
   	  var url = '<%=basePath%>';
   	    alert('session 超时');

      </script>
      <%
         }
         Users user=SessionAgentManager.getSessionAgentBean();
         String username=user==null?"":user.getUsername();
         %>
     
		<li style="float:right;"> <%request.getContextPath();%><%=username%></li> 
		<li style="margin-left:15px;" id="mytimer"></li>
    <script>Time();</script>
    </ul>
	<div class="title">
		<span style=" display:block; margin-top:6px">病理远程会诊平台</span>
	</div>
	<div class="clear"></div>


