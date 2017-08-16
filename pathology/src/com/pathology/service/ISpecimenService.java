package com.pathology.service;

import com.pathology.entity.Specimen;

import java.util.List;

public interface ISpecimenService {

  List<Specimen> selectList(Class clazz, String hql);
}
