<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
  <head>
  <meta charset="UTF-8" />
   <title>登录-病理远程会诊平台</title>
  
 <c:set var="path" value="${pageContext.request.contextPath }" />
<script src="${path}/js/jquery-1.7.1.min.js" type="text/javascript"></script>
<script src="${path}/js/login.js" type="text/javascript"></script>
  <script type="text/javascript" src="${path }/assets/jqueryui/jquery-ui.min.js"></script>
  <script>
  function showTips(text) {
    $('#tipInfo').text(text);
    $('#tips').dialog({
      title: '提示',
      modal: true,
      width: '400',
      height: '200',
      buttons: [{
        text: "确定",
        icon: "ui-icon-heart",
        click: function () {
          $(this).dialog("close");
        }
      }]
    });
  }
</script>
  <link rel="stylesheet" type="text/css" href="${path }/assets/jqueryui/jquery-ui.min.css"/>
  <link rel="stylesheet" type="text/css" href="${path }/assets/jqueryui/jquery-ui.theme.min.css"/>
      <link rel="stylesheet" href="css/login1.css" style="text/css">
      <script type="text/javascript">
	var flag = false;
	function Check() {
		if(flag)
			return flag;
		var username = $("#username").val();
		var password = $("#password").val();

		if (username == '') {
			showTips("用户名不能为空！");
			return false;
		} else if (password == '') {
			showTips("密码不能为空！");
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
							showTips("用户没有审核通过");
						}
					});
				},
				error : function(d) {
					showTips("用户名或密码不对");
				}
			});
			return false;
		}
	}
</script>
  </head>
  <body>			
 <form id='fm1' action="login.action" method="post" onsubmit="return Check()">
  <h4> Login Information </h4>
  <input id="username" class="name" type="text" value="lizheng" name="user.username" placeholder="Enter Username"/>
  <input id="password" class="pw" type="password" value="1234567890" name="user.password"   placeholder="Enter Password"/>
  <li><a href="HospitalAction!allHostpital">注册</a></li>
  <input class="button" type="submit" value="Log in"/>
</form>				
<div id="tips">
  <label id="tipInfo"></label>
</div>			
  </body>
</html>