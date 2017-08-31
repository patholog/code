package com.pathology.service;

import com.pathology.entity.Image;

import java.util.List;

public interface IImageService {

  Integer insertImage(Image image);

  String cutSlide(String caseId, String filePath, String fileName);

  Image select(Integer imageId);
}
