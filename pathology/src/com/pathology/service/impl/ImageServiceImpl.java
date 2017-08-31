package com.pathology.service.impl;

import com.pathology.dao.IImageDao;
import com.pathology.entity.Image;
import com.pathology.service.IImageService;
import com.pathology.util.HttpUtil;
import com.pathology.util.Property;
import org.apache.log4j.Logger;

public class ImageServiceImpl implements IImageService {

  private Logger logger = Logger.getLogger(ImageServiceImpl.class);

  private IImageDao imageDao;

  @Override
  public Integer insertImage(Image image) {
    return imageDao.insertImage(image);
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
   * @param imageId iamge id
   * @return Image
   */
  @Override
  public Image select(Integer imageId) {
    return imageDao.select(imageId);
  }

  public IImageDao getImageDao() {
    return imageDao;
  }

  public void setImageDao(IImageDao imageDao) {
    this.imageDao = imageDao;
  }
}
