package com.pathology.service.impl;

import com.pathology.dao.DescriptionAppDao;
import com.pathology.entity.DescriptionApp;
import com.pathology.service.DescriptionAppService;

import java.util.List;

public class DescriptionAppServiceImpl implements DescriptionAppService {

  private DescriptionAppDao descriptionAppDao;

  @Override
  public List<DescriptionApp> selectForListByCaseId(String caseId) {
    try {
      return descriptionAppDao.selectForListByCaseId(caseId);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public void setDescriptionAppDao(DescriptionAppDao descriptionAppDao) {
    this.descriptionAppDao = descriptionAppDao;
  }
}
