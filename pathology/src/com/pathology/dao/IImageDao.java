package com.pathology.dao;

import java.util.List;

import com.pathology.entity.Image;

public interface IImageDao {

  List<Object> getByPage(int index, Class clazz, String hql);

  List<Object> getAllImage(Class clazz, String hql);

  List<Image> getImages(Class clazz, String id);

  Integer insertImage(Image image);

  Image select(Integer imageId);

  void delete(Image image);
}
