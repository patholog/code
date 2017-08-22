package com.pathology.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.pathology.entity.Message;
import com.pathology.dto.MessageDTO;
import com.pathology.entity.Users;

public interface IMessageService {

  List<Message> getByPage(int index, Class clazz, String hql) throws Exception;

  List<Message> getAllMessage(Class clazz, String hql) throws Exception;

  void deleteMessage(Message em) throws Exception;

  void insert(Map<String, String[]> paramMap);

  Message getMessage(Class clazz, String id) throws Exception;

  MessageDTO getMessage(HttpServletRequest request, Integer id) throws Exception;

  void updateMessage(Message em) throws Exception;

  void addMessage(Message em) throws Exception;

  List<MessageDTO> getListMessage(HttpServletRequest
                                             request, String name) throws Exception;
}
