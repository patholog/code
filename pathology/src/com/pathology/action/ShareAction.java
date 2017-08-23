package com.pathology.action;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

  public String deleteShare() {
    try {
      if (!SessionAgentManager.islogin()) {
        return Constant.ERR;
      }
      Share hos = shareService.getShare(Share.class, share.getShareId());
      shareService.deleteShare(hos);
      return "deletesuccess";
    } catch (Exception e) {
      logger.error(e.getMessage());
      return Constant.ERR;
    }
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
}
