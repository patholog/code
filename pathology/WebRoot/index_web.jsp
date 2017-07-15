<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>点击弹出登录框</title>
<c:set var="path" value="${pageContext.request.contextPath }" />
<link rel="stylesheet" type="text/css" href="${path}/css/login.css" />
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
</head>
<body>

	<div class="nav">
		<ul>
			<li><a href="javascript:void(0)" onClick="showBox()">用户登录</a>
			</li>
		</ul>
	</div>
	 <%@include file="webdiagnosis/loginbox.jsp"%>
	<div class="bg_color"  id="bg_filter"
		style="display: none;"></div>


	<div style="text-align:center;"></div>
</body>
</html>