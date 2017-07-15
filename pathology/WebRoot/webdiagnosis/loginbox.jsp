<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<script src="${path}/js/jquery-1.7.1.min.js" type="text/javascript"></script>
<script src="${path}/js/login.js" type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function() {

		$("#loginBtn").click(function() {
			//login1为Action类命名空间名称；AjaxExecute为Action方法名称
			$.ajax({
				type : "post",
				url : 'UserAction!login',
				contentType : "application/json; charset=utf-8",
				data : JSON.stringify({//设置数据源
					user : {
						username : 'ff',
						password : 'ff'
					}
				}),
				dataType : "json",//设置需要返回的数据类型
				success : function(d) {

					alert(JSON.stringify(d));
				},
				error : function(d) {
				}
			});
		});

	});
</script>
<div class="event" id="login_box" style="display: none;">
		<div class="login">
			<div class="title">
				<span class="t_txt">用户登录</span> <span class="del"
					onClick="deleteLogin()">X</span>
			</div>
			<form action="UserAction!login" method="post">
				<input type="text" name="user.username" id="" value=""
					placeholder="请输入用户名" /> <input type="password"
					name="user.password" id="" value="" placeholder="请输入密码" /> <input
					type="checkbox" name="" id="rmpasswd" value="" /> <a id="rmfont">记住密码</a>
				<a href="${path}/webdiagnosis/regist/getpassword.jsp" id="forgetpwd">忘记密码</a> 
				<input  type="button"    id="loginBtn" value="登录" class="btn" />
				<!--<a href="javascript:void(0)" class="wapper" onclick='obj.sweep()'>扫码登录</a>-->
				<a id="about">关于我们</a> <a id="register"
					href="HospitalAction!allHostpital">注册</a>

			</form>
		</div>
	</div>

