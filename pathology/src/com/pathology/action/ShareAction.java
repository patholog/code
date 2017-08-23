package com.pathology.action;

import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pathology.dto.PathologyDTO;
import com.pathology.service.IPathologyService;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.pathology.dto.ShareDTO;
import com.pathology.entity.Share;
import com.pathology.service.IShareService;
import com.pathology.util.Constant;
import com.pathology.util.SessionAgentManager;

public class ShareAction extends BaseAction {

  private static final long serialVersionUID = 1L;
  private final Logger logger = Logger.getLogger(ShareAction.class);
  public IShareService shareService;
  private List<ShareDTO> shares;
  private ShareDTO share;
  private PathologyDTO pathology;
  private IPathologyService pathologyService;

  public String getShareList() {
    try {
      if (!SessionAgentManager.islogin()) {
        return Constant.ERR;
      }
      HttpServletRequest request = ServletActionContext.getRequest();
      shares = shareService.getListShare(request, "");
      return "shares";
    } catch (Exception e) {
      logger.error(e.getMessage());
      return Constant.ERR;
    }
  }

  /**
   * 新建分享
   *
   * @return null
   */
  public String share() {
    HttpServletRequest request = ServletActionContext.getRequest();
    HttpServletResponse response = ServletActionContext.getResponse();
    response.setContentType("text/html;charset=UTF-8");
    Map<String, String[]> paramMap = request.getParameterMap();
    String result = "";
    String pwd = "";
    try {
      String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
          + request.getContextPath();
      paramMap.putIfAbsent("basePath", new String[]{basePath});
      Integer shareId = shareService.insert(paramMap);
      Share share = shareService.getShare(Share.class, shareId);
      pwd = share.getSharePsd() == null ? "" : share.getSharePsd();
      result = share.getShareUrl();
    } catch (Exception e) {
      logger.error(e.getMessage());
    }
    try {
      PrintWriter out;
      out = response.getWriter();
      String jsonString = !"".equals(result) ? "{\"success\":\"" + result + "\", \"pwd\":\"" + pwd + "\"}" : "{\"failure\":\"保存失败\"}";
      out.println(jsonString);
      out.flush();
      out.close();
    } catch (Exception e) {
      logger.error(e);
    }
    return null;
  }

  /**
   * @return
   */
  public String shared() {
    HttpServletRequest request = ServletActionContext.getRequest();
    try {
      String sid = request.getParameter("sid");
      Share share = shareService.selectBySid(sid);
      if (share != null) {
        if ("0".equals(share.getType()) && share.getShareTime().before(new Timestamp(new Date().getTime()))) {
          // 公开
          pathology = pathologyService.getPathologyByIdAndDiagStatus(share.getCaseId());
          return "sharedReport";
        }
        if ("1".equals(share.getType())) {
          String pwd = request.getParameter("pwd");
          if (pwd != null && pwd.equals(share.getSharePsd())) {
            pathology = pathologyService.getPathologyByIdAndDiagStatus(share.getCaseId());
            return "sharedReport";
          }
          return "sharedReportProtected";
        }
      }
    } catch (Exception e) {
      logger.error(e.getMessage());
      return "sharedReportProtected";
    }
    return "sharedReportProtected";
  }

  public String deleteShare() {
    HttpServletResponse response = ServletActionContext.getResponse();
    response.setContentType("text/html;charset=UTF-8");
    String result = "";
    try {
      if (!SessionAgentManager.islogin()) {
        return Constant.ERR;
      }
      shareService.deleteShare(share.getShareId());
      result = "取消成功";
    } catch (Exception e) {
      logger.error(e.getMessage());
    }
    try {
      PrintWriter out;
      out = response.getWriter();
      String jsonString = !"".equals(result) ? "{\"succ\":\"" + result + "\"}" : "{\"failure\":\"保存失败\"}";
      out.println(jsonString);
      out.flush();
      out.close();
    } catch (Exception e) {
      logger.error(e);
    }
    return null;
  }

  public ShareDTO getShare() {
    return share;
  }

  public void setShare(ShareDTO share) {
    this.share = share;
  }

  public IShareService getShareService() {
    return shareService;
  }

  public void setShareService(IShareService shareService) {
    this.shareService = shareService;
  }

  public List<ShareDTO> getShares() {
    return shares;
  }

  public void setShares(List<ShareDTO> shares) {
    this.shares = shares;
  }

  public PathologyDTO getPathology() {
    return pathology;
  }

  public void setPathology(PathologyDTO pathology) {
    this.pathology = pathology;
  }

  public IPathologyService getPathologyService() {
    return pathologyService;
  }

  public void setPathologyService(IPathologyService pathologyService) {
    this.pathologyService = pathologyService;
  }
}
