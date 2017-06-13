package com.pathology.entity;

import java.sql.Timestamp;

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
	private String isdeleted;
	private String deletor;
	private String userstatus;

	// Constructors

	/** default constructor */
	public Users() {
	}

	/** minimal constructor */
	public Users(String username) {
		this.username = username;
	}

	/** full constructor */
	public Users(String username, String realname, String sex,
			Timestamp birthday, String email, String password,
			String belonghospital, String signature, String stateid,
			String specialty, String mobile, String tel, String isdeleted,
			String deletor, String userstatus) {
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
		this.isdeleted = isdeleted;
		this.deletor = deletor;
		this.userstatus = userstatus;
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

}