<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>  
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>  
  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
  <head>  
    <base href="<%=basePath%>">  
      
    <title>My JSP 'login.jsp' starting page</title>  
      
    <meta http-equiv="pragma" content="no-cache">  
    <meta http-equiv="cache-control" content="no-cache">  
    <meta http-equiv="expires" content="0">      
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">  
    <meta http-equiv="description" content="This is my page">  
    <!--  
    <link rel="stylesheet" type="text/css" href="styles.css">  
    -->  
  <link rel="stylesheet" type="text/css" href="css/settings.css" />
  </head>  
  <%  
    String incode = (String)request.getParameter("code");   
    String rightcode = (String)session.getAttribute("rCode");   
      
    if(incode != null && rightcode != null){  
        if(incode.equals(rightcode)){  
            out.println("验证码输入正确！");  
        }else{  
            out.println("验证码输入不正确，请重新输入！");  
        }  
    }  
  %>  
    
  <body>  


<div id="3" style="position: relative; top: 100px; z-index: 3;">
  <table align="center" cellspacing="0" class="table">
    <tr class="thead">
      <td align="left" colspan="9" ><div class="tabletitle"> 用户信息</div></td>
    </tr>
    <tr>
      <td colspan="9"><table id="registertable" border="0px" align="center" border="0px" cellspacing="0" cellpadding="5px">
    <tr>
    
    <tr height="50px;" style="border-bottom:1px solid #39F;">
      <td width="10px;"></td>
      <td align="left" colspan="8" style="font-size:18px;"> 基本信息</td>
    </tr>
    <tr height="50px;">
      <td width="10px;"></td>
      <td width="80px" align="left">用户名：</td>
      <td width="200px" align="left"><input type="text" name="username"></td>
      <td width="80px" align="left">真实姓名：</td>
      <td width="200px" align="left"><input type="text" name="realname"></td>
      <td width="80px" align="left">性别：</td>
      <td width="100px" align="left"><select name="sex" >
          <option value="男" >男</option>
          <option  value="女" > 女</option>
        </select></td>
      <td width="80px" align="left">出生年月：</td>
      <td width="200px" align="left"><input type="date" name="birthday"></td>
    </tr>
    <tr height="50px;">
      <td width="10px;"></td>
      <td align="left">密码：</td>
      <td align="left"><input type="password" name="password"></td>
      <td width="80px" align="left">所属医院：</td>
      <td width="200px" align="left"><input type="text" name="belonghospital"></td>
      <td width="80px" align="left">特长：</td>
      <td align="left"><input type="text" name=""></td>
      <td align="left" colspan="6" ></td>
    </tr>
    <tr height="50px;" style="border-bottom:1px solid #39F;">
      <td width="10px;"></td>
      <td align="left" colspan="8" style="font-size:18px;"> 联系方式</td>
    </tr>
    <tr height="50px;">
      <td width="10px;"></td>
      <td align="left">手机号码：</td>
      <td width="200px" align="left"><input type="text" name="mobile"></td>
      <td align="left">电话号码：</td>
      <td width="200px" align="left"><input type="text" name="tel"></td>
      <td align="left">电子邮箱：</td>
      <td width="400px" align="left" colspan="3"><input type="text" name="email"></td>
    </tr>
    <tr>
    <td colspan="9" align="center"><input type="submit" class="submit" value="保存"></td>
    </tr>
  </table>
</div>

  
  </body>  
</html>  