package com.flp.hib;

import java.sql.Timestamp;

/**
 * Hospital entity. @author MyEclipse Persistence Tools
 */

public class Hospital implements java.io.Serializable {

	// Fields

	private String idHospital;
	private String name;
	private String address;
	private String tel;
	private String memo;
	private String transferedHospital;
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
	public Hospital(String name, String address, String tel, String memo,
			String transferedHospital, String delete, Timestamp createTime,
			String creator) {
		this.name = name;
		this.address = address;
		this.tel = tel;
		this.memo = memo;
		this.transferedHospital = transferedHospital;
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

	public String getTransferedHospital() {
		return this.transferedHospital;
	}

	public void setTransferedHospital(String transferedHospital) {
		this.transferedHospital = transferedHospital;
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