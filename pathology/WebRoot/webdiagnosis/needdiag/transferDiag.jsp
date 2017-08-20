<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
  <title>病理远程会诊平台-转诊</title>
  <c:set var="path" value="${pageContext.request.contextPath }"/>
  <link rel="stylesheet" type="text/css" href="${path }/css/comc_diagnosis_wait_style.css"/>
  <link rel="stylesheet" type="text/css" href="${path }/css/comc_head_style.css"/>
  <link rel="stylesheet" type="text/css" href="${path }/css/comc_left_nav_style.css"/>
  <link rel="stylesheet" type="text/css" href="${path }/css/comc_page_style.css"/>
  <link rel="stylesheet" type="text/css" href="${path }/css/datepicker.css"/>
  <link rel="stylesheet" type="text/css" href="${path }/css/public_flat.css"/>
  <link rel="stylesheet" type="text/css" href="${path }/css/theme.css"/>
  <link rel="stylesheet" href="${path }/css/comc_head_style.css?Version=5.5.1.1"/>
  <link rel="stylesheet" href="${path }/css/comc_diagnosis_new_style.css?Version=5.5.1.1"/>
  <link rel="stylesheet" href="${path }/css/comc_left_nav_style.css?Version=5.5.1.1"/>
  <link rel="stylesheet" href="${path }/css/comc_register_style.css?Version=5.5.1.1"/>
  <link rel="stylesheet" type="text/css" href="${path }/css/WdatePicker.css"/>
  <link rel="stylesheet" type="text/css" href="${path }/css/weebox.css"/>

  <script type="text/javascript" src="${path }/js/jquery.min.js"></script>
  <script type="text/javascript" src="${path }/js/jquery.form.min.js"></script>
  <script type="text/javascript" src="${path }/js/treeView.js"></script>
  <script type="text/javascript" src="${path }/js/common-cn.js"></script>
  <script type="text/javascript" src="${path }/js/forbid-refresh.js"></script>
</head>
<body>
<div class="header">
  <%@include file="/webdiagnosis/maintop.jsp" %>
</div>
<div class="menu_left">
  <ul id="Left1_MenuList">
    <%@include file="/webdiagnosis/mainleft.jsp" %>
  </ul>
</div>

<div class="content_right" style="padding-top: 10px;">
  <div class="index_right" style="min-height: 494px;">
    <div class="step1_information" style="position: relative;">
      <div style="display: block; position: relative">
        <form id="transferForm" action="PathologyAction!saveTransferDiag" method="post">
          <div class="information">
            <ul class="state_six">
              <li>
                <div>
                  <span class="red_star">*</span>转诊医院
                  <select name="toHospitalId" id="toHospitalId" style="width: 120px;">
                    <option value="">请选择</option>
                    <c:forEach items="${hospitalList}" var="list" varStatus="status">
                      <option value='${list.hospitalcode}'>${list.name}</option>
                    </c:forEach>
                  </select>
                </div>
              </li>
              <li>
                <div>
                  <span class="red_star">*</span>转诊医生
                  <select name="toDoctorId" id="toDoctorId" style="width: 120px;">
                    <option value="">请选择</option>
                    <c:forEach items="${userList}" var="list" varStatus="status">
                      <option value='${list.idUsers}'>${list.realname}</option>
                    </c:forEach>
                  </select>
                </div>
              </li>
            </ul>
          </div>
          <div class="clear"></div>
          <div class="information_btn">
            <input id="save" type="button" class="inf_btn left" value="保存"/>
          </div>
        </form>
      </div>
    </div>
    <div class="index_diagnosis_table">
      <div class="diagnosis_table">
        <table class="table">
          <tbody>
          <tr>
            <th width="10%">病理号</th>
            <th width="10%">申请医院</th>
            <th width="15%">申请医生</th>
            <th width="10%">转诊医院</th>
            <th width="10%">转诊医生</th>
            <th width="20%">提交日期</th>
          </tr>
          <s:iterator value="descriptionAppList" id="description" status="11">
            <tr>
              <td><s:property value="#description.caseId"/></td>
              <td><s:property value="#description.fromHospitalId"/></td>
              <td><s:property value="#description.fromDoctorId"/></td>
              <td><s:property value="#description.toHospitalId"/></td>
              <td><s:property value="#description.toDoctorId"/></td>
              <td><s:date name="#description.applyDateTime" format="yyyy-MM-dd HH:mm:ss"/></td>
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
    </div>
  </div>
</div>
</body>
<script>
  $(function () {
    var flag = false;
    $("#save").click(function () {
      if (flag) {
        $('#transferForm').ajaxSubmit({
          dataType: 'json',
          success: function (result) {
            if (result && result !== "") {
              alert("转诊成功");
            } else {
              alert("新建病理失败");
            }
          }
        })
      }
    })
  })
</script>
</html>