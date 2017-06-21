<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<c:set var="path" value="${pageContext.request.contextPath }" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>病理平台管理中心 v1.0</title>
<meta name="Copyright" content="Douco Design." />
<link rel="stylesheet" type="text/css" href="${path}/css/style.css" />
<script type="text/javascript"	src="${path}/CKEditor/ckeditor/ckeditor.js"></script>
<script type="text/javascript"	src="${path}/CKFinder/ckfinder/ckfinder.js"></script>
<script type="text/javascript" src="${path}/js/treeView.js"></script>
<script type="text/javascript" src="${path}/js/common-cn.js"></script>
<script type="text/javascript" src="${path}/js/forbid-refresh.js"></script>
</head>
<body>
	<div id="header">
		<%@include file="managetop.jsp"%>
	</div>
	<!-- dcHead 结束 -->
	<table id="main" cellpadding="0" cellspacing="0" border="0">
		<tr>
			<td id="leftmenu">
			<%@include file="manageleft.jsp"%>
			</td>
			<td id="contents"><h5>欢迎使用</h5></td>
		</tr>
	</table>



</body>
</html>
