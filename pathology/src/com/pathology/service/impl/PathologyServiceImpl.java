package com.pathology.service.impl;

import com.pathology.dao.IImageDao;
import com.pathology.dao.IPathologyDao;
import com.pathology.dto.PathologyDTO;
import com.pathology.entity.Image;
import com.pathology.entity.Pathology;
import com.pathology.entity.Result;
import com.pathology.entity.Users;
import com.pathology.mapping.PathologyMapping;
import com.pathology.service.IImageService;
import com.pathology.service.IPathologyService;
import com.pathology.service.IResultService;
import com.pathology.service.IUsersService;
import com.pathology.util.Pages;
import com.pathology.util.SessionAgentManager;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;


public class PathologyServiceImpl implements IPathologyService {

  private Logger logger = Logger.getLogger(PathologyServiceImpl.class);

  private IPathologyDao pathologydao;
  private IImageDao imagedao;
  private IImageService imageService;
  private IResultService resultService;
  private IUsersService userService;

  public IImageDao getImagedao() {
    return imagedao;
  }

  public void setImagedao(IImageDao imagedao) {
    this.imagedao = imagedao;
  }

  private JdbcTemplate jdbcTemplate;
  private String basicSql = "SELECT a.id_case caseId, a.pathologyno, a.patientname, a.crt_Time, d.name hospitalname,"
      + "a.patientbirthday patientBirthday, a.patientsex patientSex, a.patientage patientAge, a.ageunit,"
      + "a.specimenname specimenName, a.idcard idCard, a.mobile, a.diag_time,a.retreat_reason,"
      + "a.historysummary historySummary, a.clinicdiagnose clinicDiagnose, a.inspectiondate inspectionDate,"
      + "c.generalSee, c.microscopeSee, c.result, c.diagnosed, a.memo,E.ID_COLLECTION, a.diag_status,"
      + "case a.diag_status when '1' THEN '新建' WHEN '2' then '待诊断' when '7' then '已诊断' end diagStatusName,"
      + "a.specimentype, s.name specimenTypeName "
      + " FROM pathology a "
      + " LEFT JOIN COLLECTION E ON E.CASE_ID=A.ID_CASE AND A.ID_DOCTOR=E.ID_DOCTOR"
      + " LEFT JOIN result  c ON a.id_case = c.case_id"
      + " LEFT JOIN hospital  d ON a.hospitalcode = d.id_hospital"
      + " LEFT JOIN specimen s on a.specimentype = s.id_specimen";
  private String basicCountSql = "SELECT count(1) FROM pathology a "
      + " LEFT JOIN result  c ON a.id_case = c.case_id"
      + " LEFT JOIN hospital  d ON a.hospitalcode = d.id_hospital"
      + " LEFT JOIN COLLECTION E ON A.ID_CASE=E.CASE_ID AND A.ID_DOCTOR=E.ID_DOCTOR"
      + " LEFT JOIN specimen s on a.specimentype = s.id_specimen";

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

  /**
   * 获取新建列表
   *
   * @param request 请求
   * @param name    登录用户
   * @return 列表
   */
  @Override
  public List<PathologyDTO> getNewListPathology(HttpServletRequest request, String name) {
    try {
      String pageNum = request.getParameter("pageNum");
      pageNum = pageNum != null ? pageNum : "1";
      String title = "";
      int status = 1;
      String countSql = basicCountSql + " WHERE a.diag_status='1' and a.crt_user_id='" + name + "'";

      int totalNum = jdbcTemplate.queryForInt(countSql);
      if (totalNum > 0) {
        Pages page = new Pages(totalNum, "PathologyAction!getNewPathology", Integer.parseInt(pageNum), 10);
        String sql = basicSql + " WHERE a.diag_status='1' and a.crt_user_id='" + name + "' " + page.getPageLimit();
        request.setAttribute("page", page.getPageStr());
        return jdbcTemplate.query(sql, new PathologyMapping());
      } else {
        request.setAttribute("page", "暂无数据");
        return null;
      }
    } catch (Exception ex) {
      throw new RuntimeException("查询出现错误");
    }
  }

  /**
   * 根据前台的数据更新病例信息
   *
   * @param paramMap 数据
   */
  @Override
  public void updatePathology(Map<String, String[]> paramMap) {
    try {
      Pathology pathology = assemblePathology(paramMap);
      pathology.setIdCase(paramMap.get("caseId")[0]);
      updatePathology(pathology);
    } catch (Exception e) {
      logger.error(e.getMessage());
      throw new RuntimeException(e);
    }
  }

  /**
   * 根据数据组装Pathology对象
   *
   * @param paramMap 数据
   * @return 对象
   */
  private Pathology assemblePathology(Map<String, String[]> paramMap) {
    Pathology pathology = new Pathology();
    try {
      pathology.setIdCase(generateCaseId()); // 会诊号（主键）
      pathology.setPatientname(paramMap.get("patientName")[0]); // 姓名
      pathology.setPathologyno(paramMap.get("pathologyNo")[0]); // 病理编号
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
      pathology.setDiagStatus("1"); // 病理初始状态
      pathology.setDoctorId(SessionAgentManager.getSessionAgentBean().getIdUsers()); // 创建人
    } catch (Exception e) {
      logger.error(e.getMessage());
      throw new RuntimeException("获取基本信息数据失败，请联系管理员");
    }
    return pathology;
  }

  /**
   * 生成病例表主键
   *
   * @return 主键
   */
  private String generateCaseId() {
    String count = "select count(1) from pathology "
        + " where DATE_FORMAT(crt_time,'%Y-%m-%d') = DATE_FORMAT('" + new java.sql.Date(new Date().getTime()) + "','%Y-%m-%d') ";
    if (jdbcTemplate.queryForInt(count) > 0) {
      String sql = "SELECT id_case "
          + " from pathology "
          + " where DATE_FORMAT(crt_time,'%Y-%m-%d') = DATE_FORMAT('" + new java.sql.Date(new Date().getTime()) + "','%Y-%m-%d') "
          + " order BY crt_time DESC limit 1 ";
      Map map = jdbcTemplate.queryForMap(sql);
      if (map.containsKey("id_case") && map.get("id_case") != null) {
        String next = String.valueOf(Integer.valueOf(((String) map.get("id_case")).substring(10)) + 1);
        next = next.length() < 3 ? (next.length() == 2 ? "0" + next : "00" + next) : next;
        return "BL" + new SimpleDateFormat("yyyyMMdd").format(new Date()) + next;
      } else {
        throw new RuntimeException("获取会诊号出现错误，请联系管理员");
      }
    } else {
      return "BL" + new SimpleDateFormat("yyyyMMdd").format(new Date()) + "001";
    }
  }

  /**
   * 获取待诊断列表
   */
  public List<PathologyDTO> getListPathologyToNeed(HttpServletRequest request, String name) {
    try {
      String pageNum = request.getParameter("pageNum");
      pageNum = pageNum != null ? pageNum : "1";
      String title = "";
      int status = 1;
      String countSql = basicCountSql + " WHERE a.diag_status='2' and ifnull(a.id_doctor,'" + name + "')='" + name + "'";

      int totalNum = jdbcTemplate.queryForInt(countSql);
      if (totalNum > 0) {
        Pages page = new Pages(totalNum, "PathologyAction!getPathologyListToNeed", Integer.parseInt(pageNum), 10);
        String sql = basicSql + " WHERE a.diag_status='2' and ifnull(a.id_doctor,'" + name + "')='" + name + "'"
            + page.getPageLimit();
        request.setAttribute("page", page.getPageStr());
        return jdbcTemplate.query(sql, new PathologyMapping());
      } else {
        request.setAttribute("page", "暂无数据");
      }
      return null;
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
    Result result = new Result();
    Pathology pathology = assemblePathology(paramMap);
    if (this.getPathology(Pathology.class, pathology.getIdCase()) != null) {
      throw new RuntimeException("该会诊号已经存在");
    }
    try {
      addPathology(pathology); // 新增病理信息
    } catch (Exception e) {
      logger.error(e.getMessage());
      throw new RuntimeException("新增病理数据失败，请联系管理员");
    }
    try {
      // 大体所见等Result数据
      result.setCaseId(pathology.getIdCase());
      result.setIdResult(pathology.getIdCase());
      result.setGeneralSee(paramMap.get("generalSeeHidden")[0]); // 大体所见
      result.setMicroscopeSee(paramMap.get("microscopeSeeHidden")[0]); // 影像检查
      result.setDiagnosed(paramMap.get("firstVisit")[0]); // 初诊意见
      result.setResult(paramMap.get("immuneResult")[0]); // 免疫组化结果
    } catch (Exception e) {
      logger.error(e.getMessage());
      throw new RuntimeException("获取结果数据失败！请联系管理员");
    }
    try {
      resultService.insert(result);
    } catch (Exception e) {
      throw new RuntimeException("新增结果数据失败，请联系管理员");
    }

    try {
      // 病理图片信息
      if (paramMap.containsKey("slideFileName") && !"".equals(paramMap.get("slideFileName")[0])) {
        Image image = new Image();
        // image.setIdImage(paramMap.get("pathologyNo")[0]); // 主键自增
        image.setCaseId(pathology.getIdCase());
        Calendar cal = Calendar.getInstance();
        String year = String.valueOf(cal.get(Calendar.YEAR));
        String month = String.valueOf(cal.get(Calendar.MONTH) + 1);
        month = month.length() == 1 ? "0" + month : month;
        String day = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
        day = day.length() == 1 ? "0" + day : day;
        String datePath = "\\" + year + "\\" + month + "\\" + day;
        image.setPathImage(datePath); // 文件路径名（不包含文件名）
        paramMap.put("slideFilePath", new String[]{datePath});
        image.setFileName(paramMap.get("slideFileName")[0]); // 文件名
        image.setCrtTime(new Timestamp(new Date().getTime()));
        paramMap.put("imageId", new String[]{String.valueOf(imageService.insertImage(image))});
      }
    } catch (Exception e) {
      logger.error(e.getMessage());
      throw new RuntimeException("保存病理图片失败，请联系管理员");
    }
    return 1;
  }

  @Override
  public void finishPathology(String caseId) {
    Pathology pathology = getPathology(Pathology.class, caseId);
    if (pathology != null) {
      pathology.setDiagStatus("7");
      updatePathology(pathology);
    }
  }

  /**
   * 已诊断列表
   *
   * @param request 请求
   * @param name    当前登录用户id
   * @return 已诊断列表
   */
  public List<PathologyDTO> getListPathologyToHas(HttpServletRequest request, String name) {
    String pageNum = request.getParameter("pageNum");
    pageNum = pageNum != null ? pageNum : "1";
    String title = "";
    int status = 1;
    String countSql = basicCountSql + " WHERE a.diag_status='7' and a.id_doctor='" + name + "'";
    try {
      int totalNum = jdbcTemplate.queryForInt(countSql);
      if (totalNum > 0) {
        Pages page = new Pages(totalNum, "PathologyAction!getPathologyListToHas", Integer.parseInt(pageNum), 10);
        String sql = basicSql + " WHERE a.diag_status='7' and a.id_doctor='" + name + "'" + page.getPageLimit();
        request.setAttribute("page", page.getPageStr());
        return jdbcTemplate.query(sql, new PathologyMapping());
      } else {
        request.setAttribute("page", "暂无数据");
        return null;
      }
    } catch (Exception e) {
      logger.error(e.getMessage());
      return null;
    }
  }

  /**
   * 查看退回病理列表
   *
   * @param request 请求
   * @param name    当前登录用户id
   * @return 退回病理列表
   */
  public List<PathologyDTO> getListPathologyToBack(HttpServletRequest request, String name) {
    String pageNum = request.getParameter("pageNum");
    pageNum = pageNum != null ? pageNum : "1";
    String title = "";
    int status = 1;
    String countSql = basicCountSql + " WHERE a.diag_status='3' and a.LAST_UPD_USER_ID='" + name + "'";
    try {
      int totalNum = jdbcTemplate.queryForInt(countSql);
      if (totalNum > 0) {
        Pages page = new Pages(totalNum, "PathologyAction!getPathologyListToBack", Integer.parseInt(pageNum), 10);
        String sql = basicSql + " WHERE a.diag_status='3' and a.LAST_UPD_USER_ID='" + name + "'" + page.getPageLimit();
        request.setAttribute("page", page.getPageStr());
        return jdbcTemplate.query(sql, new PathologyMapping());
      } else {
        request.setAttribute("page", "暂无数据");
        return null;
      }
    } catch (Exception e) {
      logger.error(e.getMessage());
      return null;
    }
  }

  /**
   * 获取医生信息列表（不包含当前登录用户，不包含未审核用户）
   *
   * @return 医生信息列表
   */
  @Override
  public List<Users> selectDoctorListNoMe() {
    try {
      return userService.getAllUser(Users.class, " and userstatus = '1' and idUsers != '"
          + SessionAgentManager.getSessionAgentBean().getIdUsers() + "'");
    } catch (Exception e) {
      logger.error("获取医生信息错误");
      return null;
    }
  }

  @Override
  public void getFirstPage(HttpServletRequest request, String name) {
    // TODO Auto-generated method stub
    // int needcount=0;
//	  int hascount=0;
//	  int backcount=0;
    String needcountSql = basicCountSql + " WHERE a.diag_status='2' and ifnull(a.id_doctor,'" + name + "')='" + name + "'";
    String hascountSql = basicCountSql + " WHERE a.diag_status='7' and a.id_doctor='" + name + "'";
    String callcountSql = basicCountSql + " WHERE a.diag_status='3' and a.LAST_UPD_USER_ID='" + name + "'";
    int needcount = jdbcTemplate.queryForInt(needcountSql);
    int hascount = jdbcTemplate.queryForInt(hascountSql);
    int backcount = jdbcTemplate.queryForInt(callcountSql);
    request.setAttribute("needcount", needcount);
    request.setAttribute("hascount", hascount);
    request.setAttribute("backcount", backcount);
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

  public IUsersService getUserService() {
    return userService;
  }

  public void setUserService(IUsersService userService) {
    this.userService = userService;
  }


}
