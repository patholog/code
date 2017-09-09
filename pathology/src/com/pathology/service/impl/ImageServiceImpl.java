package com.pathology.service.impl;

import com.pathology.dao.IImageDao;
import com.pathology.entity.Image;
import com.pathology.service.IImageService;
import com.pathology.util.HttpUtil;
import com.pathology.util.Property;
import com.pathology.util.SlideUtil;
import org.apache.log4j.Logger;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ImageServiceImpl implements IImageService {

  private Logger logger = Logger.getLogger(ImageServiceImpl.class);

  private IImageDao imageDao;

  @Override
  public Integer insertImage(Image image) {
    return imageDao.insertImage(image);
  }

  @Override
  public void insertImage(String caseId, String filePath) {
    String rootPath = Property.getProperty("slideFilePath");
    File file = new File(rootPath + filePath);
    Image image = new Image();
    image.setCaseId(caseId);
    image.setPathImage(filePath);
    image.setPath(filePath.substring(0, filePath.lastIndexOf(caseId) - 1));
    image.setFileName(filePath.substring(filePath.lastIndexOf("\\") + 1));
    image.setCrtTime(new Timestamp(new Date().getTime()));
    try {
      BufferedImage bufferedImage = SlideUtil.loadImage(file);
      image.setWidth(bufferedImage.getWidth());
      image.setHeight(bufferedImage.getHeight());
    } catch (IOException e) {
      logger.error(e.getMessage());
    }
    int imageId = insertImage(image);
    String datePath = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
    try {
      SlideUtil.processImageFile(new File(rootPath + filePath), new File(Property.getProperty("slideFilePath") + "\\" + datePath + "\\"
          + imageId));
    } catch (IOException e) {
      logger.error(e.getMessage());
    }
  }

  /**
   * 调用切图方法
   *
   * @param caseId case id
   * @param filePath 文件路径名（包含文件名）
   * @param fileName 文件名
   * @return 结果
   */
  @Override
  public String cutSlide(String caseId, String filePath, String fileName) {
    if (!"".equals(caseId) && !"".equals(fileName)) {
      filePath = "".equals(filePath) ? filePath : filePath.substring(0, filePath.lastIndexOf("\\"));
      String imageSystemLocation = Property.getProperty("slideImageSystem");
      String download = "http://" + imageSystemLocation + "/local/upload.do?caseuid=" + caseId
          + "&path=" + filePath + "&filename=" + fileName;
      String downloadResult = HttpUtil.sendGet(download, "");
      logger.error(downloadResult);
    }
    return null;
  }

  /**
   * 根据主键查询
   *
   * @param imageId image id
   * @return Image
   */
  @Override
  public Image select(Integer imageId) {
    return imageDao.select(imageId);
  }

  /**
   * 根据caseId查询Image列表
   *
   * @param caseId 病理号
   * @return Image列表
   */
  @Override
  public List<Image> selectListByCaseId(String caseId) {
    List<Object> objectList = imageDao.getAllImage(Image.class, " and caseId = '" + caseId + "'");
    List<Image> imageList = new ArrayList<>();
    for (Object object : objectList) {
      imageList.add((Image) object);
    }
    return imageList;
  }

  @Override
  public void deleteByCaseId(String caseId) {
    List<Image> imageList = selectListByCaseId(caseId);
    for (Image image : imageList) {
      imageDao.delete(image);
    }
  }

  @Override
  public void delete(Integer imageId) {
    imageDao.delete(select(imageId));
  }

  public IImageDao getImageDao() {
    return imageDao;
  }

  public void setImageDao(IImageDao imageDao) {
    this.imageDao = imageDao;
  }
}
