<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
 <base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>病理平台管理中心 v1.0</title>
<meta name="Copyright" content="Douco Design." />
<link href="css/public.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/global.js"></script>

</head>
<body>
<div id="dcHead">
<%@include file="managetop.jsp"%>
</div>
<!-- dcHead 结束 --> 

<div id="dcLeft">
	<%@include file="manageleft.jsp"%>
</div>
 <div id="dcMain"> <!-- 当前位置 -->
 <div id="index" class="mainBox" style="padding-top:18px;height:auto!important;height:550px;min-height:550px;">

     <h5>欢迎使用</h5>
  </div>

 </div>


</body>
</html>