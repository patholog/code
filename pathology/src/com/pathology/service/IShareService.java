package com.pathology.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.pathology.entity.Share;
import com.pathology.dto.ShareDTO;

public interface IShareService {

  List<Share> getByPage(int index, Class clazz, String hql) throws Exception;

  List<Share> getAllShare(Class clazz, String hql) throws Exception;

  void deleteShare(Share em) throws Exception;

  Share getShare(Class clazz, Integer id) throws Exception;

  void updateShare(Share em) throws Exception;

  void addShare(Share em) throws Exception;

  Integer insert(Map<String, String[]> paramMap);

  List<ShareDTO> getListShare(HttpServletRequest request, String name) throws Exception;
}
