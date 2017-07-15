package com.pathology.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.pathology.dao.IFunctionDao;
import com.pathology.dao.IRoleFunctionDao;
import com.pathology.dao.IRolesDao;
import com.pathology.entity.Function;
import com.pathology.entity.RoleFunction;
import com.pathology.entity.Roles;
import com.pathology.service.IRolesService;
import com.pathology.util.RandomNumbers;

public class RolesServiceImpl implements IRolesService {

	private IRolesDao rolesdao;
	private IFunctionDao functiondao;
	private IRoleFunctionDao rolefunctiondao;
	
	public IRolesDao getRolesdao() {
		return rolesdao;
	}

	public void setRolesdao(IRolesDao rolesdao) {
		this.rolesdao = rolesdao;
	}
	

	public IFunctionDao getFunctiondao() {
		return functiondao;
	}

	public void setFunctiondao(IFunctionDao functiondao) {
		this.functiondao = functiondao;
	}
	

	public IRoleFunctionDao getRolefunctiondao() {
		return rolefunctiondao;
	}

	public void setRolefunctiondao(IRoleFunctionDao rolefunctiondao) {
		this.rolefunctiondao = rolefunctiondao;
	}

	public List<Roles> getByPage(int index, Class clazz, String hql)  throws Exception{

		List<Object> list = rolesdao.getByPage(index, clazz, hql);
		return this.obj2Empl(list);
	}

	public List<Roles> getAllRoles(Class clazz, String hql) throws Exception {
		return this.obj2Empl(rolesdao.getAllRoles(clazz, hql));
	}

	public void deleteRoles(Roles em) throws Exception {
		if(em!=null)
			rolesdao.deleteRoles(em);

	}

	public Roles getRoles(Class clazz, String id) throws Exception {
		
		return rolesdao.getRoles(clazz, id);
	}

	public void updateRoles(Roles em) throws Exception {

		rolesdao.updateRoles(em);

	}

	public void addRoles(Roles em) throws Exception {

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

	@Override
	public Boolean findRoles(String id) throws Exception {
		HttpSession session = ServletActionContext.getRequest()
				.getSession();
		Roles roles=rolesdao.getRoles(Roles.class, id);
		List<Object> functionT=functiondao.getAllFunction(Function.class, "");
		List<Function> funclist = new ArrayList<Function>();

		for (Object obj : functionT) {

			Function em = (Function) obj;
			funclist.add(em);
		}
		session.setAttribute("roles",roles);
		session.setAttribute("functionlist", funclist);
		if(roles!=null && funclist.size()>0){
			return true;
		}
		return false;
	}

	@Override
	public void addRoles(Roles em, String idfunctions) throws Exception{
		String[] funcs=idfunctions.split(",");
		for(String funcid:funcs){
			RoleFunction rolefunc=new RoleFunction();
			rolefunc.setIdRoleFounction(RandomNumbers.getEandomId(16));
			rolefunc.setIdRole(em.getIdRoles());
			rolefunc.setIdFounction(funcid);
			rolefunctiondao.addRoleFunction(rolefunc);
		}
		rolesdao.addRoles(em);
		
	}

	@Override
	public void updateRoles(Roles em, String idfunctions)throws Exception {
		String[] funcs=idfunctions.split(",");
		for(String funcid:funcs){
			RoleFunction rolefunc=new RoleFunction();
			rolefunc.setIdRoleFounction(RandomNumbers.getEandomId(16));
			rolefunc.setIdRole(em.getIdRoles());
			rolefunc.setIdFounction(funcid);
		}
		rolesdao.updateRoles(em);
	}
	
	

}
