package com.pathology.service.impl;

import com.pathology.dao.IResultDao;
import com.pathology.entity.Result;
import com.pathology.service.IResultService;

public class ResultServiceImpl implements IResultService {

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
      e.printStackTrace();
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
