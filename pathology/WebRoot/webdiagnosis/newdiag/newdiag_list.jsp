<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
  <title>病理远程会诊平台-新建列表</title>
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
  <script type="text/javascript">
    function confirmDelete(id) {
      if (confirm('你确定删除此产品？'))
        window.location.href = '?action=delete&id=' + id;
    }
  </script>
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
  <div class="index_right" style="min-height: 494px;">
    <div class="new_step">
      <ul>
        <li>
          <a href="PathologyAction!addPathology">
            <div class="step curr">
              <span>新建病例</span>
            </div>
          </a>
        </li>
      </ul>
      <div class="clear">
      </div>
    </div>
    <div class="index_diagnosis_table">
      <div class="diagnosis_table">
        <table class="table">
          <tbody>
          <tr>
            <th width="5%">会诊号</th>
            <th width="5%">病理号</th>
            <th width="10%">病人姓名</th>
            <th width="15%">材料部位</th>
            <th width="10%">病例状态</th>
            <th width="10%">系统分类</th>
            <th width="20%">送检单位</th>
            <th width="15%">申请时间</th>
            <th width="10%">操作</th>
          </tr>
          <s:iterator value="pathologys" id="pathology" status="11">
            <tr>
              <td><s:property value="#pathology.caseId"/></td>
              <td><s:property value="#pathology.pathologyNo"/></td>
              <td><s:property value="#pathology.patientname"/></td>
              <td><s:property value="#pathology.specimenName"/></td>
              <td><s:property value="#pathology.diagStatusName"/></td>
              <td><s:property value="#pathology.specimenTypeName"/></td>
              <td><s:property value="#pathology.hospitalname"/></td>
              <td><s:property value="#pathology.createTime"/></td>
              <td align="center">
                <a href="PathologyAction!openPathologyUpdate?diagStatus=1&id=<s:property value="#pathology.caseId"/>">修改</a>
                <a href="PathologyAction!getPathologyDto?diagStatus=1&id=<s:property value="#pathology.caseId"/>" target="_blank">查看</a>
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
    </div>
  </div>
</div>
</body>
</html>