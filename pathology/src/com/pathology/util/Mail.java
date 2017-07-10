/*
 * Created on 2004-12-13
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.pathology.util;

import java.io.File;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.log4j.Logger;




/**
 * @author wlm
 * 
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
public class Mail
{
	//private static Logger log = Logger.getLogger(Mail.getName());

	private static String user = "hold\\kodansha";
	private static String password = "bfi_322";
	private static String host = "owa.hold.founder.com";
	private static String from = "kodansha@founder.com.cn";
	private static String name = "Kodansha";
	
	private static String charset = "Shift-JIS"; //"iso-2022-jp";
	
	
	public static void main(String[] args)
	{
		String[] content = new String[]{"one ddddd", "Two http://www.google.com", "Three ffafafd"};
		String[] tmp = new String[]{"D:\\tents 037.jpg", "D:\\Kikanshi-WeeklyReport20040923.xls"};
		Mail.send("wenliming@founder.co.jp", "JavaMail test", content);
	}
	
	/**
	 * 发送邮件
	 * @param to
	 * @param subject
	 * @param content
	 * @return
	 */
	public static boolean send(String to, String subject, String content)
	{
		String[] tmp = new String[]{content};
		return send(to, subject, tmp,null);
	}

	/**
	 * 发送邮件
	 * @param to
	 * @param subject
	 * @param content
	 * @return
	 */
	public static boolean send(String to, String subject, String[] content)
	{
		return send(to, subject, content,null);
	}

/**
 * 发送邮件
 * @param to
 * @param subject
 * @param content
 * @param files
 * @return
 */
	public static boolean send(String to, String subject, String content, String[] files)
	{
		String[] tmp = new String[]{content};
		return send(to, subject, tmp, files);
	}
	/**
	 * 
	 * @param tos
	 * @param subject
	 * @param content
	 * @return
	 */
	public static boolean send(String[] tos, String subject, String content)
	{
		return send(tos, subject, new String[]{content}, null, true);
	}
	/**
	 * 
	 * @param tos
	 * @param subject
	 * @param content
	 * @param files
	 * @return
	 */
	public static boolean send(String[] tos, String subject, String content, String[] files)
	{
		return send(tos, subject, new String[]{content}, files, true);
	}
	/**
	 * 
	 * @param tos
	 * @param subject
	 * @param content
	 * @param isSingleSend
	 * @return
	 */
	public static boolean send(String[] tos, String subject, String[] content)
	{
		return send(tos, subject, content, null, true);
	}
	/**
	 * 
	 * @param tos
	 * @param subject
	 * @param content
	 * @param files
	 * @param isSingleSend 
	 * @return
	 */
	public static boolean send(String[] tos, String subject, String[] content, String[] files, boolean isSingleSend)
	{
		boolean result = true;
		if (tos == null)
		{
			return false;
		}
		String toAddrs = "";
		for (int i = 0; i < tos.length; i++)
		{
			if (i == 0)
			{
				toAddrs = tos[i];
			} else {
				toAddrs += "," + tos[i];
			}
		}
		
		if (!isSingleSend)
        {
			try {
        		Address[] addrs = new InternetAddress[tos.length];
            	for (int i = 0; i < tos.length; i++)
            	{
            		addrs[i] = new InternetAddress(tos[i]);
            	}
        		send(addrs, subject, content, files, false);
        		//log.info(subject + " mail to " + toAddrs + " succeeded.");
        	} catch (Exception e)
			{
        		result = false;
            	//log.error(subject + " mail to " + toAddrs + " failed. Info: " + e.getMessage());
            	e.printStackTrace();
			}
        } else {
        	for (int i = 0; i < tos.length; i++)
        	{
        		try {
        			send(tos[i], subject, content, files, true);
        			//log.info(subject + " mail to " + tos[i] + " succeeded.");
        		} catch (Exception e)
				{
        			result = false;
                	//log.error(subject + " mail to " + tos[i] + " failed. Info: " + e.getMessage());
                	e.printStackTrace();
				}            		
        	}
        }
            
        return result;
	}
	
	private static void send(Object addr, String subject, String[] content, String[] files, boolean isSingle) throws Exception
	{		
		Session  session;
        MimeMessage msg;
        
        Properties props = System.getProperties();
		props.put("mail.smtp.host", getHost());
		props.put("mail.smtp.auth", "true");
		
		Authenticator auth = new MailAuthenticator(getUser(), getPassword());
	    //session = Session.getDefaultInstance(props, auth); // yaoxm drop 2005/04/28
	    session = Session.getInstance(props, auth); // yaoxm add 2005/04/28 避免偶而出现的错误：Access to default session denied
 
	    msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(getFrom(), getName()));
        if (isSingle)
        {
        	msg.setRecipient(Message.RecipientType.TO, new InternetAddress((String) addr));
        } else {
        	msg.setRecipients(Message.RecipientType.TO, (Address[]) addr);
        }
        
        msg.setSubject(subject);
        msg.setSentDate(new java.util.Date());
        
        if(files != null && files.length>0) // Has attach files
        {
        	Multipart mp = new MimeMultipart();
            MimeBodyPart mbp = new MimeBodyPart();
            
            mbp.setText(formatContent(content));
            mp.addBodyPart(mbp);
            
            for (int i=0; i<files.length; i++)
            {
            	mbp = new MimeBodyPart();
            	File attachFile = new File(files[i]);
            	FileDataSource fds = new FileDataSource(attachFile);
            	mbp.setDataHandler(new DataHandler(fds));
            	mbp.setFileName(fds.getName());
            	mp.addBodyPart(mbp);
            }
            msg.setContent(mp);
        }
        else
        {
        	 msg.setContent(formatContent(content), "text/plain; charset=Shift_JIS");
        }
       
        Transport.send(msg);  

	}
	
	public void getMail()
	{
		System.out.println("Mail.getMail()");
		Session  session;
        MimeMessage msg;
        
        Properties props = System.getProperties();
		props.put("mail.smtp.host", getHost());
		props.put("mail.smtp.auth", "true");
		
		Authenticator auth = new MailAuthenticator(getUser(), getPassword());
	    //session = Session.getDefaultInstance(props, auth); // yaoxm drop 2005/04/28
	    session = Session.getInstance(props, auth); // yaoxm add 2005/04/28 避免偶而出现的错误：Access to default session denied
	    try
		{
	    	Store store = session.getStore("pop3");
	    	store.connect(getHost(), getUser(), getPassword());
	    	Folder folder = store.getFolder("INBOX");
	    	folder.open(Folder.READ_ONLY);
	    	int cnt = folder.getMessageCount();
	    	System.out.println("message count =" + cnt);
	    	Message[] message = folder.getMessages();
	    	for (int i = 0 ; i < message.length; i++)
	    	{
	    		System.out.println("******************************************");
	    		System.out.println("from=" + getAddress(message[i].getFrom()));
	    		System.out.println("subject=" + message[i].getSubject());
	    		System.out.println("content=" + message[i].getContent().toString());
	    	}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	private String getInternetAddress(InternetAddress iaddr)
	{
		if (iaddr == null)
		{
			return "";
		}
		
		System.out.println("ok");
		return iaddr.getPersonal() + "(" + iaddr.getAddress() + ")";
	}
	
	private String getAddress(Address addr)
	{
		if (addr instanceof InternetAddress)
		{
			return getInternetAddress((InternetAddress) addr);
		}
		
		return addr.toString();
	}
	
	private String getAddress(Address[] addr)
	{
		System.out.println("address count = " + addr.length);
		String result = "";
		for (int i = 0; i < addr.length; i++)
		{
			String str = getAddress(addr[i]);
			if (i == 0)
			{
				result = str;
			} else {
				result += "," + str;
			}
		}
		
		return result;
	}
	/**
	 * 
	 * @param to
	 * @param subject
	 * @param content
	 * @param files
	 * @return
	 */
	public static boolean send(String to, String subject, String[] content, String[] files)
	{		
		boolean result = true;
        try
        {
	        send(to, subject, content, files, true);
            //log.info(subject + " mail to " + to + " succeeded.");
	    }
        catch (Exception e)
        {
        	result = false;
        	//log.error(subject + " mail to " + to + " failed. Info: " + e.getMessage());
        	e.printStackTrace();
        }
        return result;
	}
	
	private static String formatContent(String[] content)
	{
		String result = "";
		if (content != null && content.length>0)
		{
			for (int i=0; i<content.length; i++)
			{
				result += content[i] + "\r\n";
			}
		}
		
		/* 替换(株)，目前这个字在发送邮件之后乱码 */
		//result = result.replaceAll(SysInfo.get("INFO_0318"), SysInfo.get("INFO_0319"));
		
		return result;
	}
	
	/**
	 * @return Returns the from.
	 */
	public static String getFrom()
	{
		return from;
	}
	/**
	 * @param from The from to set.
	 */
	public static void setFrom(String from)
	{
		Mail.from = from;
	}
	/**
	 * @return Returns the host.
	 */
	public static String getHost()
	{
		return host;
	}
	/**
	 * @param host The host to set.
	 */
	public static void setHost(String host)
	{
		Mail.host = host;
	}
	/**
	 * @return Returns the password.
	 */
	public static String getPassword()
	{
		return password;
	}
	/**
	 * @param password The password to set.
	 */
	public static void setPassword(String password)
	{
		Mail.password = password;
	}
	/**
	 * @return Returns the user.
	 */
	public static String getUser()
	{
		return user;
	}
	/**
	 * @param user The user to set.
	 */
	public static void setUser(String user)
	{
		Mail.user = user;
	}
	
	/**
	 * @return Returns the name.
	 */
	public static String getName()
	{
		return name;
	}
	/**
	 * @param name The name to set.
	 */
	public static void setName(String name)
	{
		Mail.name = name;
	}
	
	/**
	 * @return Returns the charset.
	 */
	public static String getCharset()
	{
		return charset;
	}
	/**
	 * @param name The name to charset.
	 */
	public static void setCharset(String charset)
	{
		Mail.charset = charset;
	}
	
	
}