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
<script type="text/javascript" src="${path }/js/treeView.js"></script>
<script type="text/javascript" src="${path }/js/common-cn.js"></script>
<script type="text/javascript" src="${path }/js/forbid-refresh.js"></script>
<link rel="stylesheet" type="text/css"
	href="${path }/css/jquery.multiselect.css" />
<link rel="stylesheet" type="text/css"
	href="${path }/css/jquery.multiselect.filter.css" />
<link rel="stylesheet" type="text/css"
	href="${path }/js/multiselect/jquery-ui.css" />
<script type="text/javascript" src="${path }/js/multiselect/jquery.js"></script>
<script type="text/javascript"
	src="${path }/js/multiselect/jquery-ui.js"></script>
<script type="text/javascript"
	src="${path }/js/multiselect/jquery.multiselect.min.js"></script>
<script type="text/javascript"
	src="${path }/js/multiselect/jquery.multiselect.filter.min.js"></script>
<script type="text/javascript">
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
		  
		  <form name="articles" id="articles" method="post" action="UserAction!checkUserStatus">
		    <table class="maintable form_top_thin">
              <tr>
                <th>用户名</th>
                <td><input type="text" name="user.username" id="title" value="${sessionScope.user.username}" disabled="true" style="width:300px;" /> 
                	<input type="hidden" name="user.idUsers" value="${sessionScope.user.idUsers}" />
                </td>
              </tr>			  
              <tr>
                <th>密码</th>
                <td><input type="password" name="user.password" id="title" value="${sessionScope.user.password}" disabled="true" style="width:300px;" /> </td>
              </tr>			  
              <tr>
                <th>电子邮箱</th>
                <td><input type="text" name="user.email" id="title" value="${sessionScope.user.email}" disabled="true" style="width:300px;" /> </td>
              </tr>			  
              <tr>
                <th>真实姓名</th>
                <td><input type="text" name="user.realname" id="title2" value="${sessionScope.user.realname}"  disabled="true" style="width:300px;" /></td>
              </tr>			  
              <tr>
                <th>性别</th>
                <td><input type="radio" name="user.sex" value="男"  disabled="true"/>
                男  &nbsp;&nbsp;
                  <input type="radio" name="user.sex" value="女" disabled="true" />
                女 </td>
              </tr>			  
              <tr>
                <th>联系电话</th>
                <td><input type="text" name="user.mobile" id="title" disabled="true" value="${sessionScope.user.mobile}" style="width:300px;" /> </td>
              </tr>			  		  
              <tr>
                <th>状态</th>
                <td>
                <input type="text"  disabled="true" 
                <c:choose>
                <c:when test="${sessionScope.user.userstatus=='0'}"> value="待审核"</c:when>
                <c:when test="${sessionScope.user.userstatus=='1'}"> value="审核通过"</c:when>
                <c:when test="${sessionScope.user.userstatus=='2'}"> value="审核拒绝"</c:when>
                <c:otherwise>value="未知"</c:otherwise></c:choose>
                 />
                
                </td>
              </tr>
              <tr>
						<th>所属医院</th>
						<td>
						<input type="text" name="user.belonghospital"
							id="hospitalIdIpt" type="hidden"
							value="${sessionScope.edituser.belonghospital}" style="display:none" /> 
						<select id='select' multiple="multiple" style="width:300px;">
								<c:forEach items="${sessionScope.allhaospitallist}"
									var="hospital">
									<option value="${hospital.idHospital}">${hospital.name}</option>
								</c:forEach>


						</select> <script type="text/javascript">
							$(function() {

								//以下为初始配置参数，用户可自行配置，同时，可配置事件参数
								var el = $('#select').multiselect({
									header : true,
									height : 175,
									minWidth : 225,
									classes : '',
									checkAllText : '选中全部',
									uncheckAllText : '取消全选',
									noneSelectedText : '请勾选',
									selectedText : '# 选中',
									selectedList : 5,
									show : null,
									hide : null,
									autoOpen : false,
									multiple : true,
									position : {},
									appendTo : "body",
									menuWidth : null
								}).multiselectfilter();

								var ss = '${sessionScope.edituser.belonghospital}';
								var ay = ss.split(',');
								$('#select option').each(function(i, content) {
									for ( var i = 0; i < ay.length; i++) {
										if ($(content).val() == ay[i])
											this.selected = true;
									}
								});
								el.multiselect('refresh');

							});

							function hosset() {
								var hospitalIds = '';
								$('#select option').each(function(i, content) {
									if (this.selected) {
										if (hospitalIds != '')
											hospitalIds += ',';

										hospitalIds += $(content).val();
									}
								});
								if (hospitalIds == '') {
									$('#hospitalIdIpt').val('');
									return false;
								} else {
									$('#hospitalIdIpt').val(hospitalIds);
									return true;
								}
							}
						</script>
						</td>
					</tr>
              <tr>
                <th>医师资格</th>
                <td><img id="img" name="user.mobile" src="${sessionScope.user.doctorctfsrc}" width="400" height="400" /> </td>
              </tr>	
            </table>
		    <table width="60%" align="center" border="0">
		  	<tr>
				<td class="buttons">
				<input type="submit" name="Submit" id="Submit" <c:if test="${sessionScope.user.userstatus=='1'}">disabled="true"</c:if>  value="审核通过" />
				<input id="Refuse" type="button" <c:if test="${sessionScope.user.userstatus=='2'}">disabled="true"</c:if> name="Refuse"  onClick="window.location.href='UserAction!refuseCheck?idUsers=${sessionScope.user.idUsers}'" value="审核拒绝" />
				</td>
			</tr>
		  </table>
		  		<input type="hidden" name="id" value="" />
		  </form>
		  
	  </td>
		</tr>
	</table>
</html>