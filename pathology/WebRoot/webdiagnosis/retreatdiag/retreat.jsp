<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<title>病理远程会诊平台-用户注册</title>
<c:set var="path" value="${pageContext.request.contextPath }" />
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="this is my page">
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<LINK rel="Shortcut icon" href="favicon.ico" />
<link rel="stylesheet" type="text/css" href="${path }/css/settings.css" />
<link rel="stylesheet" type="text/css" href="${path }/css/select.css" />
<script src="${path }/js/regist.js" type="text/javascript"></script>
<script type="text/javascript" src="${path }/js/passwordcheck.js"></script>
<script src="${path }/js/jquery/jquery-1.4.4.min.js"
	type="text/javascript"></script>

</head>
<body>
	<div id="3" style="position: relative;  z-index: 3;">
		<form id="f1" action="PathologyAction!updateRetreatReason" method="post"
			enctype="multipart/form-data" >
			<table align="center" cellspacing="0" class="registtb">
				<tr class="thead">
					<td align="center">退回病例</td>
				</tr>
				<tr>
					<td>
						<table id="registertable" border="0px" align="center" border="0px"
							cellspacing="0" cellpadding="5px">
							<tr>
							<tr>
								<td align="right">退回原因：</td>
								<td align="left"><input id="retreatreason" type="text"
									name="pathology.retreatReason"  /> <input
									id="caseid" type="hidden" name="pathology.caseId" />
									
								</td>
							</tr>
							<tr>
								<td colspan="2"></td>
							</tr>

							<tr height="60px">
								
								<td align="center"><input type="submit" accesskey="enter"
									value="确定" id="btn" onmousemove="changeBgColor('btn')"
									onmouseout="recoverBgColor('btn');" class="submit"
									formmethod="post" />
								</td>
								<td align="center"><INPUT TYPE='BUTTON' class="submit" value='关闭' onClick='window.close()'> </td>

							</tr>
						</table>
					</td>
				</tr>
			</table>
		</form>
	</div>

</body>
</html>
