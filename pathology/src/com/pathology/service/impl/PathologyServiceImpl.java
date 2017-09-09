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
import com.pathology.util.StringUtil;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


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
  private String basicSql = "SELECT a.id_case caseId, a.pathologyno, a.patientname, a.crt_Time, a.last_upd_time last_upd_time,d.name hospitalname,"
      + "a.patientbirthday patientBirthday, a.patientsex patientSex, a.patientage patientAge, a.ageunit,"
      + "a.specimenname specimenName, a.idcard idCard, a.mobile, a.diag_time,a.retreat_reason,"
      + "a.historysummary historySummary, a.clinicdiagnose clinicDiagnose, a.inspectiondate inspectionDate,"
      + "c.generalSee, c.microscopeSee, c.result, c.diagnosed, a.memo,E.ID_COLLECTION, a.diag_status,"
      + "case a.diag_status when '1' THEN '新建' WHEN '2' then '待诊断' WHEN '3' THEN '已退回' when '7' then '已诊断' end diagStatusName,"
      + "a.specimentype, s.name specimenTypeName, a.hospitalcode, a.id_doctor "
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

      String whereStr = "";
      String newpat = request.getParameter("newpat");
      String newhospital = request.getParameter("newhospital");
      String newfromdate = request.getParameter("newfromdate");
      String newtodate = request.getParameter("newtodate");
      if (StringUtil.isNotBlank(newpat)) {
        whereStr += " and a.patientname like'%" + newpat + "%' ";
        request.setAttribute("newpat", newpat);
      }
      if (StringUtil.isNotBlank(newhospital)) {
        whereStr += " and d.name like'%" + newhospital + "%' ";
        request.setAttribute("newhospital", newhospital);
      }
      if (StringUtil.isNotBlank(newfromdate) && StringUtil.isNotBlank(newtodate)) {
        request.setAttribute("newfromdate", newfromdate);
        request.setAttribute("newtodate", newtodate);
        newfromdate = newfromdate + " 00:00:01";
        newtodate = newtodate + " 23:59:59";
        whereStr += " and a.crt_Time between'" + newfromdate + "' and '" + newtodate + "'";
      }

      String countSql = basicCountSql + " WHERE a.crt_user_id='" + name + "'" + whereStr;

      int totalNum = jdbcTemplate.queryForInt(countSql);
      if (totalNum > 0) {
        Pages page = new Pages(totalNum, "PathologyAction!getNewPathologyList", Integer.parseInt(pageNum), 10);
        String sql = basicSql + " WHERE a.crt_user_id='" + name + "'" + whereStr + " order by crt_time DESC " + page.getPageLimit();
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
   * @return 病例对象
   */
  @Override
  public Pathology updatePathology(Map<String, String[]> paramMap) {
    try {
      Pathology pathology = pathologydao.getPathology(Pathology.class, paramMap.get("caseId")[0]);
      assemblePathology(pathology, paramMap);
      updatePathology(pathology);
      resultService.update(paramMap);
      return pathology;
    } catch (Exception e) {
      logger.error(e.getMessage());
      throw new RuntimeException(e.getMessage());
    }
  }

  /**
   * 根据数据组装Pathology对象
   * <p>注意：如果是新建的Pathology对象，必须要在调用此方法后指定创建时间和创建人！</p>
   *
   * @param paramMap 数据
   * @return 对象
   */
  private Pathology assemblePathology(Pathology pathology, Map<String, String[]> paramMap) {
    try {
      pathology.setPatientname(paramMap.get("patientName")[0]); // 姓名
      pathology.setPathologyno(paramMap.get("pathologyNo")[0]); // 病理编号
      pathology.setPatientage(paramMap.get("patientAge")[0]); // 年龄
      pathology.setAgeunit(paramMap.get("ageUnit")[0]); // 年龄单位
      pathology.setPatientsex(paramMap.get("patientSex")[0]); // 性别（男/女）
      pathology.setSpecimenname(paramMap.get("specimenName")[0]); // 取材部位
      pathology.setSpecimentype(paramMap.get("specimenType")[0]); // 标本类型
      pathology.setIdcard(paramMap.get("idCard")[0]); // 身份证号
      pathology.setMobile(paramMap.get("mobile")[0]); // 手机号
      pathology.setHospitalcode(paramMap.get("hospitalCode")[0]); // 送检单位编码
      pathology.setDoctorId(paramMap.get("toDoctorId")[0]); // 送检医生
      if (!"".equals(paramMap.get("diagTime")[0])) {
        pathology.setDiagTime(Timestamp.valueOf(paramMap.get("diagTime")[0])); // 送检日期
      }
      pathology.setMemo(paramMap.get("memo")[0]); // 备注
      pathology.setClinicdiagnose(paramMap.get("clinicDiagnose")[0]); // 临床诊断
      pathology.setHistorysummary(paramMap.get("historySummary")[0]); // 病史
      // pathology.setDiagStatus("1"); // 病理初始状态
    } catch (Exception e) {
      logger.error(e.getMessage());
      throw new RuntimeException("获取基本信息数据失败，请联系管理员");
    }
    return pathology;
  }

  /**
   * 生成病例表主键
   *
   * @param length 末尾自增部分的位数
   * @return 主键
   */
  private String generateCaseId(int length) {
    length = length <= 0 ? 5 : length; // 默认为5位
    String count = "select count(1) from pathology "
        + " where DATE_FORMAT(crt_time,'%Y-%m-%d') = DATE_FORMAT('" + new java.sql.Date(new Date().getTime()) + "','%Y-%m-%d') ";
    if (jdbcTemplate.queryForInt(count) > 0) {
      String sql = "SELECT id_case "
          + " from pathology "
          + " where DATE_FORMAT(crt_time,'%Y-%m-%d') = DATE_FORMAT('" + new java.sql.Date(new Date().getTime()) + "','%Y-%m-%d') "
          + " order BY crt_time DESC limit 1 ";
      Map map = jdbcTemplate.queryForMap(sql);
      if (map.containsKey("id_case") && map.get("id_case") != null) {
        String next = String.valueOf(Integer.valueOf(((String) map.get("id_case")).substring(8)) + 1);
        int nextLength = next.length();
        for (int i = 0; i < length - nextLength; i++) {
          next = "0" + next;
        }
        return new SimpleDateFormat("yyyyMMdd").format(new Date()) + next;
      } else {
        throw new RuntimeException("获取会诊号出现错误，请联系管理员");
      }
    } else {
      String next = "1";
      for (int i = 0; i < length - 1; i++) {
        next = "0" + next;
      }
      return new SimpleDateFormat("yyyyMMdd").format(new Date()) + next;
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
      String whereStr = "";
      String needpat = request.getParameter("needpat");
      String needhospital = request.getParameter("needhospital");
      String needfromdate = request.getParameter("needfromdate");
      String needtodate = request.getParameter("needtodate");
      if (StringUtil.isNotBlank(needpat)) {
        whereStr += " and a.patientname like'%" + needpat + "%' ";
        request.setAttribute("needpat", needpat);
      }
      if (StringUtil.isNotBlank(needhospital)) {
        whereStr += " and d.name like'%" + needhospital + "%' ";
        request.setAttribute("needhospital", needhospital);
      }
      if (StringUtil.isNotBlank(needfromdate) && StringUtil.isNotBlank(needtodate)) {
        request.setAttribute("needfromdate", needfromdate);
        request.setAttribute("needtodate", needtodate);
        needfromdate = needfromdate + " 00:00:01";
        needtodate = needtodate + " 23:59:59";
        whereStr += " and a.crt_Time between'" + needfromdate + "' and '" + needtodate + "'";

      }

      String countSql = basicCountSql + " WHERE a.diag_status='2' and ifnull(a.id_doctor,'" + name + "')='" + name + "'" + whereStr;

      int totalNum = jdbcTemplate.queryForInt(countSql);
      if (totalNum > 0) {
        Pages page = new Pages(totalNum, "PathologyAction!getPathologyListToNeed", Integer.parseInt(pageNum), 10);
        String sql = basicSql + " WHERE a.diag_status='2' and ifnull(a.id_doctor,'" + name + "')='" + name + "'" + whereStr
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
  public Pathology addPathology(Map<String, String[]> paramMap) {
    // 新增病例信息
    Pathology pathology = new Pathology();
    try {
      pathology.setIdCase(generateCaseId(5)); // 会诊号（主键）
      assemblePathology(pathology, paramMap);
      paramMap.put("caseId", new String[]{pathology.getIdCase()});
      pathology.setDiagStatus("2"); // 默认新建为待诊断
      pathology.setCrtTime(new Timestamp(System.currentTimeMillis())); // 创建日期
      pathology.setCrtUserId(SessionAgentManager.getSessionAgentBean().getIdUsers()); // 创建人
      addPathology(pathology); // 新增病理信息
    } catch (Exception e) {
      logger.error(e.getMessage());
      throw new RuntimeException("新增病理数据失败，请联系管理员");
    }

    // 新增大体所见等Result数据
    try {
      resultService.insert(paramMap);
    } catch (Exception e) {
      logger.error(e.getMessage());
      throw new RuntimeException(e.getMessage());
    }

    /*// 新增病理图片信息
    try {
      if (paramMap.containsKey("slideFileName") && !"".equals(paramMap.get("slideFileName")[0])) {
        Image image = new Image();
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
    }*/
    return pathology;
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

    String whereStr = "";
    String haspat = request.getParameter("haspat");
    String hashospital = request.getParameter("hashospital");
    String hasfromdate = request.getParameter("hasfromdate");
    String hastodate = request.getParameter("hastodate");
    if (StringUtil.isNotBlank(haspat)) {
      whereStr += " and a.patientname like'%" + haspat + "%' ";
      request.setAttribute("haspat", haspat);
    }
    if (StringUtil.isNotBlank(hashospital)) {
      whereStr += " and d.name like'%" + hashospital + "%' ";
      request.setAttribute("hashospital", hashospital);
    }
    if (StringUtil.isNotBlank(hasfromdate) && StringUtil.isNotBlank(hastodate)) {
      request.setAttribute("hasfromdate", hasfromdate);
      request.setAttribute("hastodate", hastodate);
      hasfromdate = hasfromdate + " 00:00:01";
      hastodate = hastodate + " 23:59:59";
      whereStr += " and a.diag_Time between'" + hasfromdate + "' and '" + hastodate + "'";

    }

    String countSql = basicCountSql + " WHERE a.diag_status='7' and a.id_doctor='" + name + "'" + whereStr;
    try {
      int totalNum = jdbcTemplate.queryForInt(countSql);
      if (totalNum > 0) {
        Pages page = new Pages(totalNum, "PathologyAction!getPathologyListToHas", Integer.parseInt(pageNum), 10);
        String sql = basicSql + " WHERE a.diag_status='7' and a.id_doctor='" + name + "'" + whereStr + page.getPageLimit();
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

    String whereStr = "";
    String backpat = request.getParameter("backpat");
    String backhospital = request.getParameter("backhospital");
    String backfromdate = request.getParameter("backfromdate");
    String backtodate = request.getParameter("backtodate");
    if (StringUtil.isNotBlank(backpat)) {
      whereStr += " and a.patientname like'%" + backpat + "%' ";
      request.setAttribute("backpat", backpat);
    }
    if (StringUtil.isNotBlank(backhospital)) {
      whereStr += " and d.name like'%" + backhospital + "%' ";
      request.setAttribute("backhospital", backhospital);
    }
    if (StringUtil.isNotBlank(backfromdate) && StringUtil.isNotBlank(backtodate)) {
      request.setAttribute("backfromdate", backfromdate);
      request.setAttribute("backtodate", backtodate);
      backfromdate = backfromdate + " 00:00:01";
      backtodate = backtodate + " 23:59:59";
      //whereStr+=" and a.LAST_UPD_TIME between'"+backfromdate+"' and '"+backtodate+"'";
      whereStr += " and a.crt_Time between'" + backfromdate + "' and '" + backtodate + "'";

    }

    String countSql = basicCountSql + " WHERE a.diag_status='3' and a.LAST_UPD_USER_ID='" + name + "'" + whereStr;
    try {
      int totalNum = jdbcTemplate.queryForInt(countSql);
      if (totalNum > 0) {
        Pages page = new Pages(totalNum, "PathologyAction!getPathologyListToBack", Integer.parseInt(pageNum), 10);
        String sql = basicSql + " WHERE a.diag_status='3' and a.LAST_UPD_USER_ID='" + name + "'" + whereStr + page.getPageLimit();
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

  /**
   * 根据caseId删除病例信息（同时删除结果和图像表数据）
   *
   * @param id caseId
   */
  @Override
  public void delete(String id) {
    try {
      this.deletePathology(getPathology(Pathology.class, id));
      resultService.deleteByCaseId(id);
      imageService.deleteByCaseId(id);
      // TODO 要不要删除分享还有收藏什么的？
    } catch (Exception e) {
      logger.error(e.getMessage());
      throw new RuntimeException("删除出现错误，请联系管理员");
    }
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
