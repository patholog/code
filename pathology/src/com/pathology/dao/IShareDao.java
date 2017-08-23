package com.pathology.dao;

import java.util.List;

import com.pathology.entity.Share;

public interface IShareDao {
  List<Object> getByPage(int index, Class clazz, String hql);

  List<Object> getAllShare(Class clazz, String hql);

  void deleteShare(Share em);

  Share getShare(Class clazz, Integer id);

  void updateShare(Share em);

  Integer addShare(Share em);
}
