package com.pathology.entity;

import java.sql.Timestamp;

/**
 * Leaf entity. @author MyEclipse Persistence Tools
 */

public class Leaf implements java.io.Serializable {

	// Fields

	private String lid;
	private Integer uid;
	private String sendfor;
	private Timestamp pdate;
	private String content;

	// Constructors

	/** default constructor */
	public Leaf() {
	}

	/** full constructor */
	public Leaf(Integer uid, String sendfor, Timestamp pdate, String content) {
		this.uid = uid;
		this.sendfor = sendfor;
		this.pdate = pdate;
		this.content = content;
	}

	// Property accessors

	public String getLid() {
		return this.lid;
	}

	public void setLid(String lid) {
		this.lid = lid;
	}

	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getSendfor() {
		return this.sendfor;
	}

	public void setSendfor(String sendfor) {
		this.sendfor = sendfor;
	}

	public Timestamp getPdate() {
		return this.pdate;
	}

	public void setPdate(Timestamp pdate) {
		this.pdate = pdate;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}