package com.pathology.entity;

import java.sql.Timestamp;

/**
 * Cons entity. @author MyEclipse Persistence Tools
 */

public class Cons implements java.io.Serializable {

	// Fields

	private String idCons;
	private String fromhospitalid;
	private String fromdoctorid;
	private String tohospitalid;
	private String todoctorid;
	private Timestamp applydatetime;
	private String transferparentid;
	private String isdeleted;
	private String deletor;

	// Constructors

	/** default constructor */
	public Cons() {
	}

	/** minimal constructor */
	public Cons(String idCons) {
		this.idCons = idCons;
	}

	/** full constructor */
	public Cons(String idCons, String fromhospitalid, String fromdoctorid,
			String tohospitalid, String todoctorid, Timestamp applydatetime,
			String transferparentid, String isdeleted, String deletor) {
		this.idCons = idCons;
		this.fromhospitalid = fromhospitalid;
		this.fromdoctorid = fromdoctorid;
		this.tohospitalid = tohospitalid;
		this.todoctorid = todoctorid;
		this.applydatetime = applydatetime;
		this.transferparentid = transferparentid;
		this.isdeleted = isdeleted;
		this.deletor = deletor;
	}

	// Property accessors

	public String getIdCons() {
		return this.idCons;
	}

	public void setIdCons(String idCons) {
		this.idCons = idCons;
	}

	public String getFromhospitalid() {
		return this.fromhospitalid;
	}

	public void setFromhospitalid(String fromhospitalid) {
		this.fromhospitalid = fromhospitalid;
	}

	public String getFromdoctorid() {
		return this.fromdoctorid;
	}

	public void setFromdoctorid(String fromdoctorid) {
		this.fromdoctorid = fromdoctorid;
	}

	public String getTohospitalid() {
		return this.tohospitalid;
	}

	public void setTohospitalid(String tohospitalid) {
		this.tohospitalid = tohospitalid;
	}

	public String getTodoctorid() {
		return this.todoctorid;
	}

	public void setTodoctorid(String todoctorid) {
		this.todoctorid = todoctorid;
	}

	public Timestamp getApplydatetime() {
		return this.applydatetime;
	}

	public void setApplydatetime(Timestamp applydatetime) {
		this.applydatetime = applydatetime;
	}

	public String getTransferparentid() {
		return this.transferparentid;
	}

	public void setTransferparentid(String transferparentid) {
		this.transferparentid = transferparentid;
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

}