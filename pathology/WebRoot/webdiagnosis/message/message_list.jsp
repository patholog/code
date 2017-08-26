<%@ page language="java" contentType="text/html;charset=utf-8"
         pageEncoding="utf8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
  <title>病理远程会诊平台-留言列表</title>
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
  <script type="text/javascript" src="${path }/js/jquery-1.9.0.min.js"></script>
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
    <div class="index_diagnosis_table">
      <div class="diagnosis_table">
        <table class="table">
          <tbody>
          <tr>
            <th width="10%">序号</th>
            <th width="10%">会诊号</th>
            <th width="10%">病人姓名</th>
            <th width="10%">留言人</th>
            <th width="20%">留言内容</th>
            <th width="15%">留言时间</th>
            <th width="10%">操作</th>
          </tr>
          <s:iterator value="messages" id="message" status="11">
            <tr>
              <td><s:property value="#message.messageOrder"/></td>
              <td><s:property value="#message.caseId"/></td>
              <td><s:property value="#message.patientname"/></td>
              <td><s:property value="#message.username"/></td>
              <td><s:property value="#message.content"/></td>
              <td><s:property value="#message.createTime"/></td>
              <td align="center">
                <a href="MessageAction!getMessageId?id=<s:property value="#message.idMessage"/>">查看</a>
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