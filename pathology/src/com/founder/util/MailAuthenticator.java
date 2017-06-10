/*
 * Created on 2004-12-13
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.founder.util;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * @author wlm
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class MailAuthenticator extends Authenticator
{
	private String user;
	private String password;
	
	/**
	 * 
	 */
	public MailAuthenticator(String user, String password)
	{
		super();
		this.user = user;
		this.password = password;
	}
	
	/* (non-Javadoc)
	 * @see javax.mail.Authenticator#getPasswordAuthentication()
	 */
	protected PasswordAuthentication getPasswordAuthentication()
	{
		return new PasswordAuthentication(user, password);
	}
}
