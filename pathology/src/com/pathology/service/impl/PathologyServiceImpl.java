package com.pathology.service.impl;

import com.pathology.dao.IImageDao;
import com.pathology.dao.IPathologyDao;
import com.pathology.dto.PathologyDTO;
import com.pathology.entity.Image;
import com.pathology.entity.Pathology;
import com.pathology.entity.Result;
import com.pathology.mapping.PathologyMapping;
import com.pathology.service.IImageService;
import com.pathology.service.IPathologyService;
import com.pathology.service.IResultService;
import com.pathology.util.Pages;
import com.pathology.util.SessionAgentManager;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class PathologyServiceImpl implements IPathologyService {

  private IPathologyDao pathologydao;
  private IImageDao imagedao;
  private IImageService imageService;
  private IResultService resultService;

  public IImageDao getImagedao() {
    return imagedao;
  }

  public void setImagedao(IImageDao imagedao) {
    this.imagedao = imagedao;
  }

  private JdbcTemplate jdbcTemplate;
  private String basicSql = "SELECT a.id_case caseId, a.pathologyno, a.patientname, a.crt_Time, d.name hospitalname,"
      + "a.patientbirthday patientBirthday, a.patientsex patientSex, a.patientage patientAge,"
      + "a.specimenname specimenName, a.idcard idCard, a.mobile, a.diag_time,"
      + "a.historysummary historySummary, a.clinicdiagnose clinicDiagnose, a.inspectiondate inspectionDate,"
      + "c.generalSee, c.microscopeSee, a.memo,E.ID_COLLECTION"
      + " FROM pathology a "
      + " LEFT JOIN COLLECTION E ON E.CASE_ID=A.ID_CASE AND A.ID_DOCTOR=E.ID_DOCTOR"
      + " LEFT JOIN result  c ON a.id_case = c.case_id"
      + " LEFT JOIN hospital  d ON a.hospitalcode = d.id_hospital";
  private String basicCountSql = "SELECT count(1) FROM pathology a "
      + " LEFT JOIN result  c ON a.id_case = c.case_id"
      + " LEFT JOIN hospital  d ON a.hospitalcode = d.id_hospital"
      + " LEFT JOIN COLLECTION E ON A.ID_CASE=E.CASE_ID AND A.ID_DOCTOR=E.ID_DOCTOR";

  public JdbcTemplate getJdbcTemplate() {
    return jdbcTemplate;
  }

  public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  public IPathologyDao getPathologydao() {
    return pathologydao;
  }

  public void setPathologydao(IPathologyDao udao) {
    this.pathologydao = udao;
  }

  public List<Pathology> getByPage(int index, Class clazz, String hql) {

    List<Object> list = pathologydao.getByPage(index, clazz, hql);
    return this.obj2Empl(list);
  }

  public List<Pathology> getAllPathology(Class clazz, String hql) {
    return this.obj2Empl(pathologydao.getAllPathology(clazz, hql));
  }

  public void deletePathology(Pathology em) {
    if (em != null)
      pathologydao.deletePathology(em);
  }

  /*
   * 获取待诊断列表
   */
  public List<PathologyDTO> getListPathologyToNeed(HttpServletRequest request, String name) {
    try {
      String pageNum = request.getParameter("pageNum");
      pageNum = pageNum != null ? pageNum : "1";
      String title = "";
      int status = 1;
      String sql = basicSql + " WHERE a.diag_status='2' and a.id_doctor='" + name + "'";
      String countSql = basicCountSql + " WHERE a.diag_status='2' and a.id_doctor='" + name + "'";

      int totalNum = jdbcTemplate.queryForInt(countSql);
      if (totalNum > 0) {
        Pages page = new Pages(totalNum, "listAskonlineForm", Integer.parseInt(pageNum), 10);
        request.setAttribute("page", page.getPageStr());
      }
      return jdbcTemplate.query(sql, new PathologyMapping());
    } catch (Exception ex) {
      throw new RuntimeException("查询出现错误");
    }

  }

  @Override
  public PathologyDTO getPathologyByIdAndDiagStatus(String caseId) {
    try {
//    	//获取当前登陆用户
//    	String userId=SessionAgentManager.getSessionAgentBean().getIdUsers();
      String sql = basicSql + " WHERE a.id_case = '" + caseId + "'";
      PathologyDTO pathologyDto = (PathologyDTO) jdbcTemplate.queryForObject(sql, new PathologyMapping());
      if (pathologyDto == null)
        return null;
      List<Image> lst = imagedao.getImages(Image.class, pathologyDto.getCaseId());
      pathologyDto.setImages(lst);
      return pathologyDto;
    } catch (Exception e) {
      throw new RuntimeException("查询出现错误");
    }
  }

  /**
   * 新建病理信息
   *
   * @param paramMap 表单数据
   */
  @Override
  public int addPathology(Map<String, String[]> paramMap) {
    try {
      Pathology pathology = new Pathology();
      pathology.setPatientname(paramMap.get("patientName")[0]); // 姓名
      pathology.setPathologyno(paramMap.get("pathologyNo")[0]); // 病理编号
      pathology.setIdCase(paramMap.get("caseId")[0]); // 会诊号（主键）
      pathology.setPatientage(paramMap.get("patientAge")[0]); // 年龄
      pathology.setAgeunit(paramMap.get("ageUnit")[0]); // 年龄单位
      pathology.setPatientsex(paramMap.get("patientSex")[0]); // 性别（男/女）
      pathology.setSpecimenname(paramMap.get("specimenName")[0]); // 取材部位
      pathology.setSpecimentype(paramMap.get("specimenType")[0]); // 标本类型
      pathology.setIdcard(paramMap.get("idCard")[0]); // 身份证号
      pathology.setMobile(paramMap.get("mobile")[0]); // 手机号
      pathology.setHospitalcode(paramMap.get("hospitalCodeHidden")[0]); // 送检单位编码
      if (!"".equals(paramMap.get("diagTime")[0])) {
        pathology.setDiagTime(Timestamp.valueOf(paramMap.get("diagTime")[0])); // 送检日期
      }
      pathology.setMemo(paramMap.get("memo")[0]); // 备注
      pathology.setCrtTime(new Timestamp(System.currentTimeMillis())); // 创建日期
      pathology.setClinicdiagnose(paramMap.get("clinicDiagnose")[0]); // 临床诊断
      pathology.setHistorysummary(paramMap.get("historySummary")[0]); // 病史
      pathology.setCrtUserId(SessionAgentManager.getSessionAgentBean().getIdUsers()); // 创建人
      pathology.setDiagStatus("2"); // 病理初始状态
      pathology.setDoctorId(SessionAgentManager.getSessionAgentBean().getIdUsers()); // 创建人
      addPathology(pathology); // 新增病理信息
      if ((paramMap.containsKey("generalSeeHidden") && !"".equals(paramMap.get("generalSeeHidden")[0]))
          || (paramMap.containsKey("microscopeSeeHidden") && !"".equals(paramMap.get("microscopeSeeHidden")[0]))) {
        // 大体所见等Result数据
        Result result = new Result();
        result.setCaseId(paramMap.get("caseId")[0]);
        result.setIdResult(paramMap.get("caseId")[0]);
        result.setGeneralSee(paramMap.get("generalSeeHidden")[0]); // 大体所见
        result.setMicroscopeSee(paramMap.get("microscopeSeeHidden")[0]); // 影像检查
        result.setDiagnosed(paramMap.get("firstVisit")[0]); // 初诊意见
        result.setResult(paramMap.get("immuneResult")[0]); // 免疫组化结果
        resultService.insert(result);
      }
      if (paramMap.containsKey("slideFilePath") && !"".equals(paramMap.get("slideFilePath")[0])) {
        Image image = new Image();
        image.setIdImage(paramMap.get("pathologyNo")[0]);
        image.setCaseId(paramMap.get("pathologyNo")[0]);
        image.setPathImage(paramMap.get("slideFilePath")[0]);
        imageService.insertImage(image);
      }
      return 1;
    } catch (Exception e) {
      Logger.getLogger(PathologyServiceImpl.class).error(e.getMessage());
      return 0;
    }
  }

  public List<PathologyDTO> getListPathologyToHas(HttpServletRequest request, String name) {

    String pageNum = request.getParameter("pageNum");
    pageNum = pageNum != null ? pageNum : "1";
    String title = "";
    int status = 1;
    String sql = basicSql + " WHERE a.diag_status='7' and a.id_doctor='" + name + "'";
    String countSql = basicCountSql + " WHERE a.diag_status='7' and a.id_doctor='" + name + "'";

    int totalNum = jdbcTemplate.queryForInt(countSql);
    if (totalNum > 0) {
      Pages page = new Pages(totalNum, "listAskonlineForm", Integer.parseInt(pageNum), 10);
      request.setAttribute("page", page.getPageStr());
    }
    return jdbcTemplate.query(sql, new PathologyMapping());

  }

  public List<PathologyDTO> getListPathologyToBack(HttpServletRequest request, String name) {
    String pageNum = request.getParameter("pageNum");
    pageNum = pageNum != null ? pageNum : "1";
    String title = "";
    int status = 1;
    String sql = basicSql + " WHERE a.diag_status='3'";
    String countSql = basicCountSql + " WHERE a.diag_status='3'";
    int totalNum = jdbcTemplate.queryForInt(countSql);
    if (totalNum > 0) {
      Pages page = new Pages(totalNum, "listAskonlineForm", Integer.parseInt(pageNum), 10);
      request.setAttribute("page", page.getPageStr());
    }
    List<PathologyDTO> ss = (List<PathologyDTO>) jdbcTemplate.query(sql, new PathologyMapping());
    return jdbcTemplate.query(sql, new PathologyMapping());
  }

  public Pathology getPathology(Class clazz, String id) {
    return pathologydao.getPathology(clazz, id);
  }

  public void updatePathology(Pathology em) {
    pathologydao.updatePathology(em);
  }

  public void addPathology(Pathology em) {
    pathologydao.addPathology(em);
  }

  public List<Pathology> obj2Empl(List<Object> list) {
    List<Pathology> elist = new ArrayList<Pathology>();
    for (Object obj : list) {
      Pathology em = (Pathology) obj;
      elist.add(em);
    }
    return elist;
  }

  public IImageService getImageService() {
    return imageService;
  }

  public void setImageService(IImageService imageService) {
    this.imageService = imageService;
  }

  public void setResultService(IResultService resultService) {
    this.resultService = resultService;
  }
}
