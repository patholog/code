package com.flp.serv;

import java.util.List;

import com.flp.hib.Hospital;


public interface IHospitalServ {
	Hospital check(Hospital u);
	Hospital save(Hospital u);
	Hospital update(Hospital u);
	Hospital del(Hospital u);
	List<Hospital> findAll();
	List<Hospital> find(String wherestrs);
	Hospital findById(String id);
}
