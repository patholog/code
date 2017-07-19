<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="com.pathology.entity.Function"%>

 <%   
       List list = (List)request.getAttribute("functionList");
          if(list !=null){
         for(int i =0;i<list.size();i++){
          Function bean =(Function)list.get(i);
                %>
                <div name="leftmenu">
                 <h3><a href="${path}/<%=bean.getUrl()%>"><%=bean.getName() %></a></h3>
                 </div>
                 <%
                }
            }
           %>
           
        
	
	
	
