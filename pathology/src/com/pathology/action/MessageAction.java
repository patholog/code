package com.pathology.action;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

 

 

import com.opensymphony.xwork2.ActionContext;
import com.pathology.dto.MessageDTO;
import com.pathology.entity.Message;
import com.pathology.service.IMessageService;
public class MessageAction extends BaseAction{

	public IMessageService messageService;
	private Message message;
	private List<Message> messages;
	
	
	public String  getMessageList(){
		try{
		
			HttpServletRequest
			 request = ServletActionContext.getRequest();	
			
		String hql =" from message ";
		messages =  messageService.getListMessage(request,"");
		Message me = new Message();
		me.setIdMessage("000");
		me.setContent("留言");
		//me.setCreateTime(new Timestamp(0));
		me.setMessageOrder("留言内容");
		me.setFromDoctorId("ssss");
		me.setToDoctorId("sss");
		me.setMemo("说明");
		/*if(messages  == null){
			messages = new ArrayList();
			messages.add(me);
		}*/
		
	 
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
