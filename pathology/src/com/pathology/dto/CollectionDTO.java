package com.pathology.dto;


import java.sql.Timestamp;
import java.util.Date;

public class CollectionDTO implements java.io.Serializable {

	// Fields

	private int num;
	private String patientname;
	private String username;
	private String content;
	private String caseId;
	private String collectionId;
	public String getCollectionId() {
		return collectionId;
	}
	public void setCollectionId(String collectionId) {
		this.collectionId = collectionId;
	}
	private String messageOrder;
	private String isReaded;
	private Timestamp createTime;
	private String memo;
	private Date lastUpdTime;
	private String lastUpdDeptCd;
	private String lastUpdUserId;
	private Integer delF;
	private String pathologyNo;
	
	
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getPatientname() {
		return patientname;
	}
	public void setPatientname(String patientname) {
		this.patientname = patientname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCaseId() {
		return caseId;
	}
	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}
	public String getMessageOrder() {
		return messageOrder;
	}
	public void setMessageOrder(String messageOrder) {
		this.messageOrder = messageOrder;
	}
	public String getIsReaded() {
		return isReaded;
	}
	public void setIsReaded(String isReaded) {
		this.isReaded = isReaded;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public Date getLastUpdTime() {
		return lastUpdTime;
	}
	public void setLastUpdTime(Date lastUpdTime) {
		this.lastUpdTime = lastUpdTime;
	}
	public String getLastUpdDeptCd() {
		return lastUpdDeptCd;
	}
	public void setLastUpdDeptCd(String lastUpdDeptCd) {
		this.lastUpdDeptCd = lastUpdDeptCd;
	}
	public String getLastUpdUserId() {
		return lastUpdUserId;
	}
	public void setLastUpdUserId(String lastUpdUserId) {
		this.lastUpdUserId = lastUpdUserId;
	}
	public Integer getDelF() {
		return delF;
	}
	public void setDelF(Integer delF) {
		this.delF = delF;
	}
	public String getPathologyNo() {
		return pathologyNo;
	}
	public void setPathologyNo(String pathologyNo) {
		this.pathologyNo = pathologyNo;
	}

	// Constructors

	/** default constructor */
	 

	/** minimal constructor */
 

 

	// Property accessors

	 

 
 

}

