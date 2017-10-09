package com.pathology.service;

import com.pathology.entity.Annotation;

import java.util.List;

public interface AnnotationService {

  Integer insert(Annotation annotation);

  List<Annotation> selectListByImageId(Integer imageId);
}
