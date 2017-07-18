<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="com.pathology.entity.Function"%>

 <%   
       List list = (List)request.getAttribute("functionList");
          if(list !=null){
         for(int i =0;i<list.size();i++){
          Function bean =(Function)list.get(i);
                %>
                <div name="leftmenu">
                 <h3><a href="${path}<%=bean.getUrl()%>" target="body"><%=bean.getName() %></a></h3>
                 </div>
                 <%
                }
            }
           %>
           
        
	
	
	
	<div name="leftmenu">
        <h3><a href="PathologyAction!getPathologyListToNeed">待诊断</a></h3>
    </div>
    <div name="leftmenu">
    	<h3><a href="PathologyAction!getPathologyListToHas">已诊断</a></h3>
    </div>
    <div name="leftmenu">
    	<h3><a href="PathologyAction!getPathologyListToBack">退回病例</a></h3>
    </div>
    <div name="leftmenu">
    	<h3><a href="CollectionAction!getCollectionList">收藏病例</a></h3>
    </div>
    <div name="leftmenu">
    	<h3><a href="MessageAction!getMessageList">留言列表</a></h3>
    </div>
    <div name="leftmenu">
    	<h3><a href="${path}/webdiagnosis/diagreport/diagreport_list.jsp">诊断报表</a></h3>
    </div>
    <div name="leftmenu">
    	<h3><a href="${path}/webdiagnosis/meeting/meeting_list.jsp">会议列表</a></h3>
    </div>
    <div name="leftmenu">
    	<h3><a href="ShareAction!getShareList">病例分享</a></h3>
    </div>
      <div name="leftmenu">
    	<h3><a href="${path}/manage/user/add_user.jsp">添加用户</a> </h3>
    </div>


