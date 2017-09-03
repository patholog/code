<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<title>新增功能</title>
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

		$("#url").blur(function() {
			var spe = $("#url").val().trim();
			if(spe.length>128){
				$("#urltip").html("<a style='color:#2ca9cc;font-size:14px;'>录入超长!</a>");
				$("#Submit").attr("disabled",true);
				return false;
			}else{
				$("#urltip").html("");
				$("#Submit").attr("disabled",false);
				return true;
			}
		});
		$("#short").blur(function() {
			var spe = $("#short").val().trim();
			if(spe.length>128){
				$("#shorttip").html("<a style='color:#2ca9cc;font-size:14px;'>录入超长!</a>");
				$("#Submit").attr("disabled",true);
				return false;
			}else{
				$("#shorttip").html("");
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
			  <td><h1>功能信息</h1></td>
			</tr>
		  </table>
		  
		  <form name="articles" id="articles" method="post" action="FunctionAction!addFunction">
		    <table class="maintable form_top_thin">
              <tr>
                <th>功能名称</th>
                <td><input type="text" name="function.name" id="name" value="" style="width:300px;" /><span id="nametip"></span> </td>
              </tr>			  
              <tr>
                <th>URL</th>
                <td><input type="text" name="function.url" id="url" value="" style="width:300px;" /> <span id="urltip"></span></td>
              </tr>			  
              <tr>
                <th>简称</th>
                <td><input type="text" name="function.short_" id="short" value="" style="width:300px;" /><span id="shorttip"></span> </td>
              </tr>			  
              <tr>
                <th>描述</th>
                <td><input type="text" name="function.description" id="description" value="" style="width:300px;" /><span id="descriptiontip"></span></td>
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