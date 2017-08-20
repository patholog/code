package com.pathology.dao.impl;

import com.pathology.dao.DescriptionAppDao;
import com.pathology.dao.SuperDao;
import com.pathology.entity.DescriptionApp;

import java.util.ArrayList;
import java.util.List;

public class DescriptionAppDaoImpl extends SuperDao implements DescriptionAppDao {

  @Override
  public List<DescriptionApp> selectForListByCaseId(String caseId) {
    List<Object> objectList = super.getAllObject(DescriptionApp.class, " and case_id = '" + caseId + "'");
    List<DescriptionApp> returnList = new ArrayList<>();
    for (Object object : objectList) {
      DescriptionApp descriptionApp = (DescriptionApp) object;
      returnList.add(descriptionApp);
    }
    return returnList;
  }
}
