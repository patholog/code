<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<meta name="Copyright" content="Douco Design." />
<link href="css/public.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/global.js"></script>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'daizhenduanlist.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <div id="dcHead">
 <div id="head">
  <div class="logo"><a href="index.html"><img src="images/bllogo.jpg" alt="logo"></a></div>
  <div class="nav">
   <ul class="navRight">
    <li class="M noLeft"><a href="JavaScript:void(0);">您好，admin</a>
     <div class="drop mUser">
      <a href="http://www.w3school.com.cn">账号设置</a>
      <a href="http://www.w3school.com.cn">状态设置</a>
      <a href="http://www.w3school.com.cn">签名设置</a>
      <a href="http://www.w3school.com.cn">问题反馈</a>
      <a href="http://www.w3school.com.cn">修改密码</a>
      <a href="http://www.w3school.com.cn">使用帮助</a>
      <a href="http://www.w3school.com.cn">退出登录</a>
     </div>
    </li>
   </ul>
  </div>
 </div>
</div>
<!-- dcHead 结束 --> 

<div id="dcLeft">
	<div id="menu">
		 <ul>
		  <li><a href="daizhenduanlist.jsp"><i class="articleCat"></i><em>待诊断</em></a></li>
		  <li><a href="http://www.jq22.com/jquery-info4155" target="_blank"><i class="page"></i><em>已诊断</em></a></li>
		  <li><a href="http://blog.csdn.net/shaobingj126/article/details/23676759/" target="_blank"><i class="article"></i><em>退回病例</em></a></li>
		  <li><a href="http://blog.csdn.net/shaobingj126/article/details/23676759/" target="_blank"><i class="productCat"></i><em>收藏病例</em></a></li>
		  <li><a href="http://blog.csdn.net/shaobingj126/article/details/23676759/" target="_blank"><i class="show"></i><em>留言列表</em></a></li>
		  <li><a href="http://blog.csdn.net/shaobingj126/article/details/23676759/" target="_blank"><i class="theme"></i><em>诊断报表</em></a></li>
		  <li><a href="http://blog.csdn.net/shaobingj126/article/details/23676759/" target="_blank"><i class="manager"></i><em>会议列表</em></a></li>
		  <li><a href="http://blog.csdn.net/shaobingj126/article/details/23676759/" target="_blank"><i class="nav"></i><em>病例分享</em></a></li>
		 </ul>
	</div>
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
          <th width="15%">申请日期</th>
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
