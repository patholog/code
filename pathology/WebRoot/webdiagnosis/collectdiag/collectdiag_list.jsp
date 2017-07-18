<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf8"%>
	<%@ page language="java" import="com.pathology.entity.Function"%>
	<%String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<title>病理远程会诊平台-收藏病例</title>
<c:set var="path" value="${pageContext.request.contextPath }" />
<link rel="stylesheet" type="text/css" href="${path }/css/style.css" />
<script type="text/javascript"
	src="${path }/CKEditor/ckeditor/ckeditor.js"></script>
<script type="text/javascript"
	src="${path }/CKFinder/ckfinder/ckfinder.js"></script>
<script type="text/javascript" src="${path }/js/treeView.js"></script>
<script type="text/javascript" src="${path }/js/common-cn.js"></script>
<script type="text/javascript" src="${path }/js/forbid-refresh.js"></script>
<script type="text/javascript">
	function confirmDelete(id) {
		if (confirm('确定取消收藏？'))
			window.location.href = 'CollectionAction!deleteCollection?collection.collectionId=' + id;
	}
</script>
</head>

<body>
	<div id="header">
		<%@include file="/webdiagnosis/maintop.jsp"%>
	</div>
	<table id="main" cellpadding="0" cellspacing="0" border="0">
		<tr>
			<td id="leftmenu"><%@include file="/webdiagnosis/mainleft.jsp"%>
			</td>
			<td id="contents">
				 <s:form action="CollectionAction!getCollectionList" theme="simple"
					target="mainFrame">
					<table cellspacing="0" cellpadding="0" width="100%" border="0"
						class="toolstable">
						<tr>
							<td width="86%" style="text-align:left;"><label>患者姓名：</label>
								<input type="text" name="hospital.name" id="hostpital_name" value="" style="width:120px;" /> <label>送检单位：</label> 
								<input type="text" name="hospital.code" id="hostpital_code" value="" style="width:120px;" /> 
								<input name="searchButton" id="searchButton" onclick="" type="submit" style="width:80px;background:url(css/img-blue/search.gif) 8px top no-repeat;"
									value="  搜索" />
							</td>
				
						</tr>
					</table>
				</s:form>
				<table class="listtable" cellspacing="0" cellpadding="0"
					width="100%">
					<tbody>
						<tr>
				          <th width="10%">病理号</th>
				          <th width="10%">病人姓名</th>
				          <th width="10%">材料部位</th>
				          <th width="10%">病例状态</th>
				          <th width="10%">系统分类</th>
				          <th width="15%">送检单位</th>
				          <th width="10%">申请时间</th>
				          <th width="10%">诊断时间</th>
				          <th width="15%">操作</th>
				             
						</tr>
						         <s:iterator value="collections" id="collection" status="11">
						         <tr>
						         <td><s:property value="#collection.pathologyNo"/><input type="hidden" value="#collection.collectionId"></td>
						         <td><s:property value="#collection.patientname"/></td>
						         <td><s:property value="#collection.pathologyNo"/></td>
						         <td><s:property value="#collection.patientname"/></td>
						         <td><s:property value="#collection.username"/></td>
						         <td><s:property value="#collection.hospitalname"/></td>
						         <td><s:property value="#collection.createTime"/></td>
						         <td><s:property value="#collection.diagtime"/></td>
						          <td align="center"><a href="#"  onclick="confirmDelete('${collection.collectionId }')">取消收藏</a>
						          &nbsp; | &nbsp;	<a href="PathologyAction!getPathologyDto?id=${collection.caseId}" target="_blank">查看</a></td>
						          </td>
						        </tr>
						        </s:iterator>

						<tr class="lightrow">
							<td colspan="9"><div id="pageDir">
								
  <%=request.getAttribute("page")!=null?request.getAttribute("page"):"" %>
								</div></td>
						</tr>

					</tbody>
				</table>
			</td>
		</tr>
	</table>

</body>
</html>