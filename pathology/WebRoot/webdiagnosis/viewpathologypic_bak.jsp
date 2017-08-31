<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=640, initial-scale=0.5, user-scalable=no"/>
  <title>slide</title>
  <c:set var="path" value="${pageContext.request.contextPath }"/>
  <%--<link rel="stylesheet" href="${path }/assets/Seadragon/" />--%>
</head>
<body>
<!-- openseadragon 容器 -->
<div id="container" style="width: 100%; height: 600px;"></div>
</body>
<script src="${path}/assets/Seadragon/openseadragon.js" type="text/javascript"></script>
<script>
  (function (win) {
    var imageId;
    var address = document.location.href;
    var contextPath = 'http://' + window.location.host;
    if (address.indexOf('/pathology') >= 0) {
      contextPath += "\\pathology";
    }
    var params = address.substr(address.indexOf("?") + 1).split("&");
    for (var i in params) {
      if (params[i].indexOf("caseId") >= 0) {
        imageId = params[i].split("=")[1];
      }
    }
    if (imageId === '') {
      alert("获取图片信息失败");
    }
    var viewer = OpenSeadragon({
      debugMode: true,
      id: "container",  //容器id
      prefixUrl: '',
      tileSources: {
        Image: {
          xmlns: "http://schemas.microsoft.com/deepzoom/2008",
          Url: contextPath + "/PathologyAction!getSlideImage?id=" + imageId + "&position=",
          Format: "jpg",
          Overlap: "1",
          TileSize: "256",
          Size: {
            Height: "6988",
            Width: "9798"
          }
        }
      },
      showNavigator: true,  //是否显示控制按钮
      minZoomLevel: 0.1,  //最小允许放大倍数
      maxZoomLevel: 80 //最大允许放大倍数
    });
    console.log(viewer);
  })(window);
</script>

</html>
