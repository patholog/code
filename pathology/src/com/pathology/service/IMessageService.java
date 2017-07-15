package com.pathology.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.pathology.entity.Message;
import com.pathology.dto.MessageDTO;
import com.pathology.entity.Users;

public interface IMessageService {
	
	public List<Message> getByPage(int index,Class clazz,String hql) throws Exception;
	public List<Message> getAllMessage(Class clazz,String hql) throws Exception;
	public void deleteMessage(Message em) throws Exception;
	public Message getMessage(Class clazz,String id) throws Exception;
	public void updateMessage(Message em) throws Exception;
	public void addMessage(Message em) throws Exception;
	public List<MessageDTO>  getListMessage(HttpServletRequest
			 request,String name) throws Exception;
}
