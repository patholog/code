package com.pathology.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.SessionFactory;

import com.pathology.dao.IMessageDao;
import com.pathology.dao.SuperDao;
import com.pathology.entity.Message;

public class MessageDaoImpl extends SuperDao implements IMessageDao {

	private SessionFactory osessionFactory;


	public SessionFactory getOsessionFactory() {
		return osessionFactory;
	}


	public void setOsessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}


	public List<Object> getByPage(int index, Class clazz, String hql) {
		return super.selectPage(index, clazz, hql);
	}


	public List<Object> getAllMessage(Class clazz,String hql) {
		return super.getAllObject(clazz,hql);
	}


	public void deleteMessage(Message em) {
		super.delete(em);
	}
	
	public Message getMessage(Class clazz,String id) {
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("idMessage",id);
		return (Message) super.findUniqueByClz(Message.class, param);
	}
	
	public void updateMessage(Message em){
		super.update(em);
	}

	public void addMessage(Message em){
		super.add(em);
	}



}
