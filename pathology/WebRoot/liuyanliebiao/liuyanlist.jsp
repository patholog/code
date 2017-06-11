<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>留言列表</title>
    
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
	<%@include file="/maintop.jsp"%>
	</div>
<!-- dcHead 结束 --> 

<div id="dcLeft">
 <%@include file="/mainleft.jsp"%>
</div>
 <div id="dcMain"> <!-- 当前位置 -->

 <div id="index" class="mainBox" style="padding-top:18px;height:auto!important;height:550px;min-height:550px;">
    <table width="100%" border="0" cellspacing="0" cellpadding="7" class="tableBasic">
         <tr>
         <th width="10%">序号</th>
          <th width="10%">病理号</th>
          <th width="10%">病人姓名</th>
          <th width="10%">留言人</th>
          <th width="20%">送检单位</th>
          <th width="10%">留言状态</th>
          <th width="15%">柳岩时间</th>
          <th width="10%">操作</th>
         </tr>
         <tr>
          <td align="center">1</td>
          <td align="center">132142</td>
          <td align="center">齐离</td>
          <td align="center">袁主任</td>
          <td align="center">普通你赶紧转诊吧</td>
          <td align="center">已读</td>
          <td align="center">2016-02-25 23:29:08</td>
          <td align="center"><a>查看</a></td>
        </tr>
     </table>
    
  </div>
 </div>


</body>
  </body>
</html>
