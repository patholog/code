package com.pathology.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import com.pathology.dto.PathologyDTO;
import com.pathology.entity.Pathology;

public interface IPathologyService {
	
	public List<Pathology> getByPage(int index,Class clazz,String hql) throws Exception;
	public List<Pathology> getAllPathology(Class clazz,String hql) throws Exception;
	public void deletePathology(Pathology em) throws Exception;
	public Pathology getPathology(Class clazz,String id) throws Exception;
	public void updatePathology(Pathology em) throws Exception;
	public void addPathology(Pathology em) throws Exception;
	public List<PathologyDTO>  getListPathologyToNeed(HttpServletRequest
			 request,String name) throws Exception;
	public List<PathologyDTO>  getListPathologyToHas(HttpServletRequest
			 request,String name) throws Exception;
	public List<PathologyDTO>  getListPathologyToBack(HttpServletRequest
			 request,String name) throws Exception;
}
