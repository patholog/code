package com.pathology.service.impl;

import com.pathology.dao.ISpecimenDao;
import com.pathology.entity.Specimen;
import com.pathology.service.ISpecimenService;

import java.util.List;

public class SpecimenServiceImpl implements ISpecimenService {

  private ISpecimenDao specimenDao;

  @Override
  public List<Specimen> selectList(Class clazz, String hql) {
    return specimenDao.selectList(clazz, hql);
  }

  public void setSpecimenDao(ISpecimenDao specimenDao) {
    this.specimenDao = specimenDao;
  }
}
