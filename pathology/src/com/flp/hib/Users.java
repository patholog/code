package com.flp.hib;

import java.util.HashSet;
import java.util.Set;


/**
 * Users entity. @author MyEclipse Persistence Tools
 */

public class Users  implements java.io.Serializable {


    // Fields    

     private Integer uid;
     private String username;
     private String password;
     private String repassword;
     private Set leafs = new HashSet(0);


    // Constructors

    /** default constructor */
    public Users() {
    }

    
    /** full constructor */
    public Users(String username, String password, Set leafs) {
        this.username = username;
        this.password = password;
        this.leafs = leafs;
    }

   
    // Property accessors

    public Integer getUid() {
        return this.uid;
    }
    
    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    public Set getLeafs() {
        return this.leafs;
    }
    
    public void setLeafs(Set leafs) {
        this.leafs = leafs;
    }


	public String getRepassword() {
		return repassword;
	}


	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

}