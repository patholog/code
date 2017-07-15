package com.pathology.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.pathology.dao.IRoleFunctionDao;
import com.pathology.entity.RoleFunction;
import com.pathology.service.IRoleFunctionService;

public class RoleFunctionServiceImpl implements IRoleFunctionService {

	private IRoleFunctionDao rolefunctiondao;
	
	public IRoleFunctionDao getFunctiondao() {
		return rolefunctiondao;
	}

	public void setRoleFunctiondao(IRoleFunctionDao hospitaldao) {
		this.rolefunctiondao = hospitaldao;
	}

	public List<RoleFunction> getByPage(int index, Class clazz, String hql)  throws Exception{

		List<Object> list = rolefunctiondao.getByPage(index, clazz, hql);
		return this.obj2Empl(list);
	}

	public List<RoleFunction> getAllRoleFunction(Class clazz, String hql) throws Exception {
		return this.obj2Empl(rolefunctiondao.getAllRoleFunction(clazz, hql));
	}

	public void deleteRoleFunction(RoleFunction em) throws Exception {
//		Hospital Hospital = hospitaldao.getHospital(Hospital.class, em.getIdHospitals());
		if(em!=null)
			rolefunctiondao.deleteRoleFunction(em);

	}

	public RoleFunction getRoleFunction(Class clazz, String id) throws Exception {
		
		return rolefunctiondao.getRoleFunction(clazz, id);
	}

	public void updateRoleFunction(RoleFunction em) throws Exception {

		rolefunctiondao.updateRoleFunction(em);

	}

	public void addRoleFunction(RoleFunction em) throws Exception {

		rolefunctiondao.addRoleFunction(em);
	}

	public List<RoleFunction> obj2Empl(List<Object> list) {

		List<RoleFunction> elist = new ArrayList<RoleFunction>();
		for (Object obj : list) {

			RoleFunction em = (RoleFunction) obj;
			elist.add(em);
		}

		return elist;
	}
	
	

}
