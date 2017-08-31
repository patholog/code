package com.pathology.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.SessionFactory;

import com.pathology.dao.IImageDao;
import com.pathology.dao.SuperDao;
import com.pathology.entity.Image;

public class ImageDaoImpl extends SuperDao implements IImageDao {

  private SessionFactory osessionFactory;


  public SessionFactory getOsessionFactory() {
    return osessionFactory;
  }

  public void setOsessionFactory(SessionFactory sessionFactory) {
    super.setSessionFactory(sessionFactory);
  }

  @Override
  public List<Object> getByPage(int index, Class clazz, String hql) {
    return super.selectPage(index, clazz, hql);
  }

  @Override
  public List<Object> getAllImage(Class clazz, String hql) {
    return super.getAllObject(clazz, hql);
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<Image> getImages(Class clazz, String id) {
    Map<String, Object> param = new HashMap<String, Object>();
    param.put("case_id", id);
    return (List<Image>) super.findByClz(Image.class, param);
  }

  @Override
  public Integer insertImage(Image image) {
    return (Integer) super.add(image);
  }

  /**
   * 根据imageId查询Image
   *
   * @param imageId 主键
   * @return Image
   */
  @Override
  public Image select(Integer imageId) {
    return (Image) super.select(Image.class, imageId);
  }
}
