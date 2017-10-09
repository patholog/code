package com.pathology.dao;

import com.pathology.entity.Annotation;

import java.util.List;

public interface AnnotationDao {

  Integer insert(Annotation annotation);

  List<Object> selectListByImageId(Integer imageId);
}
