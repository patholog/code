package com.pathology.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.pathology.dao.IHospitalDao;
import com.pathology.dao.IRolesDao;
import com.pathology.dao.IUserDao;
import com.pathology.entity.Hospital;
import com.pathology.entity.Roles;
import com.pathology.entity.Users;
import com.pathology.service.IUsersService;

public class UsersServiceImpl implements IUsersService {

	private IUserDao userdao;
	private IRolesDao rolesdao;
	private IHospitalDao hospitaldao;
	private Map<String,Hospital> hospitalMap;

	public IUserDao getUserdao() {
		return userdao;
	}

	public void setUserdao(IUserDao udao) {
		this.userdao = udao;
	}


	public IRolesDao getRolesdao() {
		return rolesdao;
	}

	public void setRolesdao(IRolesDao rolesdao) {
		this.rolesdao = rolesdao;
	}

	public IHospitalDao getHospitaldao() {
		return hospitaldao;
	}

	public void setHospitaldao(IHospitalDao hospitaldao) {
		this.hospitaldao = hospitaldao;
	}

	public List<Users> getByPage(int index, Class clazz, String hql)  throws Exception{

		List<Object> list = userdao.getByPage(index, clazz, hql);
		return this.obj2Empl(list);
	}

	public List<Users> getAllUser(Class clazz, String hql) throws Exception {
		return this.obj2Empl(userdao.getAllUser(clazz, hql));
	}

	public void deleteUser(Users em) throws Exception {
		//		Users user = userdao.getUser(Users.class, em.getIdUsers());
		if(em!=null)
			userdao.deleteUser(em);

	}

	public Users getUser(Class clazz, String id) throws Exception {

		return userdao.getUser(clazz, id);
	}

	public void updateUser(Users em) {

		userdao.updateUser(em);

	}

	public void addUser(Users em) throws Exception {

		userdao.addUser(em);
	}

	public List<Users> obj2Empl(List<Object> list) {

		List<Users> elist = new ArrayList<Users>();
		for (Object obj : list) {

			Users em = (Users) obj;
			elist.add(em);
		}

		return elist;
	}

	@Override
	public Boolean findUser(String id) throws Exception{
		HttpSession session = ServletActionContext.getRequest()
				.getSession();
		Users userT = userdao.getUser(Users.class, id);

		List<Object> roleT = rolesdao.getAllRoles(Roles.class, "");
		List<Roles> rollist = new ArrayList<Roles>();

		for (Object obj : roleT) {

			Roles em = (Roles) obj;
			rollist.add(em);
		}
		session.setAttribute("rolelist",rollist);
		session.setAttribute("edituser", userT);
		if(session.getAttribute("allhaospitallist")==null){
			session.setAttribute("allhaospitallist", getAllHospitalList());
		}
		if(userT!=null && rollist.size()>0){
			return true;
		}
		return false;
	}

	@Override
	public List<Users> getUsersByPage(int index, Class clazz, String hql)
			throws Exception {
		List<Object> list = userdao.getByPage(index, clazz, hql);
		Map<String,Hospital> hospitalMap=getHospitalMap();
		for(Object obj:list){
			Users user=(Users)obj;
			if(!"".equals(user.getBelonghospital())&&user.getBelonghospital()!=null){
				String[] hosids=user.getBelonghospital().split(",");
				StringBuffer hosnames=new StringBuffer();
				for(String hosid:hosids){
					if(hospitalMap.containsKey(hosid)){
						hosnames.append(","+hospitalMap.get(hosid).getName());
					}
				}
				user.setBelonghospital(hosnames.toString().substring(1));
			}else{
				user.setBelonghospital("");
			}

		}
		return this.obj2Empl(list);
	}

	private Map<String,Hospital> getHospitalMap() throws Exception{
		if(hospitalMap==null){
			hospitalMap=new HashMap<String,Hospital>();
			List<Object> list = hospitaldao.getAllHospital(
					Hospital.class, "");
			if(list.size()==0)return null;
			for(Object obj:list){
				Hospital hos=(Hospital)obj;
				hospitalMap.put(hos.getIdHospital(), hos);
			}
		}
		return hospitalMap;
	}

	private List<Hospital> getAllHospitalList() throws Exception {
		HttpSession session = ServletActionContext.getRequest()
				.getSession();
		List<Object> list = hospitaldao.getAllHospital(
				Hospital.class, "");
		List<Hospital> hospitallist=new ArrayList();
		for(Object obj:list){
			Hospital hos=(Hospital)obj;
			hospitallist.add(hos);
		}
		return hospitallist;
	}
}
