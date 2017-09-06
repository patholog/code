<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
  <title>病理远程会诊平台-待诊断</title>
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
  <form action="PathologyAction!getPathologyListToNeed?parameter=1" id="listMemberForm" method="post">
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
  
  <div class="index_search">
  <form action="PathologyAction!getPathologyListToNeed" id="needSearch" method="post">
		<ul>
			<li class="title_li"><div class="title" id="title" style="display: none;">待诊断</div></li>        			
			<li>申请时间：从<input name="needfromdate" type="date" id="needfromdate" class="time_s" style="width:140px;">到
						<input name="needtodate" type="date" id="needtodate" class="time_s" style="width:140px;"></li>
			<li>病人姓名：
                <input name="needpat" type="text" id="needpat" class="keyword" >
			</li>
			<li>送检单位：
                <input name="needhospital" type="text" id="needhospital" class="keyword" >
			</li>
			<li>
                <input type="submit" name="btnSearch" value="搜索" id="btnSearch" class="index_search_btn">
            </li>
		</ul>
        <div class="clear"></div>
   </form>
	</div>
    <div class="index_diagnosis_table">
      <div class="diagnosis_table">
        <table class="table">
          <tbody>
          <tr>
            <th width="10%">病理号</th>
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
              <td><s:property value="#pathology.pathologyNo"/></td>
              <td><s:property value="#pathology.patientname"/></td>
              <td><s:property value="#pathology.patientname"/></td>
              <td><s:property value="#pathology.username"/></td>
              <td><s:property value="#pathology.content"/></td>
              <td><s:property value="#pathology.hospitalname"/></td>
              <td><s:property value="#pathology.createTime"/></td>
              <td align="center">
                <a href="PathologyAction!getPathologyDto?diagStatus=2&id=<s:property value="#pathology.caseId"/>" target="_blank">查看</a>
                <a href="PathologyAction!transferPathology?id=<s:property value="#pathology.caseId"/>">转诊</a>
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
</form>
</body>
</html>