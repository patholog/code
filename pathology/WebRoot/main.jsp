<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>主页面</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<s:head />
	</head>
	<script type="text/javascript">
	 function ff(){
	  if(confirm("确认删除？"))
	   return true;
	   else
	   return false; 
	 }
	</script>
	<body bgcolor="#FFFFFF" text="#000000">
		<p>
			&nbsp;
		</p>
		<table width="500" border="0" align="center">
			<tr>
				<td height="34">
					<font size="4"><b> <a href="addleaf.action">发布信息</a> </b> </font>
					&nbsp; &nbsp; &nbsp;
					<a href="loginput.action"><b><font size="4"> 退出系统</font> </b> </a>
				</td>
			</tr>
			<tr>
				<td height="32" valign="bottom">
					<font size="4"><b>留言信息:</b> </font>
				</td>
			</tr>
			<tr>
				<td>
					<table width="100%" border="1" bordercolor="#3399CC"
						cellspacing="1">
						<tr align="center">
							<td width="65">
								发送人
							</td>
							<td width="95" align="center">
								发送时间
							</td>
							<td width="65">
								接收人
							</td>
							<td width="230">
								信息内容
							</td>
							<td width="40">
								删除
							</td>
						</tr>
						<s:if test="list==null||list.size()<1">
							<tr>
								<td colspan="5">
									<font size="4"><b>暂无留言</b> </font>
								</td>
							</tr>
						</s:if>
						<s:else>
							<s:iterator value="list" var="leaf">
								<tr>
									<td align="center">
										<s:property value="#leaf.users.username" />
									</td>
									<td align="center">
										<s:date name="pdate" format="yyyy-M-d" />
									</td>
									<td align="center">
										<s:property value="sendfor" default="所有人" />
									</td>
									<td>
										<s:property value="content" />
									</td>
									<td align="center">
										<a href="leaf!deltleaf.action?l.lid=${leaf.lid}"><img src="trash.gif"
												onclick="return ff();" border="0"></img> </a>
									</td>
								</tr>
							</s:iterator>
							<s:if test="p.maxPage>1">
								<tr>
									<td colspan="5">
										<a href="show.action?p.pageNum=1"> 首页</a>
										<s:if test="p.lastPage gt 0">
											<a href="show.action?p.pageNum=${p.lastPage}">上一页</a>
										</s:if>
										<s:if test="p.nextPage gt 0">
											<a href="show.action?p.pageNum=${p.nextPage}">下一页</a>
										</s:if>
										<a href="show.action?p.pageNum=${p.maxPage}">尾页</a>
									</td>
								</tr>
							</s:if>
						</s:else>
					</table>
					<p>
						&nbsp;
					</p>
				</td>
			</tr>
			<tr>
				<td>
					<p>
						&nbsp;
					</p>
				</td>
			</tr>
		</table>
	</body>
</html>

