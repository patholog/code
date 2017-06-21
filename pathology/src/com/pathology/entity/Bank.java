package com.pathology.entity;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Bank entity. @author MyEclipse Persistence Tools
 */

public class Bank implements java.io.Serializable {

	// Fields

	private String idBank;
	private String userId;
	private String accountType;
	private String accountName;
	private String accountNo;
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
	public Bank() {
	}

	/** minimal constructor */
	public Bank(String idBank) {
		this.idBank = idBank;
	}

	/** full constructor */
	public Bank(String idBank, String userId, String accountType,
			String accountName, String accountNo, String memo, String sortNo,
			String spellNo, String wubiNo, Integer updCnt, Timestamp crtTime,
			String crtUserId, String crtDeptCd, Date lastUpdTime,
			String lastUpdDeptCd, String lastUpdUserId, Integer delF) {
		this.idBank = idBank;
		this.userId = userId;
		this.accountType = accountType;
		this.accountName = accountName;
		this.accountNo = accountNo;
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

	public String getIdBank() {
		return this.idBank;
	}

	public void setIdBank(String idBank) {
		this.idBank = idBank;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAccountType() {
		return this.accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getAccountName() {
		return this.accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountNo() {
		return this.accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
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