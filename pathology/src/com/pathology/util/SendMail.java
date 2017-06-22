package com.pathology.util;

public class SendMail {
	/*private static final String mailUserName = Property.getProperty("mailUserName");
	private static final String mailPassWord = Property.getProperty("mailPassWord");
	private static final String mailAdd = Property.getProperty("mailAdd");
	private static final String mailServerHost = Property.getProperty("mailServerHost");
	private static final String mailServerPort = Property.getProperty("mailServerPort");
	
	public static String modifyPwdNotice(String email,String username, String newPwd){
		
		// TODO Auto-generated method stub
		//这个类主要是设置邮件　　 
		MailSenderInfo mailInfo = new MailSenderInfo();
		  //mailInfo.setMailServerHost("smtp.163.com");  
	      mailInfo.setMailServerHost(mailServerHost);  
		  //mailInfo.setMailServerPort("25");  
	      mailInfo.setMailServerPort(mailServerPort); //587
	      mailInfo.setValidate(true);  
		  
		  mailInfo.setUserName(mailUserName);  
		  mailInfo.setPassword(mailPassWord);//您的邮箱密码  
		  mailInfo.setFromAddress(mailAdd); 
		  mailInfo.setToAddress(email); 
		  mailInfo.setSubject("修改密码邮件"); 
		  StringBuffer meassage =new StringBuffer("<meta http-equiv=Content-Type content=text/html; charset=gb2312>")
		  .append("<div align=left>尊敬的身心康中医在线用户："+username+"</div>")
		  .append("<div align=left>您在身心康用户名为           的用户密码已经修改，新密码是："+newPwd+"</div>")
		  .append("<div align=left>该密码是您登录“身心康中医在线”的唯一通行证，为了您能顺利享受我们的各种服务，请务必妥善保管。</div>")
		  .append("<div align=left>一个安全的密码长度应在10位以上，为数字、字母以及半角符号的混合体，密码应该定期更改</div>")
		  .append("<div align=left>如有问题，请发送邮件至         ，或致电010-82029789   ，我们将耐心为您解答。</div>")
		  .append("<div align=left>尊敬的身心康中医在线用户：</div>")
		  .append("<div align=left>祝您健康快乐</div>")
		  .append("<div align=\"right\"> 身心康中医在线</div>")
		  .append("<div align=\"right\">"+DateUtil.getDate()+"</div>");
		  mailInfo.setContent(meassage.toString()); 
		  //这个类主要来发送邮件　　 
		  SimpleMailSender sms = new SimpleMailSender();
		  //sms.sendTextMail(mailInfo);//发送文体格式  
		  boolean result = sms.sendHtmlMail(mailInfo);//发送html格式
		if(result){
			return "success";
		}else{
			return "";
		}
	}*/
}
