package com.pathology.action;

import com.alibaba.fastjson.JSON;
import com.pathology.dto.PathologyDTO;
import com.pathology.entity.*;
import com.pathology.service.*;
import com.pathology.util.*;
import com.sun.istack.internal.Nullable;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yi
 */
public class PathologyAction extends BaseAction {
  private final Logger logger = Logger.getLogger(PathologyAction.class);
  /**
   *
   */
  private static final long serialVersionUID = 1L;
  private IPathologyService pathologyService;
  private List<PathologyDTO> pathologys;
  private PathologyDTO pathology;
  private IHospitalService hospitalservice;
  private ISpecimenService specimenService;
  private String content;
  private IResultService resultService;
  private IImageService imageService;
  @Nullable
  private File slide;
  private String slideFileName;
  private List<Hospital> hospitalList;
  private List<Specimen> specimenList;
  private DescriptionAppService descriptionAppService; // 转诊
  private List<DescriptionApp> descriptionAppList; // 转诊信息列表
  private List<Users> usersList;
  private String caseId;

  /**
   * 保存病理
   *
   * @return
   */
  public String savePathology() {
    try {
      JSONObject obj = JSONObject.fromObject(this.content);// 将json字符串转换为json对象
      // 将json对象转换为java对象
      Result result = (Result) JSONObject.toBean(obj, Result.class);// 将建json对象转换为Person对象
      resultService.updateResult(result);
      return "true";
    } catch (Throwable e) {
      logger.error(e.getMessage());
      return null;
    }
  }

  /**
   * 保存病理信息
   *
   * @return 病理编号
   */
  public String saveInfo() {
    HttpServletRequest request = ServletActionContext.getRequest();
    HttpServletResponse response = ServletActionContext.getResponse();
    response.setContentType("text/html;charset=utf-8");
    PrintWriter out;
    Map<String, String[]> paramMap = new HashMap<>(request.getParameterMap());
    try {
      int count;
      String failure = "";
      paramMap.put("slideFileName", new String[]{slideFileName});
      try {
        count = pathologyService.addPathology(paramMap);
      } catch (RuntimeException e) {
        logger.error(e.getMessage());
        count = 0;
        failure = e.getMessage();
      } catch (Exception e) {
        logger.error(e.getMessage());
        count = 0;
        failure = "出现未知错误，请联系管理员";
      }
      String rootPath = Property.getProperty("slideFilePath");
      if (slide != null) {
        InputStream is = new FileInputStream(getSlide()); //根据上传的文件得到输入流
        if (!new File(rootPath + paramMap.get("slideFilePath")[0] + "\\"
            + paramMap.get("imageId")[0]).exists()) {
          try {
            if (!new File(rootPath + paramMap.get("slideFilePath")[0] + "\\"
                + paramMap.get("imageId")[0]).mkdirs()) {
              logger.error("error create dir");
            }
          } catch (Exception e) {
            e.printStackTrace();
          }
        }
        OutputStream os = new FileOutputStream(rootPath + paramMap.get("slideFilePath")[0] + "\\"
            + paramMap.get("imageId")[0] + "\\" + slideFileName); //指定输出流地址
        byte buffer[] = new byte[1024];
        int len;
        while ((len = is.read(buffer)) > 0) {
          os.write(buffer, 0, len); //把文件写到指定位置的文件中
        }
        os.close(); //关闭
        is.close();
        try {
          // 调用切图方法
          // imageService.cutSlide(paramMap.get("caseId")[0], paramMap.get("slideFilePath")[0], paramMap.get("slideFileName")[0]);
          SlideUtil.processImageFile(new File(rootPath + "\\"+ paramMap.get("slideFilePath")[0] + "\\"
              +  paramMap.get("imageId")[0] + "\\" + slideFileName),
              new File(rootPath + "\\" + paramMap.get("slideFilePath")[0] + "\\" + paramMap.get("imageId")[0]));
        } catch (Exception e) {
          logger.error(e.getMessage());
          count = 0;
          failure = e.getMessage();
        }
      }
      out = response.getWriter();
      String jsonString = count > 0 ? "{\"success\":\"新建病理成功\"}" : "{\"failure\":\"" + failure + "\"}";
      out.println(jsonString);
      out.flush();
      out.close();
    } catch (Exception e) {
      logger.error(e.getMessage());
      return null;
    }
    return null;
  }

  /**
   * 查看新建列表
   *
   * @return 列表数据
   */
  public String getNewPathologyList() {
    try {
      String userId = SessionAgentManager.getSessionAgentBean().getIdUsers();
      HttpServletRequest request = ServletActionContext.getRequest();
      pathologys = pathologyService.getNewListPathology(request, userId);
    } catch (Exception e) {
      logger.error(e.getMessage());
    }
    return "newPathlogy";
  }

  /**
   * 待诊断
   *
   * @return 列表数据
   */
  public String getPathologyListToNeed() {
    try {
      //获取当前登陆用户
      String userId = SessionAgentManager.getSessionAgentBean().getIdUsers();
      HttpServletRequest request = ServletActionContext.getRequest();
      pathologys = pathologyService.getListPathologyToNeed(request, userId);
      return "pathologysneed";
    } catch (Exception e) {
      e.printStackTrace();
    }
    return "pathologysneed";
  }

  /**
   * 添加及查看病理（根据状态控制是否可编辑）
   *
   * @return
   */
  public String getPathologyDto() {
    HttpServletRequest request = ServletActionContext.getRequest();
    String id = request.getParameter("id");
    if (StringUtil.isBlank(id)) {
      logger.error("缺少必要参数id,请求参数为：" + JSON.toJSONString(request.getParameterMap()));
      return Constant.ERR;
    }
    pathology = pathologyService.getPathologyByIdAndDiagStatus(id);
    return "diagReport";
  }

  /**
   * 打开更新病理界面
   *
   * @return page
   */
  public String openPathologyUpdate() {
    HttpServletRequest request = ServletActionContext.getRequest();
    String id = request.getParameter("id");
    pathology = pathologyService.getPathologyByIdAndDiagStatus(id);
    try {
      hospitalList = hospitalservice.getAllHospital(Hospital.class, "");
    } catch (Exception e) {
      e.printStackTrace();
    }
    specimenList = specimenService.selectList(Specimen.class, "");
    usersList = pathologyService.selectDoctorListNoMe();
    return "pathologyUpdate";
  }

  /**
   * 更新病理信息
   *
   * @return 结果
   */
  public String updatePathology() {
    HttpServletRequest request = ServletActionContext.getRequest();
    HttpServletResponse response = ServletActionContext.getResponse();
    Map<String, String[]> paramMap = new HashMap<>(request.getParameterMap());
    String result = "";
    try {
      pathologyService.updatePathology(paramMap);
    } catch (Exception e) {
      logger.error(e.getMessage());
      result = e.getMessage();
    }
    String jsonString = "" + result;
    printJson(response, jsonString);
    return null;
  }

  /**
   * 转诊
   *
   * @return 转诊页面
   */
  public String transferPathology() {
    HttpServletRequest request = ServletActionContext.getRequest();
    try {
      String id = request.getParameter("id");
      caseId = id;
      descriptionAppList = descriptionAppService.selectForListByCaseId(id);
      hospitalList = hospitalservice.getAllHospital(Hospital.class, "");
      usersList = pathologyService.selectDoctorListNoMe();
    } catch (Exception e) {
      logger.error(e.getMessage());
    }
    return "transferPathology";
  }

  /**
   * 保存转诊信息
   *
   * @return 结果
   */
  public String saveTransferDiag() {
    HttpServletRequest request = ServletActionContext.getRequest();
    HttpServletResponse response = ServletActionContext.getResponse();
    response.setContentType("text/html;charset=UTF-8");
    Map<String, String[]> paramMap = request.getParameterMap();
    String result = "";
    try {
      descriptionAppService.insert(paramMap);
      result = "保存成功";
    } catch (Exception e) {
      logger.error(e.getMessage());
    }
    String jsonString = !"".equals(result) ? "{\"success\":\"保存成功\"}" : "{\"failure\":\"保存失败\"}";
    printJson(response, jsonString);
    return "保存成功";
  }

  /**
   * 已诊断查询
   *
   * @return 已诊断结果列表
   */
  public String getPathologyListToHas() {
    try {
      //获取当前登陆用户
      if (!SessionAgentManager.islogin())
        return Constant.ERR;
      String userId = SessionAgentManager.getSessionAgentBean().getIdUsers();
      HttpServletRequest request = ServletActionContext.getRequest();
      pathologys = pathologyService.getListPathologyToHas(request, userId);
      return "pathologyshas";
    } catch (Exception e) {
      e.printStackTrace();
    }
    return "pathologyshas";
  }

  /**
   * 打开新建界面
   *
   * @return 新建页面
   */
  public String addPathology() {
    HttpServletRequest request = ServletActionContext.getRequest();
    try {
      hospitalList = hospitalservice.getAllHospital(Hospital.class, "");
      specimenList = specimenService.selectList(Specimen.class, "");
      usersList = pathologyService.selectDoctorListNoMe();
    } catch (Exception e) {
      logger.error(e.getMessage());
    }
    return "addPathology";
  }

  /**
   * 查看切片
   *
   * @return 查询切片信息
   * @throws IOException IO
   */
  public String OpenSlideHandler() throws IOException {
    HttpServletRequest request = ServletActionContext.getRequest();
    String imageId = request.getParameter("caseId"); // 图片编号
    // TODO 判断是否已经切片
    HttpServletResponse response = ServletActionContext.getResponse();
    response.setContentType("text/html;charset=utf-8");
    PrintWriter out = response.getWriter();
    String url;
    Image image = imageService.select(Integer.valueOf(imageId));
    url = "http://" + Property.getProperty("slideImageSystem") + "/show.do?filename=&id=" + imageId;
    // 组装切片数据
    SlideResult slideResult = new SlideResult("", String.valueOf(image.getWidth()), String.valueOf(image.getHeight()),
        "80", "256", "",
        "", "0", "P500B15001", url, "", "", "");
    out.println(slideResult.toString() + "$" + slideResult.toString());
    out.flush();
    out.close();
    return SUCCESS;
  }

  public void getSlideImage() {
    HttpServletRequest request = ServletActionContext.getRequest();
    HttpServletResponse response = ServletActionContext.getResponse();
    String imageId = request.getParameter("id");
    String[] position = request.getParameter("position").split("/");
    int level = Integer.valueOf(position[0]);
    try {
      Image image = imageService.select(Integer.valueOf(imageId));
      File file = new File(Property.getProperty("slideFilePath") + image.getPathImage() + "\\" + imageId + "\\" + level + "\\" + position[1]);

      if (!file.exists()) return;
      FileInputStream fis;
      OutputStream out = response.getOutputStream();
      fis = new FileInputStream(file);
      byte[] b = new byte[fis.available()];
      fis.read(b);
      out.write(b);
      out.flush();
    } catch (Exception e) {
      logger.error(e.getMessage());
    }
  }

  /**
   * 获取缩略图切片
   */
  public void getThumbnailSlide() {
    HttpServletRequest request = ServletActionContext.getRequest();
    HttpServletResponse response = ServletActionContext.getResponse();
    String imageId = request.getParameter("id");
    try {
      Image image = imageService.select(Integer.valueOf(imageId));
      File file = new File(Property.getProperty("slideFilePath") + "\\"
          + image.getPath().substring(0, image.getPath().lastIndexOf("\\") + 1) + String.valueOf(image.getIdImage())
          + "\\" + "thumb_" + image.getFileName());
      if (!file.exists()) return;
      FileInputStream fis;
      OutputStream out = response.getOutputStream();
      fis = new FileInputStream(file);
      byte[] b = new byte[fis.available()];
      fis.read(b);
      out.write(b);
      out.flush();
    } catch (Exception e) {
      logger.error(e.getMessage());
    }
  }

  public String getPathologyListToBack() {
    try {
      String userId = SessionAgentManager.getSessionAgentBean().getIdUsers();
      HttpServletRequest request = ServletActionContext.getRequest();
      pathologys = pathologyService.getListPathologyToBack(request, userId);
      return "pathologysback";
    } catch (Exception e) {
      e.printStackTrace();
    }
    return "pathologysback";
  }

  /**
   * 更新病理结果，并转移到已诊断
   *
   * @return 更新结果
   */
  public String updateResult() {
    HttpServletRequest request = ServletActionContext.getRequest();
    HttpServletResponse response = ServletActionContext.getResponse();
    response.setContentType("text/html;charset=UTF-8");
    Map<String, String[]> paramMap = request.getParameterMap();
    String result = "";
    try {
      resultService.updateResult(paramMap);
      pathologyService.finishPathology(paramMap.get("caseId")[0]);
      result = "保存成功";
    } catch (Exception e) {
      logger.error(e.getMessage());
    }
    String jsonString = !"".equals(result) ? "{\"success\":\"保存成功\"}" : "{\"failure\":\"保存失败\"}";
    printJson(response, jsonString);
    return "保存成功";
  }

  /**
   * 诊断报告页面显示病理图片
   *
   * @return null
   */
  public String showDiagImage() {
    HttpServletRequest request = ServletActionContext.getRequest();
    HttpServletResponse response = ServletActionContext.getResponse();
    String imageId = request.getParameter("imageId");
    String filePath = request.getParameter("filePath");
    String fileName = request.getParameter("name");
    ServletOutputStream out;
    FileInputStream ips;
    try {
      // 获取图片存放路径
      String imgPath = Property.getProperty("slideFilePath") + filePath + "\\" + imageId + "\\thumb_" + fileName;
      ips = new FileInputStream(new File(imgPath));
      response.setContentType("multipart/form-data");
      out = response.getOutputStream();
      // 读取文件流
      int len;
      byte[] buffer = new byte[1024 * 10];
      while ((len = ips.read(buffer)) != -1) {
        out.write(buffer, 0, len);
      }
      out.flush();
      out.close();
      ips.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  /**
   * 病例退回
   *
   * @return 显示的界面
   */
  public String updateRetreatReason() {
    try {
      Pathology pathTodo = pathologyService.getPathology(Pathology.class, pathology.getCaseId());
      if (pathTodo == null) {
        return Constant.ERR;
      }
      String userId = SessionAgentManager.getSessionAgentBean().getIdUsers();
      pathTodo.setLastUpdUserId(userId);//更新退回人为当前登录用户
      pathTodo.setDiagStatus("3");
      if (pathology.getRetreatReason() != null) {
        pathTodo.setRetreatReason(pathology.getRetreatReason());
      }
      pathologyService.updatePathology(pathTodo);
    } catch (Exception e) {
      return Constant.ERR;
    }
    return "pathologysneed1";
  }

  /**
   * 首页需要显示的数据条数
   */
  public String getFirstPage() {
    String userId;
    try {
      userId = SessionAgentManager.getSessionAgentBean().getIdUsers();
      HttpServletRequest request = ServletActionContext.getRequest();
      pathologyService.getFirstPage(request, userId);
      return "getFirstPage";
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      return "err";
    }

  }

  public IPathologyService getPathologyService() {
    return pathologyService;
  }

  public void setPathologyService(IPathologyService shareService) {
    this.pathologyService = shareService;
  }

  public List<PathologyDTO> getPathologys() {
    return pathologys;
  }

  public void setPathologys(List<PathologyDTO> pathologys) {
    this.pathologys = pathologys;
  }

  public PathologyDTO getPathology() {
    return pathology;
  }

  public void setPathology(PathologyDTO pathology) {
    this.pathology = pathology;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public IResultService getResultService() {
    return resultService;
  }

  public void setResultService(IResultService resultService) {
    this.resultService = resultService;
  }

  public File getSlide() {
    return slide;
  }

  public void setSlide(File slide) {
    this.slide = slide;
  }

  public String getSlideFileName() {
    return slideFileName;
  }

  public void setSlideFileName(String slideFileName) {
    this.slideFileName = slideFileName;
  }

  public List<Hospital> getHospitalList() {
    return hospitalList;
  }

  public void setHospitalList(List<Hospital> hospitalList) {
    this.hospitalList = hospitalList;
  }

  public void setHospitalservice(IHospitalService hospitalservice) {
    this.hospitalservice = hospitalservice;
  }

  public void setSpecimenService(ISpecimenService specimenService) {
    this.specimenService = specimenService;
  }

  public List<Specimen> getSpecimenList() {
    return specimenList;
  }

  public void setSpecimenList(List<Specimen> specimenList) {
    this.specimenList = specimenList;
  }

  public void setDescriptionAppService(DescriptionAppService descriptionAppService) {
    this.descriptionAppService = descriptionAppService;
  }

  public List<DescriptionApp> getDescriptionAppList() {
    return descriptionAppList;
  }

  public void setDescriptionAppList(List<DescriptionApp> descriptionAppList) {
    this.descriptionAppList = descriptionAppList;
  }

  public void setUsersList(List<Users> usersList) {
    this.usersList = usersList;
  }

  public List<Users> getUsersList() {
    return usersList;
  }

  public String getCaseId() {
    return caseId;
  }

  public void setCaseId(String caseId) {
    this.caseId = caseId;
  }

  public IImageService getImageService() {
    return imageService;
  }

  public void setImageService(IImageService imageService) {
    this.imageService = imageService;
  }
}
