package com.pathology.dao.impl;

import com.pathology.dao.AnnotationDao;
import com.pathology.dao.SuperDao;
import com.pathology.entity.Annotation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnnotationDaoImpl extends SuperDao implements AnnotationDao {
  @Override
  public Integer insert(Annotation annotation) {
    return ((Annotation) super.add(annotation)).getImageId();
  }

  @Override
  public List<Object> selectListByImageId(Integer imageId) {
    Map<String, Object> paramMap = new HashMap<>();
    paramMap.put("imageId", imageId);
    return findByClz(Annotation.class, paramMap);
  }
}
