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
<script type="text/javascript"
	src="${path }/CKEditor/ckeditor/ckeditor.js"></script>
<script type="text/javascript"
	src="${path }/CKFinder/ckfinder/ckfinder.js"></script>
<script type="text/javascript" src="${path }/js/treeView.js"></script>
<script type="text/javascript" src="${path }/js/common-cn.js"></script>
<script type="text/javascript" src="${path }/js/forbid-refresh.js"></script>
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
<div id="header">
		<%@include file="/manage/managetop.jsp"%>
	</div>
	<!-- dcHead 结束 -->
	<table id="main" cellpadding="0" cellspacing="0" border="0">
		<tr>
			<td id="leftmenu">
			<%@include file="/manage/manageleft.jsp"%>
			</td>
			<td id="contents">
	  
		  <table id="pagehead" cellspacing="0" cellpadding="0" width="100%" border="0">
			<tr>
			  <td><h1>会员信息</h1></td>
			</tr>
		  </table>
		  
		  <form name="articles" id="articles" method="post" action="UserAction!saveUser">
		    <table class="maintable form_top_thin">
              <tr>
                <th>用户名</th>
                <td><input type="text" name="user.username" id="title" value="${sessionScope.user.username}" style="width:300px;" disabled/> 
                	<input type="hidden" name="user.idUsers" value="${sessionScope.user.idUsers}" disabled/>
                </td>
              </tr>			  
              <tr>
                <th>密码</th>
                <td><input type="password" name="user.password" id="title" value="${sessionScope.user.password}" style="width:300px;" disabled/> </td>
              </tr>			  
              <tr>
                <th>电子邮箱</th>
                <td><input type="text" name="user.email" id="title" value="${sessionScope.user.email}" style="width:300px;" disabled/> </td>
              </tr>			  
              <tr>
                <th>真实姓名</th>
                <td><input type="text" name="user.realname" id="title2" value="${sessionScope.user.realname}" style="width:300px;" /></td>
              </tr>			  
              <tr>
                <th>性别</th>
                <td><input type="radio" name="user.sex" value="男" />
                男  &nbsp;&nbsp;
                  <input type="radio" name="user.sex" value="女" />
                女 </td>
              </tr>			  
              <tr>
                <th>联系电话</th>
                <td><input type="text" name="user.mobile" id="title" value="${sessionScope.user.mobile}" style="width:300px;" /> </td>
              </tr>			  
             		  
              <tr>
                <th>角色</th>
                <td><select name="select">
                <c:forEach var="roles" items="${rolelist}">
                  <option value="${roles.idRoles}">${roles.name}</option>
                  
                  </c:forEach>
				
                  </select></td>
              </tr>
            </table>
		    <table width="60%" align="center" border="0">
		  	<tr>
				<td class="buttons">
				<input type="submit" name="Submit" id="Submit"  value="提交" />
				<input type="button" name="Reset" id="Reset" value="重置" onclick="resetForm()" />
				</td>
			</tr>
		  </table>
		  		<input type="hidden" name="id" value="" />
		  </form>
		  
	  </td>
		</tr>
	</table>
</html>