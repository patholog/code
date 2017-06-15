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
			this.style.backgroundColor = [ '#ffffff', '#dde5f2' ][i % 2]
		});

		$(".ta tr").mouseover(function() {//如果鼠标移到class为stripe的表格的tr上时，执行函数
			$(this).addClass("mousehover");
		}).mouseout(function() {//给这行添加class值为over，并且当鼠标一出该行时执行函数
			$(this).removeClass("mousehover");
		}); //移除该行的class
	});

	function showDialogForEdit(id) {
		window.showModalDialog('UserAction!updateUsersDialog?hospital.idUsers='
				+ id, '', 'dialogWidth=800px;dialogHeight=600px;');
	}
	function showBox(id) {
		hospitalList.forEach(function(hospital){
			if(hospital.idHospital == id) {
				for(var key in hospital){
					$("#editForm").find("[name=hospital\\."+key+"]").val(hospital[key]);
				}
			}
		});
	
		var show = document.getElementById("edit");
		var bg_filter = document.getElementById("bg_filter");
		show.style.display = "block";
		bg_filter.style.display = "block";
	}
	function deleteLogin() {
		var del = document.getElementById("edit");
		var bg_filter = document.getElementById("bg_filter");
		bg_filter.style.display = "none";
		del.style.display = "none";
	}
	
	var hospitalList=[
		<c:forEach items="${sessionScope.hoslist }" var="hospital"
			varStatus="status">
			{
				idHospital:"${hospital.idHospital}",
				name:"${hospital.name}",
				code:"${hospital.code}",
				tel:"${hospital.tel}",
				address:"${hospital.address }",
				memo:"${hospital.memo }",
				
			},
		</c:forEach>
	];
	
</script>
</head>
<center>
	<body>
		<!-- 综合查询操作层 -->
		<div id="selectDiv">
			<s:form action="HospitalAction!hospitalList" theme="simple"
				target="mainFrame">
				<fieldset style="width:80%">
					<legend>查询条件</legend>
					医院名称:
					<s:textfield name="hospital.name" cssClass="textStyle" />
					编码:
					<s:textfield name="hospital.code" cssClass="textStyle" />
					<s:submit value="查  询" cssClass="buStyle" />
				</fieldset>
			</s:form>
		</div>
		<table class="ta">
			<tr bgcolor="#578de3">
				<th width="20%">医院</th>
				<th width="10%">编号</th>
				<th width="10%">电话</th>
				<th width="20%">地址</th>				
				<th width="30%">备注</th>
				<th width="10%">操作</th>
			</tr>
			<c:forEach items="${sessionScope.hoslist }" var="hospital"
				varStatus="status">
				<tr bgColor="${status.index%2==0?'#ffffff':'#dde5f2' }">
					<td class="username">${hospital.name}</td>
					<td>${hospital.code}</td>
					<td>${hospital.tel }</td>
					<td>${hospital.address }</td>
					<td>${hospital.memo }</td>
					<td><img class="img" src="${path }/images/icon_edit_blue.png"
						alt="编辑" href="javascript:void(0)"
						onclick="showBox('${hospital.idHospital }')" /><a
						style="border-width:0px"
						href="HospitalAction!deleteHospital?hospital.idHospital=${hospital.idHospital }"><img
							class="img" src="${path }/images/icon_no.png" alt="删除" /> </a>
					</td>
				</tr>s
			</c:forEach>
		</table>
		<br />
		<center>
			<div id="pageDir">
				<c:set var="pageCount" value="${(sessionScope.count-1)/10+1 }" />
				<fmt:formatNumber var="lastIndex" value="${pageCount}" pattern="#" />
				<ul>
					<li style="margin-left:25%;">第${sessionScope.thisindex
						}/${lastIndex }页</li>
					<li style="margin-left:40px;"><a
						href="HospitalAction!hospitalList?index=1" target="mainFrame">首页</a> <!-- 
							<c:set var="pageCount" value="${fn:length(userList)%10==0?fn:length(userList)/10:fn:length(userList)/10+1 }"/>
						--> <c:forEach var="i" begin="1" step="1" end="${lastIndex }">
							<a href="HospitalAction!hospitalList?index=${i } " target="mainFrame"><c:out
									value="${i }" /> </a>
						</c:forEach> <a href="HospitalAction?index=${lastIndex}" target="mainFrame">尾页</a>
					</li>
					<li style="margin-left:40px;"><s:form
							action="HospitalAction!hospitalList" theme="simple" target="mainFrame">
							第<s:textfield name="index" cssStyle="width:25px;height:20px;" />页
							<s:submit value="Go" id="go" />
						</s:form></li>
				</ul>
			</div>
		</center>
		<div class="event" id="edit" style="display: none;">
			<div class="editing">
				<div class="title">
					<span class="t_txt">医院修改</span> <span class="del"
						onClick="deleteLogin()">X</span>
				</div>
				<form id="editForm" action="HospitalAction!updateHospital"
					target="mainFrame">
					<table>
						<tr>
							<td>医院名称</td>
							<td><input type="text" name="hospital.name" /></td>
						</tr>
						<tr>
							<td>编码</td>
							<td><input type="text" name="hospital.code" /> <input
								type="hidden" name="hospital.idHospital" " />
							</td>
						</tr>
						<tr>
							<td>电话</td>
							<td><input type="text" name="hospital.tel " /></td>
						</tr>
						<tr>
							<td>地址</td>
							<td><input type="text" name="hospital.address" /></td>
						</tr>
						<tr>
							<td>备注</td>
							<td><input type="text" name="hospital.memo" /></td>
						</tr>
						
						<tr>
							<td colspan="2"><input type="submit" value="提交"
								class="buStyle" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
								type="reset" value="重置" class="buStyle" /></td>
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