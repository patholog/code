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
<link rel="stylesheet" type="text/css" href="${path }/css/comc_diagnosis_wait_style.css"/>
<link rel="stylesheet" type="text/css" href="${path }/css/comc_firstpage_style.css"/>
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
<script type="text/javascript" src="${path }/js/page_size.js"></script>
<script type="text/javascript" src="${path }/js/popBox_flat.js"></script>
<script type="text/javascript" src="${path }/js/bgiframe.js"></script>
<script type="text/javascript" src="${path }/js/browser.js"></script>
<script type="text/javascript" src="${path }/js/EVision_index.js"></script>
<script type="text/javascript" src="${path }/js/jquery-1.11.2.js"></script>
<script type="text/javascript" src="${path }/js/scroll_news.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        getCenter();
        
    });
    window.onresize = function () {
        getCenter();
    }
    function getCenter() {
        var wh = $(window).get(0).innerHeight - 62 || $(window).height() - 62;
        var wh2 = $(".center").height();
        if (wh2 + 140 > wh) {
            $(".center").css("padding-top", "70px;")
        } else {
            $(".center").css("padding-top", (wh - wh2) / 2 + "px");
        }
    }


</script>
</head>

<body>
	<div class="header">
		<%@include file="/webdiagnosis/maintop.jsp"%>
	</div>
	<div class="center" >
		<div class="w_portal_box" >
			<div>
				<a href="PathologyAction!getPathologyListToNeed" class="one_block">
		    	<div class="w_center_icon4"></div>
		        <div class="w_center_title">待诊断</div>
		    </a>
		    </div>
		    <div>
		      <div>
		
		
		    <a href="PathologyAction!getPathologyListToHas" class="two_block">
		    	<div class="w_center_icon4"></div>
		        <div class="w_center_title">已诊断</div>
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
		        <div class="w_center_title">我的退回</div>
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