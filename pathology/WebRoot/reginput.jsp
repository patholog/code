<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>注册界面</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="description" content="This is my page">
		<s:head />
	</head>
	<body bgcolor="#FFFFFF" text="#000000">
		<center><s:actionerror/></center>
		<s:form action="leaf!reg.action" theme="simple">
			<table width="258" border="1" align="center" cellspacing="1"
				bordercolor="#3399CC">
				<tr align="center">
					<td colspan="2" height="59">
						<font size="6"><b><font color="#330099" size="5">留言板用户注册</font>
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
				<tr>
					<td width="96" align="right">
						确认口令:
					</td>
					<td width="154">
						<s:password name="u.repassword" cssStyle="width:120px;"></s:password>
					</td>
				</tr>
				<tr align="center">
					<td colspan="2">
						<input type="submit" name="oper" value=" 注  册 ">
						<input type="reset" name="reset" value=" 复  位 ">
					</td>
				</tr>
			</table>
		</s:form>
	</body>
</html>
