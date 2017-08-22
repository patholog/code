<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
	<title>病理远程会诊平台-留言查看</title>
	<c:set var="path" value="${pageContext.request.contextPath }"/>
  <link rel="stylesheet" href="${path }/css/public_flat.css"/>
  <link rel="stylesheet" href="${path }/css/theme.css?Version=5.5.1.1"/>
  <link rel="stylesheet" href="${path }/css/comc_head_style.css?Version=5.5.1.1"/>
  <link rel="stylesheet" href="${path }/css/comc_diagnosis_new_style.css?Version=5.5.1.1"/>
  <link rel="stylesheet" href="${path }/css/comc_left_nav_style.css?Version=5.5.1.1"/>
  <link rel="stylesheet" href="${path }/css/comc_register_style.css?Version=5.5.1.1"/>
  <link rel="stylesheet" href="${path }/css/datepicker.css"/>
  <link rel="stylesheet" href="${path }/css/theme.css"/>
  <link rel="stylesheet" href="${path }/css/WdatePicker.css"/>
  <link rel="stylesheet" href="${path }/css/weebox.css"/>
  <link rel="stylesheet" href="${path }/assets/jqueryui/jquery-ui.min.css"/>
  <link rel="stylesheet" href="${path }/assets/jqueryui/jquery-ui-timepicker-addon.min.css"/>

  <script type="text/javascript" src="${path }/js/jquery.min.js"></script>
  <script type="text/javascript" src="${path }/assets/jqueryui/jquery-ui.min.js"></script>
  <script type="text/javascript" src="${path }/assets/jqueryui/jquery-ui-timepicker-addon.min.js"></script>
  <script type="text/javascript" src="${path }/assets/jqueryui/jquery-ui-timepicker-zh-CN.js"></script>
  <script type="text/javascript" src="${path }/js/jquery.form.min.js"></script>
  <script type="text/javascript" src="${path }/js/treeView.js"></script>
  <script type="text/javascript" src="${path }/js/common-cn.js"></script>
  <script type="text/javascript" src="${path }/js/forbid-refresh.js"></script>
  <script type="text/javascript" src="${path }/js/CKEditor/ckeditor.js"></script>
</head>
<body>
<div class="header">
  <%@include file="/webdiagnosis/maintop.jsp" %>
</div>
<form id="infoForm" method="post" action="PathologyAction!saveInfo" enctype="multipart/form-data">
  <div id="whole" class="mlrAuto">
    <div class="menu_left">
      <ul id="Left1_MenuList">
        <%@include file="/webdiagnosis/mainleft.jsp" %>
      </ul>
    </div>
    <div class="content_right" style="">
      <div class="index_right" id="divAll" style="">
        <!--步骤指示条-->
        <div class="new_step">
          <ul>
            <li>
              <a href="">
                <div class="step curr"><span>留言信息</span></div>
              </a>
            </li>
          </ul>
          <div class="clear">
          </div>
        </div>
        <!--相关内容块-->
        <div class="step1_information" style="position: relative;">
          <div class="information" id="divHead">
            <ul class="state_six">
              <li>
                <div>
                  <span class="red_star"></span>病人姓名
                  <input name="patientName" id="patientName" class="patient_name" value="${messageDTO.patientname}" readonly>
                  <input type="hidden" id="idMessage" name="idMessage" value="${messageDTO.idMessage}"/>
                </div>
              </li>
              <li>
                <div>
                  <span class="red_star"></span>会<ins class="half_words"></ins>诊<ins class="half_words"></ins>号
                  <input name="caseId" id="caseId" value="${messageDTO.caseId}" readonly/>
                </div>
              </li>
              <li>
                <div>
                  <span class="red_star"></span>序号
                  <input name="messageOrder" id="messageOrder" value="${messageDTO.messageOrder}" readonly/>
                </div>
              </li>
              <li>
                <div>
                  <span class="red_star"></span>留言人
                  <input name="username" id="username" value="${messageDTO.username}">
                </div>
              </li>
              <li>
                <div>
                  <div class="pos_r">
                    <ins class="half_words"></ins>留言时间
                    <input name="createTime" id="createTime" style="width: 150px;"
                           value="${messageDTO.createTime}"/>
                  </div>
                </div>
              </li>
            </ul>
            <div class="clear">
            </div>
            <div class="information">
              <ul>
                <li style="width: 100%;">
                  <div style="float: left"><span class="red_star"></span>留言内容</div>
                  <textarea id="content" name="content" class="row2" cols="20" rows="2" style="height: 100px;width: 98%;"
                            readonly>${messageDTO.content}</textarea>
                </li>
              </ul>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</form>
</body>
</html>