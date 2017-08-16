package com.pathology.service;

import com.pathology.entity.Result;

public interface IResultService {

  void insert(Result result);

  void updateResult(Result result);

  Result selectByCaseId(String caseId);
}
