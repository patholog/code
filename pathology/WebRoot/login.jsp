<%@ page language="java" contentType="text/html; charset=GB18030" 
pageEncoding="GB18030"%> 
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>���������¼��</title>
	<link rel="stylesheet" type="text/css" href="css/login.css"/>
	<script src="js/jquery-1.7.1.min.js" type="text/javascript" charset="utf-8"></script>
</head>
<body>

	<div class="nav">
		<ul>
			<li><a href="javascript:void(0)" onClick="showBox()">�û���¼</a></li>
		</ul>
	</div>
	<div class="event" id="login_box" style="display: none;">
		<div class="login">
			<div class="title">
				<span class="t_txt">�û���¼</span>
				<span class="del" onClick="deleteLogin()">X</span>
			</div>
			<form action="" method="post">
				<input type="text" name="" id="" value="" placeholder="�������û���"/>
				<input type="password" name="" id="" value="" placeholder="����������"/>
                <input type="checkbox" name="" id="rmpasswd" value=""/>
                <a id="rmfont">��ס����</a>
                <a href="" id="forgetpwd">��������</a>
                <input type="button" name="" id="" value="��¼" class="btn" onclick="location.href='index.jsp'" />
				<!--<a href="javascript:void(0)" class="wapper" onclick='obj.sweep()'>ɨ���¼</a>-->
                <a id="about">��������</a>
                <a id="register">ע��</a>
                
			</form>	
		</div>
	</div>
	
	<div class="bg_color" onClick="deleteLogin()" id="bg_filter" style="display: none;"></div>
	
	<script src="js/login.js" type="text/javascript" charset="utf-8"></script>
<div style="text-align:center;">

</div>
</body>
</html>