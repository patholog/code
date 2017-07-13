<%@ page language="java" contentType="text/html;charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>待诊断初步</title>
  <style type="text/css">
    * {
      margin: 0;
      padding: 0;
    }

    body {
      background: #ddd;
    }

    ul {
      list-style: none;
    }

    a {
      text-decoration: none;
    }

    .nav {
      background: #fff;
      width: 100%;
      height: 100px;
      font-size: 20px;
      line-height: 100px;
      text-align: center;
      border-bottom: 1px solid #f60;
    }

    .box {
      margin: 0 auto;
      width: 950px;
    }

    .fl_l {
      width: 200px;
      float: left;
      border: 1px solid #f4f4f4;
      background: #fff;
    }

    .fl_l li a {
      border-bottom: 1px solid #eee;
      text-align: center;
      display: inline;
      color: #333;
      font-size: 14px;
      line-height: 60px;
    }

    .fl_l li.active a {
      background: #63B8FF;
      color: #fff;
    }

    .fl_r {
      float: right;
      width: 960px;
    }

    .fl_r li {
      margin-bottom: 30px;
      background: #fff;
      font-size: 50px;
      line-height: 300px;
      display: block;
      text-align: center;
    }

    .fl_t {
      width: 800px;
      float: left;
      border: 1px solid #f4f4f4;
      background: #fff;
      white-space: nowrap;
    }

    .fl_t li {
      display: inline-block;
    }

    .fl_t li a {
      width: 200px;
      border-bottom: 1px solid #eee;
      text-align: center;
      display: inline-block;
      color: #333;
      font-size: 14px;
      line-height: 60px;
    }

    .fl_t li.active a {
      background: #63B8FF;
      color: #fff;
    }

    .banner {
      background: #fff;
      width: 100%;
      height: 600px;
      font-size: 40px;
      line-height: 600px;
      text-align: center;
      margin-bottom: 30px;
    }
  </style>
</head>
<meta name="Copyright" content="Douco Design."/>
<link href="css/public.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/global.js"></script>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<link rel="stylesheet" type="text/css" href="${path }/css/style.css"/>
<script type="text/javascript" src="${path }/CKEditor/ckeditor/ckeditor.js"></script>
<script type="text/javascript" src="${path }/CKFinder/ckfinder/ckfinder.js"></script>
<script type="text/javascript" src="${path }/js/treeView.js"></script>
<script type="text/javascript" src="${path }/js/common-cn.js"></script>
<script type="text/javascript" src="${path }/js/forbid-refresh.js"></script>
<body>
<div id="header">
  <%@include file="/webdiagnosis/maintop.jsp" %>
</div>
<table id="main" cellpadding="0" cellspacing="0" border="0">
  <tr>
    <td id="leftmenu">
      <%@include file="/webdiagnosis/mainleft.jsp" %>
    </td>
    <td id="contents">
      <div class="box">
        <ul class="fl_t">
          <li class="active"><a href="#">病历信息</a></li>
          <li><a href="#">附件&切片</a></li>
          <li><a href="#">填写诊断</a></li>
          <li><a href="#">留言</a></li>
        </ul>
        <ul class="fl_r">
          <li style="height: 600px;">病历信息内容1</li>
          <li style="height: 600px;">附件切片内容2</li>
          <li style="height: 400px;">填写诊断内容3</li>
          <li style="height: 500px;">留言内容4</li>
        </ul>
        <div style="clear: both;"></div>
      </div>
    </td>
  </tr>
</table>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript">
  $(function () {
    //设置标杆
    var _line = parseInt($(window).height() / 3);
    $(window).scroll(function () {
      //滚动730px，左侧导航固定定位
      if ($(window).scrollTop() > 730) {
        $('.fl_t').css({'position': 'fixed', 'top': 10})
      } else {
        $('.fl_t').css({'position': '', 'top': ''})
      }
      ;
      $('.fl_t li').eq(0).addClass('active');
      //滚动到标杆位置,左侧导航加active
      $('.fl_r li').each(function () {
        var _target = parseInt($(this).offset().top - $(window).scrollTop() - _line);
        var _i = $(this).index();
        if (_target <= 0) {
          $('.fl_t li').removeClass('active');
          $('.fl_t li').eq(_i).addClass('active');
        }
        //如果到达页面底部，给左侧导航最后一个加active
        else if ($(document).height() == $(window).scrollTop() + $(window).height()) {
          $('.fl_t li').removeClass('active');
          $('.fl_t li').eq($('.fl_r li').length - 1).addClass('active');
        }
      });
    });
    $('.fl_t li').click(function () {
      $(this).addClass('active').siblings().removeClass('active');
      var _i = $(this).index();
      $('body, html').animate({scrollTop: $('.fl_r li').eq(_i).offset().top - _line}, 500);
    });
  });
</script>
<div style="text-align:center;">
</div>
</body>
</html>
