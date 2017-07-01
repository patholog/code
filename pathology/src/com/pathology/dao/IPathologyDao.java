package com.pathology.dao;
import java.util.List;

import com.pathology.entity.Pathology;
public interface IPathologyDao{
	public List<Object> getByPage(int index, Class clazz, String hql);
	public List<Object> getAllPathology(Class clazz,String hql);
	public void deletePathology(Pathology em);
	public Pathology getPathology(Class clazz,String id);
	public void updatePathology(Pathology em);
	public void addPathology(Pathology em);
}
