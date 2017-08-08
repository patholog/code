<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<script src="${path}/js/jquery-1.7.1.min.js" type="text/javascript"></script>
<script src="${path}/js/login.js" type="text/javascript"></script>

<div class="event" id="login_box" style="display: none;">
		<div class="login">
			<div class="title">
				<span class="t_txt">用户登录</span> <span class="del"
					onClick="deleteLogin()">X</span>
			</div>
			<form action="login.action" method="post">
				<input type="text" name="user.username" id="" value="" placeholder="请输入用户名" /> 
				<input type="password" name="user.password" id="" value="" placeholder="请输入密码" />
				<input type="checkbox" name="" id="rmpasswd" value="" /> <a id="rmfont">记住密码</a>
				<a href="${path}/webdiagnosis/regist/getpassword.jsp" id="forgetpwd">忘记密码</a> 
				<input  type="submit"    id="loginBtn" value="登录" class="btn" />
				<a id="about">关于我们</a> <a id="register" href="HospitalAction!allHostpital">注册</a>

			</form>
		</div>
	</div>

