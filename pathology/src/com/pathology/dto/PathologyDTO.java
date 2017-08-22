package com.pathology.dto;


import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.pathology.entity.Image;

public class PathologyDTO implements java.io.Serializable {

  // Fields
  private int num;
  private String patientname;
  private String username;
  private String hospitalname;
  private String content;
  private String caseId;
  private String messageOrder;
  private String isReaded;
  private String createTime;
  private String memo;
  private Date lastUpdTime;
  private String lastUpdDeptCd;
  private String lastUpdUserId;
  private Integer delF;
  private String pathologyNo;
  private Date patientBirthday;
  private String patientSex;
  private String patientAge;
  private String specimenName;
  private String idCard;
  private String mobile;
  private String diagTime;
  private String collectionId;
  private List<Image> Images;
  private String retreatReason;
  /**
   * 初步诊断
   */
  private String diagnosed;
  /**
   * 免疫结果
   */
  private String result;
  public List<Image> getImages() {
	return Images;
}

public void setImages(List<Image> images) {
	Images = images;
}

public String getCollectionId() {
	return collectionId;
}

public void setCollectionId(String collectionId) {
	this.collectionId = collectionId;
}

/**
   * 病史
   */
  private String historySummary;
  /**
   * 临床诊断
   */
  private String clinicDiagnose;
  /**
   * 检验时间
   */
  private Date inspectionDate;
  /**
   * 大体所见
   */
  private String generalSee;

  /**
   * 影像学所见
   */
  private String microscopeSee;

  public String getHospitalname() {
    return hospitalname;
  }

  public void setHospitalname(String hospitalname) {
    this.hospitalname = hospitalname;
  }

  public int getNum() {
    return num;
  }

  public void setNum(int num) {
    this.num = num;
  }

  public String getPatientname() {
    return patientname;
  }

  public void setPatientname(String patientname) {
    this.patientname = patientname;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getCaseId() {
    return caseId;
  }

  public void setCaseId(String caseId) {
    this.caseId = caseId;
  }

  public String getMessageOrder() {
    return messageOrder;
  }

  public void setMessageOrder(String messageOrder) {
    this.messageOrder = messageOrder;
  }

  public String getIsReaded() {
    return isReaded;
  }

  public void setIsReaded(String isReaded) {
    this.isReaded = isReaded;
  }

  public String getCreateTime() {
    return createTime;
  }

  public void setCreateTime(String createTime) {
    this.createTime = createTime;
  }

  public String getMemo() {
    return memo;
  }

  public void setMemo(String memo) {
    this.memo = memo;
  }

  public Date getLastUpdTime() {
    return lastUpdTime;
  }

  public void setLastUpdTime(Date lastUpdTime) {
    this.lastUpdTime = lastUpdTime;
  }

  public String getLastUpdDeptCd() {
    return lastUpdDeptCd;
  }

  public void setLastUpdDeptCd(String lastUpdDeptCd) {
    this.lastUpdDeptCd = lastUpdDeptCd;
  }

  public String getLastUpdUserId() {
    return lastUpdUserId;
  }

  public void setLastUpdUserId(String lastUpdUserId) {
    this.lastUpdUserId = lastUpdUserId;
  }

  public Integer getDelF() {
    return delF;
  }

  public void setDelF(Integer delF) {
    this.delF = delF;
  }

  public String getPathologyNo() {
    return pathologyNo;
  }

  public void setPathologyNo(String pathologyNo) {
    this.pathologyNo = pathologyNo;
  }

  public Date getPatientBirthday() {
    return patientBirthday;
  }

  public void setPatientBirthday(Date patientBirthday) {
    this.patientBirthday = patientBirthday;
  }

  public String getPatientSex() {
    return patientSex;
  }

  public void setPatientSex(String patientSex) {
    this.patientSex = patientSex;
  }

  public String getPatientAge() {
    return patientAge;
  }

  public void setPatientAge(String patientAge) {
    this.patientAge = patientAge;
  }

  public String getSpecimenName() {
    return specimenName;
  }

  public void setSpecimenName(String specimenName) {
    this.specimenName = specimenName;
  }

  public String getIdCard() {
    return idCard;
  }

  public void setIdCard(String idCard) {
    this.idCard = idCard;
  }

  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public String getDiagTime() {
    return diagTime;
  }

  public void setDiagTime(String diagTime) {
    this.diagTime = diagTime;
  }

  public String getHistorySummary() {
    return historySummary;
  }

  public void setHistorySummary(String historySummary) {
    this.historySummary = historySummary;
  }

  public String getClinicDiagnose() {
    return clinicDiagnose;
  }

  public void setClinicDiagnose(String clinicDiagnose) {
    this.clinicDiagnose = clinicDiagnose;
  }

  public Date getInspectionDate() {
    return inspectionDate;
  }

  public void setInspectionDate(Date inspectionDate) {
    this.inspectionDate = inspectionDate;
  }

  public String getGeneralSee() {
    return generalSee;
  }

  public void setGeneralSee(String generalSee) {
    this.generalSee = generalSee;
  }

  public String getMicroscopeSee() {
    return microscopeSee;
  }

  public void setMicroscopeSee(String microscopeSee) {
    this.microscopeSee = microscopeSee;
  }

  public String getDiagnosed() {
    return diagnosed;
  }

  public void setDiagnosed(String diagnosed) {
    this.diagnosed = diagnosed;
  }

  public String getResult() {
    return result;
  }

  public void setResult(String result) {
    this.result = result;
  }

public String getRetreatReason() {
	return retreatReason;
}

public void setRetreatReason(String retreatReason) {
	this.retreatReason = retreatReason;
}
  
}