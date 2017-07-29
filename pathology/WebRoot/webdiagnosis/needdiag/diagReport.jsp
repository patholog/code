﻿<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>病理远程会诊平台</title>
  <meta name="Copyright" content="Douco Design."/>
  <c:set var="path" value="${pageContext.request.contextPath }"/>
  <link rel="stylesheet" href="${path }/css/public_flat.css"/>
  <link rel="stylesheet" href="${path }/css/theme.css"/>
  <link rel="stylesheet" href="${path }/css/comc_head_style.css"/>
  <link rel="stylesheet" href="${path }/css/comc_diagnosis_wait_in_style.css"/>
  <link rel="stylesheet" href="${path }/css/comc_diagnosis_wait_on_style.css"/>
  <link rel="stylesheet" href="${path }/css/comc_left_nav_style.css"/>
  <link rel="stylesheet" href="${path }/css/comc_page_style.css"/>
  <link rel="stylesheet" href="${path }/css/WdatePicker.css"/>
  <link rel="stylesheet" href="${path }/css/weebox.css"/>
  <link rel="stylesheet" href="${path }/js/iviewer/jquery.iviewer.css"/>
  <script type="text/javascript" src="${path }/js/jquery.min.js"></script>
  <script type="text/javascript" src="${path }/js/global.js"></script>
  <script type="text/javascript" src="${path }/js/CKEditor/ckeditor.js"></script>
  <script type="text/javascript" src="${path }/CKFinder/ckfinder/ckfinder.js"></script>
  <script type="text/javascript" src="${path }/js/treeView.js"></script>
  <script type="text/javascript" src="${path }/js/common-cn.js"></script>
  <script type="text/javascript" src="${path }/js/forbid-refresh.js"></script>
  <script type="text/javascript" src="${path }/js/scrolllisten.js"></script>
  <style type="text/css">
    #divGeneralObservation img
    {
      width:auto;
      cursor:pointer;
    }
    .viewer
    {
      width: 50%;
      height: 500px;
      border: 1px solid black;
      position: relative;
      background-color:White;
    }
    .wrapper
    {
      overflow: hidden;
    }
  </style>
</head>
<body>
<form>
  <div id="whole" class="mlrAuto">
    <div class="header">
      <%@include file="/webdiagnosis/maintop.jsp" %>
    </div>
    <%--<div class="menu_left">
      <ul id="Left1_MenuList">
        <%@include file="/webdiagnosis/mainleft.jsp" %>
      </ul>
    </div>--%>
    <div id="divAllBoxTop" class="in_box">
      <div id="divAllBoxLeft" class="in_box_section" style="margin-bottom:20px;">
        <div id="leftDiv" class="left in_box_nav">
          <div class="nav" style="min-height:298px;">
            <ul>
              <li class="in_box_nav_on">
                <p class="left">
                </p>
                <a href="#inbox_0" class="right"><span class="in_box_nav_icon0"></span>诊断报告</a>
              </li>

              <li class="">
                <p class="left">
                </p>
                <a href="#inbox_2" class="right"><span class="in_box_nav_icon2"></span>附件&amp;切片</a>
              </li>
              <li class="">
                <p class="left"></p><a href="#inbox_3" class="right"><span class="in_box_nav_icon3"></span>留言</a>
              </li>
            </ul>
            <div class="clear">
            </div>
          </div>
        </div>
        <div class="right in_box_canvas">
          <div class="mpt80" id="inbox_0">
            <!--诊断报告开始-->
            <div class="in_box_bl inbox_0">
              <!--侧边栏开始-->
              <div id="divTab" class="tab_right">
                <ul id="UserList">
                  <li class="curr"><a href="DiagnosisList.aspx?MedicalCaseInfoID=8007&amp;UserInfoId=1914">主任</a></li>
                </ul>
              </div>
              <!--侧边栏结束-->
              <div id="divTitle" class="top_title">
                <div class="title">
                  <span class="left">诊断报告</span>
                  <%--<a id="A2" onclick="Share()">
                    <div class="share right">分享</div>
                  </a>
                  <a id="Print" onclick="ShowReport()">
                    <div class="stamp right">打印</div>
                  </a>
                  <input type="submit" name="btnExcel" value="导出" onclick="return GetHeigh();" id="btnExcel"
                         class="export right">
                  <a id="A1" onclick="ShowHistoryRmark()">
                    <div class="showhistory right">病史备注</div>
                  </a>--%>
                </div>
              </div>
              <div id="divReport" class="inbox">
                <div class="inbox_content mlrAuto">
                  <div class="inbox_con_list">
                    <div class="logo_title" align="center">
                      <span>病理远程会诊咨询意见书 </span>
                      <div class="comc_logo">
                        <%--<img id="imgLogo" src="../img/icon_logo.png">--%>
                      </div>
                    </div>
                    <div class="pl_number border_bom">
                      <a>原病理号：<span id="lblPathologyNumber">未处理</span></a>
                      <a style=" float:right">会诊号：<span id="lblCheckNumber">未处理</span></a>
                    </div>
                    <div class="report_list border_bom">
                      <ul>
                        <li>
                          <label>姓&nbsp;名：</label>
                          <span id="lblPatientName">
                            <s:property value="pathology.patientname"/>
                          </span>
                        </li>
                        <li>
                          <label>性&nbsp;别：</label>
                          <span id="lblGender">
                            <s:property value="pathology.patientSex"/>
                          </span>
                        </li>
                        <li style="width: 20%">
                          <label>年&nbsp;龄：</label>
                          <span id="lblAge">
                            <s:property value="pathology.patientAge"/>
                          </span>
                        </li>
                        <li style="width: 30%">
                          <label>送检时间：</label>
                          <span id="lblDateOfDelivery">
                            <s:date name="pathology.inspectionDate" format="yyyy-MM-dd HH:mm:ss"/>
                          </span>
                        </li>
                        <li class="half">
                          <label>送检单位：</label>
                          <span id="lblHospitalOfDelivery">未处理</span>
                        </li>
                        <li style="width: 20%">
                          <label>切片&amp;附件数：</label>
                          <span id="lblRemark2">未处理</span>
                        </li>
                        <li style="width: 30%">
                          <label>诊断时间：</label>
                          <span id="lblDiagnosisTime">
                            <s:date name="pathology.createTime" format="yyyy-MM-dd HH:mm:ss"/>
                          </span>
                        </li>
                      </ul>
                      <div class="clearleft">
                      </div>
                    </div>
                  </div>
                  <div class="inbox_con_list">
                    <div class="report_title">临床资料（手术所见、影像学、相关检验等）：</div>
                    <div class="inbox_list border_bom">
                      <p>
                        <span id="lblClinicalData">
                          <s:property value="pathology.clinicDiagnose"/>
                        </span>
                      </p>
                    </div>
                  </div>
                  <div class="inbox_con_list">
                    <div class="report_title">
                      <span>材料部位：</span>
                    </div>
                    <div class="inbox_list border_bom">
                      <p>
                        <span id="lblAdoptedPart">
                          <s:property value="pathology.specimenName"/>
                        </span>
                      </p>
                    </div>
                  </div>
                  <div class="inbox_con_list">
                    <div class="report_title">
                      <span>大体所见：</span>
                    </div>
                    <div class="inbox_list border_bom" id="divGeneralObservation">
                      <textarea id="generalSee" cols="10" rows="1" class="ckeditor">
                        <s:property value="pathology.generalSee"/>
                      </textarea>
                    </div>
                  </div>
                  <div class="inbox_con_list">
                    <div class="report_title">
                      <span>免疫组化：</span>
                    </div>
                    <div class="inbox_list border_bom">
                      <p>
                        <span id="lblImmuneOrgan">
                          未处理免疫组化
                        </span>
                      </p>
                    </div>
                  </div>
                  <div class="inbox_con_list">
                    <div class="report_title">
                      <span>初诊意见（或其他单位诊断意见）：</span>
                    </div>
                    <div class="inbox_list border_bom">
                      <p>
                        <span id="lblFirstVisit">未处理</span>
                      </p>
                    </div>
                  </div>
                  <div class="inbox_con_list" style="display: none">
                    <div class="report_title">
                      <span>备注：</span>
                    </div>
                    <div class="inbox_list border_bom">
                      <p>
                        <span id="lblRemark"></span>
                      </p>
                    </div>
                  </div>
                  <div id="divConn" class="inbox_con_list">
                    <div class="report_title">病理图像：</div>
                    <div id="divCaseList" class="case_list border_bom">
                      <div class="show_img">
                        <a class="go" href="${path}/upload/img/2017/4/20170407093319_8007_1.png" rel="gallery">
                          <img alt="" src="${path}/upload/img/2017/4/20170407093319_8007_1.png"></a>
                        <p>可见核分裂像</p>
                      </div>
                      <div class="clear"></div>
                    </div>
                  </div>
                  <div class="inbox_con_list">
                    <div class="report_title">远程病理专家诊断意见：</div>
                    <div class="inbox_list ">
                      <p><span id="txtDiagnosisConclusion">未处理</span>
                      </p>
                    </div>
                  </div>
                  <div class="inbox_con_list">
                  </div>
                  <div id="divFoot" class="inbox_list border_bom" style=" height:40px">
                    <div style="float: left;"> 注：</div>
                    <div style="float: left;">会诊资料局限，以上报告仅为所见切片的咨询意见，仅供原单位病理科参考。
                      <br>如治疗，请结合原单位临床资料综合分析。
                    </div>
                  </div>
                  <div class="inbox_con_list">
                    <div class="inbox_title">
                      <div class="left">本报告由
                        <span id="lblUserHospital">有限责任公司未处理</span>
                        &nbsp;&nbsp;袁主任&nbsp;&nbsp;专家会诊
                        <p></p></div>
                      <div class="right">专家签字：<span id="lblUserName">袁主任</span>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <!--诊断报告结束-->
          <div id="inbox_2" class="mpt80">
            <div class="in_box_bl">
              <div class="title">
                <span>附件&nbsp;&amp;&nbsp;切片</span>
              </div>
              <div class="inbox mlrAuto">
                <ul id="ulAppendix" class="inbox_ul">
                  <div class="clearleft">
                  </div>
                </ul>
                <ul id="ulSection" class="inbox_ul inbox_ul_check">
                  <li>
                    <a style="cursor:pointer"
                       href=" http://slide.91360.com:8090/IndexPc.aspx?slideid=MTE0MzM%3d&amp;userid=1913&amp;pid=8007&amp;SessionId=888426"
                       target="_blank">
                      <img src="http://120.26.45.137:8077/Thumbnail/2017/3/20170331132926234_2017_3_31_132931.jpg"
                           alt="">
                      <div class="inbox_ul_msg">
                        <div class="mlrAuto inbox_span font14">切片：<span
                            title="20161205135531603.kfb">20161205135531603...</span>
                        </div>
                        <div class="mlrAuto inbox_span font12">时间：<span>2017/3/31 13:29:31</span>
                        </div>
                        <div class="mlrAuto inbox_span font12">免疫组化：<span>否</span>
                        </div>
                      </div>
                      <div style="display: none;" class="inbox_file_look undis">
                        <div class="icon_down">
                          <center>
                            <img src="../img/icon_look.png" class="icon_look" alt="">
                            <p>查看</p>
                          </center>
                        </div>
                      </div>
                    </a>
                  </li>
                  <div class="clearleft">
                  </div>
                </ul>
              </div>
            </div>
          </div>
          <!--留言-->
          <div class="mpt80" id="inbox_3">
            <div class="in_box_bl">
              <div class="title">
                <span>留言</span>
              </div>
              <div class="inbox">
                <div class="inbox_add mlrAuto">
                  <div class="in_text comments">
                    <textarea id="tbContent" class="leave_word" placeholder="输入文字信息留言"></textarea>
                  </div>
                  <div class="massges">
                    <div id="divIsAllExpert" class="massges_div left">
                      <input value="1" type="radio" name="readable" checked="checked"><span>所有专家可见</span>
                      <input value="0" type="radio" name="readable"><span>部分专家可见</span>
                    </div>
                    <input name="btnCreateMeeting" type="button" id="btnCreateMeeting" class="massges_btn"
                           style="width:130px; margin-left:10px;" value="创建视频会议" onclick="openMeeting()">
                    <input type="button" id="btnSaveContent" class="massges_btn" value="发送留言"
                           onclick="SaveContentByID('btnSaveContent')">
                    <div class="clear">
                    </div>
                  </div>
                  <div id="divExpertList" class="choose_experts" style="display:none;">
                    <input type="checkbox" name="chbExpert" value="1914"><span>袁主任</span>&nbsp;&nbsp;
                  </div>
                  <div id="divContentList" class="message_text">
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="clear">
        </div>
      </div>
    </div>
  </div>
  <div id="iviewer" class="wrapper" style="display: none;">
    <div class="loader" style="display: none;"></div>
    <div id="viewer" class="viewer iviewer_cursor"
         style="width: 1249px; height: 230px; margin-left: 50px; margin-top: 50px; overflow: hidden; display: block;">
      <div class="iviewer_zoom_in iviewer_common iviewer_button"></div>
      <div class="iviewer_zoom_out iviewer_common iviewer_button"></div>
      <div class="iviewer_zoom_zero iviewer_common iviewer_button"></div>
      <div class="iviewer_zoom_fit iviewer_common iviewer_button"></div>
      <div class="iviewer_zoom_status iviewer_common">100%</div>
      <div class="iviewer_rotate_left iviewer_common iviewer_button"></div>
      <div class="iviewer_rotate_right iviewer_common iviewer_button"></div>
      <a href="${path}/upload/img/2017/4/20170407093319_8007_1.png" target="_blank" download>
        <div class="iviewer_download iviewer_common iviewer_button"></div>
      </a></div>
    <div class="info">
      <div id="topBar">
        <a href="${path}/upload/img/2017/4/20170407093319_8007_1.png" id="prevLink" class="go"
           style="width: 40px; visibility: visible;"><img src="${path}/images/iviewer/btn_prev.png"></a>
        <p id="imageCount"> (2/3)</p>
        <a href="${path}/upload/img/2017/4/20170407093319_8007_1.png" id="nextLink" class="go"
           style="width: 40px; visibility: visible;"><img src="${path}/images/iviewer/btn_next.png"></a>
        <ul class="controls">
          <li class="close"></li>
        </ul>
      </div>
    </div>
  </div>
</form>
<div style="text-align:center;">
</div>
</body>
<script type="text/javascript" src="${path }/js/jquery.min.js"></script>
<script type="text/javascript" src="${path }/js/iviewer/jqueryui.js"></script>
<script type="text/javascript" src="${path }/js/iviewer/jquery.mousewheel.min.js"></script>
<script type="text/javascript" src="${path }/js/iviewer/jquery.iviewer.js"></script>
<script type="text/javascript" src="${path }/js/iviewer/main.js"></script>
<script>
    $(function () {
        // 禁用所有input
//    $('input').attr("disabled", "true");
//    $('textarea').attr("disabled", "true");
//    $('select').attr("disabled", "true");
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
</html>