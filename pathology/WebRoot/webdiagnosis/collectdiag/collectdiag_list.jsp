<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<title>病理远程会诊平台-收藏病例</title>
<c:set var="path" value="${pageContext.request.contextPath }" />
<link rel="stylesheet" type="text/css" href="${path }/css/comc_diagnosis_wait_style.css"/>
<link rel="stylesheet" type="text/css" href="${path }/css/comc_head_style.css"/>
<link rel="stylesheet" type="text/css" href="${path }/css/comc_left_nav_style.css"/>
<link rel="stylesheet" type="text/css" href="${path }/css/comc_page_style.css"/>
<link rel="stylesheet" type="text/css" href="${path }/css/datepicker.css"/>
<link rel="stylesheet" type="text/css" href="${path }/css/public_flat.css"/>
<link rel="stylesheet" type="text/css" href="${path }/css/theme.css"/>
<link rel="stylesheet" type="text/css" href="${path }/css/WdatePicker.css"/>
<link rel="stylesheet" type="text/css" href="${path }/css/weebox.css"/>
<script type="text/javascript" src="${path }/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript"
	src="${path }/CKEditor/ckeditor/ckeditor.js"></script>
<script type="text/javascript"
	src="${path }/CKFinder/ckfinder/ckfinder.js"></script>
<script type="text/javascript" src="${path }/js/treeView.js"></script>
<script type="text/javascript" src="${path }/js/common-cn.js"></script>
<script type="text/javascript" src="${path }/js/forbid-refresh.js"></script>
<script type="text/javascript">
	
    function cancelCase(id) {

        $.ajax({
            url:'CollectionAction!deleteCollection?collectionId='+id,
            type:'post',
            data:{},
            dataType:'text',
            success:function (data) {
                self.location.reload();
            },
            error:function (data) {
                self.location.reload();
            }})

    }
</script>
</head>

<body>
   <form action="CollectionAction!getCollectionList?parameter=1" id="listMemberForm" method="post">
	<div class="header">
		<%@include file="/webdiagnosis/maintop.jsp"%>
	</div>
	<div class="menu_left">
		<ul id="Left1_MenuList">
		<%@include file="/webdiagnosis/mainleft.jsp" %>
		</ul>
	</div>

	<div class="content_right">
		<div class="index_right" style="min-height: 494px;">
			  <div class="index_search">
				  <form action="CollectionAction!getCollectionList" id="colSearch" method="post">
						<ul>
							<li class="title_li"><div class="title" id="title" style="display: none;">待诊断</div></li>        			
							<li>申请时间：从<input name="colfromdate" type="date" id="colfromdate" class="time_s" style="width:140px;">到
										<input name="coltodate" type="date" id="coltodate" class="time_s" style="width:140px;"></li>
							<li>病人姓名：
				                <input name="colpat" type="text" id="colpat" class="keyword" >
							</li>
							<li>送检单位：
				                <input name="colhospital" type="text" id="colhospital" class="keyword" >
							</li>
							<li>
				                <input type="submit" name="btnSearch" value="搜索" id="btnSearch" class="index_search_btn">
				            </li>
						</ul>
				        <div class="clear"></div>
				   </form>
				</div>
			<div class="index_diagnosis_table">
                 <div class="diagnosis_table">
                        <table class="table">
					<tbody>
						<tr>
				          <th width="10%">病理号</th>
				          <th width="10%">病人姓名</th>
				          <th width="10%">材料部位</th>
				          <th width="10%">病例状态</th>
				          <th width="10%">系统分类</th>
				          <th width="15%">送检单位</th>
				          <th width="10%">申请时间</th>
				          <th width="10%">诊断时间</th>
				          <th width="15%">操作</th>
				             
						</tr>
						         <s:iterator value="collections" id="collection" status="11">
						         <tr>
						         <td><s:property value="#collection.pathologyNo"/><input type="hidden" value="#collection.collectionId"></td>
						         <td><s:property value="#collection.patientname"/></td>
						         <td><s:property value="#collection.pathologyNo"/></td>
						         <td><s:property value="#collection.patientname"/></td>
						         <td><s:property value="#collection.username"/></td>
						         <td><s:property value="#collection.hospitalname"/></td>
						         <td><s:property value="#collection.createTime"/></td>
						         <td><s:property value="#collection.diagtime"/></td>
						          <td align="center"><a href="#"  onclick="cancelCase('${collection.collectionId }')">取消收藏</a>
						          &nbsp; | &nbsp;	<a href="PathologyAction!getPathologyDto?id=${collection.caseId}" target="_blank">查看</a></td>
						          </td>
						        </tr>
						        </s:iterator>

						<tr class="lightrow">
							<td colspan="9"><div id="pageDir">
								
  <%=request.getAttribute("page")!=null?request.getAttribute("page"):"" %>
								</div></td>
						</tr>

					</tbody>
				</table>
                  </div>
			  </div>
			</div>
		</div>
 </form>
</body>
</html>