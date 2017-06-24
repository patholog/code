package com.pathology.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.pathology.dao.IMessageDao;
import com.pathology.entity.Message;
import com.pathology.mapping.MessageMapping;
import com.pathology.service.IMessageService;

public class MessageServiceImpl implements IMessageService {

	private IMessageDao messagedao;
	@Autowired
	private JdbcTemplate  jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

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
	
	
	public List<Message>  getListMessage(String name){
		String sql = " select  c.username,b.content,a.patientname from   pathology  a"
						+" left join  message  b  on a.pathology_no = b.pathology_no"
						+" left join  users  c on b.fromDoctorId = c.id_users";
		return jdbcTemplate.query(sql, new MessageMapping());
	 
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
