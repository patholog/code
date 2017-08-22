<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
  <head>
   <title>登录-病理远程会诊平台</title>
  
 
      <link rel="stylesheet" href="css/login1.css" style="text/css">
  </head>
  <body>			
 <form action="login.action" method="post">
  <h4> Login Information </h4>
  <input class="name" type="text" value="lizheng" name="user.username" placeholder="Enter Username"/>
  <input class="pw" type="password" value="lizheng" name="user.password"   placeholder="Enter Password"/>
  <li><a href="HospitalAction!allHostpital">注册</a></li>
  <input class="button" type="submit" value="Log in"/>
</form>				
					
  </body>
</html>