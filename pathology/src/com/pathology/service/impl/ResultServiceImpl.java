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
  public void insert(Map<String, String[]> paramMap) {
    Result result = new Result();
    result.setIdResult(paramMap.get("caseId")[0]);
    result.setCaseId(paramMap.get("caseId")[0]);
    assembleResult(result, paramMap);
    try {
      insert(result);
    } catch (Exception e) {
      logger.error(e.getMessage());
      throw new RuntimeException("新建结果失败");
    }
  }

  @Override
  public void updateResult(Result result) {
    try {
      resultDao.updateResult(result);
    } catch (Exception e) {
      logger.error(e.getMessage());
    }
  }

  @Override
  public void update(Map<String, String[]> paramMap) {
    try {
      Result result = selectByCaseId(paramMap.get("caseId")[0]);
      assembleResult(result, paramMap);
      resultDao.updateResult(result);
    } catch (Exception e) {
      logger.error(e.getMessage());
      throw new RuntimeException(e);
    }
  }


  /**
   * 根据前台数据更新Result数据
   *
   * @param result
   * @param paramMap
   * @return
   */
  private Result assembleResult(Result result, Map<String, String[]> paramMap) {
    try {
      // 大体所见等Result数据
      result.setGeneralSee(paramMap.get("generalSeeHidden")[0]); // 大体所见
      result.setMicroscopeSee(paramMap.get("microscopeSeeHidden")[0]); // 影像检查
      result.setDiagnosed(paramMap.get("diagnosed")[0]); // 初诊意见
      result.setResult(paramMap.get("immuneResult")[0]); // 免疫组化结果
    } catch (Exception e) {
      logger.error(e.getMessage());
      throw new RuntimeException("获取结果数据失败！请联系管理员");
    }
    return result;
  }

  @Override
  public void deleteByCaseId(String caseId) {
    resultDao.delete(this.selectByCaseId(caseId));
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
