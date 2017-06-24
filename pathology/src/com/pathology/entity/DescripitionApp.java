package com.pathology.entity;

import java.sql.Timestamp;
import java.util.Date;

/**
 * DescripitionApp entity. @author MyEclipse Persistence Tools
 */

public class DescripitionApp implements java.io.Serializable {

	// Fields

	private String idDescriptionApp;
	private String fromHospitalId;
	private String fromDoctorId;
	private String toHospitalId;
	private String toDoctorId;
	private Timestamp applyDateTime;
	private String transferParentId;
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
	public DescripitionApp() {
	}

	/** minimal constructor */
	public DescripitionApp(String idDescriptionApp) {
		this.idDescriptionApp = idDescriptionApp;
	}

	/** full constructor */
	public DescripitionApp(String idDescriptionApp, String fromHospitalId,
			String fromDoctorId, String toHospitalId, String toDoctorId,
			Timestamp applyDateTime, String transferParentId, String memo,
			String sortNo, String spellNo, String wubiNo, Integer updCnt,
			Timestamp crtTime, String crtUserId, String crtDeptCd,
			Date lastUpdTime, String lastUpdDeptCd, String lastUpdUserId,
			Integer delF) {
		this.idDescriptionApp = idDescriptionApp;
		this.fromHospitalId = fromHospitalId;
		this.fromDoctorId = fromDoctorId;
		this.toHospitalId = toHospitalId;
		this.toDoctorId = toDoctorId;
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

	public String getIdDescriptionApp() {
		return this.idDescriptionApp;
	}

	public void setIdDescriptionApp(String idDescriptionApp) {
		this.idDescriptionApp = idDescriptionApp;
	}

	public String getFromHospitalId() {
		return this.fromHospitalId;
	}

	public void setFromHospitalId(String fromHospitalId) {
		this.fromHospitalId = fromHospitalId;
	}

	public String getFromDoctorId() {
		return this.fromDoctorId;
	}

	public void setFromDoctorId(String fromDoctorId) {
		this.fromDoctorId = fromDoctorId;
	}

	public String getToHospitalId() {
		return this.toHospitalId;
	}

	public void setToHospitalId(String toHospitalId) {
		this.toHospitalId = toHospitalId;
	}

	public String getToDoctorId() {
		return this.toDoctorId;
	}

	public void setToDoctorId(String toDoctorId) {
		this.toDoctorId = toDoctorId;
	}

	public Timestamp getApplyDateTime() {
		return this.applyDateTime;
	}

	public void setApplyDateTime(Timestamp applyDateTime) {
		this.applyDateTime = applyDateTime;
	}

	public String getTransferParentId() {
		return this.transferParentId;
	}

	public void setTransferParentId(String transferParentId) {
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

}