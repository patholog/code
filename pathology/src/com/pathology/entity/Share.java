package com.pathology.entity;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Share entity. @author MyEclipse Persistence Tools
 */

public class Share implements java.io.Serializable {

  // Fields

  private Integer idShare;
  private String caseId;
  private String doctorId;
  private Timestamp shareTime;
  private Timestamp endTime;
  private String hospitalId;
  private String memo;
  private String sortNo;
  private String spellNo;
  private String wubiNo;
  private Integer updCnt;
  private Timestamp crtTime;
  private String crtUserId;
  private String crtDeptCd;
  private Date lastUpdTime;
  private String lastUpdDeptCd;
  private String lastUpdUserId;
  private Integer delF;
  private String pathologyNo;
  private String shareUrl;
  private String sharePsd;
  private String shareTerm;
  private String type;
  private String sid;
  // Constructors

  /**
   * default constructor
   */
  public Share() {
  }

  /**
   * minimal constructor
   */
  public Share(Integer idShare) {
    this.idShare = idShare;
  }

  /**
   * full constructor
   */
  public Share(Integer idShare, String caseId, String doctorId,
               Timestamp shareTime, String hospitalId, String memo, String sortNo,
               String spellNo, String wubiNo, Integer updCnt, Timestamp crtTime,
               String crtUserId, String crtDeptCd, Date lastUpdTime,
               String lastUpdDeptCd, String lastUpdUserId, Integer delF,
               String pathologyNo, String shareUrl, String sharePsd, String shareTerm) {
    this.idShare = idShare;
    this.caseId = caseId;
    this.doctorId = doctorId;
    this.shareTime = shareTime;
    this.hospitalId = hospitalId;
    this.memo = memo;
    this.sortNo = sortNo;
    this.spellNo = spellNo;
    this.wubiNo = wubiNo;
    this.updCnt = updCnt;
    this.crtTime = crtTime;
    this.crtUserId = crtUserId;
    this.crtDeptCd = crtDeptCd;
    this.lastUpdTime = lastUpdTime;
    this.lastUpdDeptCd = lastUpdDeptCd;
    this.lastUpdUserId = lastUpdUserId;
    this.delF = delF;
    this.pathologyNo = pathologyNo;
    this.shareUrl = shareUrl;
    this.sharePsd = sharePsd;
    this.shareTerm = shareTerm;
  }

  // Property accessors

  public Integer getIdShare() {
    return this.idShare;
  }

  public void setIdShare(Integer idShare) {
    this.idShare = idShare;
  }

  public String getCaseId() {
    return this.caseId;
  }

  public void setCaseId(String caseId) {
    this.caseId = caseId;
  }

  public String getDoctorId() {
    return this.doctorId;
  }

  public void setDoctorId(String doctorId) {
    this.doctorId = doctorId;
  }

  public Timestamp getShareTime() {
    return this.shareTime;
  }

  public void setShareTime(Timestamp shareTime) {
    this.shareTime = shareTime;
  }

  public String getHospitalId() {
    return this.hospitalId;
  }

  public void setHospitalId(String hospitalId) {
    this.hospitalId = hospitalId;
  }

  public String getMemo() {
    return this.memo;
  }

  public void setMemo(String memo) {
    this.memo = memo;
  }

  public String getSortNo() {
    return this.sortNo;
  }

  public void setSortNo(String sortNo) {
    this.sortNo = sortNo;
  }

  public String getSpellNo() {
    return this.spellNo;
  }

  public void setSpellNo(String spellNo) {
    this.spellNo = spellNo;
  }

  public String getWubiNo() {
    return this.wubiNo;
  }

  public void setWubiNo(String wubiNo) {
    this.wubiNo = wubiNo;
  }

  public Integer getUpdCnt() {
    return this.updCnt;
  }

  public void setUpdCnt(Integer updCnt) {
    this.updCnt = updCnt;
  }

  public Timestamp getCrtTime() {
    return this.crtTime;
  }

  public void setCrtTime(Timestamp crtTime) {
    this.crtTime = crtTime;
  }

  public String getCrtUserId() {
    return this.crtUserId;
  }

  public void setCrtUserId(String crtUserId) {
    this.crtUserId = crtUserId;
  }

  public String getCrtDeptCd() {
    return this.crtDeptCd;
  }

  public void setCrtDeptCd(String crtDeptCd) {
    this.crtDeptCd = crtDeptCd;
  }

  public Date getLastUpdTime() {
    return this.lastUpdTime;
  }

  public void setLastUpdTime(Date lastUpdTime) {
    this.lastUpdTime = lastUpdTime;
  }

  public String getLastUpdDeptCd() {
    return this.lastUpdDeptCd;
  }

  public void setLastUpdDeptCd(String lastUpdDeptCd) {
    this.lastUpdDeptCd = lastUpdDeptCd;
  }

  public String getLastUpdUserId() {
    return this.lastUpdUserId;
  }

  public void setLastUpdUserId(String lastUpdUserId) {
    this.lastUpdUserId = lastUpdUserId;
  }

  public Integer getDelF() {
    return this.delF;
  }

  public void setDelF(Integer delF) {
    this.delF = delF;
  }

  public String getPathologyNo() {
    return this.pathologyNo;
  }

  public void setPathologyNo(String pathologyNo) {
    this.pathologyNo = pathologyNo;
  }

  public String getShareUrl() {
    return shareUrl;
  }

  public void setShareUrl(String shareUrl) {
    this.shareUrl = shareUrl;
  }

  public String getSharePsd() {
    return sharePsd;
  }

  public void setSharePsd(String sharePsd) {
    this.sharePsd = sharePsd;
  }

  public String getShareTerm() {
    return shareTerm;
  }

  public void setShareTerm(String shareTerm) {
    this.shareTerm = shareTerm;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getSid() {
    return sid;
  }

  public void setSid(String sid) {
    this.sid = sid;
  }

  public Timestamp getEndTime() {
    return endTime;
  }

  public void setEndTime(Timestamp endTime) {
    this.endTime = endTime;
  }
}