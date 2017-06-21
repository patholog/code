package com.pathology.entity;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Image entity. @author MyEclipse Persistence Tools
 */

public class Image implements java.io.Serializable {

	// Fields

	private String idImage;
	private String caseId;
	private Integer rowImage;
	private Integer colImage;
	private String pathImage;
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

	/** default constructor */
	public Image() {
	}

	/** minimal constructor */
	public Image(String idImage) {
		this.idImage = idImage;
	}

	/** full constructor */
	public Image(String idImage, String caseId, Integer rowImage,
			Integer colImage, String pathImage, String memo, String sortNo,
			String spellNo, String wubiNo, Integer updCnt, Timestamp crtTime,
			String crtUserId, String crtDeptCd, Date lastUpdTime,
			String lastUpdDeptCd, String lastUpdUserId, Integer delF) {
		this.idImage = idImage;
		this.caseId = caseId;
		this.rowImage = rowImage;
		this.colImage = colImage;
		this.pathImage = pathImage;
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

	public String getIdImage() {
		return this.idImage;
	}

	public void setIdImage(String idImage) {
		this.idImage = idImage;
	}

	public String getCaseId() {
		return this.caseId;
	}

	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}

	public Integer getRowImage() {
		return this.rowImage;
	}

	public void setRowImage(Integer rowImage) {
		this.rowImage = rowImage;
	}

	public Integer getColImage() {
		return this.colImage;
	}

	public void setColImage(Integer colImage) {
		this.colImage = colImage;
	}

	public String getPathImage() {
		return this.pathImage;
	}

	public void setPathImage(String pathImage) {
		this.pathImage = pathImage;
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

}