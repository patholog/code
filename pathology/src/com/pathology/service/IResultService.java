package com.pathology.service;

import com.pathology.entity.Result;

public interface IResultService {

  void updateResult(Result result);

  Result selectByCaseId(String caseId);
}
