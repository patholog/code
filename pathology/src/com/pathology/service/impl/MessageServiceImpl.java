package com.pathology.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.pathology.dao.IMessageDao;
import com.pathology.entity.Message;
import com.pathology.service.IMessageService;

public class MessageServiceImpl implements IMessageService {

	private IMessageDao messagedao;

	public IMessageDao getMessagedao() {
		return messagedao;
	}

	public void setMessagedao(IMessageDao udao) {
		this.messagedao = udao;
	}

	public List<Message> getByPage(int index, Class clazz, String hql) {

		List<Object> list = messagedao.getByPage(index, clazz, hql);
		return this.obj2Empl(list);
	}

	public List<Message> getAllMessage(Class clazz, String hql) {
		return this.obj2Empl(messagedao.getAllMessage(clazz, hql));
	}

	public void deleteMessage(Message em) {
//		Message Message = Messagedao.getMessage(Message.class, em.getIdMessage());
		if(em!=null)
			messagedao.deleteMessage(em);

	}

	public Message getMessage(Class clazz, String id) {
		
		return messagedao.getMessage(clazz, id);
	}

	public void updateMessage(Message em) {

		messagedao.updateMessage(em);

	}

	public void addMessage(Message em) {

		messagedao.addMessage(em);
	}

	public List<Message> obj2Empl(List<Object> list) {

		List<Message> elist = new ArrayList<Message>();
		for (Object obj : list) {

			Message em = (Message) obj;
			elist.add(em);
		}

		return elist;
	}

 
}
