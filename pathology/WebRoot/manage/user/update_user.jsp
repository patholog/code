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
	</script>
	</head>
	<center>
	<body>
		<div class="event" id="edit" style="display: none;">
		<div class="editing">
			<div class="title">
				<span class="t_txt">人员修改</span>
				<span class="del" onClick="deleteLogin()">X</span>
			</div>
			<form action="UserAction!updateUser" target="mainFrame"
				onsubmit="javascript:window.close();">
				<table  >
					<tr>
						<td>用户名</td>
						<td><input type="text" name="user.username"
							value="${request.user.username }" />
						</td>
					</tr>
					<tr>
						<td>密码</td>
						<td><input type="password" name="user.password"
							value="${request.user.password }" /> <input type="hidden"
							name="user.idUsers" value="${request.user.idUsers }" /></td>
					</tr>
					<tr>
						<td>邮箱</td>
						<td><input type="text" name="user.email"
							value="${request.user.email }" />
						</td>
					</tr>
					<tr>
						<td>电话</td>
						<td><input type="text" name="user.mobile"
							value="${request.user.mobile }" />
						</td>
					</tr>
					<tr>
						<td>特长</td>
						<td><input type="text" name="user.specialty"
							value="${user.specialty }" />
						</td>
					</tr>

					<tr>
						<td colspan="2"><input type="submit" value="提交"
							class="buStyle" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
							type="reset" value="重置" class="buStyle" />
						</td>
					</tr>
				</table>
			</form>
			</div>
		</div>
		<div class="bg_color" onClick="deleteLogin()" id="bg_filter"
			style="display: none;"></div>
	</body>
	</center>
</html>