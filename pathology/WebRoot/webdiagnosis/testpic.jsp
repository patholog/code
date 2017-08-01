<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>jQuery图片支持鼠标滚轮缩放以及点击自定义缩放图片的插件smartZoom.js下载</title>

<c:set var="path" value="${pageContext.request.contextPath }"/>
<link rel="stylesheet" href="${path }/cropper/dist/image.css"/>
<script src="${path }/js/jquery.min.js"></script>
<script src="${path }/cropper/dist/e-smart-zoom-jquery.min.js"></script>
<!--[if lt IE 9]>
    <script src="http://libs.useso.com/js/html5shiv/3.6/html5shiv.min.js"></script>
<![endif]-->
<script>
    $(document).ready(function() {        
        $('#imageFullScreen').smartZoom({'containerClass':'zoomableContainer'});        
        $('#topPositionMap,#leftPositionMap,#rightPositionMap,#bottomPositionMap').bind("click", moveButtonClickHandler);
        $('#zoomInButton,#zoomOutButton').bind("click", zoomButtonClickHandler);
        
        function zoomButtonClickHandler(e){
            var scaleToAdd = 0.8;
            if(e.target.id == 'zoomOutButton')
                scaleToAdd = -scaleToAdd;
            $('#imageFullScreen').smartZoom('zoom', scaleToAdd);
        }        
        function moveButtonClickHandler(e){
            var pixelsToMoveOnX = 0;
            var pixelsToMoveOnY = 0;
    
            switch(e.target.id){
                case "leftPositionMap":
                    pixelsToMoveOnX = 50;	
                break;
                case "rightPositionMap":
                    pixelsToMoveOnX = -50;
                break;
                case "topPositionMap":
                    pixelsToMoveOnY = 50;	
                break;
                case "bottomPositionMap":
                    pixelsToMoveOnY = -50;	
                break;
            }
            $('#imageFullScreen').smartZoom('pan', pixelsToMoveOnX, pixelsToMoveOnY);
        } 
    });
</script>
</head>
<body>
<c:set var="path" value="${pageContext.request.contextPath }" />
<div id="pageContent">
	<div id="imgContainer"> <img id="imageFullScreen" src="${path }/webdiagnosis/20161205135531603.jpg"/> </div>
	</div>	
</body>
</html>
