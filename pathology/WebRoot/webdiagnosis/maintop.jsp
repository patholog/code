<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="com.pathology.entity.Users"%>
<%@ page language="java" import="com.pathology.util.SessionAgentManager" %>
<%String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";%>
<div class="top-thickline"><img src="${path}/css/img-blue/spacer.gif" width="5" height="5" /></div>
	<ul>
		<!--  <li style="float:right;"><input type="button" value ="退出" onclick ="logout()"/></li>-->
		    <%
       if(SessionAgentManager.getSessionAgentBean()==null){
              %>
  <script type="text/javascript">
	    	var url = '<%=basePath%>';
	    	  alert('session 过期请登陆');
	    	  window.parent.location=url+"login.jsp";
		      </script>
      <%
         }
         Users user=SessionAgentManager.getSessionAgentBean();
         String username=user==null?"":user.getUsername() +" " +user.getRoleName();
        
         %>
		<!--<li style="float:right;"> <%= username%></li> -->
 
		<li style="margin-left:15px;" id="mytimer"></li>
      <script>Time();</script>
    </ul>





	<div class="nav mlrAuto">
		<div class="logo left">
			<a href="" id="t_left">数字病理会诊平台</a>
			
			<div class="clear"></div>
		</div>
		<div class="user_msg right">
			<div class="msg_box right">
			<span class="t_left"><a onclick="logout();" href="javascript:void(0)"><font color="#FFFFF4">退出</font></a></span>
				<div class="user_box right">
					<span>
                        <span id="Head_lblUserName"><%= username%></span>
                    </span>
                  &nbsp;&nbsp;<!--▼  -->  
				</div>
                <span class="t_left">欢迎您！</span>
                
                <div class="user_box_index undis" id="user_in">
					<center>
						<span>▲</span>
						<div class="user_inbox">
							<ul>
								<li class="noborder">
									<a onclick="logout();" href="javascript:void(0)">退出登录</a>
								</li>
							</ul>
						</div>
					</center>
				</div>
			</div>
			<div class="clear"></div>
		</div>
		<div class="clear"></div>
	</div>








	
 <body>
  <form action="loginout" method ="post" id ="logoutFrom">
  </form>
 </body>
   <script type="text/javascript">
		function logout(){
		    confirm("退出");
		    document.getElementById("logoutFrom").submit();
		     var url = '<%=basePath%>';
		        
			return true;
		      }
	</script>

<div id="tips">
  <label id="tipInfo"></label>
</div>
<script>
  function showTips(text) {
    $('#tipInfo').text(text);
    $('#tips').dialog({
      title: '提示',
      modal: true,
      width: '400',
      height: '200',
      buttons: [{
        text: "确定",
        icon: "ui-icon-heart",
        click: function () {
          $(this).dialog("close");
        }
      }]
    });
  }
</script>