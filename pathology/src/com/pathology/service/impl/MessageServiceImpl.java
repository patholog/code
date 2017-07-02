package com.pathology.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.jdbc.core.JdbcTemplate;
import com.pathology.util.Pages;
import com.pathology.dao.IMessageDao;
import com.pathology.entity.Message;
import com.pathology.dto.MessageDTO;
import com.pathology.mapping.MessageMapping;
import com.pathology.service.IMessageService;
 

public class MessageServiceImpl implements IMessageService {

	private IMessageDao messagedao;
	
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
	
	
	public List<MessageDTO>  getListMessage(HttpServletRequest
			 request,String name){
		
		String pageNum = request.getParameter("pageNum");
		pageNum = pageNum != null?pageNum:"1";
		String title = "";
		int status = 1;
		String sql = " select b.pathology_no ,b.patientname,c.username,a.content,a.createTime from message  a "
						+" left join  pathology  b  on a.case_id = b.id_case "
						+" left join  users  c on a.fromDoctorId = c.id_users";
		
		String sqlcount  = "select  count(*) from   message  a"
				+"  left join  pathology  b  on  b.id_case=a.case_id "
				+"   left join  users  c on  c.id_users=b.fromDoctorId";
		
		int totalNum = jdbcTemplate.queryForInt(sqlcount);
		if(totalNum > 0){
			Pages page = new Pages(totalNum, "listAskonlineForm", Integer.parseInt(pageNum), 10);
			//List<Message> messages = jdbcTemplate.query(sql +"  "+page.getPageLimit(), new MessageMapping());
			request.setAttribute("page", page.getPageStr());
			//request.setAttribute("list", messages);
		 
		}
		
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
