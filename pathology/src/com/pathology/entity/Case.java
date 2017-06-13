package com.pathology.entity;

import java.sql.Timestamp;

/**
 * Case entity. @author MyEclipse Persistence Tools
 */

public class Case implements java.io.Serializable {

	// Fields

	private String idCase;
	private String hospitalcode;
	private String patientname;
	private String patientage;
	private String ageunit;
	private String patientsex;
	private Timestamp patientbirthday;
	private String patientoccupation;
	private String pathologyno;
	private String idcard;
	private String mobile;
	private String specimenname;
	private String specimentype;
	private Timestamp inspectiondate;
	private String clinicdiagnose;
	private String historysummary;
	private String isdeleted;
	private String deletor;

	// Constructors

	/** default constructor */
	public Case() {
	}

	/** minimal constructor */
	public Case(String hospitalcode) {
		this.hospitalcode = hospitalcode;
	}

	/** full constructor */
	public Case(String hospitalcode, String patientname, String patientage,
			String ageunit, String patientsex, Timestamp patientbirthday,
			String patientoccupation, String pathologyno, String idcard,
			String mobile, String specimenname, String specimentype,
			Timestamp inspectiondate, String clinicdiagnose,
			String historysummary, String isdeleted, String deletor) {
		this.hospitalcode = hospitalcode;
		this.patientname = patientname;
		this.patientage = patientage;
		this.ageunit = ageunit;
		this.patientsex = patientsex;
		this.patientbirthday = patientbirthday;
		this.patientoccupation = patientoccupation;
		this.pathologyno = pathologyno;
		this.idcard = idcard;
		this.mobile = mobile;
		this.specimenname = specimenname;
		this.specimentype = specimentype;
		this.inspectiondate = inspectiondate;
		this.clinicdiagnose = clinicdiagnose;
		this.historysummary = historysummary;
		this.isdeleted = isdeleted;
		this.deletor = deletor;
	}

	// Property accessors

	public String getIdCase() {
		return this.idCase;
	}

	public void setIdCase(String idCase) {
		this.idCase = idCase;
	}

	public String getHospitalcode() {
		return this.hospitalcode;
	}

	public void setHospitalcode(String hospitalcode) {
		this.hospitalcode = hospitalcode;
	}

	public String getPatientname() {
		return this.patientname;
	}

	public void setPatientname(String patientname) {
		this.patientname = patientname;
	}

	public String getPatientage() {
		return this.patientage;
	}

	public void setPatientage(String patientage) {
		this.patientage = patientage;
	}

	public String getAgeunit() {
		return this.ageunit;
	}

	public void setAgeunit(String ageunit) {
		this.ageunit = ageunit;
	}

	public String getPatientsex() {
		return this.patientsex;
	}

	public void setPatientsex(String patientsex) {
		this.patientsex = patientsex;
	}

	public Timestamp getPatientbirthday() {
		return this.patientbirthday;
	}

	public void setPatientbirthday(Timestamp patientbirthday) {
		this.patientbirthday = patientbirthday;
	}

	public String getPatientoccupation() {
		return this.patientoccupation;
	}

	public void setPatientoccupation(String patientoccupation) {
		this.patientoccupation = patientoccupation;
	}

	public String getPathologyno() {
		return this.pathologyno;
	}

	public void setPathologyno(String pathologyno) {
		this.pathologyno = pathologyno;
	}

	public String getIdcard() {
		return this.idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getSpecimenname() {
		return this.specimenname;
	}

	public void setSpecimenname(String specimenname) {
		this.specimenname = specimenname;
	}

	public String getSpecimentype() {
		return this.specimentype;
	}

	public void setSpecimentype(String specimentype) {
		this.specimentype = specimentype;
	}

	public Timestamp getInspectiondate() {
		return this.inspectiondate;
	}

	public void setInspectiondate(Timestamp inspectiondate) {
		this.inspectiondate = inspectiondate;
	}

	public String getClinicdiagnose() {
		return this.clinicdiagnose;
	}

	public void setClinicdiagnose(String clinicdiagnose) {
		this.clinicdiagnose = clinicdiagnose;
	}

	public String getHistorysummary() {
		return this.historysummary;
	}

	public void setHistorysummary(String historysummary) {
		this.historysummary = historysummary;
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