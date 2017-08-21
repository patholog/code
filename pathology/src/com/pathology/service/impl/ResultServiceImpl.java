package com.pathology.service.impl;

import com.pathology.dao.IResultDao;
import com.pathology.entity.Result;
import com.pathology.service.IResultService;
import org.apache.log4j.Logger;

import java.util.Map;

public class ResultServiceImpl implements IResultService {

  private Logger logger = Logger.getLogger(ResultServiceImpl.class);

  private IResultDao resultDao;

  @Override
  public void insert(Result result) {
    resultDao.insert(result);
  }

  @Override
  public void updateResult(Result result) {
    try {
      String generalSee = result.getGeneralSee();
      result = selectByCaseId(result.getCaseId());
      result.setGeneralSee(generalSee);
      resultDao.updateResult(result);
    } catch (Exception e) {
      logger.error(e.getMessage());
    }
  }

  @Override
  public void updateResult(Map<String, String[]> paramMap) {
    try {
      Result result = selectByCaseId(paramMap.get("caseId")[0]);
      result.setCaseId(paramMap.get("caseId")[0]);
      result.setGeneralSee(paramMap.get("generalSee")[0]);
      result.setResult(paramMap.get("immuneResult")[0]);
      result.setDiagnosed(paramMap.get("firstVisit")[0]);
      resultDao.updateResult(result);
    } catch (Exception e) {
      logger.error(e.getMessage());
      throw new RuntimeException(e);
    }
  }

  @Override
  public Result selectByCaseId(String caseId) {
    return resultDao.selectByCaseId(caseId);
  }

  public IResultDao getResultDao() {
    return resultDao;
  }

  public void setResultDao(IResultDao resultDao) {
    this.resultDao = resultDao;
  }
}
