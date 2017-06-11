<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>医院列表</title>
    
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
          <th width="10%">病理号</th>
          <th width="10%">病人姓名</th>
          <th width="15%">材料部位</th>
          <th width="10%">病例状态</th>
          <th width="10%">系统分类</th>
          <th width="20%">送检单位</th>
          <th width="15%">申请时间</th>
          <th width="10%">操作</th>
         </tr>
         <tr>
          <td align="center">127001</td>
          <td align="center">齐德龙</td>
          <td align="center">膝盖</td>
          <td align="center">普通</td>
          <td align="center">全科</td>
          <td align="center">齐德龙大集团</td>
          <td align="center">2016-02-25 23:29:08</td>
          <td align="center"><a href="daizhenduan" target="_blank">诊断</a></td>
        </tr>
     </table>
    
  </div>
 </div>


</body>
  </body>
</html>
