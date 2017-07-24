<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<title>病理远程会诊平台-病例分享</title>
<c:set var="path" value="${pageContext.request.contextPath }" />
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
		if (confirm('确定取消分享？'))
			window.location.href = 'ShareAction!deleteShare?share.shareId=' + id;
	}
</script>
</head>

<body>
	<div class="header">
		<%@include file="/webdiagnosis/maintop.jsp"%>
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
				          <th width="10%">病理号</th>
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
						         <td><s:property value="#share.pathologyNo"/><input type="hidden" value="#share.shareId"></td>
						         <td><s:property value="#share.patientname"/></td>
						         <td><s:property value="#share.createTime"/></td>
						         <td><s:property value="#share.username"/></td>
						         <td><s:property value="#share.username"/></td>
						         <td><s:property value="#share.memo"/></td>
						         <td><s:property value="#share.shareId"/></td>
						          <td align="center"><a href="#"  onclick="confirmDelete('${share.shareId }')">取消分享</a>
						          	&nbsp; | &nbsp;	<a href="PathologyAction!getPathologyDto?id=${share.caseId}" target="_blank">查看</a>
						          </td>
						        </tr>
						        </s:iterator>

						<tr class="lightrow">
							<td colspan="8"><div id="pageDir">
								
  <%=request.getAttribute("page")!=null?request.getAttribute("page"):"" %>
								</div></td>
						</tr>

					</tbody>
				</table>
                  </div>
			  </div>
			</div>
		</div>>

</body>
</html>s