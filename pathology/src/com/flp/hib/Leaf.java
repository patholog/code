package com.flp.hib;

import java.util.Date;


/**
 * Leaf entity. @author MyEclipse Persistence Tools
 */

public class Leaf  implements java.io.Serializable {


    // Fields    

     private String lid;
     private Users users;
     private String sendfor;
     private Date pdate;
     private String content;


    // Constructors

    /** default constructor */
    public Leaf() {
    }

    
    /** full constructor */
    public Leaf(Users users, String sendfor, Date pdate, String content) {
        this.users = users;
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

    public Users getUsers() {
        return this.users;
    }
    
    public void setUsers(Users users) {
        this.users = users;
    }

    public String getSendfor() {
        return this.sendfor;
    }
    
    public void setSendfor(String sendfor) {
        this.sendfor = sendfor;
    }

    public Date getPdate() {
        return this.pdate;
    }
    
    public void setPdate(Date pdate) {
        this.pdate = pdate;
    }

    public String getContent() {
        return this.content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
   








}