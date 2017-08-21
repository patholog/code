package com.pathology.service.impl;

import com.pathology.dao.DescriptionAppDao;
import com.pathology.entity.DescriptionApp;
import com.pathology.service.DescriptionAppService;
import com.pathology.util.SessionAgentManager;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class DescriptionAppServiceImpl implements DescriptionAppService {

  private Logger logger = Logger.getLogger(DescriptionAppServiceImpl.class);

  private DescriptionAppDao descriptionAppDao;
  private JdbcTemplate jdbcTemplate;

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
      descriptionApp.setToDoctorId(paramMap.get("toDoctorId")[0]);
      descriptionApp.setFromDoctorId(SessionAgentManager.getSessionAgentBean().getIdUsers());
      descriptionApp.setFromHospitalId(SessionAgentManager.getSessionAgentBean().getBelonghospital());
      descriptionApp.setApplyDateTime(Timestamp.valueOf(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())));
      int first = jdbcTemplate.queryForInt("select min(id_description_app) from description_app"
          + " where case_id = '" + paramMap.get("caseId")[0] + "' order by applyDateTime");
      if (first > 0) {
        descriptionApp.setTransferParentId(first);
      }
      descriptionAppDao.insert(descriptionApp);
    } catch (Exception e) {
      logger.error(e.getMessage());
      throw new RuntimeException(e);
    }
  }

  public void setDescriptionAppDao(DescriptionAppDao descriptionAppDao) {
    this.descriptionAppDao = descriptionAppDao;
  }

  public JdbcTemplate getJdbcTemplate() {
    return jdbcTemplate;
  }

  public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }
}
