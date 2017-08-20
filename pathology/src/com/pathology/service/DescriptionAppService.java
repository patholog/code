package com.pathology.service;

import com.pathology.entity.DescriptionApp;

import java.util.List;
import java.util.Map;

public interface DescriptionAppService {

  List<DescriptionApp> selectForListByCaseId(String caseId);

  void insert(Map<String, String[]> paramMap);
}
