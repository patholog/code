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
<div id="container" style="width: 100%; height: 600px;position: absolute;"></div>
<div class="color" style="float:right;position:absolute;padding-top: 100px;">
  R<input id="colorR" type="range" name="points" min="0" max="255" value="255"><br>
  G<input id="colorG" type="range" name="points" min="0" max="255" value="255"><br>
  B<input id="colorB" type="range" name="points" min="0" max="255" value="255">
</div>
</body>
<script type="text/javascript" src="${path }/js/jquery-1.9.0.min.js"></script>
<script src="${path}/assets/Seadragon/openseadragon.js" type="text/javascript"></script>
<script>
  (function (win) {
    var _colorR = $('#colorR').val();
    var _colorG = $('#colorG').val();
    var _colorB = $('#colorB').val();
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
      // debugMode: true,
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
            Height: "${image.height}",
            Width: "${image.width}"
          }
        }
      },
      showNavigator: true,  //是否显示控制按钮
      minZoomLevel: 0.1,  //最小允许放大倍数
      maxZoomLevel: 16 //最大允许放大倍数
    });
//    viewer.addHandler("tile-drawing",function () {
//      console.log(arguments);
//    });
    viewer.addHandler("tile-drawn", function () {
      viewer.removeAllHandlers();
      viewer.addHandler("tile-drawn", function (obj) {
        var context2D = obj.eventSource.drawer.context;
        var pos = obj.tile.position;
        var size = obj.tile.size;
        var imgData = context2D.getImageData(Math.ceil(pos.x), Math.ceil(pos.y), Math.ceil(size.x), Math.ceil(size.y));

        var data = imgData.data;
        for (var i = 0; i < data.length; i += 4) {
          // red
          data[i] = _colorR - (255 - data[i]);
          // green
          data[i + 1] = _colorG - (255 - data[i + 1]);
          // blue
          data[i + 2] = _colorB - (255 -data[i + 2]);
        }
        context2D.putImageData(imgData, Math.ceil(pos.x), Math.ceil(pos.y));
      });
    });

    $('.color').on('change','input',function(){
      _colorR = $('#colorR').val();
      _colorG = $('#colorG').val();
      _colorB = $('#colorB').val();
    });
  })(window);
</script>

</html>
