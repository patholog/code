package com.pathology.entity;

import java.sql.Timestamp;

/**
 * Hospital entity. @author MyEclipse Persistence Tools
 */

public class Hospital implements java.io.Serializable {

	// Fields

	private String idHospital;
	private String name;
	private String code;
	private String hospitalcode;
	private String address;
	private String tel;
	private String memo;
	private String transferedhospital;
	private String delete;
	private Timestamp createTime;
	private String creator;

	// Constructors

	/** default constructor */
	public Hospital() {
	}

	/** minimal constructor */
	public Hospital(String name) {
		this.name = name;
	}

	/** full constructor */
	public Hospital(String name, String code, String hospitalcode,
			String address, String tel, String memo, String transferedhospital,
			String delete, Timestamp createTime, String creator) {
		this.name = name;
		this.code = code;
		this.hospitalcode = hospitalcode;
		this.address = address;
		this.tel = tel;
		this.memo = memo;
		this.transferedhospital = transferedhospital;
		this.delete = delete;
		this.createTime = createTime;
		this.creator = creator;
	}

	// Property accessors

	public String getIdHospital() {
		return this.idHospital;
	}

	public void setIdHospital(String idHospital) {
		this.idHospital = idHospital;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getHospitalcode() {
		return this.hospitalcode;
	}

	public void setHospitalcode(String hospitalcode) {
		this.hospitalcode = hospitalcode;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getTransferedhospital() {
		return this.transferedhospital;
	}

	public void setTransferedhospital(String transferedhospital) {
		this.transferedhospital = transferedhospital;
	}

	public String getDelete() {
		return this.delete;
	}

	public void setDelete(String delete) {
		this.delete = delete;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getCreator() {
		return this.creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

}