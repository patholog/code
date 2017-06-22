<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
	
	<div name="leftmenu" id="usermanagement">
        <h3>用户管理</h3>
        <ul>
          <li><a href="${path}/manage/user/add_user.jsp">添加用户</a> </li>
          <li><a href="UserAction!userList">用户管理</a> </li>
        </ul>
      </div>
      
      <!-- 1 id="categorymenu" -->
      
      <div name="leftmenu" id="categorymenu">
        <h3>医疗机构</h3>
        <ul>
          <li><a href="${path}/manage/hospital/add_hospital.jsp">添加医疗机构</a> </li>
          <li><a href="HospitalAction!hospitalList">管理医疗机构</a> </li>
        </ul>
      </div>
      <script>
				leftMenuTreeView();
			</script>

