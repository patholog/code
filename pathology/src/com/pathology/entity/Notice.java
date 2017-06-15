package com.pathology.entity;

import java.sql.Timestamp;

/**
 * Notice entity. @author MyEclipse Persistence Tools
 */

public class Notice implements java.io.Serializable {

	// Fields

	private String idNotice;
	private String name;
	private String content;
	private String creator;
	private Timestamp createtime;
	private String groupid;
	private String isdeleted;
	private String deletor;

	// Constructors

	/** default constructor */
	public Notice() {
	}

	/** minimal constructor */
	public Notice(String idNotice, String name) {
		this.idNotice = idNotice;
		this.name = name;
	}

	/** full constructor */
	public Notice(String idNotice, String name, String content, String creator,
			Timestamp createtime, String groupid, String isdeleted,
			String deletor) {
		this.idNotice = idNotice;
		this.name = name;
		this.content = content;
		this.creator = creator;
		this.createtime = createtime;
		this.groupid = groupid;
		this.isdeleted = isdeleted;
		this.deletor = deletor;
	}

	// Property accessors

	public String getIdNotice() {
		return this.idNotice;
	}

	public void setIdNotice(String idNotice) {
		this.idNotice = idNotice;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCreator() {
		return this.creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public Timestamp getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}

	public String getGroupid() {
		return this.groupid;
	}

	public void setGroupid(String groupid) {
		this.groupid = groupid;
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