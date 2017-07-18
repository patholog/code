package com.pathology.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.pathology.dao.IFunctionDao;
import com.pathology.entity.Function;
import com.pathology.mapping.FunctionMapping;
import com.pathology.service.IFunctionService;

public class FunctionServiceImpl implements IFunctionService {

	private IFunctionDao functiondao;
	private JdbcTemplate  jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public IFunctionDao getFunctiondao() {
		return functiondao;
	}

	public void setFunctiondao(IFunctionDao hospitaldao) {
		this.functiondao = hospitaldao;
	}

	public List<Function> getByPage(int index, Class clazz, String hql)  throws Exception{

		List<Object> list = functiondao.getByPage(index, clazz, hql);
		return this.obj2Empl(list);
	}

	public List<Function> getFunctionList(String id_role)throws Exception{
		String sql = " select f.name,f.url,f.id_function from function  f, role_function r where f.id_function = r.id_founction and  r.id_role = '"+id_role+"'";
	    return jdbcTemplate.query(sql, new FunctionMapping());
	}
	
	
	public List<Function> getAllFunction(Class clazz, String hql) throws Exception {
		return this.obj2Empl(functiondao.getAllFunction(clazz, hql));
	}

	public void deleteFunction(Function em) throws Exception {
//		Hospital Hospital = hospitaldao.getHospital(Hospital.class, em.getIdHospitals());
		if(em!=null)
			functiondao.deleteFunction(em);

	}

	public Function getFunction(Class clazz, String id) throws Exception {
		
		return functiondao.getFunction(clazz, id);
	}

	public void updateFunction(Function em) throws Exception {

		functiondao.updateFunction(em);

	}

	public void addFunction(Function em) throws Exception {

		functiondao.addFunction(em);
	}

	public List<Function> obj2Empl(List<Object> list) {

		List<Function> elist = new ArrayList<Function>();
		for (Object obj : list) {

			Function em = (Function) obj;
			elist.add(em);
		}

		return elist;
	}
	
	

}
