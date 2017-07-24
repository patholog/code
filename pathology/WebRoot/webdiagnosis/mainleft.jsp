<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="com.pathology.entity.Function"%>
<%@ page language="java" import="com.pathology.util.SessionAgentManager" %>

 <%   
       List list = (List)SessionAgentManager.getSessionAgentFunctionList("functionList");
          if(list !=null){
         for(int i =0;i<list.size();i++){
          Function bean =(Function)list.get(i);
                %>
                
                <li><a href="${path}/<%=bean.getUrl()%>"  target="_self" ><div class="icon_index_0"><i></i><%=bean.getName() %></div></a></li>
                
                 <%
                }
            }
           %>
           
        
	
	
	
