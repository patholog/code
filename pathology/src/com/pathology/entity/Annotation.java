package com.pathology.entity;

import java.util.Date;

/**
 * 标注
 */
public class Annotation implements java.io.Serializable {

  private Integer imageId;
  private String name;
  private Integer positionX;
  private Integer positionY;
  private Date crtTime;

  public Annotation() {
  }

  public Annotation(Integer imageId, String name, Integer positionX, Integer positionY) {
    this.imageId = imageId;
    this.name = name;
    this.positionX = positionX;
    this.positionY = positionY;
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

  public Integer getPositionX() {
    return positionX;
  }

  public void setPositionX(Integer positionX) {
    this.positionX = positionX;
  }

  public Integer getPositionY() {
    return positionY;
  }

  public void setPositionY(Integer positionY) {
    this.positionY = positionY;
  }

  public Date getCrtTime() {
    return crtTime;
  }

  public void setCrtTime(Date crtTime) {
    this.crtTime = crtTime;
  }
}
