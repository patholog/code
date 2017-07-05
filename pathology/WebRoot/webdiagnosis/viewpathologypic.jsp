<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>病理图片查看</title>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<link rel="stylesheet" type="text/css" href="${path }/cropper/css/normalize.css"/>
<link rel="stylesheet" type="text/css" href="${path }/cropper/css/default.css"/>
<link ref="stylesheet" href="${path }/cropper/assets/css/bootstrap.min.css"/>
<link rel="stylesheet" type="text/css" href="${path }/css/style.css" />
<link ref="stylesheet" href="${path }/cropper/dist/cropper.css"/>
<link ref="stylesheet" href="${path }/cropper/css/main.css"/>
<script type="text/javascript" src="${path }/js/treeView.js"></script>
<script type="text/javascript" src="${path }/js/common-cn.js"></script>
<script type="text/javascript" src="${path }/js/forbid-refresh.js"></script>

<body>
	<c:set var="path" value="${pageContext.request.contextPath }" />
    <div id="header">
        <%@include file="/webdiagnosis/maintop.jsp"%>
    </div>
    <table id="main" cellpading="0" cellspacing="0" border="0">
        <tr>
            <td id="Leftmenu"><%@include file="/webdiagnosis/mainleft.jsp"%>
            </td>
            <td id="contents"><%@include file="/webdiagnosis/content.jsp"%>
            </td>
            <!-- <td id="contents">
                 <div class="img-container">
                    <img src="${path }/webdiagnosis/picture.jpg" alt="Picture">
                </div>                   
            </td> -->
            <!--<td id="middle"> 

                <div>
					<div class="docs-preview clearfix"></div>
					<div class="img-preview preview-lg"></div>
					<div class="img-preview preview-md"></div>
					<div class="img-preview preview-sm"></div>
					<div class="img-preview preview-xs"></div>
				</div>    
            </td>-->
        </tr>
    </table>
    <script src="${path }/js/jquery.min.js"></script>
    <script src="${path }/assets/js/bootstrap.min.js"></script>
<script src="${path }/cropper/dist/cropper.js"></script>
<script src="${path }/cropper/js/main.js"></script>
</body> 
</html>