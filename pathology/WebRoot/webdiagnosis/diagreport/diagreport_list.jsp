<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<title>病理远程会诊平台-病例分享</title>
<c:set var="path" value="${pageContext.request.contextPath }" />
<link rel="stylesheet" type="text/css" href="${path }/css/comc_diagnosis_wait_style.css"/>
<link rel="stylesheet" type="text/css" href="${path }/css/comc_head_style.css"/>
<link rel="stylesheet" type="text/css" href="${path }/css/comc_left_nav_style.css"/>
<link rel="stylesheet" type="text/css" href="${path }/css/comc_page_style.css"/>
<link rel="stylesheet" type="text/css" href="${path }/css/datepicker.css"/>
<link rel="stylesheet" type="text/css" href="${path }/css/public_flat.css"/>
<link rel="stylesheet" type="text/css" href="${path }/css/theme.css"/>
<link rel="stylesheet" type="text/css" href="${path }/css/WdatePicker.css"/>
<link rel="stylesheet" type="text/css" href="${path }/css/weebox.css"/>
<script type="text/javascript" src="${path }/js/treeView.js"></script>
<script type="text/javascript" src="${path }/js/common-cn.js"></script>
<script type="text/javascript" src="${path }/js/forbid-refresh.js"></script>
<script type="text/javascript">
	function confirmDelete(id) {
		if (confirm('确定取消分享？'))
			window.location.href = 'ShareAction!deleteShare?share.shareId=' + id;
	}
</script>
</head>

<body>
	<div class="header">
		<%@include file="/webdiagnosis/maintop.jsp"%>
	</div>
	<div class="menu_left">
		<ul id="Left1_MenuList">
		<%@include file="/webdiagnosis/mainleft.jsp" %>
		</ul>
	</div>
	
	<div class="content_right">
		<div class="index_right" style="min-height: 494px;">
			<div class="index_diagnosis_table">
                 <div class="diagnosis_table">
                        诊断报表
                  </div>
			  </div>
			</div>
		</div>

</body>
</html>s