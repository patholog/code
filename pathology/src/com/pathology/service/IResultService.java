package com.pathology.service;

import com.pathology.entity.Result;

import java.util.Map;

public interface IResultService {

  void insert(Result result);

  void insert(Map<String, String[]> paramMap);

  void updateResult(Result result);

  void update(Map<String, String[]> paramMap);

  Result selectByCaseId(String caseId);

  void deleteByCaseId(String caseId);
}
