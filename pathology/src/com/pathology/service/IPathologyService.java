package com.pathology.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import com.pathology.dto.PathologyDTO;
import com.pathology.entity.Pathology;

public interface IPathologyService {
	
	public List<Pathology> getByPage(int index,Class clazz,String hql);
	public List<Pathology> getAllPathology(Class clazz,String hql);
	public void deletePathology(Pathology em);
	public Pathology getPathology(Class clazz,String id);
	public void updatePathology(Pathology em);
	public void addPathology(Pathology em);
	public List<PathologyDTO>  getListPathologyToNeed(HttpServletRequest
			 request,String name);
	public List<PathologyDTO>  getListPathologyToHas(HttpServletRequest
			 request,String name);
}
