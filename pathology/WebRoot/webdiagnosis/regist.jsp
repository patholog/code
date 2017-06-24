<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<title>用户注册</title>
<c:set var="path" value="${pageContext.request.contextPath }" />
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="this is my page">
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<LINK rel="Shortcut icon" href="favicon.ico" />
<link rel="stylesheet" type="text/css" href="${path }/css/settings.css" />
<script src="${path }/js/regist.js" type="text/javascript"></script>
<script type="text/javascript">
	function play() {
		document.getElementById("menu_item").style.display = "";
	}
	function noplay() {
		document.getElementById("menu_item").style.display = "none";
	}
	function passwd() {
		var pass = document.getElementById("password").value;
		var tip = document.getElementById("tip");
		if (pass.length < 4) {
			document.getElementById("meter").value = pass.length;
			tip.innerHTML = "差";
		} else if (pass.length <= 8) {
			document.getElementById("meter").value = pass.length;
			tip.innerHTML = "中";
		} else {
			document.getElementById("meter").value = pass.length;
			tip.innerHTML = "高";
		}
	}
</script>
</head>
<body>
	<div id="3" style="position: relative; top: 100px; z-index: 3;">
		<form id="f1" action="UserAction!registUser" method="post">
			<table align="center" cellspacing="0" class="registtb">
				<tr class="thead">
					<td align="center">用户注册</td>
				</tr>
				<tr>
					<td>
						<table id="registertable" border="0px" align="center" border="0px"
							cellspacing="0" cellpadding="5px">
							<tr>
							<tr>
								<td align="right">用户名：</td>
								<td align="left"><input type="text" name="user.username"
									placeholder="用户名" required /></td>
							</tr>
							<tr>
								<td align="right">密 码：</td>
								<td align="left"><input type="password" name="user.password"
									id="password" placeholder="密码" required onkeyup="passwd()" /> 
									<span id="tip"></span></td>
							</tr>
							<tr>
								<td align="right">密码确认：</td>
								<td align="left"><input type="password" name="password2"
									placeholder="确认密码" required /></td>
							</tr>
							<td align="right">邮 箱：</td>
							<td align="left"><input type="email" name="user.email"
								placeholder="邮箱" id="email" required /></td>
							</tr>
							<tr>
								<td align="right">医师资格证：</td>
								<td align="left"><input name="photo" class="file" type="file" id="f"
									accept="image/jpeg" onchange="show()" />
								</td>
							<tr>
								<td></td>
								<td align="left"><span><img id="img" src=""
										width="200" height="200" />
								</span></td>
								<script>
									function show() {
										var file = document.getElementById("f").files[0];
										var fileReader = new FileReader();
										fileReader.readAsDataURL(file);
										fileReader.onload = function() {
											document.getElementById("img").src = fileReader.result;
										}
									}
								</script>
								</td>
							</tr>
							<tr>
								<td colspan="2"></td>
							</tr>

							<tr height="60px">
								<td align="center" colspan="2"><input
									type="submit" accesskey="enter" value="注册" id="btn"
									onmousemove="changeBgColor('btn')"
									onmouseout="recoverBgColor('btn');" class="submit"
									formmethod="post" /></td>
							</tr>
						</table></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
