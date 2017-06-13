<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<meta name="Copyright" content="Douco Design." />
<link href="css/public.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/global.js"></script>
  </head>
  
  <body>
    <div id="dcHead">
	<%@include file="/manage/managetop.jsp"%>
	</div>
<!-- dcHead 结束 --> 

<div id="dcLeft">
 <%@include file="/manage/manageleft.jsp"%>
</div>
 <div id="dcMain"> <!-- 当前位置 -->

 <div id="index" class="mainBox" style="padding-top:18px;height:auto!important;height:550px;min-height:550px;">
    <table width="100%" border="0" cellspacing="0" cellpadding="7" class="tableBasic">
         <tr>
          <th width="10%">用户名称</th>
          <th width="10%">性别</th>
          <th width="15%">邮箱</th>
          <th width="20%">所属医院</th>
          <th width="10%">特长</th>
          <th width="15%">手机</th>
          <th width="10%">电话</th>
          <th width="10%">操作</th>
         </tr>
              <c:forEach var="user" items="${userList}">
                <tr align="center">
                
                <td >${user.username}</td>
                <td >${user.sex}</td>
                <td >${user.email }</td>
                <td >${user.belonghospital }</td>
                <td >${user.specialty }</td>
                <td >${user.mobile }</td>
                <td >${user.tel }</td>
                <td ><a href="http://localhost:8080/pathology/admin_delUser?userId=${user.idUsers }"><input type="button" value="删除" /></a></td>
                
                 
                </tr>
               </c:forEach>
     </table>
    
  </div>
 </div>


</body>
  </body>
</html>
