package com.pathology.entity;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Result entity. @author MyEclipse Persistence Tools
 */

public class Result implements java.io.Serializable {

	// Fields

	private String idResult;
	private String caseId;
	private String doctorId;
	private Timestamp reportTime;
	private Integer reportOrder;
	private String generalSee;
	private String microscopeSee;
	private String diagnosed;
	private String result;
	private String description;
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

	// Constructors

	/** default constructor */
	public Result() {
	}

	/** minimal constructor */
	public Result(String idResult) {
		this.idResult = idResult;
	}

	/** full constructor */
	public Result(String idResult, String caseId, String doctorId,
			Timestamp reportTime, Integer reportOrder, String generalSee,
			String microscopeSee, String diagnosed, String result,
			String description, String memo, String sortNo, String spellNo,
			String wubiNo, Integer updCnt, Timestamp crtTime, String crtUserId,
			String crtDeptCd, Date lastUpdTime, String lastUpdDeptCd,
			String lastUpdUserId, Integer delF, String pathologyNo) {
		this.idResult = idResult;
		this.caseId = caseId;
		this.doctorId = doctorId;
		this.reportTime = reportTime;
		this.reportOrder = reportOrder;
		this.generalSee = generalSee;
		this.microscopeSee = microscopeSee;
		this.diagnosed = diagnosed;
		this.result = result;
		this.description = description;
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
	}

	// Property accessors

	public String getIdResult() {
		return this.idResult;
	}

	public void setIdResult(String idResult) {
		this.idResult = idResult;
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

	public Timestamp getReportTime() {
		return this.reportTime;
	}

	public void setReportTime(Timestamp reportTime) {
		this.reportTime = reportTime;
	}

	public Integer getReportOrder() {
		return this.reportOrder;
	}

	public void setReportOrder(Integer reportOrder) {
		this.reportOrder = reportOrder;
	}

	public String getGeneralSee() {
		return this.generalSee;
	}

	public void setGeneralSee(String generalSee) {
		this.generalSee = generalSee;
	}

	public String getMicroscopeSee() {
		return this.microscopeSee;
	}

	public void setMicroscopeSee(String microscopeSee) {
		this.microscopeSee = microscopeSee;
	}

	public String getDiagnosed() {
		return this.diagnosed;
	}

	public void setDiagnosed(String diagnosed) {
		this.diagnosed = diagnosed;
	}

	public String getResult() {
		return this.result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
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

}