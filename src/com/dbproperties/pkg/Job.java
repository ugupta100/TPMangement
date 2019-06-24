package com.dbproperties.pkg;

import java.sql.Date;

public class Job {
	private int ID,CREATEDBY,MINEXP,MAXEXP,VACANCY;  
	private String JOBID,JOBTYPE,SKILL,COMPANYNAME,COMPANYID;
	private Date VALIDDATE;
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
	public String getJOBID() {
		return JOBID;
	}
	public void setJOBID(String JOBID) {
		this.JOBID = JOBID;
	}	
	public String getJOBTYPE() {
		return JOBTYPE;
	}
	public void setJOBTYPE(String JOBTYPE) {
		this.JOBTYPE = JOBTYPE;
	}	
	public String getSKILL() {
		return SKILL;
	}
	public void setSKILL(String SKILL) {
		this.SKILL = SKILL;
	}	
	public Date getVALIDDATE() {
		return VALIDDATE;
	}
	public void setVALIDDATE(Date VALIDDATE) {
		this.VALIDDATE = VALIDDATE;
	}
	public int getMINEXP() {
		return MINEXP;
	}
	public void setMINEXP(int MINEXP) {
		this.MINEXP = MINEXP;
	}	
	public int getMAXEXP() {
		return MAXEXP;
	}
	public void setMAXEXP(int MAXEXP) {
		this.MAXEXP = MAXEXP;
	}	
	public int getVACANCY() {
		return VACANCY;
	}
	public void setVACANCY(int VACANCY) {
		this.VACANCY = VACANCY;
	}
	public String getCOMPANYNAME() {
		return COMPANYNAME;
	}
	public void setCOMPANYNAME(String COMPANYNAME) {
		this.COMPANYNAME = COMPANYNAME;
	}

}
