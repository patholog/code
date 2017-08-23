package com.pathology.dto;


import java.util.Date;

public class ShareDTO implements java.io.Serializable {

  // Fields
  private int num;
  private String caseId;
  private String patientname;
  private String doctorId;
  private String username;
  private String type;
  private String typeName;
  private Integer shareId;
  private String shareTime;
  private Date endTime;
  private String shareUrl;
  private String sharePsd;
  private String sid;

  public int getNum() {
    return num;
  }

  public void setNum(int num) {
    this.num = num;
  }

  public String getCaseId() {
    return caseId;
  }

  public void setCaseId(String caseId) {
    this.caseId = caseId;
  }

  public String getPatientname() {
    return patientname;
  }

  public void setPatientname(String patientname) {
    this.patientname = patientname;
  }

  public String getDoctorId() {
    return doctorId;
  }

  public void setDoctorId(String doctorId) {
    this.doctorId = doctorId;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Integer getShareId() {
    return shareId;
  }

  public void setShareId(Integer shareId) {
    this.shareId = shareId;
  }

  public String getShareTime() {
    return shareTime;
  }

  public void setShareTime(String shareTime) {
    this.shareTime = shareTime;
  }

  public Date getEndTime() {
    return endTime;
  }

  public void setEndTime(Date endTime) {
    this.endTime = endTime;
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

  public String getTypeName() {
    return typeName;
  }

  public void setTypeName(String typeName) {
    this.typeName = typeName;
  }

  public String getSid() {
    return sid;
  }

  public void setSid(String sid) {
    this.sid = sid;
  }
}

