<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>登录界面</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<s:head />
	</head>
	<body bgcolor="#FFFFFF" text="#000000">
		<p>
			&nbsp;
		</p>
		<center><s:actionerror/></center>
		<s:form action="leaf!login.action" theme="simple">
			<table width="258" border="1" align="center" cellspacing="1"
				bordercolor="#3399CC">
				<tr align="center">
					<td colspan="2" height="59">&nbsp; 
						<font size="6"><b><font color="#330099" size="5">开发部内部留言板</font>
						</b>
						</font>
					</td>
				</tr>
				<tr>
					<td width="96" align="right">
						姓名:
					</td>
					<td width="154">
					    <s:textfield name="u.username" cssStyle="width:120px;"></s:textfield>
					</td>
				</tr>
				<tr>
					<td width="96" align="right">
						口令:
					</td>
					<td width="154">
					    <s:password name="u.password" cssStyle="width:120px;"></s:password>
					</td>
				</tr>
				<tr align="center">
					<td colspan="2">
						<input type="submit" name="oper" value=" 登  录 ">
						<input type="reset" name="reset" value=" 复  位 ">
						<a href="reginput.action">注册</a>
					</td>
				</tr>
			</table>
		</s:form>
	</body>
</html>
