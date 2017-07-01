package com.pathology.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.pathology.entity.Collection;
import com.pathology.dto.CollectionDTO;

public interface ICollectionService {
	
	public List<Collection> getByPage(int index,Class clazz,String hql);
	public List<Collection> getAllCollection(Class clazz,String hql);
	public void deleteCollection(Collection em);
	public Collection getCollection(Class clazz,String id);
	public void updateCollection(Collection em);
	public void addCollection(Collection em);
	public List<CollectionDTO>  getListCollection(HttpServletRequest
			 request,String name);
}
