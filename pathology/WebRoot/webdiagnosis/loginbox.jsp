<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<div class="event" id="login_box" style="display: none;">
		<div class="login">
			<div class="title">
				<span class="t_txt">用户登录</span> <span class="del"
					onClick="deleteLogin()">X</span>
			</div>
			<form action="" method="post">
				<input type="text" name="user.username" id="" value=""
					placeholder="请输入用户名" /> <input type="password"
					name="user.password" id="" value="" placeholder="请输入密码" /> <input
					type="checkbox" name="" id="rmpasswd" value="" /> <a id="rmfont">记住密码</a>
				<a href="${path}/webdiagnosis/regist/getpassword.jsp" id="forgetpwd">忘记密码</a> <input type="button" name=""
					id="loginBtn" value="登录" class="btn" />
				<!--<a href="javascript:void(0)" class="wapper" onclick='obj.sweep()'>扫码登录</a>-->
				<a id="about">关于我们</a> <a id="register"
					href="HospitalAction!allHostpital">注册</a>

			</form>
		</div>
	</div>

