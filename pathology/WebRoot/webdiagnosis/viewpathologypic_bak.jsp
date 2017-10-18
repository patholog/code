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
  <link href="${path}/assets/jqueryui/jquery-ui.min.css" rel="stylesheet"/>
  <style type="text/css">
    .skin {
      width : 100px;
      border : 1px solid gray;
      padding : 2px;
      visibility : hidden;
      position : absolute;
    }
    div.menuitems {
      margin : 1px 0;
    }
    div.menuitems a {
      text-decoration : none;
    }
    div.menuitems:hover {
      background-color : #c0c0c0;
    }
  </style>
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
<div id="imgSource">
  <s:iterator value="annotationList" id="annotation">
    <div id="<s:property value='#annotation.name'/>" class="my-overlay"
         positionx="<s:property value='#annotation.positionX'/>"
         positiony="<s:property value='#annotation.positionY'/>">
      <span><s:property value='#annotation.textTips'/></span>
      <br>
      <img src="https://upload.wikimedia.org/wikipedia/commons/4/4a/Cercle_rouge_100%25.svg" width="38">
    </div>
  </s:iterator>
</div>
<div id="container" style="position:absolute;top:150px;width:100%;height:700px;">
</div>
<div id="tipsModal" hidden>
  <form id="tipsForm" action="ShareAction!share" method="post">
    <div style="float: left;">
      <label for="textTips">标注内容</label>
      <input id="textTips" name="textTips" style="border: solid 1px #8b8d8f; width: 100px;"/>
    </div>
  </form>
</div>
<div id="tips">
  <label id="tipInfo"></label>
</div>
</body>
<script type="text/javascript" src="${path }/js/jquery-1.9.0.min.js"></script>
<script src="${path}/assets/Seadragon/openseadragon.min.js" type="text/javascript"></script>
<script src="${path}/assets/Seadragon/openseadragonselection.js" type="text/javascript"></script>
<script src="${path}/assets/Seadragon/openseadragonimagefilter.js" type="text/javascript"></script>
<script src="${path}/assets/Seadragon/openseadragon-paperjs-overlay.js" type="text/javascript"></script>
<script src="${path}/assets/js/event-0.6.js" type="text/javascript"></script>
<script src="${path}/assets/jqueryui/jquery-ui.min.js"
<script src="https://cdnjs.cloudflare.com/ajax/libs/paper.js/0.9.25/paper-full.min.js"></script>
<script>
  (function (win) {
    var _colorR = $('#colorR').val();
    var _colorG = $('#colorG').val();
    var _colorB = $('#colorB').val();
    var container = document.getElementById('container');
    var imgSource = $('#imgSource');
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

    function showCallbackTips(text, callback) {
      $('#tipInfo').text(text);
      $('#tips').dialog({
        title: '提示',
        modal: true,
        width: '400',
        height: '200',
        buttons: [{
          text: "确定",
          icon: "ui-icon-heart",
          click: callback
        }]
      });
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
        height: 256 * ${image.height},
        width:  256 * ${image.width},
        tileSize: 256,
        minLevel: 6,
        getTileUrl: function( level, x, y ) {
          function getColor() {
            _colorR = $('#colorR').val();
            _colorG = $('#colorG').val();
            _colorB = $('#colorB').val();
            return "&r=" + _colorR + "&g=" + _colorG + "&b=" + _colorB;
          }
          return contextPath + "/PathologyAction!getSlideImage?id=" + imageId + getColor() + "&position="
              + level + "/" + x + "_" + y + ".jpg";
        }
      },
      showNavigator: true,  //是否显示小导航图（地图）
      minZoomLevel: 0.1,  //最小允许放大倍数
      maxZoomLevel: 8 //最大允许放大倍数
      /*overlays: [{
        id: 'right-arrow-overlay-no-rotate', // Arrow pointing to the tip of the hair
        x: 0.592,
        y: 0.496,
        placement: OpenSeadragon.Placement.RIGHT,
        rotationMode: OpenSeadragon.OverlayRotationMode.NO_ROTATION
      }]*/
    });
    // 初始化标注
    initAnnotation();
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
          rect.x=rect.x/256;
          rect.y=rect.y/256;
          rect.width=rect.width/256;
          rect.height=rect.height/256;
          var context2D = rect.eventSource.drawer.context;
          var imgData = context2D.getImageData(Math.ceil(rect.x), Math.ceil(rect.y), Math.ceil(rect.width), Math.ceil(rect.height));
        	//创建一个画布canvas
          var canvas = document.createElement("canvas");
          // document.body.appendChild(canvas);
          var contextNew = canvas.getContext("2d");
          canvas.width = rect.width+10;
          canvas.height = rect.height+10;
          canvas.style.width = rect.width + "px";
          canvas.style.height = rect.height + "px";
          // var image=new Image(rect.width,rect.height);
          // contextNew.drawImage(image,0,0,rect.width,rect.height);
          contextNew.putImageData(imgData,0,0);
          var rawImageData = canvas.toDataURL("image/png;");
          rawImageData = rawImageData.replace("image/png", "image/octet-stream");
          document.location.href = rawImageData;
          // alert("图片剪切")
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
            }
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
        // var imgData = context2D.getImageData(Math.ceil(pos.x), Math.ceil(pos.y), Math.floor(size.x), Math.floor(size.y));
        var imgData = context2D.getImageData(pos.x, pos.y, size.x, size.y);

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
        viewer.forceRedraw();
      });
    // });
    $('.rotate').on('change','input',function() {
    	viewer.viewport.setRotation($('#rotateSlider').val());
      viewer.forceRedraw();
    });

    $('.color').on('change','input',function(){
      _colorR = $('#colorR').val();
      _colorG = $('#colorG').val();
      _colorB = $('#colorB').val();
      viewer.forceRedraw();
    });
    /*
    var circles = [];
    var paintCircles = function(jsondata, overlay) {
    };
    var hit_item = null;
    var drag_handler = function(event) {
    if (hit_item) {
        var transformed_point1 = paper.view.viewToProject(new paper.Point(0,0));
        var transformed_point2 = paper.view.viewToProject(new paper.Point(event.delta.x, event.delta.y));
        hit_item.position = hit_item.position.add(transformed_point2.subtract(transformed_point1));
        window.viewer.setMouseNavEnabled(false);
        paper.view.draw();
      }
    };
    var dragEnd_handler = function(event) {
    if (hit_item) {
        window.viewer.setMouseNavEnabled(true);
    }
    hit_item = null;
    };
    var press_handler = function(event) {
      hit_item = null;
      var transformed_point = paper.view.viewToProject(new paper.Point(event.position.x, event.position.y));
      var hit_test_result = paper.project.hitTest(transformed_point);
      if (hit_test_result) {
          hit_item = hit_test_result.item;
      }
    };

    var overlay=viewer.paperjsOverlay();
    var paint_circles = function(overlay, event) {
        var circles = [
            {
                "pixel_x": 4000,
                "pixel_y": 4000,
                "radius": 400
            },
            {
                "pixel_x": 5000,
                "pixel_y": 5000,
                "radius": 400
            }
        ];
        var num_circles = circles.length;
        for (var i = 0; i < num_circles; i++) {
            var circle = circles[i];
            var circle = new paper.Path.Circle(new paper.Point(circle.pixel_x, circle.pixel_y), circle.radius);
            circle.fillColor = 'red';
            circle.visible = true;
            circles.push(circle);
            circle.onMouseDown = function (event) {
                console.log("circle.onMouseDown" , "event.point.x = ", event.point.x , "event.point.y = ", event.point.y);
            };
        }
        overlay.resize();
        overlay.resizecanvas();
    }.bind(null, overlay);

    new OpenSeadragon.MouseTracker({
        element: viewer.canvas,
        pressHandler: press_handler,
        dragHandler: drag_handler,
        dragEndHandler: dragEnd_handler
    }).setTracking(true);
    //TODO 触发绘制图层
    paint_circles();*/

    // 加载标注
    function initAnnotation() {
      $(".my-overlay").each(function(){
        var viewportPos = new OpenSeadragon.Point();
        viewportPos.x = ($(this).attr('positionx') * 1);
        viewportPos.y = $(this).attr('positiony') * 1;
        viewer.addOverlay($(this).attr('id'), viewportPos, OpenSeadragon.Placement.CENTER, null);
      });
    }
    // 双击添加标注
    var press_handler = function(event) {
      event.preventDefaultAction = true;
      var viewportPos = viewer.viewport.viewerElementToViewportCoordinates(event.position);
      var nowPos = 'pos_' + viewportPos.x + '_' + viewportPos.y;
      var tips = "";
      $('#textTips').val("");
      $('#tipsModal').attr('hidden', false);
      $("#tipsModal").dialog({
        title: '标注内容',
        modal: true,
        width: '300',
        height: '200',
        buttons: [{
          text: "确定",
          icon: "ui-icon-heart",
          click: function () {
            $(this).dialog("close");
            tips = $('#textTips').val();
            $.ajax({
              url: 'PathologyAction!insertAnnotation?imageId=' + ${image.idImage} + '&name=' + nowPos + '&positionX='
              + viewportPos.x + '&positionY=' + viewportPos.y + '&textTips=' + tips,
              dataType: "json",
              success: function(result) {
                if (result && result.success) {
                  imgSource.html(imgSource.html() + '<div id="' + nowPos + '"><span>' + tips + '</span><br><img '
                      + ' src="https://upload.wikimedia.org/wikipedia/commons/4/4a/Cercle_rouge_100%25.svg" '
                      + ' width="38"></div>');
                  viewer.addOverlay(nowPos, viewportPos, OpenSeadragon.Placement.CENTER, null);
                } else {
                  // alert("出现错误，请重试");
                }
              }
            });
          }
        }, {
          text: "取消",
          icon: "ui-icon-heart",
          click: function () {
            $(this).dialog("close");
          }
        }]
      });
    };
    new OpenSeadragon.MouseTracker({
      element: viewer.canvas,
      dblClickHandler: press_handler
    }).setTracking(true);
    viewer.addHandler("canvas-click", function(event) {
      event.preventDefaultAction = true;
      return false;
    })
  })(window);
</script>

</html>
