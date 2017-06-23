package com.pathology.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import sun.misc.Request;

import com.opensymphony.xwork2.ActionContext;
import com.pathology.entity.Message;
import com.pathology.entity.Users;
import com.pathology.service.IMessageService;
import com.pathology.service.IUsersService;

public class MessageAction {

	public IMessageService messageService;
	private Message message;
	private List<Message> messages;
	
	
	public String  getMessageList(){
		try{
			
		String hql =" from message ";
		//messages =  messageService.getAllMessage(Message.class, hql);
		Message me = new Message();
		me.setIdMessage("000");
		if(messages  == null){
			messages = new ArrayList();
			messages.add(me);
		}
		
		Map  request = (Map) ActionContext.getContext().get("request");
		return "messages";
	  }catch(Exception e){
		
	   }
		return "messages";
	}


	public IMessageService getMessageService() {
		return messageService;
	}


	public void setMessageService(IMessageService messageService) {
		this.messageService = messageService;
	}


	public List<Message> getMessages() {
		return messages;
	}


	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	
	
	
}
