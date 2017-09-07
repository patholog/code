<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="com.pathology.entity.Function"%>
<%@ page language="java" import="com.pathology.util.SessionAgentManager"%>


<ul id="Left1_MenuList">
 <%   
       List list = (List)SessionAgentManager.getSessionAgentFunctionList("functionList");
          if(list !=null){
         for(int i =0;i<list.size();i++){
          Function bean =(Function)list.get(i);
                %>
                
                <li><a href="${path}/<%=bean.getUrl()%>"  target="_self" ><div><i></i><%=bean.getName() %></div></a></li>
                
                 <%
                }
            }
           %>
</ul>
<script type="text/javascript">
$(document).ready(function(){
	$("#Left1_MenuList a").each(function() {
		if (window.location.pathname.indexOf($(this).attr('href'))>=0) {
			$(this).find('div').attr("id",'li_selected');
		}
	});
});
</script>





