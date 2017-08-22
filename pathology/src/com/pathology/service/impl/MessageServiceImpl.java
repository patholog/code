package com.pathology.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import com.pathology.util.Pages;
import com.pathology.dao.IMessageDao;
import com.pathology.entity.Message;
import com.pathology.dto.MessageDTO;
import com.pathology.mapping.MessageMapping;
import com.pathology.service.IMessageService;


public class MessageServiceImpl implements IMessageService {

  private Logger logger = Logger.getLogger(MessageServiceImpl.class);

  private IMessageDao messagedao;
  private JdbcTemplate jdbcTemplate;

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

  public List<Message> getByPage(int index, Class clazz, String hql) throws Exception {

    List<Object> list = messagedao.getByPage(index, clazz, hql);
    return this.obj2Empl(list);
  }

  public List<Message> getAllMessage(Class clazz, String hql) throws Exception {
    return this.obj2Empl(messagedao.getAllMessage(clazz, hql));
  }

  public void deleteMessage(Message em) throws Exception {
//		Message Message = Messagedao.getMessage(Message.class, em.getIdMessage());
    if (em != null)
      messagedao.deleteMessage(em);

  }


  public List<MessageDTO> getListMessage(HttpServletRequest request, String name) throws Exception {
    String pageNum = request.getParameter("pageNum");
    pageNum = pageNum != null ? pageNum : "1";
    String title = "";
    int status = 1;
    String sql = " select a.id_message idMessage, b.pathologyno, a.case_id caseId, b.patientname, c.username,"
        + " a.content, a.createTime, a.messageOrder"
        + " from message a "
        + " left join  pathology  b  on a.case_id = b.id_case "
        + " left join  users  c on a.fromDoctorId = c.id_users";

    String sqlcount = "select  count(*) from   message  a"
        + "  left join  pathology  b  on   a.case_id = b.id_case "
        + "   left join  users  c on  a.fromDoctorId = c.id_users";

    int totalNum = jdbcTemplate.queryForInt(sqlcount);
    if (totalNum > 0) {
      Pages page = new Pages(totalNum, "listAskonlineForm", Integer.parseInt(pageNum), 10);
      //List<Message> messages = jdbcTemplate.query(sql +"  "+page.getPageLimit(), new MessageMapping());
      request.setAttribute("page", page.getPageStr());
      //request.setAttribute("list", messages);

    }
    try {
      return jdbcTemplate.query(sql, new MessageMapping());
    } catch (Exception e) {
      logger.error(e.getMessage());
      return null;
    }
  }

  public MessageDTO getMessage(HttpServletRequest request, Integer id) throws Exception {
    String sql = " select a.id_message idMessage, b.pathologyno, a.case_id caseId, b.patientname, c.username,"
        + " a.content, a.createTime, a.messageOrder"
        + " from message a "
        + " left join  pathology  b  on a.case_id = b.id_case "
        + " left join  users  c on a.fromDoctorId = c.id_users"
        + " where a.id_message = " + String.valueOf(id);

    try {
      return (MessageDTO) jdbcTemplate.queryForObject(sql, new MessageMapping());
    } catch (Exception e) {
      logger.error(e.getMessage());
      return null;
    }
  }

  public Message getMessage(Class clazz, String id) throws Exception {

    return messagedao.getMessage(clazz, id);
  }

  public void updateMessage(Message em) throws Exception {

    messagedao.updateMessage(em);

  }

  public void addMessage(Message em) throws Exception {

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
