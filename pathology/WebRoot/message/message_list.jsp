<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>留言</title>
    
	 
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
          <th width="15%">序号</th>
          <th width="10%">病理号</th>
          <th width="10%">病人姓名</th>
          <th width="15%">留言人</th>
          <th width="10%">留言内容</th>
          <th width="10%">状态</th>
          <th width="20%">时间</th>
          <th width="15%">申请时间</th>
          <th width="10%">操作</th>
         </tr>
         <s:iterator value="messages" id="message" status="11">
         <tr>
         <td><s:property value="#message.idMessage"/></td>
          <td align="center">齐德龙</td>
          <td align="center">膝盖</td>
          <td align="center">普通</td>
          <td align="center">全科</td>
          <td align="center">齐德龙大集团</td>
          <td align="center">2016-02-25 23:29:08</td>
          <td align="center"><a href="daizhenduan" target="_blank">诊断</a></td>
        </tr>
        </s:iterator>
     </table>
    
  </div>
 </div>


</body>
  </body>
</html>
