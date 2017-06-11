package com.flp.hib;

/**
 * UserAccount entity. @author MyEclipse Persistence Tools
 */

public class UserAccount implements java.io.Serializable {

	// Fields

	private String idAccount;
	private String idUser;
	private String accounttype;
	private String accountname;
	private String accountno;
	private String isdeleted;
	private String deletor;

	// Constructors

	/** default constructor */
	public UserAccount() {
	}

	/** minimal constructor */
	public UserAccount(String idUser) {
		this.idUser = idUser;
	}

	/** full constructor */
	public UserAccount(String idUser, String accounttype, String accountname,
			String accountno, String isdeleted, String deletor) {
		this.idUser = idUser;
		this.accounttype = accounttype;
		this.accountname = accountname;
		this.accountno = accountno;
		this.isdeleted = isdeleted;
		this.deletor = deletor;
	}

	// Property accessors

	public String getIdAccount() {
		return this.idAccount;
	}

	public void setIdAccount(String idAccount) {
		this.idAccount = idAccount;
	}

	public String getIdUser() {
		return this.idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

	public String getAccounttype() {
		return this.accounttype;
	}

	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
	}

	public String getAccountname() {
		return this.accountname;
	}

	public void setAccountname(String accountname) {
		this.accountname = accountname;
	}

	public String getAccountno() {
		return this.accountno;
	}

	public void setAccountno(String accountno) {
		this.accountno = accountno;
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