package com.pathology.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.pathology.entity.Collection;
import com.pathology.dto.CollectionDTO;

public interface ICollectionService {
	
	public List<Collection> getByPage(int index,Class clazz,String hql) throws Exception;
	public List<Collection> getAllCollection(Class clazz,String hql) throws Exception;
	public void deleteCollection(Collection em) throws Exception;
	public Collection getCollection(Class clazz,String id) throws Exception;
	public void updateCollection(Collection em) throws Exception;
	public void addCollection(Collection em) throws Exception;
	public List<CollectionDTO>  getListCollection(HttpServletRequest
			 request,String name) throws Exception;
}
