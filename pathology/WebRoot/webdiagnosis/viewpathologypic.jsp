<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html >
<html>
<head>
  <title>Digital Slide Viewer </title>
  <meta name="viewport"
        content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
  <c:set var="path" value="${pageContext.request.contextPath }"/>
  <link href="${path }/assets/css/farbtastic.css" rel="stylesheet" type="text/css"/>
  <link href="${path }/assets/css/slideviewer.css" rel="stylesheet" type="text/css"/>
  <link href="${path }/assets/css/bootstrap.css" rel="stylesheet" type="text/css"/>
  <link href="${path }/assets/css/liteaccordion.css" rel="stylesheet" type="text/css"/>
  <link href="${path }/assets/css/colpick.css" rel="stylesheet" type="text/css"/>
  <link href="${path }/assets/css/smoothness/jquery.ui.all.css" rel="stylesheet" type="text/css"/>
  <link href="${path }/assets/css/smoothness/jquery.ui.theme.css" rel="stylesheet" type="text/css"/>
  <link href="${path }/assets/css/smoothness/jquery.ui.dialog.css" rel="stylesheet" type="text/css"/>
  <link href="${path }/assets/css/viewerpage.css" rel="stylesheet" type="text/css"/>
  <script src="${path }/assets/jquery/jquery-1.7.2.min.js" type="text/javascript"></script>
  <!-- easing -->
  <script src="${path }/assets/js/jquery.easing.1.3.js" type="text/javascript"></script>
  <!-- liteAccordion js -->
  <script src="${path }/assets/js/liteaccordion.jquery.js" type="text/javascript"></script>
  <script src="${path }/assets/js/jquery-ui-1.8.14.custom.min.js" type="text/javascript"></script>
  <script src="${path }/assets/jquery/jquery.cookie.js" type="text/javascript"></script>
  <script src="${path }/assets/jquery/farbtastic.js" type="text/javascript"></script>
  <script src="${path }/assets/jquery/colpick.js" type="text/javascript"></script>
  <script src="${path }/assets/js/bootstrap-checkbox.js" type="text/javascript"></script>


  <!--
<script src="assets/SlideViewer/a.js" type="text/javascript"></script>
<script src="assets/SlideViewer/b.js" type="text/javascript"></script>
-->
  <script src="${path }/assets/js/syncfuture.js" type="text/javascript"></script>
  <script src="${path }/assets/SlideViewer/SlideViewerUtility.js" type="text/javascript"></script>
  <script src="${path }/assets/Seadragon/Seadragon.js" type="text/javascript"></script>
  <script src="${path }/assets/SlideViewer/SlideViewerCommon.js" type="text/javascript"></script>
  <script src="${path }/assets/SlideViewer/SlideViewerConfig.js" type="text/javascript"></script>
  <script src="${path }/assets/SlideViewer/SlideViewerSupport.js" type="text/javascript"></script>
  <script src="${path }/assets/SlideViewer/SlideViewerImageInfo.js" type="text/javascript"></script>
  <script src="${path }/assets/ImageProcess/ImageProcess.js" type="text/javascript"></script>
  <script src="${path }/assets/SlideViewer/SeadragonTileSource.js" type="text/javascript"></script>
  <script src="${path }/assets/DynamicGeometry/NavigationView.js" type="text/javascript"></script>
  <script src="${path }/assets/DynamicGeometry/AnnotationType.js" type="text/javascript"></script>
  <script src="${path }/assets/SlideViewer/SeadragonViewer.js" type="text/javascript"></script>
  <script src="${path }/assets/SlideViewer/SlideViewerStrings.js" type="text/javascript"></script>
  <script src="${path }/assets/SlideViewer/SlideViewerDialog.js" type="text/javascript"></script>
  <script src="${path }/assets/SlideViewer/SlideViewerToolbar.js" type="text/javascript"></script>
  <script src="${path }/assets/SlideViewer/SlideViewerProvider.js" type="text/javascript"></script>
  <script src="${path }/assets/SlideViewer/SlideViewerCreateView.js" type="text/javascript"></script>

  <script src="${path }/assets/DynamicGeometry/ShapeViewer.js" type="text/javascript"></script>
  <script src="${path }/assets/DynamicGeometry/Rect.js" type="text/javascript"></script>
  <script src="${path }/assets/DynamicGeometry/ShapeCanvas.js" type="text/javascript"></script>
  <script src="${path }/assets/DynamicGeometry/ActiveMove.js" type="text/javascript"></script>
  <script src="${path }/assets/DynamicGeometry/ShapeDefaultConfig.js" type="text/javascript"></script>
  <script src="${path }/assets/DynamicGeometry/Shape.js" type="text/javascript"></script>
  <script src="${path }/assets/DynamicGeometry/Line.js" type="text/javascript"></script>
  <script src="${path }/assets/DynamicGeometry/Arrow.js" type="text/javascript"></script>
  <script src="${path }/assets/DynamicGeometry/Rectangle.js" type="text/javascript"></script>
  <script src="${path }/assets/DynamicGeometry/Remark.js" type="text/javascript"></script>
  <script src="${path }/assets/DynamicGeometry/Position.js" type="text/javascript"></script>
  <script src="${path }/assets/DynamicGeometry/Ellipse.js" type="text/javascript"></script>
  <script src="${path }/assets/DynamicGeometry/CurveRounded.js" type="text/javascript"></script>
  <script src="${path }/assets/DynamicGeometry/Curve.js" type="text/javascript"></script>
  <script src="${path }/assets/DynamicGeometry/SizeOrientation.js" type="text/javascript"></script>
  <script src="${path }/assets/DynamicGeometry/Measure.js" type="text/javascript"></script>
  <script src="${path }/assets/DynamicGeometry/Point.js" type="text/javascript"></script>
  <script src="${path }/assets/DynamicGeometry/Grid.js" type="text/javascript"></script>
  <script src="${path }/assets/DynamicGeometry/Ruler.js" type="text/javascript"></script>
  <script src="${path }/assets/DynamicGeometry/SlideLabel.js" type="text/javascript"></script>
  <script src="${path }/assets/js/hammer.min.js" type="text/javascript"></script>

</head>
<body style="overflow: hidden">
<form method="post" action="./mobileViewer.aspx?caseno=2200&amp;SlideID=0f231fb7-209e-4d09-be67-46ce07ca30c0&amp;sync=1"
      id="form1">
  <div class="aspNetHidden">
    <input type="hidden" name="__VIEWSTATE" id="__VIEWSTATE"
           value="/wEPDwUKMTIwMTgyMTAxNw8WAh4QbVN5bmNJbWFnZVNlcnZlcgUTMTkyLjE2OC4yMC4xMDA6ODAzMGRkvLjzJkCx7OLbjGU7JDcwONkm4oXQMmibf0GIf/N6hoI="/>
  </div>
  <div class="aspNetHidden">
    <input type="hidden" name="__VIEWSTATEGENERATOR" id="__VIEWSTATEGENERATOR" value="54576B79"/>
  </div>
</form>

<div id="btn">
  <text id="text" hidden></text>
  <img id="Full" style="width: 40px; height: 40px;display:none" onclick="launchFullscreen(document.documentElement);"
       class="sexyButton" src="${path }/assets/image/tupian.jpg"/>
  <img id="Out" style="width: 40px; height: 40px; background-color:blue" onclick="exitFullscreen();"
       hidden class="sexyButton" src="${path }/assets/image/tuchu.jpg"/>
</div>
<div id="container">
</div>
<img id="xinxi" style="bottom: 2px; width: 240px; height: 115px; position:fixed;
        right: 24px; overflow: hidden; overflow-x: auto; -webkit-overflow-y: auto; -webkit-overflow-scrolling: touch;
        border: 1px solid rgb(49, 157, 206);" src="">
<div style="bottom: 2px; position:fixed; right:0px ; background-color: white;
        border: 2px solid rgb(49, 157, 206);" onclick="qiepian(this)">
  <img src="${path }/assets/image/la_no.png" id="Img1"/>
</div>
<div id="Tag" style="bottom: 120px; width: 240px; height: 105px; position:fixed;
        right: 22px; overflow: hidden; overflow-x: auto; -webkit-overflow-y: auto; -webkit-overflow-scrolling: touch;
        border: 2px solid rgb(49, 157, 206);">
  <ol>
    <li>
      <h2><span><img src="${path }/assets/image/234.png"/></span></h2>
      <div style="padding: 0px; height: 105px; margin-left: 20px;">
        <div>
          <img src="${path }/assets/image/zx.png" width="35px" style="cursor: pointer" id="img_zx" title="直线"
               class="xz"/>
          <img src="${path }/assets/image/jt.png" width="35px" style="cursor: pointer" id="img_jt" title="箭头"
               class="xz"/>
          <img src="${path }/assets/image/jx.png" width="35px" style="cursor: pointer" id="img_jx" title="矩形"
               class="xz"/>
          <img src="${path }/assets/image/ty.png" width="35px" style="cursor: pointer" id="img_ty" title="椭圆"
               class="xz"/>
          <img src="${path }/assets/image/pen.png" width="35px" style="cursor: pointer" id="img_pen"
               title="自由曲线" class="xz"/>
          <img src="${path }/assets/image/pin.png" width="35px" style="cursor: pointer" id="img_pin"
               title="标注" class="xz"/></div>
        <div>
          <button style="width: 40px; color: white; padding: 2px; margin: 2px" class="btn btn-primary"
                  id="btn_edit">编辑
          </button>
          <button style="width: 40px; color: white; padding: 2px; margin: 2px" class="btn btn-danger"
                  id="btn_delete">删除
          </button>
        </div>
      </div>
    </li>
    <li>
      <h2><span><img src="${path }/assets/image/345.png"/></span></h2>
      <div style="height: 109px">
        <button style="width:60px;color:White; padding:2px; margin:2px" class="btn btn-primary"
                onclick="getposition();">当前位置
        </button>
        <div style="height: 40px; font-size: 14px">
          导航图：
          <input checked type="checkbox" style="padding: 2px" onchange="isnav(this)"/>
        </div>
        <div style="font-size: 14px">
          倍率条：
          <input checked type="checkbox" style="padding: 2px" onchange="isbar(this)"/>
        </div>
      </div>
    </li>
  </ol>
</div>
<div style="bottom: 120px; position:fixed; right:0px ; background-color: white; display:none;
        border: 1px solid rgb(49, 157, 206);" onclick="list(this)">
  <img src="${path }/assets/image/la_no.png" id="Img2"/>
</div>

<div id="divScreenShotList" style="position: absolute; z-index: 999; bottom: 2px; left: 238px; filter: alpha(opacity=90);
        opacity: 0.9;" onclick="toolswitch(this)">
  <img src="${path }/assets/image/la_no.png" id="toolimg"/>
</div>
<div id="one" style="position: absolute; z-index: 999; bottom: 2px; left: 0px; filter: alpha(opacity=90);
        opacity: 0.9; border: 1px solid rgb(49, 157, 206)">
  <ol>
    <li id="li_shot">
      <h2><span><img src="${path }/assets/image/123.png"/></span></h2>
      <div style="position: absolute; height: 108px; background: white; overflow-y: auto; -webkit-overflow-y: auto;"
           id="newshot">
      </div>
    </li>
  </ol>
</div>

<div id='SlideLists'
     style='position:absolute;left:0px;bottom:110px;width:240px;height:115px;max-height:125px;overflow:hidden;overflow-y:auto;-webkit-overflow-y:auto;-webkit-overflow-scrolling:touch;border: 1px solid rgb(49, 157, 206);'>
  <ul id='SlideUl' style='margin:0px;padding:0px'>
  </ul>
</div>
<div id='slides'
     style='position:absolute;left:238px;bottom:110px;background-color:white;border: 2px solid rgb(49, 157, 206);border-left-width:0px;'
     onclick='ck(this)'><img id='SlideImg' src='${path}/assets/image/la_no.png'/></div>

<div id="over" class="over">
</div>
<div id="layout" class="layout">
  <img src="${path }/assets/image/Loading1.gif" alt=""/></div>
<div id="divTop"
     style=" background-color:#FFE4C4; border: solid 1px #121212; position: absolute ; margin:-25px 0 0  -200px ; left:50%;  top:50%; display:none; width:400px;text-align:center; height:50px;">
  <div style="text-align:center;"><span style="font-size:30px; color:#121212;font-weight:bold;">请按F11切换全屏</span></div>
  <div id="abcdef"></div>
</div>
</body>
</html>

<script>
  var mFirstLoad = 0;
  var loc = document.location.href;
  var uabc = '/pathology';
  var WebReLocation = '';
  var WebServerUrl = "http://" + window.location.host + uabc + "/PathologyAction!";
  var WebServerShotUrl = "http://" + window.location.host + uabc + "/PathologyAction!";
  //var WebReLocation = '';
  var SyncImageServer = '192.168.20.100:8030';
  var mCurrentLevel = 0;
  //var mCurrentSlideID = '';
  var viewer;

  function getposition() {
    var center = viewer.viewport.getCenter();
    var Scale = viewer.getScale() * viewer.getCurrentImage().Rate;
    var x = center.x;
    var y = center.y;
    var currUrl = document.location.href;
    //currUrl + "&scale=" + Scale + "&x=" + x + "&y=" + y;
    currUrl = changeURLPar(currUrl, "SlideID", mCurrentSlideID);
    currUrl = changeURLPar(currUrl, "scale", Scale); //  + "&x=" + x + "&y=" + y;
    currUrl = changeURLPar(currUrl, "x", x);
    currUrl = changeURLPar(currUrl, "y", y);
    currUrl = changeURLPar(currUrl, "level", mCurrentLevel);
    //window.clipboardData.setData('text', currUrl);
    prompt("按 Ctrl + C 键复制", currUrl)
  }

  /**
   * 改变URL的参数
   * @param url 当前URL
   * @param ref 要改变的参数名称
   * @param value 要改变的参数值
   * @returns {string}完整的URL
   */
  function changeURLPar(url, ref, value) {
    var str = "";
    if (url.indexOf('?') !== -1) {
      // 截取问号后面的参数
      str = url.substr(url.indexOf('?') + 1);
    } else {
      // 没有参数，拼上参数，返回url
      return url + "?" + ref + "=" + value;
    }
    var returnurl = "";
    var setparam = "";
    var arr;
    var modify = "0";

    if (str.indexOf('&') !== -1) {
      // 当前URL包含多个参数
      arr = str.split('&'); // 获取参数数组
      for (var i in arr) {
        /*
         * 如果参数名与传入的相同，则将传入的参数值赋值给setparam，否则将当前参数值赋值给setparam
         */
        if (arr[i].split('=')[0] === ref) {
          setparam = value;
          modify = "1";
        } else {
          setparam = arr[i].split('=')[1];
        }
        // 拼接新的URL
        returnurl = returnurl + arr[i].split('=')[0] + "=" + setparam + "&";
      }
      // 新URL
      returnurl = returnurl.substr(0, returnurl.length - 1);

      /*
       * 如果URL没有被修改过，并且URL值没有改变（URL中不包含传入的参数），将传入的参数添加上去
       */
      if (modify === "0") {
        if (returnurl === str) {
          returnurl = returnurl + "&" + ref + "=" + value;
        }
      }
    } else {
      // 当前URL只包含一个参数
      if (str.indexOf('=') !== -1) {
        // 有参数值
        arr = str.split('=');

        if (arr[0] === ref) {
          setparam = value;
          modify = "1";
        } else {
          setparam = arr[1];
        }
        returnurl = arr[0] + "=" + setparam;
        if (modify === "0") {
          if (returnurl === str) {
            returnurl = returnurl + "&" + ref + "=" + value;
          }
        }
      } else {
        // 没有参数值，将当前传入的值添加上去
        returnurl = ref + "=" + value;
      }
    }
    // 返回完整的URL
    return url.substr(0, url.indexOf('?')) + "?" + returnurl;
  }

  //切片图标签
  function qiepian() {
    var display = $("#xinxi").css("display");
    if (display === "none") {
      $("#xinxi").css("display", "block");
      $(this).css("right", "238px");
      $("#Img1").attr("src", "${path}/assets/image/la_no.png");
    } else {
      $("#xinxi").css("display", "none");
      $(this).css("right", "0px");
      $("#Img1").attr("src", "${path}/assets/image/biaoqiantu.png");
    }
  }

  qiepian();//默认收起标签图

  //工具列表
  function list() {
    var display = $("#Tag").css("display");
    if (display === "none") {
      $("#Tag").css("display", "block");
      $(this).css("right", "238px");
      $("#Img2").attr("src", "assets/image/la_no.png");
    } else {
      $("#Tag").css("display", "none");
      $(this).css("right", "0px");
      $("#Img2").attr("src", "assets/image/xitonggongju.png");

    }
  }

  list();//默认收起工具列表

  // 全屏
  var system = {};
  var p = navigator.platform;
  system.win = p.indexOf("Win") === 0;
  system.mac = p.indexOf("Mac") === 0;
  system.x11 = (p === "X11") || (p.indexOf("Linux") === 0);
  if (system.win || system.mac || system.xll) {

  } else {  //如果是手机
    $("#Full").css("display", "none");
  }

  function launchFullscreen(element) {
    if (element.requestFullscreen) {
      document.getElementById('Full').style.display = 'none';
      document.getElementById('Out').style.display = 'block';
      element.requestFullscreen();
    } else if (element.mozRequestFullScreen) {
      document.getElementById('Full').style.display = 'none';
      document.getElementById('Out').style.display = 'block';
      element.mozRequestFullScreen();
    } else if (element.webkitRequestFullscreen) {
      document.getElementById('Full').style.display = 'none';
      document.getElementById('Out').style.display = 'block';
      element.webkitRequestFullscreen();
    } else if (element.msRequestFullscreen) {

      //IE全屏判断提示
      $("#divTop").toggle();
      setTimeout(function () {
        $('#divTop').hide();
      }, 1000)

    }

  }

  function exitFullscreen() {
    document.getElementById('Out').style.display = 'none';
    document.getElementById('Full').style.display = 'block';
    if (document.exitFullscreen) {
      document.exitFullscreen();
    } else if (document.mozCancelFullScreen) {
      document.mozCancelFullScreen();
    } else if (document.webkitExitFullscreen) {
      document.webkitExitFullscreen();
    }
  }

  //截图列表
  function toolswitch(isExtend) {
    var display = $("#one").css("display");
    if (isExtend === "1")
      display = "none";
    if (display === "none") {
      $("#one").css("display", "block");
      //$(v).css("left", "238px");
      $("#divScreenShotList").css("left", "238px");
      $("#toolimg").attr("src", "assets/image/la_no.png");
    }
    else {
      $("#one").css("display", "none");
      //$(v).css("left", "0px");
      if (getQueryString("CanScreenShot") === "1")
        $("#divScreenShotList").css("left", "0px");
      else
        $("#divScreenShotList").css("display", "none");

      $("#toolimg").attr("src", "assets/image/jietuliebiao.png");

    }
  }

  function isnav(v) {
    var cv = $(v).attr("checked");
    if (cv === "checked") {
      $("#Thumbnail").css("display", "");
    }
    else {
      $("#Thumbnail").css("display", "none");
    }
  }

  function isbar(v) {
    var cv = $(v).attr("checked");
    if (cv === "checked") {
      $(".NavBar_zoomControlContainer").css("display", "");
    }
    else {
      $(".NavBar_zoomControlContainer").css("display", "none");
    }
  }

  $('#one').liteAccordion({
    onTriggerSlide: function () {
      this.find('figcaption').fadeOut();
    },
    onSlideAnimComplete: function () {
      this.find('figcaption').fadeIn();
    },
    autoPlay: false,
    pauseOnHover: true,
    //                    theme: 'stitch',
    dark: true,
    enumerateSlides: false
  }).find('figcaption:first').show();

  //列表折叠
  $('#Tag').liteAccordion({
    onTriggerSlide: function () {
      this.find('figcaption').fadeOut();
    },
    onSlideAnimComplete: function () {
      this.find('figcaption').fadeIn();
    },
    autoPlay: false,
    pauseOnHover: true,
    //                    theme: 'stitch',
    dark: true,
    enumerateSlides: false
  }).find('figcaption:first').show();

  var SlideIDss;

  function getGamma() {
    var ColorConfig = {Gamma: 1.5, Contrast: 1, Light: 0, RgbR: 0, RgbG: 0, RgbB: 0};
    return ColorConfig;
  }

  function showLoading() {
    document.getElementById("over").style.display = "block";
    document.getElementById("layout").style.display = "block";
  }

  function hideLoading() {
    document.getElementById("over").style.display = "none";
    document.getElementById("layout").style.display = "none";
  }

  function Frms(slideid) {
    var ProxyIP = getQueryString("ProxyIP");
    if (ProxyIP !== "") {
      ProxyIP = "&ProxyIP=" + ProxyIP;
    }

    var SlidePath = getQueryString("SlidePath");
    if (SlidePath !== "") {
      SlidePath = "&SlidePath=" + SlidePath;
    }

    var syncc = "";
    if (sign !== null) {
      syncc = "&sync=" + sign;
    }
    var masterc = "";
    if (master !== null) {
      masterc = "&master=" + master;
    }

    window.location.href = "mobileViewer.aspx?caseno=" + getQueryString("caseno") + "&SlideID=" + slideid + "&CanScreenShot=" + getQueryString("CanScreenShot") + "&ram=" + Math.random(0, 9999) + ProxyIP + SlidePath + syncc + masterc;
  }

  function getQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r = window.location.search.substr(1).match(reg);
    if (r !== null)
      return unescape(r[2]);
    return "";
  }

  function getVer() {
    var ver = '2.1.1.0';
    return ver;
  }

  function isIElast() {
    var t;
    var browser = navigator.appName;
    var b_version = navigator.appVersion;
    var version = b_version.split(";");
    if (version[1] !== null) {
      var trim_Version = version[1].replace(/[ ]/g, "");
    }
    if (browser === "Microsoft Internet Explorer") {
      return trim_Version === "MSIE6.0" || trim_Version === "MSIE7.0" || trim_Version === "MSIE8.0" ? t = !1 : t = !0,
          t;
    } else {
      return !0
    }
  }

  function GotoSlide(slidesysid) {
    var container = $("#container");
    container.height($(window).height());
    SlideViewerConfig.language = $.cookie("Language");
    viewer = SlideSeadragonViewer.createViewer("container");
    viewer.openMds(slidesysid);
    sign = GetQueryParamValue("sync");
    master = GetQueryParamValue("master");
    // sign表示使用同步功能
    if (sign !== null && sign === "1") {
      //alert(syncState);
      if (syncState !== "connected") {
        ConnectServer("", "", "", "", viewer);
      }
    }
  }

  $(document).ready(function () {
    $(":checkbox").checkboxpicker({
      offLabel: '关',
      onLabel: '开'
    });
    var cansc = getQueryString("canscreenshot");
    if (cansc && cansc === "1") {
      toolswitch("1"); //0=收起截图列表;1=展开
    } else {
      toolswitch("0"); //0=收起截图列表;1=展开
    }
    var SlideID = getQueryString("SlideID");
    var Case_No = getQueryString("caseId");
    GetSlideList(Case_No, SlideID);
    GotoSlide(SlideID);
    /*
    var slideId = 0; // parseID();
    var container = $("#container");
    container.height($(window).height());
    SlideViewerConfig.language = $.cookie("Language");
    viewer = SlideSeadragonViewer.createViewer("container");
    viewer.openMds(slideId);
    sign = GetQueryParamValue("sync");
    master = GetQueryParamValue("master");
    if (sign != null && sign == "1") //sign表示使用同步功能
    {
    //alert(syncState);
    if (syncState != "connected")
    ConnectServer("", "", "", "", viewer);
    }
    */
  });

  window.onbeforeunload = function () {
    try {
      syncSocket.close();
      syncSocket = null;
    } catch (ex) {
      //log(ex);
    }
  };

  function FormatSyncMsg() {
  }

  function GetQueryParamValue(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r = window.location.search.substr(1).match(reg);
    if (r !== null) {
      return (r[2]);
    }
    return null;
  }

  function choose() {
    var a = document.getElementById("AnnoName");
    if (a.options.length > 0) {
      var text = a.options[a.selectedIndex].text;
      for (var j = 0; j < anno.length; j++) {
        if (anno[j].name === text) {
          i = anno[j];
          isDisabled(i);
          var r = i.viewer.getShapeCanvas();
          var Anno = r.getAnnotation();
          r.setSelectedEnable(!1);
          r.getActiveShape(i);
          i && $("#linewidth").val(i.width), $("#Picker").val(i.color), $("#annoname").val(i.name), $("#annodesc").val(i.description), $("#Measurement").html($(i.txtElmt).html().split("描述")[0]),
              i.isSelected = true, r.showassets / imageAnnotations();
        }
      }
    }
  }

  function isDisabled(t) {
    var input = $('input[name="identitys"]');
    for (var i = 0; i < input.length; i++) {
      if (t.type !== "Position") {
        input[i].disabled = true;
      } else {
        input[i].disabled = false;
      }
    }
  }

  function parseID() {
    var url = location.href;
    var index = url.indexOf('?');
    var args = url.substring(index + 1).split('&');
    for (var i = 0; i < args.length; i++) {
      var nameValues = args[i].split('=');
      if (nameValues.length === 2) {
        if (nameValues[0].toLowerCase() === "caseno") {
          slideId = parseInt(nameValues[1]);
          return slideId;
        } else if (nameValues[0].toLowerCase() === "slideid") {
          slideId = parseInt(nameValues[1]);
          return slideId;
        }
      }
    }
  }

  function isMobile() {
    var t;
    var sUserAgent = navigator.userAgent.toLowerCase();
    var bIsIpad = sUserAgent.match(/ipad/i) == "ipad";
    var bIsIphoneOs = sUserAgent.match(/iphone os/i) == "iphone os";
    var bIsMidp = sUserAgent.match(/midp/i) == "midp";
    var bIsUc7 = sUserAgent.match(/rv:1.2.3.4/i) == "rv:1.2.3.4";
    var bIsUc = sUserAgent.match(/ucweb/i) == "ucweb";
    var bIsAndroid = sUserAgent.match(/android/i) == "android";
    var bIsCE = sUserAgent.match(/windows ce/i) == "windows ce";
    var bIsWM = sUserAgent.match(/windows mobile/i) == "windows mobile";
    if (!(bIsIpad || bIsIphoneOs || bIsMidp || bIsUc7 || bIsUc || bIsAndroid || bIsCE || bIsWM)) {
      return t = !1, t;
    } else {
      return t = !0, t;
    }
  }

  /* End */
</script>