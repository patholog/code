<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>发布页面</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<s:head />
	</head>
	<body bgcolor="#FFFFFF" text="#000000">
		<table width="331" border="0" align="center">
			<tr>
				<td height="34">
					<font size="4"><b> <a href="show.action">返回主页</a>
					</b>
					</font> &nbsp; &nbsp; &nbsp;
					<a href="loginput.action"><b><font size="4"> 退出系统</font>
					</b>
					</a>
				</td>
			</tr>
			<tr>
				<td height="32" valign="bottom">
					<font size="4"><b>信息发送:</b>
					</font>
				</td>
			</tr>
			<s:form action="leaf!addleaf.action" theme="simple">
			<tr>
				<td>
					<table width="308" border="1" bordercolor="#3399cc" cellspacing="1">
						<tr>
							<td width="86" align="right">
								接收人:
							</td>
							<td width="209">
								<s:textfield name="l.sendfor" value="所有人" cssStyle="width:150px;"></s:textfield>
							</td>
						</tr>
						<tr valign="top">
							<td width="86" align="right">
								信息内容:
							</td>
							<td width="209">
								<s:textarea name="l.content"></s:textarea>
							</td>
						</tr>
						<tr align="center">
							<td colspan="2">
								<input type="submit" name="oper" value=" 发  送 ">
								<input type="reset" name="reset" value=" 复  位 ">
							</td>
						</tr>
					</table>
				</td>
			</tr>
			</s:form>
			<tr>
				<td>
					&nbsp;
				</td>
			</tr>
		</table>
	</body>
</html>

