package com.pathology.service;

import com.pathology.entity.Result;

import java.util.Map;

public interface IResultService {

  void insert(Result result);

  void updateResult(Result result);

  void updateResult(Map<String, String[]> paramMap);

  Result selectByCaseId(String caseId);
}
