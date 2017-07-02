<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<title></title>
<c:set var="path" value="${pageContext.request.contextPath }" />
<link rel="stylesheet" type="text/css" href="${path }/css/style.css" />
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
	<div id="header">
		<%@include file="/webdiagnosis/maintop.jsp"%>
	</div>
	<table id="main" cellpadding="0" cellspacing="0" border="0">
		<tr>
			<td id="leftmenu"><%@include file="/webdiagnosis/mainleft.jsp"%>
			</td>
			<td id="contents">
				 <s:form action="HospitalAction!hospitalList" theme="simple"
					target="mainFrame">
					<table cellspacing="0" cellpadding="0" width="100%" border="0"
						class="toolstable">
						<tr>
							<td width="86%" style="text-align:left;"><label>医院名称：</label>
								<input type="text" name="hospital.name" id="hostpital_name" value="" style="width:120px;" /> <label>编码：</label> 
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
				          <th width="15%">创建分享时间</th>
				          <th width="10%">类型</th>
				          <th width="10%">有效期</th>
				          <th width="20%">分享链接</th>
				          <th width="15%">密码</th>
				          <th width="10%">操作</th>
				            
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
						          <td align="center"><a href="javascript:void(0);"  onclick="confirmDelete(${share.shareId })">取消分享</a></td>
						        </tr>
						        </s:iterator>

						<tr class="lightrow">
							<td colspan="8"><div id="pageDir">
								
  <%=request.getAttribute("page")!=null?request.getAttribute("page"):"" %>
								</div></td>
						</tr>

					</tbody>
				</table>
			</td>
		</tr>
	</table>

</body>
</html>s