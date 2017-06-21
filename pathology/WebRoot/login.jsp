<%@ page language="java" contentType="text/html; charset=GB18030" 
pageEncoding="GB18030"%> 
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>点击弹出登录框</title>
	<link rel="stylesheet" type="text/css" href="css/login.css"/>
	<script src="js/jquery-1.7.1.min.js" type="text/javascript" charset="utf-8"></script>
</head>
<body>

	<div class="nav">
		<ul>
			<li><a href="javascript:void(0)" onClick="showBox()">用户登录</a></li>
		</ul>
	</div>
	<div class="event" id="login_box" style="display: none;">
		<div class="login">
			<div class="title">
				<span class="t_txt">用户登录</span>
				<span class="del" onClick="deleteLogin()">X</span>
			</div>
			<form action="" method="post">
				<input type="text" name="" id="" value="" placeholder="请输入用户名"/>
				<input type="password" name="" id="" value="" placeholder="请输入密码"/>
                <input type="checkbox" name="" id="rmpasswd" value=""/>
                <a id="rmfont">记住密码</a>
                <a href="" id="forgetpwd">忘记密码</a>
                <input type="button" name="" id="" value="登录" class="btn" onclick="location.href='index.jsp'" />
				<!--<a href="javascript:void(0)" class="wapper" onclick='obj.sweep()'>扫码登录</a>-->
                <a id="about">关于我们</a>
                <a id="register">注册</a>
                
			</form>	
		</div>
	</div>
	
	<div class="bg_color" onClick="deleteLogin()" id="bg_filter" style="display: none;"></div>
	
	<script src="js/login.js" type="text/javascript" charset="utf-8"></script>
<div style="text-align:center;">

</div>
</body>
</html>