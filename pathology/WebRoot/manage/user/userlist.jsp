<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<c:set var="path" value="${pageContext.request.contextPath }" />
<link rel="stylesheet" type="text/css" href="${path}/css/style.css" />
<script type="text/javascript" src="${path}/js/treeView.js"></script>
<script type="text/javascript" src="${path}/js/common-cn.js"></script>
<script type="text/javascript" src="${path}/js/forbid-refresh.js"></script>
</head>
<body>
	<div id="header">
		<%@include file="../managetop.jsp"%>
	</div>
	<table id="main" cellpadding="0" cellspacing="0" border="0">
		<tr>
			<td id="leftmenu"><%@include file="../manageleft.jsp"%></td>
			<td id="contents"><table id="pagehead" cellspacing="0"
					cellpadding="0" width="100%" border="0">
					<tr>
						<td><h1>用户管理</h1></td>
					</tr>
				</table> <s:form action="UserAction!userList" theme="simple"
					target="mainFrame">
					<table cellspacing="0" cellpadding="0" width="100%" border="0"
						class="toolstable">
						<tr>
							<td width="86%" style="text-align:left;"><label>用户名：</label>
								<input type="text" name="user.username" id="hostpital_name"
								value="" style="width:120px;" /> <label>真实姓名：</label> <input
								type="text" name="user.relname" id="hostpital_user" value=""
								style="width:120px;" /> <label>电子邮箱：</label> <input type="text"
								name="user.email" id="hostpital_user" value=""
								style="width:120px;" /> <input name="searchButton"
								id="searchButton" onclick="" type="submit"
								style="width:80px;background:url(css/img-blue/search.gif) 8px top no-repeat;"
								value="  搜索" /></td>
						</tr>
					</table>
				</s:form>
				<table class="listtable" cellspacing="0" cellpadding="0"
					width="100%">
					<tbody>
						<tr>
							<th width="10%">用户名称</th>
							<th width="10%">性别</th>
							<th width="15%">邮箱</th>
							<th width="20%">所属医院</th>
							<th width="10%">特长</th>
							<th width="10%">手机</th>
							<th width="10%">电话</th>
							<th width="15%">操作</th>
						</tr>
						<c:forEach items="${sessionScope.list }" var="user"
							varStatus="status">
							<tr bgColor="${status.index%2==0?'#f9f9ff':'#ffffff' }">
								<td class="username">${user.username}</td>
								<td>${user.sex}</td>
								<td>${user.email }</td>
								<td>${user.belonghospital }</td>
								<td>${user.specialty }</td>
								<td>${user.mobile }</td>
								<td>${user.tel }</td>
								<td class="action_collomn"><a
									<c:choose>
									<c:when test="${user.userstatus=='1'}"> class="enable" </c:when>
									<c:otherwise>href="UserAction!checkUser?user.idUsers=${user.idUsers}"</c:otherwise>
									</c:choose>>审核</a>
									&nbsp; | &nbsp; <a
									href="UserAction!updateUser?user.idUsers=${user.idUsers}">修改</a>
									&nbsp; | &nbsp; <a
									href="UserAction!deleteUser?user.idUsers=${user.idUsers}">删除</a>
							</tr>
						</c:forEach>
						<tr class="lightrow">
							<td colspan="8">
							<table class="pagetable"><tr><td><c:set var="pageCount"
									value="${(sessionScope.count-1)/10+1 }" /> <fmt:formatNumber
									var="lastIndex" value="${pageCount}" pattern="#" />
								第${sessionScope.thisindex }/${lastIndex }页 &nbsp; &nbsp; <a
								href="UserAction!userList?index=1" target="mainFrame">首页</a>&nbsp;
								<!-- 
							<c:set var="pageCount" value="${fn:length(userList)%10==0?fn:length(userList)/10:fn:length(userList)/10+1 }"/>
						--> <c:forEach var="i" begin="1" step="1" end="${lastIndex }">
									<a href="UserAction!userList?index=${i } " target="mainFrame">
										<c:out value="${i }" /> </a>
								</c:forEach> &nbsp;<a href="UserAction?index=${lastIndex}" target="mainFrame">尾页</a></td>
							<td><s:form action="UserAction!userList" theme="simple"	target="mainFrame"> 第&nbsp;
                  <s:textfield name="index"	cssStyle="width:25px;height:20px;" /> &nbsp;页&nbsp; &nbsp;
                  <s:submit value="Go" id="go" />
								</s:form></td></tr></table></td>
						</tr>
					</tbody>
				</table></td>
		</tr>
	</table>
</body>
</html>
