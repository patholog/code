<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<title>病例管理系统-后台登录</title>
<script type="text/javascript">
	function login() {
		var name = document.getElementById("name").value;
		var pswd = document.getElementById("pswd").value;
		if (name == "" || pswd == "") {
			alert("账号密码为空！");
		} else {
			if (name == "admin" && pswd == "admin") {
				//alert(window.location.href);
			 
				var f = window.location.href;
				f = f.substr(0, f.lastIndexOf('/'));
				window.open(f + "/manage.jsp",'_self');
			} else {
				alert("账号密码错误！");
			}
		}
	}
</script>
<style type="text/css">
<!--
#Layer1 {
	position: absolute;
	margin-left: 380px;
	margin-top: 230px;
	z-index: 1;
}

input[type="text"] {
	width: 250px;
	height: 35px;
}

input[type="password"] {
	width: 250px;
	height: 35px;
}

.STYLE6 {
	font-size: 14px
}
/*设定层的阴影效果*/
.shadow {
	filter: progid:DXImageTransform.Microsoft.Shadow(color='#7d7d7d',
		Direction=150, Strength=10 );
	background-color: #dae6f4;
	-moz-box-shadow: 2px 2px 5px #7d7d7d;
	-webkit-box-shadow: 2px 2px 5px #7d7d7d;
	box-shadow: 2px 2px 5px #7d7d7d;
}
-->
</style>
</head>
<c:set var="path" value="${pageContext.request.contextPath}" />
<body>

	<div id="behind" class="shadow"
		style="text-align:center;
	margin:0 auto;
	z-index:1;
	width:1000px;
	height:500px;
	background:url(${path }/images/blogin.jpg);
	background-repeat:no-repeat;">
		<div
			style="color:red; position:absolute;
	margin-left:380px;
	margin-top:230px;
	z-index:1;">
			<STRONG><s:fielderror /> </STRONG>
		</div>
		<div id="Layer1">
			<form style="height:250px;width:480px;" method="post" action="UserAction!manageLogin">
				<table width="441" height="110" border="0" cellpadding="0"
					cellspacing="0">

					<tr height="55px">

						<td align="left" valign="middle"><input id="name" type="text"
							name="user.username"
							style="border-color:#00CCFF;width:180px;height:30px;padding-top:3px;" />
						</td>
					</tr>
					<tr>
						<td align="left" valign="middle"><input id="pswd"
							type="password" name="user.password"
							style="border-color:#00CCFF;width:180px;height:30px;padding-top:3px;" />
						</td>
					</tr>
					<tr>
						<td height="50" colspan="2" align="left" valign="middle"><input
							  type="submit" name="Submit" id="Submit"  value="提  交"
							style="height:30;width:80;background-image: ${path}/images/dl.jpg" />&nbsp;&nbsp;
							<input name="reset" type="reset" value="重  置"
							style="height:30;width:80" />&nbsp;&nbsp;</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>
