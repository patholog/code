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
	function confirmDelete(id) {
		if (confirm('你确定删除此产品？'))
			window.location.href = '?action=delete&id=' + id;
	}
</script>
</head>

<body>
	<div id="header">
		<%@include file="/webdiagnosis/maintop.jsp"%>
	</div>
	<table id="main" cellpadding="0" cellspacing="0" border="0">
		<tr>
			<td id="leftmenu"><%@include file="/webdiagnosis/mainleft.jsp"%>
			</td>
			<td id="contents">
				 <s:form action="HospitalAction!hospitalList" theme="simple"
					target="mainFrame">
					<table cellspacing="0" cellpadding="0" width="100%" border="0"
						class="toolstable">
						<tr>
							<td width="86%" style="text-align:left;"><label>医院名称：</label>
								<input type="text" name="hospital.name" id="hostpital_name" value="" style="width:120px;" /> <label>编码：</label> 
								<input type="text" name="hospital.code" id="hostpital_code" value="" style="width:120px;" /> 
								<input name="searchButton" id="searchButton" onclick="" type="submit" style="width:80px;background:url(css/img-blue/search.gif) 8px top no-repeat;"
									value="  搜索" />
							</td>
				
						</tr>
					</table>
				</s:form>
				<table class="listtable" cellspacing="0" cellpadding="0"
					width="100%">
					<tbody>
						<tr>
				          <th width="10%">病理号</th>
				          <th width="10%">病人姓名</th>
				          <th width="15%">材料部位</th>
				          <th width="10%">病例状态</th>
				          <th width="10%">系统分类</th>
				          <th width="20%">送检单位</th>
				          <th width="15%">退回原因</th>
				          <th width="10%">退回时间</th>
						</tr>
						<c:forEach items="${sessionScope.hoslist }" var="hospital" varStatus="status">
							<tr bgColor="${status.index%2==0?'#f9f9ff':'#ffffff' }">
							<td>${hospital.name}</td>
							<td>${hospital.code}</td>
							<td>${hospital.tel }</td>
							<td>${hospital.address }</td>
							<td>${hospital.memo }</td>
								<td class="action_collomn"><a
									href="HospitalAction!updateHospital?hospital.idHospital=${hospital.idHospital }">修改</a> &nbsp; | &nbsp; <a
									href="HospitalAction!deleteHospital?hospital.idHospital=${hospital.idHospital }">删除</a>
							</tr>
						</c:forEach>


						<tr class="lightrow">
							<td colspan="8"><div id="pageDir">
									<c:set var="pageCount" value="${(sessionScope.count-1)/10+1 }" />
									<fmt:formatNumber var="lastIndex" value="${pageCount}"
										pattern="#" />

									第${sessionScope.thisindex }/${lastIndex }页 &nbsp; &nbsp; <a
										href="HospitalAction!hospitalList?index=1" target="mainFrame">首页</a>&nbsp; 
									<!-- 
							<c:set var="pageCount" value="${fn:length(userList)%10==0?fn:length(userList)/10:fn:length(userList)/10+1 }"/>
						-->
									<c:forEach var="i" begin="1" step="1" end="${lastIndex }">
										<a href="HospitalAction!hospitalList?index=${i } " target="mainFrame"><c:out
												value="${i }" /> </a>
									</c:forEach>
									&nbsp;<a href="HospitalAction?index=${lastIndex}" target="mainFrame">尾页</a>

									<s:form action="HospitalAction!hospitalList" theme="simple"
										target="mainFrame">
							第&nbsp;<s:textfield name="index" cssStyle="width:25px;height:20px;" />&nbsp;页&nbsp; &nbsp;
							<s:submit value="Go" id="go" />
									</s:form>

								</div></td>
						</tr>

					</tbody>
				</table>
			</td>
		</tr>
	</table>

</body>
</html>