package com.pathology.dao;
import java.util.List;
import com.pathology.entity.Share;
public interface IShareDao{
	public List<Object> getByPage(int index, Class clazz, String hql);
	public List<Object> getAllShare(Class clazz,String hql);
	public void deleteShare(Share em);
	public Share getShare(Class clazz,String id);
	public void updateShare(Share em);
	public void addShare(Share em);
}
