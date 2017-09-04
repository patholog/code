<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<title>病理远程会诊平台-找回密码</title>
<c:set var="path" value="${pageContext.request.contextPath }" />
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="this is my page">
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<LINK rel="Shortcut icon" href="favicon.ico" />
<link rel="stylesheet" type="text/css" href="${path }/css/settings.css" />
<link rel="stylesheet" type="text/css" href="${path }/css/select.css" />
<script src="${path }/js/regist.js" type="text/javascript"></script>
<script src="${path }/js/jquery/jquery-1.4.4.min.js"
	type="text/javascript"></script>
<script>
        //防止页面后退
        history.pushState(null, null, document.URL);
        window.addEventListener('popstate', function () {
            history.pushState(null, null, document.URL);
        });
    </script>
</head>
<body>
	<div id="3" style="position: relative;  z-index: 3;">
		
			<table align="center" cellspacing="0" class="registtb">
				<tr class="thead">
					<td align="center">注册成功！请耐心等待审核</td>
				</tr>
				<tr>
					<td>
						<table id="registertable" border="0px" align="center" border="0px"
							cellspacing="0" cellpadding="5px">
							<tr>
							<tr>
								<td align="center"><a href="${path }/login.jsp">点击返回登录界面</a></td>
							</tr>
							
							
						</table></td>
				</tr>
			</table>
	</div>
</body>
</html>
