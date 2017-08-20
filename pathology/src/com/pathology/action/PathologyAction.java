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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
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
  private IUsersService usersService;
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
    Map<String, String[]> paramMap = request.getParameterMap();
    try {
      String slideFilePath = Property.getProperty("slideFilePath");
      if (slide != null) {
        InputStream is = new FileInputStream(getSlide()); //根据上传的文件得到输入流
        OutputStream os = new FileOutputStream(slideFilePath + "\\" + slideFileName); //指定输出流地址
        byte buffer[] = new byte[1024];
        int count;
        while ((count = is.read(buffer)) > 0) {
          os.write(buffer, 0, count); //把文件写到指定位置的文件中
        }
        os.close(); //关闭
        is.close();
        paramMap.put("slideFilePath", new String[]{slideFilePath + "\\" + slideFileName});
      }
      pathologyService.addPathology(paramMap);
    } catch (Exception e) {
      logger.error(e.getMessage());
      return "新建病理失败";
    }
    return paramMap.get("pathologyNo")[0];
  }

  /**
   * 待诊断
   *
   * @return
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
      usersList = usersService.getAllUser(Users.class, "");
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
    Map<String, String[]> paramMap = request.getParameterMap();
    descriptionAppService.insert(paramMap);
    return "保存成功";
  }

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
    String caseId = request.getParameter("caseId"); // 病理编号
    String remotePath = "/pptest"; // FTP远程文件路径
    String filename = "123.jpg"; // FTP远程文件名
    // 下载图片
    String imageSystemLocation = "localhost:8080/imagesystem";
    String download = "http://" + imageSystemLocation + "/ftp/download.do?caseuid=" + caseId
        + "&remotepath=" + remotePath + "&filename=" + filename;
    String downloadResult = HttpUtil.sendGet(download, "");
    HttpServletResponse response = ServletActionContext.getResponse();
    response.setContentType("text/html;charset=utf-8");
    PrintWriter out = response.getWriter();
    String url = "http://localhost:8080/imagesystem/show.do?filename=&id=" + caseId;
    // 组装切片数据
    SlideResult slideResult = new SlideResult("", "58112", "64000", "40", "256", "",
        "", "0", "P500B15001", url, "", "", "");
    out.println(slideResult.toString() + "$" + slideResult.toString() + "#" + slideResult.toString());
    out.flush();
    out.close();
    return SUCCESS;
  }

  /*
   * 已诊断
   */
  public String getPathologyListToBack() {
    try {
      HttpServletRequest request = ServletActionContext.getRequest();
      pathologys = pathologyService.getListPathologyToBack(request, "");
      return "pathologysback";
    } catch (Exception e) {
      e.printStackTrace();
    }
    return "pathologysback";
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

  public void setDescriptionAppList(List<DescriptionApp> descriptionAppList) {
    this.descriptionAppList = descriptionAppList;
  }

  public void setUsersList(List<Users> usersList) {
    this.usersList = usersList;
  }

  public List<Users> getUsersList() {
    return usersList;
  }

  public IUsersService getUsersService() {
    return usersService;
  }

  public void setUsersService(IUsersService usersService) {
    this.usersService = usersService;
  }

  public String getCaseId() {
    return caseId;
  }

  public void setCaseId(String caseId) {
    this.caseId = caseId;
  }
}
