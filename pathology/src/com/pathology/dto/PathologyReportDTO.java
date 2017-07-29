package com.pathology.dto;

import java.util.Date;
import java.util.List;

import com.pathology.entity.Image;

public class PathologyReportDTO implements java.io.Serializable{

	private String patientName;
	private String sex;
	private int age;
	private String pathologyNo;
	private String caseId;
	public String getCaseId() {
		return caseId;
	}
	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}
	public String getPathologyNo() {
		return pathologyNo;
	}
	public void setPathologyNo(String pathologyNo) {
		this.pathologyNo = pathologyNo;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getInspecDate() {
		return inspecDate;
	}
	public void setInspecDate(Date inspecDate) {
		this.inspecDate = inspecDate;
	}
	public String getInspecEnterprise() {
		return inspecEnterprise;
	}
	public void setInspecEnterprise(String inspecEnterprise) {
		this.inspecEnterprise = inspecEnterprise;
	}
	public int getOrders() {
		return orders;
	}
	public void setOrders(int orders) {
		this.orders = orders;
	}
	public Date getDiagnosisTime() {
		return diagnosisTime;
	}
	public void setDiagnosisTime(Date diagnosisTime) {
		this.diagnosisTime = diagnosisTime;
	}
	public String getMedicalInfo() {
		return medicalInfo;
	}
	public void setMedicalInfo(String medicalInfo) {
		this.medicalInfo = medicalInfo;
	}
	public String getPartBody() {
		return partBody;
	}
	public void setPartBody(String partBody) {
		this.partBody = partBody;
	}
	public String getGeneralSee() {
		return generalSee;
	}
	public void setGeneralSee(String generalSee) {
		this.generalSee = generalSee;
	}
	public String getMicroscopeSee() {
		return microscopeSee;
	}
	public void setMicroscopeSee(String microscopeSee) {
		this.microscopeSee = microscopeSee;
	}
	public String getDiagnosed() {
		return diagnosed;
	}
	public void setDiagnosed(String diagnosed) {
		this.diagnosed = diagnosed;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getSuggestion() {
		return suggestion;
	}
	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
	}
	private Date inspecDate;
	private String inspecEnterprise;
	private int orders;
	private Date diagnosisTime;
	private String medicalInfo;
	private String partBody;
	private String generalSee;
	private String microscopeSee;
	private String diagnosed;
	private String result;
	private String suggestion;
	private List<Image> images;
	//图片实体
	public List<Image> getImages() {
		return images;
	}
	public void setImages(List<Image> images) {
		this.images = images;
	}
}
