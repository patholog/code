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
			  <td><h1>医院信息</h1></td>
			</tr>
		  </table>
		  
		  <form name="articles" id="articles" method="post" action="HospitalAction!saveHospital">
		    <table class="maintable form_top_thin">
              <tr>
                <th>医院名称</th>
                <td><input type="text" name="hospital.name" id="title" value="${sessionScope.hospital.name}" style="width:300px;" /> 
                	<input type="hidden" name="{hospital.idHospital" value="${sessionScope.hospital.idHospital}" />
                </td>
              </tr>		  
              <tr>
                <th>医院编码</th>
                <td><input type="text" name="hospital.code" id="title" value="${sessionScope.hospital.code}" style="width:300px;" /> </td>
              </tr>			  
              <tr>
                <th>电话</th>
                <td><input type="text" name="hospital.tel" id="title" value="${sessionScope.hospital.tel}" style="width:300px;" /></td>
              </tr>			    
              <tr>
                <th>地址</th>
                <td><input type="text" name="hospital.address" id="title" value="${sessionScope.hospital.address}" style="width:300px;" /> </td>
              </tr>	
              <tr>
                <th>备注</th>
                <td><input type="text" name="hospital.memo" id="title" value="${sessionScope.hospital.memo}" style="width:300px;" /> </td>
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