<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<script src="${path}/js/jquery-1.7.1.min.js" type="text/javascript"></script>
<script src="${path}/js/login.js" type="text/javascript"></script>

<script type="text/javascript">
	var flag = false;
	function Check() {
		if(flag)
			return flag;
		var username = $("#username").val();
		var password = $("#password").val();

		if (username == '') {
			alert("用户名不能为空！");
			return false;
		} else if (password == '') {
			alert("密码不能为空！");
			return false;
		} else {
			$.ajax({
				type : "post",
				url : 'email_checkNamePsd',
				contentType : "application/json; charset=utf-8",
				data : JSON.stringify({//设置数据源
					p : {
						username : username,
						password : password
					}
				}),
				dataType : "json",//设置需要返回的数据类型
				success : function(d) {
					$.ajax({
						type : "post",
						url : 'email_checkUserIsPass',
						contentType : "application/json; charset=utf-8",
						data : JSON.stringify({//设置数据源
							p : {
								username : username
							}
						}),
						dataType : "json",//设置需要返回的数据类型
						success : function(d) {
							flag = true;
							document.getElementById('fm1').submit();
						},
						error : function(d) {
							alert("用户没有审核通过");
						}
					});
				},
				error : function(d) {
					alert("用户名或密码不对");
				}
			});
			return false;
		}
	}
</script>
<div class="event" id="login_box" style="display: none;">
	<div class="login">
		<div class="title">
			<span class="t_txt">用户登录</span> <span class="del"
				onClick="deleteLogin()">X</span>
		</div>
		<form id='fm1' action="login.action" method="post" onsubmit="return Check()">
			<input type="text" name="user.username" id="username" value=""
				placeholder="请输入用户名" /> <input type="password" name="user.password"
				id="password" value="" placeholder="请输入密码" /> <input
				type="checkbox" name="" id="rmpasswd" value="" /> <a id="rmfont">记住密码</a>
			<a href="${path}/webdiagnosis/regist/getpassword.jsp" id="forgetpwd">忘记密码</a>
			<input type="submit" id="loginBtn" value="登录" class="btn" /> <a
				id="about">关于我们</a> <a id="register"
				href="HospitalAction!allHostpital">注册</a>

		</form>
	</div>
</div>

