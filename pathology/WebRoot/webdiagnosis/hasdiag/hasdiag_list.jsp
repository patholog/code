<%@ page language="java" contentType="text/html;charset=utf-8"
         pageEncoding="utf8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
  <title>病理远程会诊平台-已诊断</title>
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
  <script type="text/javascript" src="${path }/js/treeView.js"></script>
  <script type="text/javascript" src="${path }/js/common-cn.js"></script>
  <script type="text/javascript" src="${path }/js/forbid-refresh.js"></script>
  <script type="text/javascript" src="${path }/js/jquery-1.9.0.min.js"></script>
  <script type="text/javascript" src="${path }/assets/jqueryui/jquery-ui.min.js"></script>
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
            <th width="9%">病理号</th>
            <th width="9%">病人姓名</th>
            <th width="15%">材料部位</th>
            <th width="9%">病例状态</th>
            <th width="10%">系统分类</th>
            <th width="15%">送检单位</th>
            <th width="10%">申请时间</th>
            <th width="10%">诊断时间</th>
            <th width="13%">操作</th>
          </tr>
          <s:iterator value="pathologys" id="pathology" status="11">
            <tr>
              <td><s:property value="#pathology.pathologyNo"/></td>
              <td><s:property value="#pathology.patientname"/></td>
              <td><s:property value="#pathology.specimenname"/></td>
              <!-- todo 确定病例状态 -->
              <td><s:property value="#pathology.content"/></td>
              <!-- todo 系统分类需要获取 -->
              <td><s:property value="#pathology.username"/></td>
              <td><s:property value="#pathology.hospitalname"/></td>
              <td><s:property value="#pathology.inspectiondate"/></td>
              <td><s:property value="#pathology.diagtime"/></td>
              <td align="center">
                <a href="PathologyAction!getPathologyDto?diagStatus=7&id=${pathology.caseId}" target="_blank">查看</a>
                <c:if test="${pathology.collectionId ==null or pathology.collectionId=='undefined'}">
                  <a id="${pathology.collectionId}"
                     href="javascript:collectCase('${pathology.caseId}','${pathology.pathologyNo}')" target="_blank">
                    收藏</a>
                </c:if>
                <c:if test="${pathology.collectionId !=null and pathology.collectionId!='undefined'}">
                  <a id="${pathology.caseId}" href="javascript:cancelCase('${pathology.collectionId}')" target="_blank">取消收藏</a>
                </c:if>
                <a href="javascript:shareCase('${pathology.caseId}')">分享</a>
              </td>
            </tr>
          </s:iterator>

          <tr class="lightrow">
            <td colspan="9">
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
<div id="shareModal" style="width: 300px; height: 200px;">
  <div id="shareTabs">
    <ul>
      <li><a href="#open">公开的</a></li>
      <li><a href="#protected">私密的</a></li>
    </ul>
    <div id="open">
      <form action="">
        <input type="hidden" name="type" value="open"/>
        <input id="btnOpen" type="button" class="btn1" value="创建链接"/>
      </form>
    </div>
    <div id="protected">
      <div>
      <input id="btnProtected" type="button" class="btn1" value="创建私密链接"/>
      </div>
      <div class="hidden">
        <textarea name="protectedUrl" id="protectedUrl">123</textarea>
      </div>
    </div>
  </div>
</div>
</body>
<script>
  function collectCase(id, pathologyno) {
    var collectionDo = {"caseId": id, "pathologyNo": pathologyno}
    $.ajax({
      url: 'CollectionAction!saveCollection',
      type: 'post',
      data: {"collectionDo": JSON.stringify(collectionDo)},
      dataType: 'text',
      success: function (data) {
        self.location.reload();
      },
      error: function (data) {
        self.location.reload();
      }
    })
  }

  function cancelCase(id) {
    $.ajax({
      url: 'CollectionAction!deleteCollection?collectionId=' + id,
      type: 'post',
      data: {},
      dataType: 'text',
      success: function (data) {
        self.location.reload();
      },
      error: function (data) {
        self.location.reload();
      }
    })
  }

  function confirmDelete(id) {
    if (confirm('你确定删除此产品？'))
      window.location.href = '?action=delete&id=' + id;
  }

  /**
   * 分享
   * @param caseId
   */
  function shareCase(caseId) {
    $('#shareTabs').tabs({
      width: '360',
      height: '250'
    });
    $("#shareModal").dialog({
      title: '分享',
      modal: true,
      width: '400',
      height: '300'
    });
  }

  $('#btnOpen').click(function () {

  });
  
  $('#btnProtected').click(function () {
    $.ajax({
      url: '',
      success: function (result) {
        if (result && result.success) {
          $('#protectedUrl').val(result.success);
        } else {
          alert('创建分享失败');
        }
      }
    });
  })

</script>
</html>