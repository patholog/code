<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<title>病理远程会诊平台</title>
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
		if (confirm('你确定删除此产品？'))
			window.location.href = '?action=delete&id=' + id;
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
				          <th width="10%">序号</th>
				          <th width="10%">病理号</th>
				          <th width="10%">病人姓名</th>
				          <th width="10%">留言人</th>
				          <th width="20%">留言内容</th>
				          <th width="10%">留言状态</th>
				          <th width="15%">留言时间</th>
				          <th width="10%">操作</th>
				            
						</tr>
						         <s:iterator value="messages" id="message" status="11">
						         <tr>
						         <td><s:property value="#message.messageOrder"/></td>
						         <td><s:property value="#message.pathologyNo"/></td>
						         <td><s:property value="#message.patientname"/></td>
						         <td><s:property value="#message.username"/></td>
						         <td><s:property value="#message.content"/></td>
						         <td><s:property value="#message.isReaded"/></td>
						         <td><s:property value="#message.createTime"/></td>
						          <td align="center"><a href="MessageAction!getMessageId?id=<s:property value="#message.id_message"/>" target="_blank">查看</a></td>
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
</html>