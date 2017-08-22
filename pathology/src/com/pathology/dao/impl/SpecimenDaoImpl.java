package com.pathology.dao.impl;

import com.pathology.dao.ISpecimenDao;
import com.pathology.dao.SuperDao;
import com.pathology.entity.Specimen;

import java.util.ArrayList;
import java.util.List;

public class SpecimenDaoImpl extends SuperDao implements ISpecimenDao {

  @Override
  public List<Specimen> selectList(Class clazz, String hql) {
    List<Object> list = super.getAllObject(clazz, "");
    List<Specimen> returnList = new ArrayList<Specimen>();
    for (Object object : list) {
      Specimen specimen = (Specimen) object;
      returnList.add(specimen);
    }
    return returnList;
  }
}
