package com.pathology.action;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.pathology.entity.Users;
import com.pathology.service.IUsersService;
import com.pathology.util.DigestMD5;
import com.pathology.util.Mail;
import com.pathology.util.SessionAgentManager;

public class UsersAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Users u = new Users();
	public IUsersService userservice;

	private List<String> usernamelist = new ArrayList<String>();
	private String idUsers;
	private HttpServletRequest request;

	private Users user;
	private List<Users> list;
	private int index;

	private String photoFileName;
	private String photoType;
	private File photo;
	private String username;
	private String email;
	private Map<String, Object> result = new HashMap<String, Object>();

	public String login() {
		try {
			// String
			// hql=" and  s.username='"+user.getUsername()+"' and s.password='"+DigestMD5.getDigestPassWord(user.getPassword())+"'";
			String hql = " and  s.username='" + user.getUsername()
					+ "' and s.password='" + user.getPassword() + "'";
			List<Users> userT = userservice.getAllUser(Users.class, hql);
			if (userT != null && userT.size() == 1) {
				SessionAgentManager.setSessionAgentBean(user, "admin");
				return "loginSuccess";
			} else {
				return "false";
			}
		} catch (Exception e) {
			return "err";
		}
	}

	public String manageLogin() {
		try {
			// String
			// hql=" and  s.username='"+user.getUsername()+"' and s.password='"+DigestMD5.getDigestPassWord(user.getPassword())+"'";
			String hql = " and  s.username='" + user.getUsername()
					+ "' and s.password='" + user.getPassword() + "'";
			List<Users> userT = userservice.getAllUser(Users.class, hql);
			if (userT != null && userT.size() == 1) {
				SessionAgentManager.setSessionAgentBean(user, "admin");
				return "manageLoginSuccess";
			} else {
				return "false";
			}
		} catch (Exception e) {
			return "err";
		}
	}

	public String checkEmail() {
		try {
			String hql = " and s.email='" + user.getEmail() + "'";
			List<Users> userT = userservice.getAllUser(Users.class, hql);
			if (userT != null && userT.size() > 0) {
				return "false";
			} else {
				return SUCCESS;
			}
		} catch (Exception e) {
			return "err";
		}
	}

	public String userList() {
		try {
			String hql = "";
			if (user != null) {
				if (user.getUsername() != null && !("".equals(user.getUsername())))
					hql += " and username like '%" + user.getUsername() + "%'";
				if (user.getEmail() != null && !("".equals(user.getEmail())))
					hql += " and email like " + user.getEmail();
			}

			List<Users> list = index != 0 ? userservice.getByPage(index,
					Users.class, hql) : userservice.getByPage(1, Users.class,
					hql);

			HttpSession session = ServletActionContext.getRequest()
					.getSession();
			session.setAttribute("list", list);
			session.setAttribute("thisindex", index == 0 ? 1 : index);

			session.setAttribute("count",
					userservice.getAllUser(Users.class, hql).size());
			
			return SUCCESS;
		} catch (Exception e) {
			return "err";
		}
	}

	public String updateUser() throws IOException {
		try {
			HttpSession session = ServletActionContext.getRequest()
					.getSession();
			Users userT = userservice.getUser(Users.class, user.getIdUsers());
			session.setAttribute("user", userT);
			return "edit";
		} catch (Exception e) {
			return "err";
		}
	}

	public String checkUser() throws IOException {
		try {
			HttpSession session = ServletActionContext.getRequest()
					.getSession();
			Users userT = userservice.getUser(Users.class, user.getIdUsers());
			session.setAttribute("user", userT);
			return "check";
		} catch (Exception e) {
			return "err";
		}
	}

	public String deleteUser() {
		try {
			Users userT = userservice.getUser(Users.class, user.getIdUsers());
			userservice.deleteUser(userT);
			return "deletesuccess";
		} catch (Exception e) {
			return "err";
		}
	}

	public String saveUser() throws IOException {
		try {
			userservice.updateUser(user);
			return "updatesuccess";
		} catch (Exception e) {
			return "err";
		}
	}

	public String addUser() throws IOException {
		try {
			user.setIdUsers(getEandomId(16));
			user.setUserstatus("0");
			userservice.addUser(user);
			return "updatesuccess";
		} catch (Exception e) {
			return "err";
		}
	}

	public String registUser() throws IOException {
		
		
		try {
			user.setPassword(DigestMD5.getDigestPassWord(user.getPassword()));
			user.setDoctorctfsrc(upImg());
			user.setIdUsers(getEandomId(16));
			user.setUserstatus("0");
			userservice.addUser(user);

			return "registsuccess";
		} catch (Exception e) {
			return "err";
		}
	}

	// 图片上传
	public String upImg() {
		try {
			String img = null;
			if (photo != null) {
				String realpath = ServletActionContext.getServletContext()
						.getRealPath("upload/img/") + "\\";
				System.out.println("11111" + realpath);
				System.out.println(photoFileName);
				String type = photoFileName.substring(
						photoFileName.lastIndexOf(".") + 1,
						photoFileName.length());
				System.out.println("222" + type);
				String time = new SimpleDateFormat("yyMMddssSSS")
						.format(new Date());
				System.out.println(time);
				String name = time + "." + type;
				System.out.println(name);
				File saveFile = new File(realpath, name);
				if (saveFile.getParentFile().exists()) {
					saveFile.getParentFile().mkdirs();
				}
				try {
					FileUtils.copyFile(photo, saveFile);
				} catch (IOException e) {
					e.printStackTrace();
				}
				request = ServletActionContext.getRequest();
				String path = request.getContextPath();
				String basePath = request.getScheme() + "://"
						+ request.getServerName() + ":"
						+ request.getServerPort() + path + "/";
				String picturePath = basePath + "upload/img" + "/" + name;
				img = picturePath;
			}
			return img;
		} catch (Exception e) {
			return "err";
		}
	}

	public String checkUserStatus() {
		// send email demo by ldq
		Mail.setFrom("zhq567888@126.com");
		Mail.setHost("smtp.126.com");
		Mail.setName("病例平台管理员");
		Mail.setPassword("Founder123");
		Mail.setUser("zhq567888@126.com");
		String[] content = new String[] { "您好：", "恭喜您的账号已经审核通过", "感谢您的使用" };
		Mail.send("zou_haiqiang@founder.com.cn", "病例平台审核通过", content);
		// end demo

		try {
			Users userT = userservice.getUser(Users.class, user.getIdUsers());
			userT.setUserstatus("1");
			userservice.updateUser(userT);
			return "updatesuccess";
		} catch (Exception e) {
			return "err";
		}
	}

	public String refuseCheck() {
		Mail.setFrom("zhq567888@126.com");
		Mail.setHost("smtp.126.com");
		Mail.setName("病理平台管理员");
		Mail.setPassword("Founder123");
		Mail.setUser("zhq567888@126.com");
		String[] content = new String[] { "您好：", "恭喜您的账号没有审核通过", "请重新提交相关证件" };
		Mail.send("zou_haiqiang@founder.com.cn", "病理平台审核没通过", content);
		try {
			Users userT = userservice.getUser(Users.class, this.idUsers);
			userT.setUserstatus("2");
			userservice.updateUser(userT);
			return "updatesuccess";
		} catch (Exception e) {
			return "err";
		}
	}
	public void sendEmailForPassWord() {
		
		String randomStr=getStringRandom(6);
		
		String hql = " and  s.email='" + email + "'";
		List<Users> userT = userservice.getAllUser(Users.class, hql);
		
		if(userT.size()>0){
			Users[] userArr=(Users[]) userT.toArray();
			Users todoUser =userArr[0];
			todoUser.setVerification(randomStr);
			userservice.updateUser(todoUser);
			
			Mail.setFrom("zhq567888@126.com");
			Mail.setHost("smtp.126.com");
			Mail.setName("病理平台管理员");
			Mail.setPassword("Founder123");
			Mail.setUser("zhq567888@126.com");
			String[] content = new String[] { "您好：", "恭喜您的随机验证码是"+randomStr+",注意保存", "感谢您的使用" };
			Mail.send("zou_haiqiang@founder.com.cn", "您正在找回密码", content);
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
	public IUsersService getUserservice() {
		return userservice;
	}

	public void setUserservice(IUsersService userservice) {
		this.userservice = userservice;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Users getU() {
		return u;
	}

	public void setU(Users u) {
		this.u = u;
	}

	public List<String> getUsernamelist() {
		return usernamelist;
	}

	public void setUsernamelist(List<String> usernamelist) {
		this.usernamelist = usernamelist;
	}

	public String getIdUsers() {
		return idUsers;
	}

	public void setIdUsers(String idUsers) {
		this.idUsers = idUsers;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public String getPhotoFileName() {
		return photoFileName;
	}

	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}

	public String getPhotoType() {
		return photoType;
	}

	public void setPhotoType(String photoType) {
		this.photoType = photoType;
	}

	public File getPhoto() {
		return photo;
	}

	public void setPhoto(File photo) {
		this.photo = photo;
	}
	
	public Map<String, Object> getResult() {
		return result;
	}

	public void setResult(Map<String, Object> result) {
		this.result = result;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	// public IUsersService getUserserv() {
	// return userserv;
	// }
	//
	// public void setUserserv(IUsersService userserv) {
	// this.userserv = userserv;
	// }

}
