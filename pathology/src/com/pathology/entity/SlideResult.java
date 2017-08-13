package com.pathology.entity;

public class SlideResult {

  private String address;
  private String width;
  private String height;
  private String rate;
  private String id;
  private String digitalSlidePath;
  private String fileNum;
  private String slideAddress;
  private String tileSize;
  private String fileSize;
  private String consultID;
  private String userID;
  private String caseNo;

  public SlideResult() {
  }

  public SlideResult(String address, String width, String height, String rate, String id, String digitalSlidePath,
                     String fileNum, String slideAddress, String tileSize, String fileSize, String consultID,
                     String userID, String caseNo) {
    this.address = address;
    this.width = width;
    this.height = height;
    this.rate = rate;
    this.id = id;
    this.digitalSlidePath = digitalSlidePath;
    this.fileNum = fileNum;
    this.slideAddress = slideAddress;
    this.tileSize = tileSize;
    this.fileSize = fileSize;
    this.consultID = consultID;
    this.userID = userID;
    this.caseNo = caseNo;
  }

  @Override
  public String toString() {
    return address + "|" + width + "|" + height + "|" + rate + "|" + id + "|" + digitalSlidePath + "|" + fileNum + "|"
        + slideAddress + "|" + tileSize + "|" + fileSize + "|" + consultID + "|" + userID + "|" + caseNo + "|";
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getWidth() {
    return width;
  }

  public void setWidth(String width) {
    this.width = width;
  }

  public String getHeight() {
    return height;
  }

  public void setHeight(String height) {
    this.height = height;
  }

  public String getRate() {
    return rate;
  }

  public void setRate(String rate) {
    this.rate = rate;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getDigitalSlidePath() {
    return digitalSlidePath;
  }

  public void setDigitalSlidePath(String digitalSlidePath) {
    this.digitalSlidePath = digitalSlidePath;
  }

  public String getFileNum() {
    return fileNum;
  }

  public void setFileNum(String fileNum) {
    this.fileNum = fileNum;
  }

  public String getSlideAddress() {
    return slideAddress;
  }

  public void setSlideAddress(String slideAddress) {
    this.slideAddress = slideAddress;
  }

  public String getTileSize() {
    return tileSize;
  }

  public void setTileSize(String tileSize) {
    this.tileSize = tileSize;
  }

  public String getFileSize() {
    return fileSize;
  }

  public void setFileSize(String fileSize) {
    this.fileSize = fileSize;
  }

  public String getConsultID() {
    return consultID;
  }

  public void setConsultID(String consultID) {
    this.consultID = consultID;
  }

  public String getUserID() {
    return userID;
  }

  public void setUserID(String userID) {
    this.userID = userID;
  }

  public String getCaseNo() {
    return caseNo;
  }

  public void setCaseNo(String caseNo) {
    this.caseNo = caseNo;
  }
}
