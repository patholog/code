<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>病理远程会诊平台</title>
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
      float: left;
      /*width: 960px;*/
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
  <script type="text/javascript" src="${path }/js/CKEditor/ckeditor.js"></script>
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
      outline: solid thin #bbb;
      margin: 0 8px;
      padding: 0 7px;
    }

    .fl_r_table textarea {
      font-size: 14px;
      outline: solid thin #bbb;
      resize: none;
      width: 400px;
      padding: 0 7px;
    }

    .input-20 {
      width: 20px;
    }

    .input-30 {
      width: 30px;
    }

    .input-50 {
      width: 50px;
    }

    .input-120 {
      width: 120px;
    }

    .input-150 {
      width: 150px;
    }

    .main-contents {
      padding-left: 10px;
    }

    span.red-star, .half-word {
      display: inline-block;
      *display: inline;
      *zoom: 1;
      width: 0.5em;
    }

    span.red-star {
      color: #cb1d20;
    }

    .remarks {
      line-height: 25px;
      font-size: 14px;
      padding: 0 8px;
      border-radius: 3px;
      margin-top: 10px;
      background-color: #e4e4e4;
      border: 1px solid #dcdcdc;
      width: auto;
    }

    hr.split-line {
      border: 1px solid #63B8FF;
    }
  </style>
  <link rel="stylesheet" type="text/css" href="${path }/css/diag_theme.css"/>
  <link rel="stylesheet" type="text/css" href="${path }/css/diag_style.css"/>
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
    <td class="main-contents">
      <div class="box">
        <ul class="fl_t">
          <li class="active"><a href="#">病历信息</a></li>
          <li><a href="#">附件&切片</a></li>
          <li><a href="#">填写诊断</a></li>
          <li><a href="#">留言</a></li>
        </ul>
        <ul class="fl_r">
          <li>
            <div class="in_box_bl inbox_0">
              <div id="divTitle">
                <div class="title">
                  <span class="left">诊断报告</span>
                  <a class="history">
                    <div class="share right">分享</div>
                  </a>
                  <a class="history">
                    <div class="print right">打印</div>
                  </a>
                  <a class="history">
                    <div class="export right">导出</div>
                  </a>
                  <a class="history">
                    <div class="show-history right">病史备注</div>
                  </a>
                </div>
              </div>
              <div id="divReport">
                <div class="logo-title">
                  <span>病理远程会诊咨询意见书</span>
                </div>
                <div class="subtitle">
                  <span>原病理号：17040601</span>
                  <span>会诊号：20170406800</span>
                </div>
                <div class="hr-report">
                  <hr>
                </div>
                <div class="">
                  <table>
                    <tr>
                      <td>
                        <label>姓名：</label>
                        <span><s:property value="pathology.patientname"/></span>
                      </td>
                      <td>
                        <label>性别：</label>
                        <span><s:property value="pathology.patientSex"/></span>
                      </td>
                      <td>
                        <label>年龄：</label>
                        <span><s:property value="pathology.patientAge"/></span>
                      </td>
                      <td>
                        <label>送检时间：</label>
                        <span><s:property value="pathology.inspectionDate"/></span>
                      </td>
                    </tr>
                    <tr>
                      <td colspan="2">
                        <label>送检单位：</label>
                        <span>未处理</span>
                      </td>
                      <td>
                        <label>切片&附件数：</label>
                        <span>未处理</span>
                      </td>
                      <td>
                        <label>诊断时间：</label>
                        <span><s:property value="pathology.createTime"/></span>
                      </td>
                    </tr>
                  </table>
                </div>
                <div>
                  <hr>
                </div>
                <div>
                  <span>临床资料（手术所见、影像学、相关检验等）：</span>
                  <div>
                    <span><s:property value="pathology.clinicDiagnose"/></span>
                  </div>
                </div>
                <hr>
                <div>
                  <span>材料部位：</span>
                  <div>
                    <span><s:property value="pathology.specimenName"/></span>
                  </div>
                </div>
                <hr>
                <div>
                  <span>大体所见：</span>
                  <div>
                  <textarea id="generalSee" cols="10" rows="1" class="ckeditor">
                    <s:property value="pathology.generalSee"/>
                  </textarea>
                  </div>
                </div>
                <hr>
                <div>
                  <span>免疫组化：</span>
                  <div>
                    <span>未处理免疫组化</span>
                  </div>
                </div>
                <hr>
                <div>
                  <span>初诊意见（或其他单位诊断意见）：</span>
                  <div>
                    <span>未处理</span>
                  </div>
                </div>
                <hr>
                <div>
                  <span>病理图像：</span>
                  <div>
                    <img alt="未处理">
                  </div>
                </div>
                <hr>
                <div>
                  <span>远程病理专家诊断意见：</span>
                  <div>
                    <span>未处理</span>
                  </div>
                </div>
                <div class="divFoot">
                  <div style="float: left;">
                    <span>注：</span>
                  </div>
                  <div style="float: left;">
                    <span>会诊资料局限，以上报告仅为所见切片的咨询意见，仅供原单位病理科参考。</span>
                    <br>
                    <span>如治疗，请结合原单位临床资料综合分析。</span>
                  </div>
                </div>
                <hr>
                <div>
                  <span>本报告由武汉千屏影像技术有限责任公司  </span>
                  <span>袁主任</span>
                  <span>专家会诊</span>
                </div>
              </div>
            </div>
          </li>
          <li>
            <div class="upload-module">
              <div class="title-left">上传切片</div>
              <table class="listtable" cellspacing="0" cellpadding="0" width="100%">
                <tbody>
                <tr>
                  <th>序号</th>
                  <th>状态</th>
                  <th>切片名称</th>
                  <th>上传时间</th>
                  <th>物镜倍数</th>
                  <th>切片大小</th>
                  <th>免疫组化</th>
                  <th>操作</th>
                </tr>
                <s:iterator value="pathologys" id="pathology" status="11">
                  <tr>
                    <td><s:property value="#pathology.pathologyNo"/></td>
                    <td><s:property value="#pathology.patientname"/></td>
                    <td><s:property value="#pathology.patientname"/></td>
                    <td><s:property value="#pathology.username"/></td>
                    <td><s:property value="#pathology.content"/></td>
                    <td><s:property value="#pathology.hospitalname"/></td>
                    <td><s:property value="#pathology.createTime"/></td>
                    <td align="center">
                      <a href="PathologyAction!null?id=<s:property value="#pathology.caseId"/> target='_blank'">查看</a>
                    </td>
                  </tr>
                </s:iterator>
                <tr class="lightrow">
                  <td colspan="8">
                    <div id="pageDir">
                      <%=request.getAttribute("page") != null ? request.getAttribute("page") : "" %>
                    </div>
                  </td>
                </tr>
                </tbody>
              </table>
            </div>
          </li>
          <li style="height: 400px;">填写诊断内容3</li>
          <li style="height: 500px;">留言内容4</li>
        </ul>
        <div style="clear: both;"></div>
      </div>
    </td>
  </tr>
</table>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script>
  $(function () {
    // 禁用所有input
    $('input').attr("disabled", "true");
    $('textarea').attr("disabled", "true");
    $('select').attr("disabled", "true");
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