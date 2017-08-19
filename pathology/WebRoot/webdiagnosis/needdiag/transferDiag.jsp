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
  <link rel="stylesheet" type="text/css" href="${path }/css/WdatePicker.css"/>
  <link rel="stylesheet" type="text/css" href="${path }/css/weebox.css"/>
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

<div class="content_right">
  <div>
    <form>
      <table>
        <tr>
          <td>申请医院</td>
          <td><input></td>
          <td>申请医生</td>
          <td><input></td>
        </tr>
      </table>
    </form>
  </div>
  <div class="index_right" style="min-height: 494px;">
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
          <%--<s:iterator value="pathologys" id="pathology" status="11">
            <tr>
              <td><s:property value="#pathology.caseId"/></td>
              <td><s:property value="#pathology.patientname"/></td>
              <td><s:property value="#pathology.patientname"/></td>
              <td><s:property value="#pathology.username"/></td>
              <td><s:property value="#pathology.content"/></td>
              <td><s:date name="#pathology.createTime" format="yyyy-MM-dd HH:mm:ss"/></td>
            </tr>
          </s:iterator>--%>

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
</html>