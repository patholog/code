package com.pathology.entity;

import java.util.Date;

/**
 * 标注
 */
public class Annotation implements java.io.Serializable {

  private Integer imageId;
  private String name;
  private Double positionX;
  private Double positionY;
  private Date crtTime;
  private String textTips;

  public Annotation() {
  }

  public Annotation(Integer imageId, String name, Double positionX, Double positionY) {
    this.imageId = imageId;
    this.name = name;
    this.positionX = positionX;
    this.positionY = positionY;
  }

  public Annotation(Integer imageId, String name, Double positionX, Double positionY, String textTips) {
    this.imageId = imageId;
    this.name = name;
    this.positionX = positionX;
    this.positionY = positionY;
    this.textTips = textTips;
  }

  public Integer getImageId() {
    return imageId;
  }

  public void setImageId(Integer imageId) {
    this.imageId = imageId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Double getPositionX() {
    return positionX;
  }

  public void setPositionX(Double positionX) {
    this.positionX = positionX;
  }

  public Double getPositionY() {
    return positionY;
  }

  public void setPositionY(Double positionY) {
    this.positionY = positionY;
  }

  public Date getCrtTime() {
    return crtTime;
  }

  public void setCrtTime(Date crtTime) {
    this.crtTime = crtTime;
  }

  public String getTextTips() {
    return textTips;
  }

  public void setTextTips(String textTips) {
    this.textTips = textTips;
  }
}
