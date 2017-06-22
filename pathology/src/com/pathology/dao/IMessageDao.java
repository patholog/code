package com.pathology.dao;
import java.util.List;

import com.pathology.entity.Message;
public interface IMessageDao{
	public List<Object> getByPage(int index, Class clazz, String hql);
	public List<Object> getAllMessage(Class clazz,String hql);
	public void deleteMessage(Message em);
	public Message getMessage(Class clazz,String id);
	public void updateMessage(Message em);
	public void addMessage(Message em);
}
