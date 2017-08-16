package com.pathology.dao;

import com.pathology.entity.Result;

public interface IResultDao {

  void insert(Result result);

  void updateResult(Result result);

  Result selectByCaseId(String caseId);
}
