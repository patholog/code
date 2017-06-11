package com.flp.serv;

import java.util.List;

import com.flp.dao.IHospitalDao;
import com.flp.hib.Hospital;

public class HospitalServImpl implements IHospitalServ {

	private IHospitalDao<Hospital,Integer> hosDao;
	@Override
	public Hospital check(Hospital u) {
		return null;
	}

	@Override
	public Hospital save(Hospital u) {
		return hosDao.save(u);
	}

	@Override
	public Hospital update(Hospital u) {
		return hosDao.edit(u);
	}

	@Override
	public Hospital del(Hospital u) {
		return hosDao.delt(u);
	}

	@Override
	public List<Hospital> findAll() {
		return hosDao.getAll("select * from hospital");
	}
	
	@Override
	public Hospital findById(String id) {
		if(id.isEmpty())return null;
		List<Hospital> userlist = hosDao.getAll("select h.* from hospital h where h.id='"+id+"'");
		if(userlist.size()>0)return userlist.get(0);
		return null;
	}

	@Override
	public List<Hospital> find(String wherestrs) {
		if(wherestrs.isEmpty())return null;
		return hosDao.getAll("select * from hospital where '"+wherestrs+"'");
	}

}
