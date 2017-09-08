<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<title>病理远程会诊平台首页</title>
<c:set var="path" value="${pageContext.request.contextPath }" />
<link rel="stylesheet" type="text/css" href="${path }/css/w_index.css"/>
<link rel="stylesheet" type="text/css" href="${path }/css/comc_head_style.css"/>
<link rel="stylesheet" type="text/css" href="${path }/css/public_flat.css"/>
<link rel="stylesheet" type="text/css" href="${path }/css/theme.css"/>
<script type="text/javascript" src="${path }/js/jquery-1.9.0.min.js"></script>
<script type="text/javascript" src="${path }/js/common-cn.js"></script>
<script language="javascript">
        //防止页面后退
        history.pushState(null, null, document.URL);
        window.addEventListener('popstate', function () {
            history.pushState(null, null, document.URL);
        });
    </script>
</head>

<body>
	<div class="header">
		<%@include file="/webdiagnosis/maintop.jsp"%>
	</div>
	<div class="content_center">
		<div class="w_portal_box">
			<div>
				<a href="PathologyAction!getPathologyListToNeed" class="one_block">
		    	<div class="w_center_icon3"></div>
		        <div class="w_center_title">待诊断&nbsp;<%=request.getAttribute("needcount") != null ? request.getAttribute("needcount") : "" %>&nbsp;例</div>
		    </a>
		    </div>
		    <div>
		      <div>
		
		
		    <a href="PathologyAction!getPathologyListToHas" class="two_block">
		    	<div class="w_center_icon4"></div>
		        <div class="w_center_title">已诊断&nbsp;<%=request.getAttribute("hascount") != null ? request.getAttribute("hascount") : "" %>&nbsp;例</div>
		    </a>
		         </div>
		          <div>
		        <a href="CollectionAction!getCollectionList" class="three_block">
		    	<div class="w_center_icon6"></div>
		        <div class="w_center_title">我的收藏</div>
		    </a>
		     </div>
		  </div>
		    <div>
		    <a href="PathologyAction!getPathologyListToBack" class="four_block">
		    	<div class="w_center_icon4"></div>
		        <div class="w_center_title">我的退回&nbsp;<%=request.getAttribute("backcount") != null ? request.getAttribute("backcount") : "" %>&nbsp;例</div>
		    </a>
		     </div>
		    <div>
		    <a href="MessageAction!getMessageList" class="five_block">
		    	<div class="w_center_icon1"></div>
		        <div class="w_center_title">留言列表</div>
		    </a>
		     </div>
		    <div>
		    <a href="ShareAction!getShareList" class="six_block">
		    	<div class="w_center_icon5"></div>
		        <div class="w_center_title">病例分享</div>
		    </a>
		    </div>
		</div>
	</div>
	
	
	

</body>
</html>