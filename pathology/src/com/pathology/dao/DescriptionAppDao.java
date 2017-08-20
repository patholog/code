package com.pathology.dao;

import com.pathology.entity.DescriptionApp;

import java.util.List;

public interface DescriptionAppDao {

  List<DescriptionApp> selectForListByCaseId(String caseId);
}
