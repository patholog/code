package com.pathology.service.impl;

import com.pathology.dao.IShareDao;
import com.pathology.dto.ShareDTO;
import com.pathology.entity.Share;
import com.pathology.mapping.ShareMapping;
import com.pathology.service.IShareService;
import com.pathology.util.Pages;
import com.pathology.util.RandomNumbers;
import com.pathology.util.SessionAgentManager;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


public class ShareServiceImpl implements IShareService {

  private Logger logger = Logger.getLogger(ShareServiceImpl.class);

  private IShareDao sharedao;

  private JdbcTemplate jdbcTemplate;

  public JdbcTemplate getJdbcTemplate() {
    return jdbcTemplate;
  }

  public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  public IShareDao getSharedao() {
    return sharedao;
  }

  public void setSharedao(IShareDao udao) {
    this.sharedao = udao;
  }

  public List<Share> getByPage(int index, Class clazz, String hql) throws Exception {

    List<Object> list = sharedao.getByPage(index, clazz, hql);
    return this.obj2Empl(list);
  }

  public List<Share> getAllShare(Class clazz, String hql) throws Exception {
    return this.obj2Empl(sharedao.getAllShare(clazz, hql));
  }

  public void deleteShare(Share em) throws Exception {
    if (em != null) {
      sharedao.deleteShare(em);
    }
  }

  /**
   * 删除分享（设置del_f为2）
   *
   * @param shareId share id
   */
  public void deleteShare(Integer shareId) {
    if (shareId > 0) {
      try {
        Share share = getShare(Share.class, shareId);
        share.setDelF(2);
        updateShare(share);
      } catch (Exception e) {
        logger.error(e.getMessage());
        throw new RuntimeException(e);
      }
    }
  }


  public List<ShareDTO> getListShare(HttpServletRequest request, String name) throws Exception {
    String pageNum = request.getParameter("pageNum");
    pageNum = pageNum != null ? pageNum : "1";
    String title = "";
    int status = 1;
    String sqlcount = " select count(1) from share a "
        + " INNER join pathology b on a.case_id = b.id_case "
        + " left join users c on a.doctorId = c.id_users "
        + " where ifnull(a.del_f, 1) = 1";
    try {
      int totalNum = jdbcTemplate.queryForInt(sqlcount);
      if (totalNum > 0) {
        Pages page = new Pages(totalNum, "ShareAction!getShareList", Integer.parseInt(pageNum), 10);
        String sql = " select a.case_Id case_id, a.id_share, b.patientname, a.DoctorId, c.username, a.type, a.shareTime,"
            + " case a.type when '0' then '公开的' else '私有的' END type_name, a.end_time, a.shareUrl, a.sharePsd, a.sid "
            + " from share a "
            + " INNER join pathology b on a.case_id = b.id_case "
            + " left join users c on a.doctorId = c.id_users "
            + " where ifnull(a.del_f, 1) = 1"
            + page.getPageLimit();
        request.setAttribute("page", page.getPageStr());
        return (List<ShareDTO>) jdbcTemplate.query(sql, new ShareMapping());
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
   * 通过sid获取Share数据
   *
   * @param sid sid
   * @return Share对象
   */
  @Override
  public Share selectBySid(String sid) {
    try {
      List<Share> shareList = getAllShare(Share.class, " and sid = '" + sid + "'");
      return shareList.get(0);
    } catch (Exception e) {
      logger.error(e.getMessage());
      return null;
    }
  }

  @Override
  public Share getShare(Class clazz, Integer id) throws Exception {
    return sharedao.getShare(clazz, id);
  }

  public void updateShare(Share em) throws Exception {

    sharedao.updateShare(em);

  }

  public void addShare(Share em) throws Exception {

    sharedao.addShare(em);
  }

  @Override
  public Integer insert(Map<String, String[]> paramMap) {
    try {
      Share share = new Share();
      share.setCaseId(paramMap.get("caseId")[0]);
      share.setType(paramMap.get("type")[0]);
      String sid = RandomNumbers.getEandomId(16);
      // TODO 添加校验sid是否已经存在
      share.setSid(sid);
      // TODO 添加有效期格式校验
      if (paramMap.containsKey("type") && "0".equals(paramMap.get("type")[0])) {
        share.setEndTime(Timestamp.valueOf(paramMap.get("endTime")[0] + " 00:00:00"));
      }
      share.setShareUrl(paramMap.get("basePath")[0] + "/ShareAction!shared?sid=" + sid);
      if ("1".equals(paramMap.get("type")[0])) {
        share.setSharePsd(RandomNumbers.getEandomId(6));
      }
      share.setShareTime(new Timestamp(new Date().getTime()));
      share.setCrtUserId(SessionAgentManager.getSessionAgentBean().getIdUsers());
      share.setDelF(1); // 正常状态
      return sharedao.addShare(share);
    } catch (Exception e) {
      logger.error(e.getMessage());
      throw new RuntimeException(e);
    }
  }

  public List<Share> obj2Empl(List<Object> list) {

    List<Share> elist = new ArrayList<Share>();
    for (Object obj : list) {

      Share em = (Share) obj;
      elist.add(em);
    }

    return elist;
  }


}
