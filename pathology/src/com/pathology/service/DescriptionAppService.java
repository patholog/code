package com.pathology.service;

import com.pathology.entity.DescriptionApp;

import java.util.List;

public interface DescriptionAppService {

  List<DescriptionApp> selectForListByCaseId(String caseId);
}
