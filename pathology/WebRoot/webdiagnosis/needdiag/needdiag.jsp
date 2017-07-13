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
    body {
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
      alignment: top;
    }

    .fl_r li {
      margin-top: 10px;
      margin-bottom: 30px;
      background: #fff;
      font-size: 16px;
    }

    .fl_r_row {
      margin-top: 10px;
      margin-bottom: 10px;
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
  <style>
    .fl_r_table {
      font-size: 16px;
    }
    .fl_r_table_tr {
      margin: 15px 0;
    }
    .fl_r_table label {
      font-size: 16px;
    }
    .fl_r_table input {
      font-size: 14px;
      outline: solid thin #555555;
    }
    .input-50 {
      width: 50px;
    }
    .input-80 {
      width: 80px;
    }
    .input-120 {
      width: 120px;
    }
    .input-150 {
      width: 150px;
    }
  </style>
</head>
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
          <li style="height: 600px;">
            <hr>
            <div class="fl_r_row">
              <span>请选择会诊分类</span>
              <input name="hzlx" type="radio" value="1">普通会诊
              <input name="hzlx" type="radio" value="2">冰冻会诊
            </div>
            <hr>
            <div class="fl_r_row">
              <table class="fl_r_table">
                <tr class="fl_r_table_tr">
                  <td>
                    <label for="name">病人姓名</label>
                    <input class="input-80" id="name" type="text" value="姓名">
                  </td>
                  <td>
                    <label for="blh">病理号</label>
                    <input class="input-120" id="blh" type="text" value="123">
                  </td>
                  <td>
                    <label for="age">年龄</label>
                    <input class="input-50" id="age" type="text" value="12">
                  </td>
                  <td>
                    <label for="sex">性别</label>
                    <select id="sex">
                      <option value="1" selected>男</option>
                      <option value="2">女</option>
                    </select>
                  </td>
                  <td>
                    <label for="qcbw">取材部位</label>
                    <input id="qcbw" type="text" value="脚趾">
                  </td>
                </tr>
                <tr>
                  <td>
                    <label for="sfzh">身份证号</label>
                    <input class="input-150" id="sfzh" type="text" value="110101199901011234">
                  </td>
                  <td>
                    <label for="mobile">手机号</label>
                    <input class="input-120" id="mobile" type="text" value="18600001111">
                  </td>
                  <td colspan="2">
                    <label for="mobileRel">家属电话</label>
                    <input class="input-120" id="mobileRel" type="text" value="18600002222">
                  </td>
                  <td>
                    <label for="sjDate">送检时间</label>
                    <input class="input-150" id="sjDate" type="text" value="2017-01-01 12:12:12">
                  </td>
                </tr>
              </table>
            </div>
            <hr>
          </li>
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
