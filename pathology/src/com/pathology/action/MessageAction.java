package com.pathology.action;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.pathology.dto.MessageDTO;
import com.pathology.entity.Message;
import com.pathology.service.IMessageService;
import com.pathology.util.Constant;

public class MessageAction extends BaseAction {
  private static final long serialVersionUID = 1L;
  private final Logger logger = Logger.getLogger(HospitalAction.class);
  public IMessageService messageService;
  private Message message;
  private MessageDTO messageDTO;
  private List<MessageDTO> messages;
  private String patientname;
  private String content;

  public String getMessageList() {
    try {
      HttpServletRequest request = ServletActionContext.getRequest();
//		String hql =" from message ";
      messages = messageService.getListMessage(request, "");
     
      return "messages";
    } catch (Exception e) {

    }
    return "messages";
  }

  /**
   * 根据主键查询message
   *
   * @return message
   */
  public String getMessageId() {
    try {
      HttpServletRequest request = ServletActionContext.getRequest();
      String id = request.getParameter("id");
      messageDTO = messageService.getMessage(request, Integer.parseInt(id));
      return "messageInfo";
    } catch (Exception e) {
      logger.error(e.getMessage());
      return Constant.ERR;
    }
  }

  /**
   * 保存留言
   *
   * @return null
   */
  public String saveMessage() {
    HttpServletRequest request = ServletActionContext.getRequest();
    HttpServletResponse response = ServletActionContext.getResponse();
    response.setContentType("text/html;charset=UTF-8");
    Map<String, String[]> paramMap = request.getParameterMap();
    String result = "";
    try {
      messageService.insert(paramMap);
      result = "保存成功";
    } catch (Exception e) {
      logger.error(e.getMessage());
    }
    try {
      PrintWriter out;
      out = response.getWriter();
      String jsonString = !"".equals(result) ? "{\"success\":\"保存成功\"}" : "{\"failure\":\"保存失败\"}";
      out.println(jsonString);
      out.flush();
      out.close();
    } catch (Exception e) {
      logger.error(e);
    }
    return null;
  }


  public String SearchMessageList() {
    try {

      HttpServletRequest
          request = ServletActionContext.getRequest();
      String conent = this.messageDTO.getContent();
//		String nam = this.message.getPatientname();
//		String hql =" from message ";
      messages = messageService.getListMessage(request, conent);
      Message me = new Message();
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
    } catch (Exception e) {

    }
    return "messages";
  }


  public IMessageService getMessageService() {
    return messageService;
  }


  public void setMessageService(IMessageService messageService) {
    this.messageService = messageService;
  }


  public List<MessageDTO> getMessages() {
    return messages;
  }


  public void setMessages(List<MessageDTO> messages) {
    this.messages = messages;
  }


  public String getPatientname() {
    return patientname;
  }


  public Message getMessage() {
    return message;
  }


  public void setMessage(Message message) {
    this.message = message;
  }


  public String getContent() {
    return content;
  }


  public void setContent(String content) {
    this.content = content;
  }


  public void setPatientname(String patientname) {
    this.patientname = patientname;
  }


  public MessageDTO getMessageDTO() {
    return messageDTO;
  }


  public void setMessageDTO(MessageDTO messageDTO) {
    this.messageDTO = messageDTO;
  }


}
