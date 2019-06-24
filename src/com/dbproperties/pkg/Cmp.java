package com.dbproperties.pkg;

public class Cmp {
	private int ID,CREATEDBY;  
	private String COMPANYID,COMPANYNAME,PHONE,EMAIL,ADRESS;  
	//generate getters and setters  
	public int getId() {
		return ID;
	}
	public void setId(int ID) {
		this.ID = ID;
	}
	public int getCREATEDBY() {
		return CREATEDBY;
	}
	public void setCREATEDBY(int CREATEDBY) {
		this.CREATEDBY = CREATEDBY;
	}
	public String getCOMPANYID() {
		return COMPANYID;
	}
	public void setCOMPANYID(String COMPANYID) {
		this.COMPANYID = COMPANYID;
	}
	public String getCOMPANYNAME() {
		return COMPANYNAME;
	}
	public void setCOMPANYNAME(String COMPANYNAME) {
		this.COMPANYNAME = COMPANYNAME;
	}	
	public String getPHONE() {
		return PHONE;
	}
	public void setPHONE(String PHONE) {
		this.PHONE = PHONE;
	}	
	public String getEMAIL() {
		return EMAIL;
	}
	public void setEMAIL(String EMAIL) {
		this.EMAIL = EMAIL;
	}	
	public String getADRESS() {
		return ADRESS;
	}
	public void setADRESS(String ADRESS) {
		this.ADRESS = ADRESS;
	}
}
