<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<title>新增角色</title>
<c:set var="path" value="${pageContext.request.contextPath }" />
<link rel="stylesheet" type="text/css" href="${path }/css/style.css" />
<script src="${path }/js/jquery/jquery-1.4.4.min.js"></script>	
<script type="text/javascript" src="${path }/js/treeView.js"></script>
<script type="text/javascript" src="${path }/js/common-cn.js"></script>
<script type="text/javascript" src="${path }/js/forbid-refresh.js"></script>
<script type="text/javascript">  
function resetForm()  
{  
document.getElementById("articles").reset();  
}  
</script>
<script type="text/javascript">
	$(document).ready(function() {

		$("#memo").blur(function() {
			var spe = $("#memo").val().trim();
			if(spe.length>128){
				$("#memotip").html("<a style='color:#2ca9cc;font-size:14px;'>录入超长!</a>");
				$("#Submit").attr("disabled",true);
				return false;
			}else{
				$("#memotip").html("");
				$("#Submit").attr("disabled",false);
				return true;
			}
		});
		
		$("#description").blur(function() {
			var spe = $("#description").val().trim();
			if(spe.length>128){
				$("#descriptiontip").html("<a style='color:#2ca9cc;font-size:14px;'>录入超长!</a>");
				$("#Submit").attr("disabled",true);
				return false;
			}else{
				$("#descriptiontip").html("");
				$("#Submit").attr("disabled",false);
				return true;
			}
		});
		
		$("#name").blur(function() {
			var spe = $("#name").val().trim();
			if(spe.length>100){
				$("#nametip").html("<a style='color:#2ca9cc;font-size:14px;'>录入超长!</a>");
				$("#btn").attr("disabled",true);
				return false;
			}else{
				$("#nametip").html("");
				$("#Submit").attr("disabled",false);
				return true;
			}
		}); 
	});
	$(function() {
		$(".ta tr").each(function(i) {
			this.style.backgroundColor = [ '#799AE1', '#D6DFF7' ][i % 2];
		});

		$(".ta tr").mouseover(function() {//如果鼠标移到class为stripe的表格的tr上时，执行函数
			$(this).addClass("mousehover");
		}).mouseout(function() {//给这行添加class值为over，并且当鼠标一出该行时执行函数
			$(this).removeClass("mousehover");
		}); //移除该行的class
	});
	
	function chk(){ 
		var obj=document.getElementsByName('function'); 
		var s=''; 
		for(var i=0; i<obj.length; i++){ 
		if(obj[i].checked) s+=obj[i].value+','; //如果选中，将value添加到变量s中 
		} 
		if(s==''){
			alert("请选择功能分配！");
		}else{
			document.articles.action="RolesAction!addRoles?function"+s;
		}
	}
	
	
</script>
</head>
<div id="header">
	<%@include file="/manage/managetop.jsp"%>
</div>
<!-- dcHead 结束 -->
<table id="main" cellpadding="0" cellspacing="0" border="0">
	<tr>
		<td id="leftmenu"><%@include file="/manage/manageleft.jsp"%>
		</td>
		<td id="contents">

			<table id="pagehead" cellspacing="0" cellpadding="0" width="100%"
				border="0">
				<tr>
					<td><h1>角色信息</h1>
					</td>
				</tr>
			</table>

			<form name="articles" id="articles" method="post"
				>
				<table class="maintable form_top_thin">
					<tr>
						<th>角色名称</th>
						<td><input type="text" name="roles.name" id="name" value=""
							style="width:300px;" /><span id="nametip"></span></td>
					</tr>
					<tr>
						<th>角色描述</th>
						<td><input type="text" name="roles.description" id="description"
							value="" style="width:300px;" /><span id="descriptiontip"></span></td>
					</tr>
					<tr>
						<th>角色备注</th>
						<td><input type="text" name="roles.memo" id="memo" value=""
							style="width:300px;" /><span id="memostip"></span></td>
					</tr>
					<tr>
						<th>功能分配</th>
						<td><c:forEach var="func" items="${functionlist}">
								<label><input type="checkbox" name="function" id="title"
									value="${func.idFunction}" /> ${func.name}</label>
							</c:forEach></td>
					</tr>
					<tr>
				</table>
				<table width="60%" align="center" border="0">
					<tr>
						<td class="buttons"><input type="submit" name="Submit"
							id="Submit" value="提交" onclick="chk()"/> <input type="button" name="Reset"
							id="Reset" value="重置" onclick="resetForm()" /></td>
					</tr>
				</table>
				<input type="hidden" name="id" value="" />
			</form></td>
	</tr>
</table>
</html>