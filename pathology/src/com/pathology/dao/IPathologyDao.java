package com.pathology.dao;

import java.util.List;

import com.pathology.entity.Pathology;
import com.pathology.entity.Result;

public interface IPathologyDao {
  List<Object> getByPage(int index, Class clazz, String hql);

  List<Object> getAllPathology(Class clazz, String hql);

  void deletePathology(Pathology em);

  Pathology getPathology(Class clazz, String id);

  void updatePathology(Pathology em);

  void addPathology(Pathology em);

}
