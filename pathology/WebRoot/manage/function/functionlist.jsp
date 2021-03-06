<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<title>功能列表</title>
<c:set var="path" value="${pageContext.request.contextPath }" />
<link rel="stylesheet" type="text/css" href="${path }/css/style.css" />
<script type="text/javascript" src="${path }/js/jquery-1.9.0.min.js"></script>
<script type="text/javascript" src="${path }/js/treeView.js"></script>
<script type="text/javascript" src="${path }/js/common-cn.js"></script>
<script type="text/javascript" src="${path }/js/forbid-refresh.js"></script>
<script type="text/javascript">
	function confirmDelete(id) {
		if (confirm('确定删除吗？'))
			window.location.href = 'FunctionAction!deleteFunction?function.idFunction=' + id;
	}
</script>
<script type="text/javascript">  
	function resetSearch()  
	{
		$("#managefunctionname").val("");
	}  
</script>  
</head>

<body>
	<div id="header">
		<%@include file="/manage/managetop.jsp"%>
	</div>
	<table id="main" cellpadding="0" cellspacing="0" border="0">
		<tr>
			<td id="leftmenu"><%@include file="/manage/manageleft.jsp"%>
			</td>
			<td id="contents">
				<table id="pagehead" cellspacing="0" cellpadding="0" width="100%"
					border="0">
					<tr>
						<td><h1>功能管理</h1></td>
					</tr>
				</table> <s:form action="FunctionAction!functionList" theme="simple">
					<table cellspacing="0" cellpadding="0" width="100%" border="0"
						class="toolstable">
						<tr>
							<td width="86%" style="text-align:left;"><label>功能名称：</label>
								<input type="text" name="managefunctionname" id="managefunctionname" value="${requestScope.managefunctionname}" style="width:120px;" /> 
								<input name="searchButton" id="searchButton" onclick="" type="submit" style="width:80px;background:url(css/img-blue/search.gif) 8px top no-repeat;"
									value="  搜索" />
								<input name="resetButton"
								id="resetButton" onclick="resetSearch()" type="button"
								style="width:80px;background: 8px top no-repeat;"
								value="  重置查询" />
							</td>
				
						</tr>
					</table>
				</s:form>
				<table class="listtable" cellspacing="0" cellpadding="0"
					width="100%">
					<tbody>
						<tr>
							<th width="15%">名称</th>
							<th width="30%">url</th>
							<th width="15%">简称</th>
							<th width="30%">描述</th>
							<th width="10%">操作</th>
						</tr>
						<c:forEach items="${sessionScope.functionlist }" var="function" varStatus="status">
							<tr bgColor="${status.index%2==0?'#f9f9ff':'#ffffff' }">
							<td>${function.name}</td>
							<td>${function.url}</td>
							<td>${function.short_ }</td>
							<td>${function.description }</td>
								<td class="action_collomn"><a
									href="FunctionAction!updateFunction?function.idFunction=${function.idFunction }">修改</a> &nbsp; | &nbsp; <a
									href="#" onclick="confirmDelete('${function.idFunction }')">删除</a>
							</tr>
						</c:forEach>


						<tr class="lightrow">
							<td colspan="8"><table class="pagetable">
							<tr><td>
									<c:set var="pageCount" value="${sessionScope.pageCount}" />
									<fmt:formatNumber var="lastIndex" value="${pageCount}"
										pattern="#" />

									第${sessionScope.thisindex }/${lastIndex }页 &nbsp; &nbsp; <a
										href="HospitalAction!hospitalList?index=1" >首页</a>&nbsp; 
									<!-- 
							<c:set var="pageCount" value="${fn:length(userList)%10==0?fn:length(userList)/10:fn:length(userList)/10+1 }"/>
						-->
									<c:forEach var="i" begin="1" step="1" end="${lastIndex }">
										<a href="FunctionAction!functionList?index=${i } " ><c:out
												value="${i }" /> </a>
									</c:forEach>
									&nbsp;<a href="FunctionAction!functionList?index=${lastIndex}" >尾页</a></td>
							<td>

									<s:form action="FunctionAction!functionList" theme="simple">
							第&nbsp;<s:textfield name="index" cssStyle="width:25px;height:20px;" />&nbsp;页&nbsp; &nbsp;
							<s:submit value="Go" id="go" />
									</s:form>
								</td></tr>
								</table></td>
						</tr>

					</tbody>
				</table>
			</td>
		</tr>
	</table>

</body>
</html>