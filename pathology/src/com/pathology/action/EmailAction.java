package com.pathology.action;

import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.Action;
import com.pathology.entity.Hospital;
import com.pathology.entity.Users;
import com.pathology.service.IHospitalService;
import com.pathology.service.IUsersService;
import com.pathology.util.Mail;

public class EmailAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	private final Logger logger = Logger.getLogger(EmailAction.class);
	private Map<String, String> p;

	public IUsersService userservice;
	private IHospitalService hospitalservice;
	

	public void setP(Map<String, String> p) {
		this.p = p;
	}

	public String checkEmail() {
		String email = this.p.get("email");
		String hql=" and s.email='"+email+"'";
		List<Users> userT;
		try {
			userT = userservice.getAllUser(Users.class, hql);
			if (userT!=null && userT.size()>0) {
				return Action.ERROR;
			} else {
				return Action.SUCCESS;
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			return Action.ERROR;
		}

	}

	public String checkUserName(){
		String name = this.p.get("username");
		String hql=" and s.username='"+name+"'";
		List<Users> userT;
		try {
			userT = userservice.getAllUser(Users.class, hql);
			if (userT!=null && userT.size()>0) {
				return Action.ERROR;
			} else {
				return Action.SUCCESS;
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			return Action.ERROR;
		}
	}
	public String checkCode(){
		String code = this.p.get("hoscode");
		String hql=" and s.hospitalcode='"+code+"'";
		List<Hospital> hosT;
		try {
			hosT = hospitalservice.getAllHospital(Hospital.class, hql);
			if (hosT!=null && hosT.size()>0) {
				return Action.ERROR;
			} else {
				return Action.SUCCESS;
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			return Action.ERROR;
		}

	}
	public String checkVerification(){
		String verification = this.p.get("verification");
		String email = this.p.get("email");
		String hql=" and s.email='"+email+"'";
		List<Users> userT;
		try {
			userT = userservice.getAllUser(Users.class, hql);
			if (userT!=null && userT.size()>0) {
				Users[] userArr=(Users[]) userT.toArray(new Users[0]);
				Users todoUser =userArr[0];
				if(todoUser.getVerification().equals(verification)){
					return Action.SUCCESS;
				}else{
					return Action.ERROR;
				}
			} else {
				return Action.ERROR;
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			return Action.ERROR;
		}
		
	}
	public String sendEmailForPassWord() {
		
		String randomStr=getStringRandom(6);
		String email = this.p.get("getemail");
		String hql = " and  s.email='" + email + "'";
		List<Users> userT;
		try {
			userT = userservice.getAllUser(Users.class, hql);
			if(userT.size()>0){
				
				Users[] userArr=(Users[]) userT.toArray(new Users[0]);
				Users todoUser =userArr[0];
				todoUser.setVerification(randomStr);
				userservice.updateUser(todoUser);
				
				Mail.setFrom("zhq567888@126.com");
				Mail.setHost("smtp.126.com");
				Mail.setName("病理平台管理员");
				Mail.setPassword("Founder123");
				Mail.setUser("zhq567888@126.com");
				String[] content = new String[] { "    您好：", "    恭喜您的随机验证码是"+randomStr+",注意保存", "         感谢您的使用" };
				Mail.send("zou_haiqiang@founder.com.cn", "您正在找回密码", content);
				return Action.SUCCESS;
			}else{
				return Action.ERROR;
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			return Action.ERROR;
		}
	}
	//生成随机数字和字母,  
    public String getStringRandom(int length) {  
          
        String val = "";  
        Random random = new Random();  
          
        //参数length，表示生成几位随机数  
        for(int i = 0; i < length; i++) {  
              
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";  
            //输出字母还是数字  
            if( "char".equalsIgnoreCase(charOrNum) ) {  
                //输出是大写字母还是小写字母  
                int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;  
                val += (char)(random.nextInt(26) + temp);  
            } else if( "num".equalsIgnoreCase(charOrNum) ) {  
                val += String.valueOf(random.nextInt(10));  
            }  
        }  
        return val;  
    }  


	public void setUserservice(IUsersService userservice) {
		this.userservice = userservice;
	}


	public void setHospitalservice(IHospitalService hospitalservice) {
		this.hospitalservice = hospitalservice;
	}
	


}
