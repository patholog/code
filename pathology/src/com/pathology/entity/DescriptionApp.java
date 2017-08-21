package com.pathology.entity;

import java.sql.Timestamp;
import java.util.Date;

/**
 * DescriptionApp entity. @author MyEclipse Persistence Tools
 */

public class DescriptionApp implements java.io.Serializable {

  // Fields

  private Integer idDescriptionApp;
  private String caseId;
  private Hospital fromHospital;
  private Users fromDoctor;
  private Hospital toHospital;
  private Users toDoctor;
  private Timestamp applyDateTime;
  private Integer transferParentId;
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

  // Constructors

  /**
   * default constructor
   */
  public DescriptionApp() {
  }

  /**
   * minimal constructor
   */
  public DescriptionApp(Integer idDescriptionApp) {
    this.idDescriptionApp = idDescriptionApp;
  }

  /**
   * full constructor
   */
  public DescriptionApp(Integer idDescriptionApp, String caseId, Hospital fromHospital,
                        Users fromDoctor, Hospital toHospital, Users toDoctor,
                        Timestamp applyDateTime, Integer transferParentId, String memo,
                        String sortNo, String spellNo, String wubiNo, Integer updCnt,
                        Timestamp crtTime, String crtUserId, String crtDeptCd,
                        Date lastUpdTime, String lastUpdDeptCd, String lastUpdUserId,
                        Integer delF) {
    this.idDescriptionApp = idDescriptionApp;
    this.caseId = caseId;
    this.fromHospital = fromHospital;
    this.fromDoctor = fromDoctor;
    this.toHospital = toHospital;
    this.toDoctor = toDoctor;
    this.applyDateTime = applyDateTime;
    this.transferParentId = transferParentId;
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
  }

  // Property accessors

  public Integer getIdDescriptionApp() {
    return this.idDescriptionApp;
  }

  public void setIdDescriptionApp(Integer idDescriptionApp) {
    this.idDescriptionApp = idDescriptionApp;
  }

  public Hospital getFromHospital() {
    return this.fromHospital;
  }

  public void setFromHospital(Hospital fromHospital) {
    this.fromHospital = fromHospital;
  }

  public Users getFromDoctor() {
    return this.fromDoctor;
  }

  public void setFromDoctor(Users fromDoctor) {
    this.fromDoctor = fromDoctor;
  }

  public Hospital getToHospital() {
    return this.toHospital;
  }

  public void setToHospital(Hospital toHospital) {
    this.toHospital = toHospital;
  }

  public Users getToDoctor() {
    return this.toDoctor;
  }

  public void setToDoctor(Users toDoctor) {
    this.toDoctor = toDoctor;
  }

  public Timestamp getApplyDateTime() {
    return this.applyDateTime;
  }

  public void setApplyDateTime(Timestamp applyDateTime) {
    this.applyDateTime = applyDateTime;
  }

  public Integer getTransferParentId() {
    return this.transferParentId;
  }

  public void setTransferParentId(Integer transferParentId) {
    this.transferParentId = transferParentId;
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

  public String getCaseId() {
    return caseId;
  }

  public void setCaseId(String caseId) {
    this.caseId = caseId;
  }
}