package com.pathology.service.impl;

import com.pathology.dao.IImageDao;
import com.pathology.entity.Image;
import com.pathology.service.IImageService;

public class ImageServiceImpl implements IImageService {

  private IImageDao imageDao;
  @Override
  public void insertImage(Image image) {
    imageDao.insertImage(image);
  }

  public IImageDao getImageDao() {
    return imageDao;
  }

  public void setImageDao(IImageDao imageDao) {
    this.imageDao = imageDao;
  }
}
