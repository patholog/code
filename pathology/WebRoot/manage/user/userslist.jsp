<%@ page language="java" contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/struts-tags" prefix="s" %> 
<html>
	<head><title></title>
	<c:set var="path" value="${pageContext.request.contextPath }"/>
	<link rel="stylesheet" href="${path }/css/general.css"/>
	<link rel="stylesheet" href="${path }/css/jquery-ui-1.8.20.custom.css"/>
	<script type="text/javascript" src="${path }/js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="${path }/js/jquery-ui-1.8.20.custom.min.js"></script>
	<script type="text/javascript">
	$(function() {
		$(".ta tr").each(function(i) {
			this.style.backgroundColor = [ '#799AE1', '#D6DFF7' ][i % 2]
		});

		  $(".ta tr").mouseover(function(){//如果鼠标移到class为stripe的表格的tr上时，执行函数
                $(this).addClass("mousehover");}).mouseout(function(){//给这行添加class值为over，并且当鼠标一出该行时执行函数
                $(this).removeClass("mousehover");}); //移除该行的class
	});
	
	
		function showDialogForEdit(id){
			window.showModalDialog('UserAction!updateUsersDialog?user.idUsers='+id,'','dialogWidth=800px;dialogHeight=600px;');
	}
	
	</script>
	</head>
	<center>
	<body>
		<!-- 综合查询操作层 -->
		<div id="selectDiv">
			<s:form action="UserAction!userList" theme="simple" target="mainFrame" >
				<fieldset style="width:80%">
					<legend>查询条件</legend>
				姓名:<s:textfield name="user.username" cssClass="textStyle"/>
				电话:<s:textfield name="user.tel" cssClass="textStyle"/>
				<s:submit value="查  询" cssClass="buStyle"/>
				</fieldset>
			</s:form>
		</div>
		<table class="ta">	
			<tr bgcolor="#D6DFF7">
				  <th width="10%">用户名称</th>
		          <th width="10%">性别</th>
		          <th width="15%">邮箱</th>
		          <th width="20%">所属医院</th>
		          <th width="10%">特长</th>
		          <th width="15%">手机</th>
		          <th width="10%">电话</th>
		          <th width="10%">操作</th>
			</tr>
			<c:forEach items="${sessionScope.list }" var="user" varStatus="status">
				<tr bgColor="${status.index%2==0?'#e5fee2':'#d6fdd0' }">
	                <td >${user.username}</td>
	                <td >${user.sex}</td>
	                <td >${user.email }</td>
	                <td >${user.belonghospital }</td>
	                <td >${user.specialty }</td>
	                <td >${user.mobile }</td>
	                <td >${user.tel }</td>
	                <td><img src="${path }/images/edit2.png" alt="编辑" onclick="showDialogForEdit(${user.idUsers})"/></td>
					<td><a style="border-width:0px" href="UserAction!deleteUser?user.idUsers=${user.idUsers }"><img src="${path }/images/delete.png" alt="删除"/></a></td>
				</tr>
			</c:forEach>		
		</table>
		<br/>
		<center>
		<div id="pageDir">
			 	<c:set var="pageCount" value="${(sessionScope.count-1)/10+1 }"/>
				<fmt:formatNumber var="lastIndex" value="${pageCount}" pattern="#"/>
			<ul>
				<li style="margin-left:25%;">
					第${sessionScope.thisindex }/${lastIndex }页
				</li>
				<li style="margin-left:40px;">
						<a href="UserAction!userList?index=1" target="mainFrame">首页</a>
						
						<!-- 
							<c:set var="pageCount" value="${fn:length(userList)%10==0?fn:length(userList)/10:fn:length(userList)/10+1 }"/>
						-->
						
						 	<c:forEach var="i"  begin="1" step="1" end="${lastIndex }">
								<a href="UserAction!userList?index=${i } " target="mainFrame"><c:out value="${i }"/></a>
							</c:forEach>
						<a href="UserAction?index=${lastIndex}" target="mainFrame">尾页</a>
				</li>
				 <li style="margin-left:40px;">
						<s:form action="UserAction!userList" theme="simple" target="mainFrame">
							第<s:textfield  name="index" cssStyle="width:25px;height:20px;"/>页
							<s:submit value="Go" id="go"/>
						</s:form>
				</li>
			</ul>
		</div>
		</center>
	</body>
	</center>
</html>