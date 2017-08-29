<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<title>新增用户</title>
<c:set var="path" value="${pageContext.request.contextPath }" />
<link rel="stylesheet" type="text/css" href="${path }/css/style.css" />
<script type="text/javascript" src="${path }/js/passwordcheck.js"></script>
<script type="text/javascript" src="${path }/js/treeView.js"></script>
<script type="text/javascript" src="${path }/js/common-cn.js"></script>
<script type="text/javascript" src="${path }/js/forbid-refresh.js"></script>
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
		$("#specialty").blur(function() {
			var spe = $("#specialty").val().trim();
			if(spe.length>200){
				$("#specialtytip").html("<a style='color:#2ca9cc;font-size:14px;'>录入超长!</a>");
				$("#btn").attr("disabled",true);
				return false;
			}else{
				$("#specialtytip").html("");
				$("#btn").attr("disabled",false);
				return true;
			}
		});
		

	});
</script>
<script type="text/javascript">
	$(function() {
		$(".ta tr").each(function(i) {
			this.style.backgroundColor = [ '#799AE1', '#D6DFF7' ][i % 2]
		});

		$(".ta tr").mouseover(function() {//如果鼠标移到class为stripe的表格的tr上时，执行函数
			$(this).addClass("mousehover");
		}).mouseout(function() {//给这行添加class值为over，并且当鼠标一出该行时执行函数
			$(this).removeClass("mousehover");
		}); //移除该行的class
	});
</script>
<script type="text/javascript">  
function resetForm()  
{  
document.getElementById("articles").reset()  
}  
</script>  
</head>
<div id="header">
	<%@include file="/manage/managetop.jsp"%>
</div>
<!-- dcHead 结束 -->
<table id="main" cellpadding="0" cellspacing="0" border="0">
	<tr>
		<td id="leftmenu"><%@include file="/manage/manageleft.jsp"%>
		</td>
		<td id="contents">

			<table id="pagehead" cellspacing="0" cellpadding="0" width="100%"
				border="0">
				<tr>
					<td><h1>用户信息</h1>
					</td>
				</tr>
			</table>

			<form name="articles" id="articles" method="post"
				action="UserAction!registUser">
				<table class="maintable form_top_thin">
					<tr>
						<th>用户名</th>
						<td><input type="text" name="user.username" id="username"
							value="" style="width:300px;" required /> <span id="nametip"></span>
						</td>
					</tr>
					<tr>
						<th>密码</th>
						<td><input type="password" name="user.password" id="password"
							value="" style="width:300px;" required onKeyUp=pwStrength(this.value) onBlur=pwStrength(this.value)/> <span id="pwsdtip">
								<div id="strength_H" class="pwdcheck"></div>
								<div id="strength_M" class="pwdcheck"></div>
								<div id="strength_L" class="pwdcheck"></div>
						</span></td>
					</tr>
					<tr>
						<th>电子邮箱</th>
						<td><input type="email" name="user.email" id="email" value=""
							style="width:300px;" required /><span id="emailtip"></span></td>
					</tr>
					<tr>
						<th>真实姓名</th>
						<td><input type="text" name="user.realname" id="realname"
							value="" style="width:300px;" />
						</td>
					</tr>
					<tr>
						<th>性别</th>
						<td><input type="radio" name="user.sex" value="男" /> 男
							&nbsp;&nbsp; <input type="radio" name="user.sex" value="女" /> 女
						</td>
					</tr>
					<tr>
						<th>联系电话</th>
						<td><input type="text" name="user.mobile" id="mobile"
							value="" style="width:300px;" /></td>
					</tr>
					<tr>
						<th>特长</th>
						<td><input type="text" name="user.specialty" id="specialty"
							value="" style="width:300px;" /><span id="specialtytip"></span></td>
					</tr>
				</table>
				<table width="60%" align="center" border="0">
					<tr>
						<td class="buttons"><input type="submit" name="Submit"
							id="Submit" value="提交" /> <input type="button" name="Reset"
							id="Reset" value="重置" onclick="resetForm()" /></td>
					</tr>
				</table>
				<input type="hidden" name="id" value="" />
			</form></td>
	</tr>
</table>
</html>