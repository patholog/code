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
<script src="${path }/js/jquery/jquery-1.4.4.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#hospitalcode").blur(function() {
					var hospitalcode = $("#hospitalcode").val().trim();
					if (hospitalcode == '') {
						$("#hospitalcodetip").html("<a style='color:#2ca9cc;font-size:14px;'>编码不能为空！</a>");
						$("#Submit").attr("disabled",true);
						return false;
					}else if(hospitalcode.length<6){
							$("#hospitalcodetip").html("<a style='color:#2ca9cc;font-size:14px;'>编码不能少于6位！</a>");
							$("#Submit").attr("disabled",true);
							return false;
					}else if(hospitalcode.length>20){
							$("#hospitalcodetip").html("<a style='color:#2ca9cc;font-size:14px;'>编码不能超过20位！</a>");
							$("#Submit").attr("disabled",true);
							return false;
					}
					else {
						
						var zmnumReg=/^[0-9a-zA-Z]*$/;  
						if(hospitalcode!=""&&!zmnumReg.test(hospitalcode)){  
							$("#hospitalcodetip").html("<a style='color:#2ca9cc;font-size:14px;'>只能输入字母或数字!</a>");
							$("#hospitalcode").val("");
							$("#Submit").attr("disabled",true);
							return false;
						}
			}
		});	
		
		$("#name").blur(function() {
					var name = $("#name").val().trim();
					if (name == '') {
						$("#nametip").html("<a style='color:#2ca9cc;font-size:14px;'>名称不能为空！</a>");
						$("#Submit").attr("disabled",true);
						return false;
					}else if(name.length>50){
							$("#nametip").html("<a style='color:#2ca9cc;font-size:14px;'>名称过长！</a>");
							$("#Submit").attr("disabled",true);
							return false;
					}
			
		});	
		
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
		$("#address").blur(function() {
			var spe = $("#address").val().trim();
			if(spe.length>128){
				$("#addresstip").html("<a style='color:#2ca9cc;font-size:14px;'>录入超长!</a>");
				$("#Submit").attr("disabled",true);
				return false;
			}else{
				$("#addresstip").html("");
				$("#Submit").attr("disabled",false);
				return true;
			}
		});
		

	});
</script>
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
		  
		  <form name="articles" id="articles" method="post" action="HospitalAction!addHospital">
		    <table class="maintable form_top_thin">
              <tr>
                <th>医院名称</th>
                <td><input type="text" name="hospital.name" id="name" value="" style="width:300px;" required/> <span id="nametip"></span></td>
              </tr>			  
              <tr>
                <th>医院编码</th>
                <td><input type="text" name="hospital.hospitalcode" id="hospitalcode" value="" style="width:300px;" required/><span id="hospitalcodetip"></span> </td>
              </tr>			  
              <tr>
                <th>电话</th>
                <td><input type="text" name="hospital.tel" id="tel" value="" style="width:300px;" required/><span id="teltip"></span> </td>
              </tr>			  
              <tr>
                <th>地址</th>
                <td><input type="text" name="hospital.address" id="address" value="" style="width:300px;" required/><span id="addresstip"></span></td>
              </tr>	
              <tr>
                <th>备注</th>
                <td><input type="text" name="hospital.memo" id="memo" value="" style="width:300px;" required/><span id="memotip"></span></td>
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