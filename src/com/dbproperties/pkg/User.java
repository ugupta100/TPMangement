package com.dbproperties.pkg;

public class User {
 
	private int ID;  
	private String USERTYPE,USERNAME,PASWORD;  
	//generate getters and setters  
	public int getId() {
		return ID;
	}
	public void setId(int ID) {
		this.ID = ID;
	}
	public String getName() {
		return USERNAME;
	}
	public void setName(String USERNAME) {
		this.USERNAME = USERNAME;
	}
	public String getPassword() {
		return PASWORD;
	}
	public void setPassword(String PASWORD) {
		this.PASWORD = PASWORD;
	}
	public String getUSERTYPE() {
		return USERTYPE;
	}
	public void setUSERTYPE(String USERTYPE) {
		this.USERTYPE = USERTYPE;
	}
}
