<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
  <title>病理远程会诊平台-病例分享</title>
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
  <link rel="stylesheet" type="text/css" href="${path }/assets/jqueryui/jquery-ui.min.css"/>
  <link rel="stylesheet" type="text/css" href="${path }/assets/jqueryui/jquery-ui.theme.min.css"/>
  <script type="text/javascript" src="${path }/js/common-cn.js"></script>
  <script type="text/javascript" src="${path }/js/forbid-refresh.js"></script>
  <script type="text/javascript" src="${path }/js/jquery-1.9.0.min.js"></script>
  <script type="text/javascript" src="${path }/assets/jqueryui/jquery-ui.min.js"></script>
</head>

<body>
  <form action="ShareAction!getShareList?parameter=1" id="listMemberForm" method="post">
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
            <th width="10%">会诊号</th>
            <th width="10%">病人姓名</th>
            <th width="15%">创建分享时间</th>
            <th width="10%">类型</th>
            <th width="10%">有效期</th>
            <th width="15%">分享链接</th>
            <th width="15%">密码</th>
            <th width="15%">操作</th>
          </tr>
          <s:iterator value="shares" id="share" status="11">
            <tr>
              <td>
                <s:property value="#share.caseId"/>
                <input type="hidden" value="<s:property value="#share.shareId"/>">
              </td>
              <td><s:property value="#share.patientname"/></td>
              <td><s:property value="#share.shareTime"/></td>
              <td><s:property value="#share.typeName"/></td>
              <td><s:property value="#share.endTime"/></td>
              <td><s:property value="#share.shareUrl"/></td>
              <td><s:property value="#share.sharePsd"/></td>
              <td align="center"><a href="javascript:void(0)" onclick='delShare(${share.shareId})'>取消分享</a>
                &nbsp; | &nbsp; <a href="PathologyAction!getPathologyDto?id=${share.caseId}" target="_blank">查看</a>
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
<div id="myDialog">
  <div align="center">
    <label id="info"></label>
  </div>
</div>
</form>
</body>
<script>
  function delShare(id) {
    $('#info').text('确定要取消分享吗？');
    $('#myDialog').dialog({
      title: '取消分享',
      resizable: false,
      modal: true,
      buttons: [{
        text: "确定",
        icon: "ui-icon-heart",
        click: function () {
          $.ajax({
            url: 'ShareAction!deleteShare?share.shareId=' + id,
            dataType: "json",
            success: function (result) {
              if (result && result.succ) {
                delTip('取消成功');
                $(this).dialog('close');
              } else {
                delTip('取消失败');
                $(this).dialog('close');
              }
            }
          })
        }
      }, {
        text: "取消",
        icon: "ui-icon-heart",
        click: function () {
          $(this).dialog("close");
        }
      }]
    });

  }

  function delTip(tips) {
    $('#info').text(tips);
    $('#myDialog').dialog({
      title: '提示',
      resizable: false,
      modal: true,
      buttons: [{
        text: "确定",
        icon: "ui-icon-heart",
        click: function () {
          window.location.reload();
          $(this).dialog("close");
        }
      }]
    });
  }
</script>
</html>