package com.pathology.entity;

import java.sql.Timestamp;

/**
 * Pathology entity. @author MyEclipse Persistence Tools
 */

public class Pathology implements java.io.Serializable {

	// Fields

	private String idCase;
	private String pathologyno;
	private String diagStatus;
	private String hospitalcode;
	private String patientname;
	private String patientage;
	private String ageunit;
	private String patientsex;
	private Timestamp patientbirthday;
	private String patientoccupation;
	private String idcard;
	private String mobile;
	private String specimenname;
	private String specimentype;
	private Timestamp inspectiondate;
	private String clinicdiagnose;
	private String historysummary;
	private String isdeleted;
	private String deletor;
	private String memo;
	private Timestamp diagTime;
	private String sortNo;
	private String spellNo;
	private String wubiNo;
	private Integer updCnt;
	private Timestamp crtTime;
	private String crtUserId;
	private String crtDeptCd;
	private Timestamp lastUpdTime;
	private String lastUpdDeptCd;
	private String lastUpdUserId;
	private Integer delF;
	private String doctorId;

	// Constructors

	/** default constructor */
	public Pathology() {
	}

	/** minimal constructor */
	public Pathology(String idCase, String hospitalcode) {
		this.idCase = idCase;
		this.hospitalcode = hospitalcode;
	}

	/** full constructor */
	public Pathology(String idCase, String pathologyno, String diagStatus,
			String hospitalcode, String patientname, String patientage,
			String ageunit, String patientsex, Timestamp patientbirthday,
			String patientoccupation, String idcard, String mobile,
			String specimenname, String specimentype, Timestamp inspectiondate,
			String clinicdiagnose, String historysummary, String isdeleted,
			String deletor, String memo, Timestamp diagTime, String sortNo,
			String spellNo, String wubiNo, Integer updCnt, Timestamp crtTime,
			String crtUserId, String crtDeptCd, Timestamp lastUpdTime,
			String lastUpdDeptCd, String lastUpdUserId, Integer delF) {
		this.idCase = idCase;
		this.pathologyno = pathologyno;
		this.diagStatus = diagStatus;
		this.hospitalcode = hospitalcode;
		this.patientname = patientname;
		this.patientage = patientage;
		this.ageunit = ageunit;
		this.patientsex = patientsex;
		this.patientbirthday = patientbirthday;
		this.patientoccupation = patientoccupation;
		this.idcard = idcard;
		this.mobile = mobile;
		this.specimenname = specimenname;
		this.specimentype = specimentype;
		this.inspectiondate = inspectiondate;
		this.clinicdiagnose = clinicdiagnose;
		this.historysummary = historysummary;
		this.isdeleted = isdeleted;
		this.deletor = deletor;
		this.memo = memo;
		this.diagTime = diagTime;
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

	public String getIdCase() {
		return this.idCase;
	}

	public void setIdCase(String idCase) {
		this.idCase = idCase;
	}

	public String getPathologyno() {
		return this.pathologyno;
	}

	public void setPathologyno(String pathologyno) {
		this.pathologyno = pathologyno;
	}

	public String getDiagStatus() {
		return this.diagStatus;
	}

	public void setDiagStatus(String diagStatus) {
		this.diagStatus = diagStatus;
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

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public Timestamp getDiagTime() {
		return this.diagTime;
	}

	public void setDiagTime(Timestamp diagTime) {
		this.diagTime = diagTime;
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

	public Timestamp getLastUpdTime() {
		return this.lastUpdTime;
	}

	public void setLastUpdTime(Timestamp lastUpdTime) {
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

	public String getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}
}