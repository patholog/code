package com.pathology.dao;
import java.util.List;
import com.pathology.entity.Collection;
public interface ICollectionDao{
	public List<Object> getByPage(int index, Class clazz, String hql);
	public List<Object> getAllCollection(Class clazz,String hql);
	public void deleteCollection(Collection em);
	public Collection getCollection(Class clazz,String id);
	public void updateCollection(Collection em);
	public void addCollection(Collection em);
}
