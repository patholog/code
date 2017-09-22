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
</head>
<body>
<!-- openseadragon 容器 -->
<div id="toolBar" style="width:100%;height:30px;"></div>
<div class="color" style="position:absolute;height:80px;top:35px">
  R<input id="colorR" type="range" name="points" min="0" max="255" value="255"><br>
  G<input id="colorG" type="range" name="points" min="0" max="255" value="255"><br>
  B<input id="colorB" type="range" name="points" min="0" max="255" value="255">
</div>
<div class="rotate" style="position:absolute;height:20px;top:120px">
	rotate<input id="rotateSlider" type="range" name="rotate" min="0" max="360" value="0"/>
</div>
<div id="container" style="position:absolute;top:150px;width:100%;height:700px;"></div>
</body>
<script type="text/javascript" src="${path }/js/jquery-1.9.0.min.js"></script>
<script src="${path}/assets/Seadragon/openseadragon.js" type="text/javascript"></script>
<script src="${path}/assets/Seadragon/openseadragonselection.js" type="text/javascript"></script>
<script src="${path}/assets/Seadragon/openseadragonimagefilter.js" type="text/javascript"></script>
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
      debugMode: false,
      id: "container",  //容器id
      prefixUrl: '',
      degrees:0,
      showRotationControl:true,
      gestrueSettingsTouch:{
    	  pinchRotate:true
      },
      toolbar:"toolBar",
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
      showNavigator: true,  //是否显示小导航图（地图）
      minZoomLevel: 0.1,  //最小允许放大倍数
      maxZoomLevel: 16 //最大允许放大倍数
    });
    viewer.imagefilters(
    		{
    		    showControl: true, //show button or not
    		    startOpen: false, //start viewer with ImageFilterTools open
    		    prefixUrl: null, //alternative location of images
    		    toolsLeft: null, //int for absolute positioning
    		    toolsTop: null, //int for absolute positioning
    		    toolsWidth: 180, //int width in pixels
    		    toolsHeight: 150, //int height in pixels
    		    class: null, //override standard styling, NB. you need to style everything
    		    navImages: { //images to use
    		        imagetools: {
    		            REST: 'imagetools_rest.png',
    		            GROUP: 'imagetools_grouphover.png',
    		            HOVER: 'imagetools_hover.png',
    		            DOWN: 'imagetools_pressed.png'
    		        }
    		    },
    		    filters: { //add filters here
    		        brightness: {
    		            min: -255,
    		            max: 255,
    		            callback: null,
    		            processor: function () {
    		                var setTo = getElementValueAsFloat('osd-filter-brightness');
    		                if (this.callback !== null) {
    		                    this.callback(setTo);
    		                }
    		                return OpenSeadragon.Filters.BRIGHTNESS(setTo);
    		            }
    		        },
    		        contrast: {
    		            min: 0,
    		            max: 5,
    		            value: 1,
    		            default_value: 1,
    		            step: 0.1,
    		            callback: null,
    		            processor: function () {
    		                var setTo = getElementValueAsFloat('osd-filter-contrast');
    		                if (this.callback !== null) {
    		                    this.callback(setTo);
    		                }
    		                return OpenSeadragon.Filters.CONTRAST(setTo);
    		            }
    		        }
    		    }
    		});
    var selection=viewer.selection({
        element:                 null, // html element to use for overlay
        showSelectionControl:    true, // show button to toggle selection mode
        toggleButton:            null, // dom element to use as toggle button
        showConfirmDenyButtons:  true,
        styleConfirmDenyButtons: true,
        returnPixelCoordinates:  true,
        keyboardShortcut:        'c', // key to toggle selection mode
        rect:                    null, // initial selection as an OpenSeadragon.SelectionRect object
        startRotated:            false, // alternative method for drawing the selection; useful for rotated crops
        startRotatedHeight:      0.1, // only used if startRotated=true; value is relative to image height
        restrictToImage:         true, // true = do not allow any part of the selection to be outside the image
        onSelection:             function(rect) {
        		alert("图片剪切")
        	}, // callback
        prefixUrl:               null, // overwrites OpenSeadragon's option
        navImages:               { // overwrites OpenSeadragon's options
            selection: {
                REST:   'selection_rest.png',
                GROUP:  'selection_grouphover.png',
                HOVER:  'selection_hover.png',
                DOWN:   'selection_pressed.png'
            },
            selectionConfirm: {
                REST:   'selection_confirm_rest.png',
                GROUP:  'selection_confirm_grouphover.png',
                HOVER:  'selection_confirm_hover.png',
                DOWN:   'selection_confirm_pressed.png'
            },
            selectionCancel: {
                REST:   'selection_cancel_rest.png',
                GROUP:  'selection_cancel_grouphover.png',
                HOVER:  'selection_cancel_hover.png',
                DOWN:   'selection_cancel_pressed.png'
            },
        }
    });
    selection.disable();
//    viewer.addHandler("tile-drawing",function () {
//      console.log(arguments);
//    });
    // viewer.addHandler("tile-drawn", function () {
      //  viewer.removeAllHandlers();
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
    // });


    
    $('.rotate').on('change','input',function()
   	{
    	viewer.viewport.setRotation($('#rotateSlider').val());
    });

    $('.color').on('change','input',function(){
      _colorR = $('#colorR').val();
      _colorG = $('#colorG').val();
      _colorB = $('#colorB').val();
      // var context=viewer.drawer.context;
      // var pos = viewer.tile.position;
      //   var size = viewer.tile.size;
      //   var imgData = context.getImageData(Math.ceil(pos.x), Math.ceil(pos.y), Math.ceil(size.x), Math.ceil(size.y));

      //   var data = imgData.data;
      //   for (var i = 0; i < data.length; i += 4) {
      //     // red
      //     data[i] = _colorR - (255 - data[i]);
      //     // green
      //     data[i + 1] = _colorG - (255 - data[i + 1]);
      //     // blue
      //     data[i + 2] = _colorB - (255 -data[i + 2]);
      //   }
      //   context.putImageData(imgData, Math.ceil(pos.x), Math.ceil(pos.y));
    });
  })(window);
</script>

</html>
