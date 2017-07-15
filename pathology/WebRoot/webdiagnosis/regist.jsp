<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<title>用户注册</title>
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
				$("#btn").attr("disabled",true);
				return false;
			} else {
				//login1为Action类命名空间名称；AjaxExecute为Action方法名称
				$.ajax({
					type : "post",
					url : 'email_checkEmail',
					contentType : "application/json; charset=utf-8",
					data : JSON.stringify({//设置数据源
						p : {
							email : email
						}
					}),
					dataType : "json",//设置需要返回的数据类型
					success : function(d) {
						$("#emailtip").html("");
						$("#btn").attr("disabled",false);
						//alert("邮箱没有被注册");
					},
					error : function(d) {
						$("#emailtip").html("<a style='color:#2ca9cc;font-size:14px;'>邮箱已注册!</a>");
						$("#btn").attr("disabled",true);
					}
				});
			}

		});
		
		
		$("#username").blur(function() {
			var username = $("#username").val().trim();
			if (username == '') {
				$("#nametip").html("<a style='color:#2ca9cc;font-size:14px;'>用户名不能为空！</a>");
				$("#btn").attr("disabled",true);
				return false;
			}else if(username.length<6){
					$("#nametip").html("<a style='color:#2ca9cc;font-size:14px;'>用户名不能少于6位！</a>");
					$("#btn").attr("disabled",true);
					return false;
			}else if(username.length>20){
					$("#nametip").html("<a style='color:#2ca9cc;font-size:14px;'>用户名不能超过20位！</a>");
					$("#btn").attr("disabled",true);
					return false;
			}
			else {
				
				var zmnumReg=/^[0-9a-zA-Z]*$/;  
				if(username!=""&&!zmnumReg.test(username)){  
					$("#nametip").html("<a style='color:#2ca9cc;font-size:14px;'>只能输入字母或数字!</a>");
					$("#username").val("");
					$("#btn").attr("disabled",true);
					return false;
				}else{
			//login1为Action类命名空间名称；AjaxExecute为Action方法名称
					$.ajax({
						type : "post",
						url : 'email_checkUserName',
						contentType : "application/json; charset=utf-8",
						data : JSON.stringify({//设置数据源
							p : {
								username : username
							}
						}),
						dataType : "json",//设置需要返回的数据类型
						success : function(d) {
							$("#nametip").html("");
							$("#btn").attr("disabled",false);
						},
						error : function(d) {
							$("#nametip").html("<a style='color:#2ca9cc;font-size:14px;'>用户名已注册!</a>");
							$("#btn").attr("disabled",true);
						}
					});
				}

	}

});
		
		$("#password2").blur(function() {
			var pswd = $("#password").val().trim();
			var pswd2 = $("#password2").val().trim();
			if(pswd==pswd2){
			$("#pwsd2tip").html("");
			$("#btn").attr("disabled",false);
			return true;
			}else{
				$("#pwsd2tip").html("<a style='color:#2ca9cc;font-size:14px;'>两次密码输入不一致!</a>");
				$("#btn").attr("disabled",true);
				
				return false;
			}
		});
		$("#password").bind('input propertychange',function() {
			var pswd = $("#password").val().trim();
			if(pswd==''){
					$("#pwsdtip").html("<a style='color:#2ca9cc;font-size:14px;'>密码不能为空！</a>");
					$("#btn").attr("disabled",true);
					return false;
			}
			else if(pswd.length<6){
					$("#pwsdtip").html("<a style='color:#2ca9cc;font-size:14px;'>密码不能少于6位！</a>");
					$("#btn").attr("disabled",true);
					return false;
			}else if(username.length>16){
					$("#nametip").html("<a style='color:#2ca9cc;font-size:14px;'>用户名不能超过16位！</a>");
					$("#btn").attr("disabled",true);
					return false;
			}else{
				$("#pwsdtip").html("<div id='strength_H' class='pwdcheck'></div><div id='strength_M' class='pwdcheck'></div><div id='strength_L' class='pwdcheck'></div>");
					$("#btn").attr("disabled",false);
					return true;
			}
		});
		

	});
</script>
<script type="text/javascript">
	function Check(){
	  if(confirm('提交当前信息吗？')){
	    return true;
	  }else{
	    return false;
	  }
	}
</script>
</head>
<body>
	<div id="3" style="position: relative;  z-index: 3;">
		<form id="f1" action="UserAction!registUser" method="post"
			enctype="multipart/form-data" onsubmit="return Check()">
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
								<td align="left"><input id="username" type="text"
									name="user.username" placeholder="用户名" required /> <input
									id="belonghospital" type="hidden" name="user.belonghospital" />
									<span id="nametip"></span>
								</td>
							</tr>
							<tr>
								<td align="right">密 码：</td>
								<td align="left"><input type="password"
									name="user.password" id="password" placeholder="密码" required
									onKeyUp=pwStrength(this.value) onBlur=pwStrength(this.value) />
									<span id="pwsdtip"> 
									<div id="strength_H" class="pwdcheck"></div>
									<div id="strength_M" class="pwdcheck"></div>
									<div id="strength_L" class="pwdcheck"></div></span>
								</td>
							</tr>

							<tr>
								<td align="right">密码确认：</td>
								<td align="left"><input type="password" name="password2"
									placeholder="确认密码" id="password2" required /><span
									id="pwsd2tip">
									</span>
								</td>
							</tr>
							<tr>
								<td align="right">邮 箱：</td>
								<td align="left"><input type="email" name="user.email"
									placeholder="邮箱" id="email" required /><span id="emailtip"></span>
								</td>
							</tr>
							<tr>
								<td align="right">所属医院：</td>
								<td align="left">
									<!--  <c:forEach var="hospital" items="${hoslist}">
									<option value="${hospital.idHospital }">${hospital.name}</option>
								</c:forEach>s --> <%@include file="CheckSelect.jsp"%>
									<span id="hospital"></span>
								</td>
							</tr>
							<tr>
								<td align="right">医师资格证：</td>
								<td align="left"><input name="photo" class="file"
									type="file" id="f" accept="image/jpeg" onchange="show()"
									required /></td>
							<tr>
								<td></td>
								<td align="left"><span><img id="img" src=""
										width="200" height="200" /> </span>
								</td>
							</tr>
							<tr>
								<td colspan="2"></td>
							</tr>

							<tr height="60px">
								<td align="center"><input type="button" value="已有账号"
									id="back" onmousemove="changeBgColor('back')"
									onmouseout="recoverBgColor('back');" class="submit"
									onclick="javascrtpt:window.location.href='${path }/webdiagnosis/login.jsp'" />
								</td>
								<td align="center"><input type="submit" accesskey="enter"
									value="注册" id="btn" onmousemove="changeBgColor('btn')"
									onmouseout="recoverBgColor('btn');" class="submit"
									formmethod="post" />
								</td>

							</tr>
						</table>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<%@include file="loginbox.jsp"%>

</body>
</html>
