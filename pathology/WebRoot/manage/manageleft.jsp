<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
	
	<div name="leftmenu" id="usermanagement">
        <h3>用户管理</h3>
        <ul>
          <li><a href="${path}/manage/user/add_user.jsp">添加用户</a> </li>
          <li><a href="UserAction!userList">用户管理</a> </li>
        </ul>
      </div>
      
      <!-- 1 id="categorymenu" -->
      
      <div name="leftmenu" id="hospitalmenu">
        <h3>医疗机构</h3>
        <ul>
          <li><a href="${path}/manage/hospital/add_hospital.jsp">添加医疗机构</a> </li>
          <li><a href="HospitalAction!hospitalList">管理医疗机构</a> </li>
        </ul>
      </div>
            <div name="leftmenu" id="funcmenu">
        <h3>功能</h3>
        <ul>
          <li><a href="${path}/manage/function/add_function.jsp">添加功能</a> </li>
          <li><a href="FunctionAction!functionList">管理功能</a> </li>
        </ul>
      </div>
            <div name="leftmenu" id="rolemenu">
        <h3>角色</h3>
        <ul>
          <li><a href="FunctionAction!allFunction">添加角色</a> </li>
          <li><a href="RolesAction!rolesList">管理角色</a> </li>
        </ul>
      </div>
            <div name="leftmenu" id="powermenu">
        <h3>权限</h3>
        <ul>
          <li><a href="${path}/manage/hospital/add_hospital.jsp">添加权限</a> </li>
          <li><a href="HospitalAction!hospitalList">管理权限</a> </li>
        </ul>
      </div>
                  <div name="leftmenu" id="powermenu">
        <h3>操作</h3>
		<ul>
          <li><a href="${path}/webdiagnosis/hasdiag/hasdiag_list.jsp">返回已诊断</a> </li>
        </ul>
      </div>
      <script>
				leftMenuTreeView();
			</script>

