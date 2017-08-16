package com.pathology.dao;

import com.pathology.entity.Specimen;

import java.util.List;

public interface ISpecimenDao {

  List<Specimen> selectList(Class clazz, String hql);
}
