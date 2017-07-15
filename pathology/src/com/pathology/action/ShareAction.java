package com.pathology.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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

			if (!SessionAgentManager.islogin())
				return Constant.ERR;
			HttpServletRequest request = ServletActionContext.getRequest();

			shares = shareService.getListShare(request, "");

			return "shares";
		} catch (Exception e) {
			logger.error(e.getMessage());
			return Constant.ERR;
		}
	}

	public String deleteShare() {
		try {

			if (!SessionAgentManager.islogin())
				return Constant.ERR;
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
