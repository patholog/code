package com.pathology.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.SessionFactory;

import com.pathology.dao.IShareDao;
import com.pathology.dao.SuperDao;
import com.pathology.entity.Share;

public class ShareDaoImpl extends SuperDao implements IShareDao {

  private SessionFactory osessionFactory;


  public SessionFactory getOsessionFactory() {
    return osessionFactory;
  }


  public void setOsessionFactory(SessionFactory sessionFactory) {
    super.setSessionFactory(sessionFactory);
  }


  public List<Object> getByPage(int index, Class clazz, String hql) {
    return super.selectPage(index, clazz, hql);
  }


  public List<Object> getAllShare(Class clazz, String hql) {
    return super.getAllObject(clazz, hql);
  }


  public void deleteShare(Share em) {
    super.delete(em);
  }

  public Share getShare(Class clazz, Integer id) {
    Map<String, Object> param = new HashMap<String, Object>();
    param.put("idShare", id);
    return (Share) super.findUniqueByClz(Share.class, param);
  }

  public void updateShare(Share em) {
    super.update(em);
  }

  @Override
  public Integer addShare(Share em) {
    return (Integer) super.add(em);
  }


}
