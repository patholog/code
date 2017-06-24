package com.pathology.entity;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Users entity. @author MyEclipse Persistence Tools
 */

public class Users implements java.io.Serializable {

	// Fields

	private String idUsers;
	private String username;
	private String realname;
	private String sex;
	private Timestamp birthday;
	private String email;
	private String password;
	private String belonghospital;
	private String signature;
	private String stateid;
	private String specialty;
	private String mobile;
	private String tel;
	private String doctorctfsrc;
	private String isdeleted;
	private String deletor;
	private String userstatus;
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
	private String userType;

	// Constructors

	/** default constructor */
	public Users() {
	}

	/** minimal constructor */
	public Users(String idUsers, String username) {
		this.idUsers = idUsers;
		this.username = username;
	}

	/** full constructor */
	public Users(String idUsers, String username, String realname, String sex,
			Timestamp birthday, String email, String password,
			String belonghospital, String signature, String stateid,
			String specialty, String mobile, String tel, String doctorctfsrc,
			String isdeleted, String deletor, String userstatus, String memo,
			String sortNo, String spellNo, String wubiNo, Integer updCnt,
			Timestamp crtTime, String crtUserId, String crtDeptCd,
			Date lastUpdTime, String lastUpdDeptCd, String lastUpdUserId,
			Integer delF, String userType) {
		this.idUsers = idUsers;
		this.username = username;
		this.realname = realname;
		this.sex = sex;
		this.birthday = birthday;
		this.email = email;
		this.password = password;
		this.belonghospital = belonghospital;
		this.signature = signature;
		this.stateid = stateid;
		this.specialty = specialty;
		this.mobile = mobile;
		this.tel = tel;
		this.doctorctfsrc = doctorctfsrc;
		this.isdeleted = isdeleted;
		this.deletor = deletor;
		this.userstatus = userstatus;
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
		this.userType = userType;
	}

	// Property accessors

	public String getIdUsers() {
		return this.idUsers;
	}

	public void setIdUsers(String idUsers) {
		this.idUsers = idUsers;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRealname() {
		return this.realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Timestamp getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Timestamp birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBelonghospital() {
		return this.belonghospital;
	}

	public void setBelonghospital(String belonghospital) {
		this.belonghospital = belonghospital;
	}

	public String getSignature() {
		return this.signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getStateid() {
		return this.stateid;
	}

	public void setStateid(String stateid) {
		this.stateid = stateid;
	}

	public String getSpecialty() {
		return this.specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getDoctorctfsrc() {
		return this.doctorctfsrc;
	}

	public void setDoctorctfsrc(String doctorctfsrc) {
		this.doctorctfsrc = doctorctfsrc;
	}

	public String getIsdeleted() {
		return this.isdeleted;
	}

	public void setIsdeleted(String isdeleted) {
		this.isdeleted = isdeleted;
	}

	public String getDeletor() {
		return this.deletor;
	}

	public void setDeletor(String deletor) {
		this.deletor = deletor;
	}

	public String getUserstatus() {
		return this.userstatus;
	}

	public void setUserstatus(String userstatus) {
		this.userstatus = userstatus;
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

	public String getUserType() {
		return this.userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

}