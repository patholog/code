package com.pathology.service.impl;

import com.pathology.dao.DescriptionAppDao;
import com.pathology.entity.DescriptionApp;
import com.pathology.service.DescriptionAppService;
import com.pathology.util.SessionAgentManager;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Map;

public class DescriptionAppServiceImpl implements DescriptionAppService {

  private Logger logger = Logger.getLogger(DescriptionAppServiceImpl.class);

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

  @Override
  public void insert(Map<String, String[]> paramMap) {
    try {
      DescriptionApp descriptionApp = new DescriptionApp();
      descriptionApp.setCaseId(paramMap.get("caseId")[0]);
      descriptionApp.setToHospitalId(paramMap.get("toHospitalId")[0]);
      descriptionApp.setCaseId(paramMap.get("toDoctorId")[0]);
      descriptionApp.setFromDoctorId(SessionAgentManager.getSessionAgentBean().getIdUsers());
      descriptionApp.setFromHospitalId(SessionAgentManager.getSessionAgentBean().getBelonghospital());
      descriptionAppDao.insert(descriptionApp);
    } catch (Exception e) {
      logger.error(e.getMessage());
    }
  }

  public void setDescriptionAppDao(DescriptionAppDao descriptionAppDao) {
    this.descriptionAppDao = descriptionAppDao;
  }
}
