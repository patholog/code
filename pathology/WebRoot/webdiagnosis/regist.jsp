<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
  <title>病理远程会诊平台-用户注册</title>
  <c:set var="path" value="${pageContext.request.contextPath }" />
  <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
  <meta http-equiv="description" content="this is my page">
  <meta http-equiv="content-type" content="text/html; charset=UTF-8">
  <LINK rel="Shortcut icon" href="favicon.ico" />
  <link rel="stylesheet" type="text/css" href="${path }/css/settings.css" />
  <link rel="stylesheet" type="text/css" href="${path }/css/select.css" />
  <link rel="stylesheet" type="text/css" href="${path }/assets/jqueryui/jquery-ui.min.css"/>
  <link rel="stylesheet" type="text/css" href="${path }/assets/jqueryui/jquery-ui.theme.min.css"/>
  <script type="text/javascript" src="${path }/js/jquery-1.9.0.min.js"></script>
  <script type="text/javascript" src="${path }/js/jquery.form.min.js"></script>
  <script type="text/javascript" src="${path }/assets/jqueryui/jquery-ui.min.js"></script>
  <script src="${path }/js/regist.js" type="text/javascript"></script>
  <script type="text/javascript" src="${path }/js/passwordcheck.js"></script>
</head>
<body>
	<div id="3" style="position: relative;  z-index: 3;">
		<form id="f1" action="UserAction!registUser" method="post"
			enctype="multipart/form-data" onsubmit="return CheckU()">
			<table align="center" cellspacing="0" class="registtb">
				<tr class="thead">
					<td align="center">用户注册</td>
				</tr>
				<tr>
					<td>
						<table id="registertable" border="0px" align="center" border="0px"
							cellspacing="0" cellpadding="5px">
							<tr>
							<tr>
								<td align="right">用户名：</td>
								<td align="left"><input id="username" type="text"
									name="user.username" placeholder="用户名" required /> <input
									id="belonghospital" type="hidden" name="user.belonghospital" />
									<span id="nametip"></span>
								</td>
							</tr>
							<tr>
								<td align="right">密 码：</td>
								<td align="left"><input type="password"
									name="user.password" id="password" placeholder="密码" required
									onKeyUp=pwStrength(this.value) onBlur=pwStrength(this.value) />
									<span id="pwsdtip"> 
									<div id="strength_H" class="pwdcheck"></div>
									<div id="strength_M" class="pwdcheck"></div>
									<div id="strength_L" class="pwdcheck"></div></span>
								</td>
							</tr>

							<tr>
								<td align="right">密码确认：</td>
								<td align="left"><input type="password" name="password2"
									placeholder="确认密码" id="password2" required /><span
									id="pwsd2tip">
									</span>
								</td>
							</tr>
							<tr>
								<td align="right">邮 箱：</td>
								<td align="left"><input type="email" name="user.email"
									placeholder="邮箱" id="email" required /><span id="emailtip"></span>
								</td>
							</tr>
							<tr>
								<td align="right">手机号码：</td>
								<td align="left"><input type="text" name="user.tel"
									placeholder="手机号码" id="tel" required /><span id="teltip"></span>
								</td>
							</tr>
							<tr>
								<td align="right">真实姓名：</td>
								<td align="left"><input type="text" name="user.realname"
									placeholder="真实姓名" id="realname" required /><span id="realnametip"></span>
								</td>
							</tr>
							<tr>
								<td align="right">医院：</td>
								
									<td align="left"><input type="text" name="user.registhospital"
										placeholder="医院" id="registhospital" required /><span id="registhospitaltip"></span></span>
									</td>
									
								
							</tr>
							<tr>
								<td align="right">特长：</td>
								<td align="left"><input id="specialty" type="text"
									name="user.specialty" placeholder="特长" /> 
									<span id="specialtytip"></span>
								</td>
							</tr>
							<tr>
								<td align="right">医师资格证：</td>
								<td align="left"><input name="photo" class="file"
									type="file" id="f" accept="image/jpeg" onchange="show()"
									required /></td>
							<tr>
								<td></td>
								<td align="left"><span><img id="img" src=""
										width="200" height="200" /> </span>
								</td>
							</tr>
							<tr>
								<td colspan="2"></td>
							</tr>

							<tr height="60px">
								<td align="center"><input type="button" value="已有账号"
									id="back" onmousemove="changeBgColor('back')"
									onmouseout="recoverBgColor('back');" class="submit"
									onclick="javascrtpt:window.location.href='${path }/login.jsp'" />
								</td>
								<td align="center"><input type="submit" accesskey="enter"
									value="注册" id="btn" onmousemove="changeBgColor('btn')"
									onmouseout="recoverBgColor('btn');" class="submit"
									formmethod="post" />
								</td>

							</tr>
						</table>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<%@include file="loginbox.jsp"%>
</body>
<div id="tips">
  <label id="tipInfo"></label>
</div>
<script>
  var emailfg=false;
  var namefg=false;
  var pswdfg=false;
  var pswd2fg=false;
  var hosfg=false;
  var spefg=true;
  var realfg=false;
  var telfg=false;
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
  $(function() {


    $("#email").blur(function() {
      var email = $("#email").val().trim();
      if (email == '') {
        $("#emailtip").html("<a style='color:#2ca9cc;font-size:14px;'>邮箱不能为空！</a>");
        //$("#btn").attr("disabled",true);
        emailfg=false;
        return false;
      } else {
        //login1为Action类命名空间名称；AjaxExecute为Action方法名称
        $.ajax({
          type : "post",
          url : 'email_checkEmail',
          contentType : "application/json; charset=utf-8",
          data : JSON.stringify({//设置数据源
            p : {
              email : email
            }
          }),
          dataType : "json",//设置需要返回的数据类型
          success : function(d) {
            $("#emailtip").html("");
            //$("#btn").attr("disabled",false);
            emailfg=true;
          },
          error : function(d) {
            $("#emailtip").html("<a style='color:#2ca9cc;font-size:14px;'>邮箱已注册!</a>");
            //$("#btn").attr("disabled",true);
            emailfg=false;
          }
        });
      }

    });


    $("#username").blur(function() {
      var username = $("#username").val().trim();
      if (username == '') {
        $("#nametip").html("<a style='color:#2ca9cc;font-size:14px;'>用户名不能为空！</a>");
        //$("#btn").attr("disabled",true);
        namefg=false;
        return false;
      }else if(username.length<6){
        $("#nametip").html("<a style='color:#2ca9cc;font-size:14px;'>用户名不能少于6位！</a>");
        //$("#btn").attr("disabled",true);
        namefg=false;
        return false;
      }else if(username.length>20){
        $("#nametip").html("<a style='color:#2ca9cc;font-size:14px;'>用户名不能超过20位！</a>");
        //$("#btn").attr("disabled",true);
        namefg=false;
        return false;
      }
      else {

        var zmnumReg=/^[0-9a-zA-Z]*$/;
        if(username!=""&&!zmnumReg.test(username)){
          $("#nametip").html("<a style='color:#2ca9cc;font-size:14px;'>只能输入字母或数字!</a>");
          $("#username").val("");
          //$("#btn").attr("disabled",true);
          namefg=false;
          return false;
        }else{
          //login1为Action类命名空间名称；AjaxExecute为Action方法名称
          $.ajax({
            type : "post",
            url : 'email_checkUserName',
            contentType : "application/json; charset=utf-8",
            data : JSON.stringify({//设置数据源
              p : {
                username : username
              }
            }),
            dataType : "json",//设置需要返回的数据类型
            success : function(d) {
              $("#nametip").html("");
              //$("#btn").attr("disabled",false);
              namefg=true;
            },
            error : function(d) {
              $("#nametip").html("<a style='color:#2ca9cc;font-size:14px;'>用户名已注册!</a>");
              //$("#btn").attr("disabled",true);
              namefg=false;
            }
          });
        }

      }

    });

    $("#password2").blur(function() {
      var pswd = $("#password").val().trim();
      var pswd2 = $("#password2").val().trim();
      if(pswd==pswd2){
        $("#pwsd2tip").html("");
        //$("#btn").attr("disabled",false);
        pswd2fg=true;
        return true;
      }else{
        $("#pwsd2tip").html("<a style='color:#2ca9cc;font-size:14px;'>两次密码输入不一致!</a>");
        //$("#btn").attr("disabled",true);
        pswd2fg=false;
        return false;
      }
    });
    $("#password").bind('input propertychange',function() {
      var pswd = $("#password").val().trim();
      if(pswd==''){
        $("#pwsdtip").html("<a style='color:#2ca9cc;font-size:14px;'>密码不能为空！</a>");
        //$("#btn").attr("disabled",true);
        pswdfg=false;
        return false;
      }
      else if(pswd.length<6){
        $("#pwsdtip").html("<a style='color:#2ca9cc;font-size:14px;'>密码不能少于6位！</a>");
        //$("#btn").attr("disabled",true);
        pswdfg=false;
        return false;
      }else if(username.length>16){
        $("#nametip").html("<a style='color:#2ca9cc;font-size:14px;'>用户名不能超过16位！</a>");
        //$("#btn").attr("disabled",true);
        pswdfg=false;
        return false;
      }else{
        $("#pwsdtip").html("<div id='strength_H' class='pwdcheck'></div><div id='strength_M' class='pwdcheck'></div><div id='strength_L' class='pwdcheck'></div>");
        //$("#btn").attr("disabled",false);
        pswdfg=true;
        return true;
      }
    });
    $("#specialty").blur(function() {
      var spe = $("#specialty").val().trim();
      if(spe.length>200){
        $("#specialtytip").html("<a style='color:#2ca9cc;font-size:14px;'>录入超长!</a>");
        //$("#btn").attr("disabled",true);
        spefg=false;
        return false;
      }else{
        $("#specialtytip").html("");
        //$("#btn").attr("disabled",false);
        spefg=true;
        return true;
      }
    });
      $("#registhospital").blur(function() {
      var registhospital = $("#registhospital").val().trim();
      if(registhospital==''){
        $("#registhospitaltip").html("<a style='color:#2ca9cc;font-size:14px;'>医院不能为空！</a>");
        //$("#btn").attr("disabled",true);
        hosfg=false;
        return false;
      }else if(registhospital.length>200){
        $("#registhospitaltip").html("<a style='color:#2ca9cc;font-size:14px;'>录入超长!</a>");
        //$("#btn").attr("disabled",true);
        hosfg=false;
        return false;
      }else{
        $("#registhospitaltip").html("");
        //$("#btn").attr("disabled",false);
        hosfg=true;
        return true;
      }
    });
 $("#realname").blur(function() {
      var realname = $("#realname").val().trim();
      if (realname == '') {
        $("#realnametip").html("<a style='color:#2ca9cc;font-size:14px;'>真实姓名不能为空！</a>");
        //$("#btn").attr("disabled",true);
        realfg=false;
        return false;
      }else if(realname.length>50){
        $("#realnametip").html("<a style='color:#2ca9cc;font-size:14px;'>真实姓名超长</a>");
        //$("#btn").attr("disabled",true);
        realfg=false;
        return false;
      }else{
        $("#realnametip").html("");
        //$("#btn").attr("disabled",false);
        realfg=true;
        return true;
      }

    });
    $("#tel").blur(function() {
      var tel = $("#tel").val().trim();
      var istel=/^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/; 
      if (tel == '') {
        $("#teltip").html("<a style='color:#2ca9cc;font-size:14px;'>手机号码不能为空！</a>");
        //$("#btn").attr("disabled",true);
        telfg=false;
        return false;
      }else if(!istel.test(tel)){
        $("#teltip").html("<a style='color:#2ca9cc;font-size:14px;'>请输入正确的手机号码</a>");
        //$("#btn").attr("disabled",true);
        telfg=false;
        return false;
      }else{
        $("#teltip").html("");
        //$("#btn").attr("disabled",false);
        telfg=true;
        return true;
      }

    });

  });

  function CheckU() {
    if(emailfg && namefg && pswdfg && pswd2fg && spefg && telfg){
      if(confirm('提交当前信息吗？')){
        
        return true;
      }else{
        return false;
      }
    }else{
      showTips("请修正错误信息！");
      return false;
    }
  }
</script>
</html>
