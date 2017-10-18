package com.pathology.service.impl;

import com.pathology.dao.AnnotationDao;
import com.pathology.entity.Annotation;
import com.pathology.service.AnnotationService;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AnnotationServiceImpl implements AnnotationService {

  private Logger logger = Logger.getLogger(AnnotationServiceImpl.class);

  private AnnotationDao annotationDao;
  @Override
  public Integer insert(Annotation annotation) {
    try {
      annotation.setCrtTime(new Date());
      return annotationDao.insert(annotation);
    } catch (Exception e) {
      logger.error(e.getMessage());
      return null;
    }
  }

  @Override
  public List<Annotation> selectListByImageId(Integer imageId) {
    List<Object> objList = annotationDao.selectListByImageId(imageId);
    List<Annotation> annotationList = new ArrayList<>();
    for (Object obj : objList) {
      annotationList.add((Annotation) obj);
    }
    return annotationList;
  }

  @Override
  public void delete(Integer imageId, String name) {
    Annotation annotation = new Annotation();
    annotation.setImageId(imageId);
    annotation.setName(name);
    annotationDao.delete(annotation);
  }

  public AnnotationDao getAnnotationDao() {
    return annotationDao;
  }

  public void setAnnotationDao(AnnotationDao annotationDao) {
    this.annotationDao = annotationDao;
  }
}
