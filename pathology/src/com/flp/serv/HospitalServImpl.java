package com.flp.serv;

import java.util.List;

import com.flp.dao.IHospitalDao;
import com.flp.hib.Hospital;

public class HospitalServImpl implements IHospitalServ {

	private IHospitalDao<Hospital,Integer> hdao;
	@Override
	public Hospital check(Hospital u) {
		return null;
	}

	@Override
	public Hospital save(Hospital u) {
		return hdao.save(u);
	}

	@Override
	public Hospital update(Hospital u) {
		return hdao.edit(u);
	}

	@Override
	public Hospital del(Hospital u) {
		return hdao.delt(u);
	}

	@Override
	public List<Hospital> findAll() {
		return hdao.getAll("select * from hospital");
	}
	
	@Override
	public Hospital findById(String id) {
		if(id.isEmpty())return null;
		List<Hospital> userlist = hdao.getAll("select h.* from hospital h where h.id='"+id+"'");
		if(userlist.size()>0)return userlist.get(0);
		return null;
	}

	@Override
	public List<Hospital> find(String wherestrs) {
		if(wherestrs.isEmpty())return null;
		return hdao.getAll("select * from hospital where '"+wherestrs+"'");
	}

}
