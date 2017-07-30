package com.pathology.action;

import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.pathology.dto.CollectionDTO;
import com.pathology.entity.Collection;
import com.pathology.entity.Pathology;
import com.pathology.service.ICollectionService;
import com.pathology.util.Constant;
import com.pathology.util.RandomNumbers;
import com.pathology.util.SessionAgentManager;

import net.sf.json.JSONObject;

public class CollectionAction extends BaseAction {

  /**
   *
   */
  private static final long serialVersionUID = 1L;
  private final Logger logger = Logger.getLogger(CollectionAction.class);
  public ICollectionService collectionService;
  private List<CollectionDTO> collections;
  private CollectionDTO collection;

  public String getCollectionList() {
    try {

      if (!SessionAgentManager.islogin())
        return Constant.ERR;
      HttpServletRequest request = ServletActionContext.getRequest();

      collections = collectionService.getListCollection(request, "");

      return "collections";
    } catch (Exception e) {
      logger.error(e.getMessage());
      return Constant.ERR;
    }
  }

  public String deleteCollection() {
    try {

      if (!SessionAgentManager.islogin())
        return Constant.ERR;
      Collection hos = collectionService.getCollection(Collection.class,
          collection.getCollectionId());
      collectionService.deleteCollection(hos);
      return "deletesuccess";
    } catch (Exception e) {
      logger.error(e.getMessage());
      return Constant.ERR;
    }
  }

  public String saveCollection() {
    try {
      if (!SessionAgentManager.islogin()) {
        return Constant.ERR;
      }
      JSONObject obj = JSONObject.fromObject(this.collectionDo);// 将json字符串转换为json对象
      // 将json对象转换为java对象
      Collection jb = (Collection) JSONObject.toBean(obj, Collection.class);// 将建json对象转换为Person对象
      jb.setCollectionerId(SessionAgentManager.getSessionAgentBean().getIdUsers());
      jb.setDoctorId(SessionAgentManager.getSessionAgentBean().getIdUsers());
      Timestamp d = new Timestamp(System.currentTimeMillis());
      //收藏时间
      jb.setCollectionTime(d);
      //主键ID
      jb.setIdCollection(RandomNumbers.getEandomId(20));
      collectionService.addCollection(jb);
      return Constant.SUCCESS;
    } catch (Throwable ex) {
      logger.error(ex.getMessage());
      return Constant.ERR;
    }
  }

  public CollectionDTO getCollection() {
    return collection;
  }

  public void setCollection(CollectionDTO collection) {
    this.collection = collection;
  }

  public ICollectionService getCollectionService() {
    return collectionService;
  }

  public void setCollectionService(ICollectionService collectionService) {
    this.collectionService = collectionService;
  }

  public List<CollectionDTO> getCollections() {
    return collections;
  }

  public void setCollections(List<CollectionDTO> collections) {
    this.collections = collections;
  }

  private String collectionDo;

  public String getCollectionDo() {
    return collectionDo;
  }

  public void setCollectionDo(String collectionDo) {
    this.collectionDo = collectionDo;
  }
}
