package com.pathology.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.pathology.entity.Message;
import com.pathology.dto.MessageDTO;
import com.pathology.entity.Users;

public interface IMessageService {
	
	public List<Message> getByPage(int index,Class clazz,String hql);
	public List<Message> getAllMessage(Class clazz,String hql);
	public void deleteMessage(Message em);
	public Message getMessage(Class clazz,String id);
	public void updateMessage(Message em);
	public void addMessage(Message em);
	public List<MessageDTO>  getListMessage(HttpServletRequest
			 request,String name);
}
