<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<title>找回密码</title>
<c:set var="path" value="${pageContext.request.contextPath }" />
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="this is my page">
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<LINK rel="Shortcut icon" href="favicon.ico" />
<link rel="stylesheet" type="text/css" href="${path }/css/settings.css" />
<link rel="stylesheet" type="text/css" href="${path }/css/select.css" />
<script src="${path }/js/regist.js" type="text/javascript"></script>
<script src="${path }/js/jquery/jquery-1.4.4.min.js"
	type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function() {

		$("#email").blur(function() {
			var email = $("#email").val().trim();
			if (email == '') {
				$("#emailtip").html("<a style='color:#2ca9cc;font-size:14px;'>邮箱不能为空！</a>");
				$("#btn").attr("disabled",false);
				return false;
			}else{
				$("#emailtip").html("");
				return true;
			} 
		});
		
		$("#verification").blur(function() {
			var a=document.getElementById("getverification").value;
			var b=document.getElementById("email").value;
			$.ajax({
					type : "post",
					url : 'email_checkVerification',
					contentType : "application/json; charset=utf-8",
					data : JSON.stringify({//设置数据源
						p : {
							verification : a,
							email : b
						}
					}),
					dataType : "json",//设置需要返回的数据类型
					success : function(d) {
						$("#verificationtip").html("");
						return true;
					},
					error : function(d) {
						$("#verificationtip").html("<a style='color:#2ca9cc;font-size:14px;'>验证失败！</a>");
						return false;
					}
				});
		});

		$("#getverification").click(function() {
			var a=document.getElementById("email").value;
			$.ajax({
					type : "post",
					url : 'email_sendEmailForPassWord',
					contentType : "application/json; charset=utf-8",
					data : JSON.stringify({//设置数据源
						p : {
							getemail : a
						}
					}),
					dataType : "json",//设置需要返回的数据类型
					success : function(d) {
						alert("验证码发送成功,请注意查收");
					},
					error : function(d) {
						alert("验证码发送失败");
					}
				});
		});
	});
</script>


</head>
<body>
	<div id="3" style="position: relative;  z-index: 3;">
		<form id="f1" action="UserAction!updateUser"  method="post"
			enctype="multipart/form-data">
			<table align="center" cellspacing="0" class="registtb">
				<tr class="thead">
					<td align="center">找回密码</td>
				</tr>
				<tr>
					<td>
						<table id="registertable" border="0px" align="center" border="0px"
							cellspacing="0" cellpadding="5px">
							<tr>
							<tr>
								<td align="right">用户名：</td>
								<td align="left"><input id="username" type="text" name="user.username"
									placeholder="用户名" required /><span
									id="nametip"></span></td>
							</tr>
							<tr>
								<td align="right">邮 箱：</td>
								<td align="left"><input type="email" name="user.email"
									placeholder="邮箱" id="email" required /><span id="emailtip"></span>
								</td>
							</tr>
							
							<tr>
								<td align="right">验证码：</td>
								<td align="left">
								<input type="text" name="user.verification"
									placeholder="验证码" id="verification" required />
									<input id="getverification" type="button"  name="getverification"  value="获取验证码" />
									<span id="verificationtip"></span>
								</td>
							</tr>
							
							<tr>
								<td align="right">密 码：</td>
								<td align="left"><input type="password"
									name="user.password" id="password" placeholder="密码" required
									onkeyup="passwd()" /> <span id="pwsdtip"></span></td>
							</tr>
							<tr>
								<td align="right">密码确认：</td>
								<td align="left"><input type="password" name="password2"
									placeholder="确认密码" id="password2" required /><span
									id="pwsd2tip"></span></td>
							</tr>


							<tr height="60px">
								<td align="center" colspan="2"><input type="submit"
									accesskey="enter" value="确定" id="btn"
									 class="submit"
									formmethod="post" disabled="disabled" /></td>
							</tr>
						</table></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
