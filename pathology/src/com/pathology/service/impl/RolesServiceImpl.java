package com.pathology.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.pathology.dao.IRolesDao;
import com.pathology.entity.Roles;
import com.pathology.service.IRolesService;

public class RolesServiceImpl implements IRolesService {

	private IRolesDao rolesdao;
	
	public IRolesDao getRolesdao() {
		return rolesdao;
	}

	public void setRolesdao(IRolesDao rolesdao) {
		this.rolesdao = rolesdao;
	}

	public List<Roles> getByPage(int index, Class clazz, String hql) {

		List<Object> list = rolesdao.getByPage(index, clazz, hql);
		return this.obj2Empl(list);
	}

	public List<Roles> getAllRoles(Class clazz, String hql) {
		return this.obj2Empl(rolesdao.getAllRoles(clazz, hql));
	}

	public void deleteRoles(Roles em) {
		if(em!=null)
			rolesdao.deleteRoles(em);

	}

	public Roles getRoles(Class clazz, String id) {
		
		return rolesdao.getRoles(clazz, id);
	}

	public void updateRoles(Roles em) {

		rolesdao.updateRoles(em);

	}

	public void addRoles(Roles em) {

		rolesdao.addRoles(em);
	}

	public List<Roles> obj2Empl(List<Object> list) {

		List<Roles> elist = new ArrayList<Roles>();
		for (Object obj : list) {

			Roles em = (Roles) obj;
			elist.add(em);
		}

		return elist;
	}
	
	

}
