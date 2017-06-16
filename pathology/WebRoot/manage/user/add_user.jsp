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
<link rel="stylesheet" href="${path }/css/general.css" />
<link rel="stylesheet" href="${path }/css/jquery-ui-1.8.20.custom.css" />
<link rel="stylesheet" href="${path }/css/public.css" type="text/css">
<script type="text/javascript" src="${path }/js/jquery.min.js"></script>
<script type="text/javascript" src="${path }/js/global.js"></script>
<script type="text/javascript" src="${path }/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript"
	src="${path }/js/jquery-ui-1.8.20.custom.min.js"></script>
<script type="text/javascript">
	$(function() {
		$(".ta tr").each(function(i) {
			this.style.backgroundColor = [ '#799AE1', '#D6DFF7' ][i % 2]
		});

		$(".ta tr").mouseover(function() {//如果鼠标移到class为stripe的表格的tr上时，执行函数
			$(this).addClass("mousehover");
		}).mouseout(function() {//给这行添加class值为over，并且当鼠标一出该行时执行函数
			$(this).removeClass("mousehover");
		}); //移除该行的class
	});
</script>
</head>
<center>
	<body>
		<div id="dcHead">
			<%@include file="/manage/managetop.jsp"%>
		</div>
		<!-- dcHead 结束 -->

		<div id="dcLeft">
			<%@include file="/manage/manageleft.jsp"%>
		</div>
		<div id="dcMain">
			<center>
				<form id="addForm" action="UserAction!addUser" target="mainFrame">
					<table>
						<tr>
							<td>用户名</td>
							<td><input class="textStyle" type="text"
								name="user.username" /></td>
						</tr>
						<tr>
							<td>密码</td>
							<td><input class="textStyle" type="password"
								name="user.password" /> <input type="hidden"
								name="user.idUsers" " />
							</td>
						</tr>
						<tr>
							<td>真实姓名</td>
							<td><input class="textStyle" type="text"
								name="user.realname " /></td>
						</tr>
						<tr>
							<td>性别</td>
							<td><input class="textStyle" type="text" name="user.sex" />
							</td>
						</tr>
						<tr>
							<td>邮箱</td>
							<td><input class="textStyle" type="text" name="user.email" />
							</td>
						</tr>
						<tr>
							<td>电话</td>
							<td><input class="textStyle" type="text" name="user.mobile" />
							</td>
						</tr>
						<tr>
							<td>手机</td>
							<td><input class="textStyle" type="text" name="user.tel" />
							</td>
						</tr>
						<tr>
							<td>所属医院</td>
							<td><input class="textStyle" type="text"
								name="user.belonghospital" /></td>
						</tr>
						<tr>
							<td>特长</td>
							<td><input class="textStyle" type="text"
								name="user.specialty" /></td>
						</tr>

						<tr>
							<td colspan="2"><input type="submit" value="提交"
								class="buStyle" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
								type="reset" value="重置" class="buStyle" /></td>
						</tr>
					</table>
				</form>
			</center>
		</div>
	</body>
</center>
</html>