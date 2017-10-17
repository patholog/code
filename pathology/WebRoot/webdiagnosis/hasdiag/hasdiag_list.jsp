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
  <script type="text/javascript" src="${path }/js/common-cn.js"></script>
  <script type="text/javascript" src="${path }/js/forbid-refresh.js"></script>
  <script type="text/javascript" src="${path }/js/jquery-1.9.0.min.js"></script>
  <script type="text/javascript" src="${path }/assets/jqueryui/jquery-ui.min.js"></script>
  <script type="text/javascript" src="${path }/js/jquery.form.min.js"></script>
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
	  <div class="index_search">
	  <form action="PathologyAction!getPathologyListToHas" id="hasSearch" method="post">
			<ul>
				<li class="title_li"><div class="title" id="title" style="display: none;">待诊断</div></li>        			
				<li>诊断时间：从<input name="hasfromdate" type="date" id="hasfromdate" class="time_s" style="width:140px;"value="${requestScope.hasfromdate}">到
							<input name="hastodate" type="date" id="hastodate" class="time_s" style="width:140px;"value="${requestScope.hastodate}"></li>
				<li>病人姓名：
	                <input name="haspat" type="text" id="haspat" class="keyword" value="${requestScope.haspat}">
				</li>
				<li>送检单位：
	                <input name="hashospital" type="text" id="hashospital" class="keyword" value="${requestScope.hashospital}">
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
              <td><s:property value="#pathology.specimenName"/></td>
              <!-- todo 确定病例状态 -->
              <td><s:property value="#pathology.diagStatusName"/></td>
              <!-- todo 系统分类需要获取 -->
              <td><s:property value="#pathology.specimenTypeName"/></td>
              <td><s:property value="#pathology.hospitalname"/></td>
              <td><s:property value="#pathology.createTime"/></td>
              <td><s:property value="#pathology.diagTime"/></td>
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
<div id="shareModal" hidden style="width: 300px; height: 200px;">
  <div id="shareTabs">
    <ul>
      <li><a href="#open">公开的</a></li>
      <li><a href="#protected">私密的</a></li>
    </ul>
    <div id="open">
      <form id="openShareForm" action="ShareAction!share" method="post">
        <div style="float: left;">
          <input type="hidden" name="type" value="0"/>
          <input type="hidden" id="openCaseId" name="caseId"/>
          <label for="endTime">有效期</label>
          <input id="endTime" name="endTime" style="border: solid 1px #8b8d8f; width: 100px;"/>
          <span>
            <input id="forever" name="forever" type="radio"/>
            <label for="forever">永久</label>
          </span>
          <input id="btnOpen" type="button" class="ui-button" value="创建链接"/>
        </div>
        <div>
          <textarea id="openShareUrl" rows="3" readonly style="width: 100%;margin-top: 5px;"></textarea>
        </div>
      </form>
    </div>
    <div id="protected">
      <form id="protectedShareForm" action="ShareAction!share" method="post">
        <div>
          <input type="hidden" name="type" value="1"/>
          <input type="hidden" id="protectedCaseId" name="caseId"/>
          <input id="btnProtected" type="button" class="ui-button" value="创建私密链接"/>
        </div>
        <div>
          <table style="width: 100%">
            <tr>
              <td width="20%"><span>链接</span></td>
              <td width="80%">
                <textarea id="protectedShareUrl" rows="3" readonly style="width: 100%;margin-top: 5px;"></textarea>
              </td>
            </tr>
            <tr>
              <td><span>密码</span></td>
              <td>
                <textarea id="protectedSharePwd" rows="1" readonly style="width: 100%;margin-top: 5px;"></textarea>
              </td>
            </tr>
          </table>
        </div>
      </form>
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

  $('#endTime').datepicker({
    defaultDate: $('#endTime').val(),
    dateFormat: "yy-mm-dd"
  });

  $('#forever').click(function () {
    if ($('#forever').attr("checked")) {
      $('#forever').attr("checked", false);
      $('#endTime').attr("disabled", false);
      $('#endTime').val("");
    } else {
      $('#forever').attr("checked", true);
      $('#endTime').attr("disabled", true);
      $('#endTime').val("9999-12-31");
    }
  });

  /**
   * 分享
   * @param caseId
   */
  function shareCase(caseId) {
    $('#shareModal').attr('hidden', false);
    $('#openCaseId').val(caseId);
    $('#protectedCaseId').val(caseId);
    $('#shareTabs').tabs({
      width: '360',
      border: '0',
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
    if ($('#endTime').val() === "") {
      $('#openShareUrl').val("有效期不能为空");
      return;
    }
    $('#endTime').attr("disabled", false);
    $('#openShareForm').ajaxSubmit({
      dataType: 'json',
      success: function (result) {
        if (result && result.success) {
          $('#openShareUrl').val(result.success);
        } else {
          $('#openShareUrl').val("分享失败");
        }
      }
    });
    if ($('#forever').attr("checked")) {
      $('#endTime').attr("disabled", true);
    }
  });
  
  $('#btnProtected').click(function () {
    $('#protectedShareForm').ajaxSubmit({
      dataType: 'json',
      success: function (result) {
        if (result && result.success && result.pwd) {
          $('#protectedShareUrl').val(result.success);
          $('#protectedSharePwd').val(result.pwd);
        } else {
          $('#protectedShareUrl').val("分享失败");
        }
      }
    })
  })

</script>
</html>