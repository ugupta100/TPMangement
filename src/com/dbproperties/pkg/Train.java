package com.dbproperties.pkg;

import java.sql.Date;
import java.sql.Time;

public class Train {
	private int ID,CREATEDBY;  
	private String TRID,TRAININGNAME,VENUE;
	private Date STARTDATE,ENDDATE;
	private Time STARTTIME,ENDTIME;
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
	public String getTRID() {
		return TRID;
	}
	public void setTRID(String TRID) {
		this.TRID = TRID;
	}
	public String getTRAININGNAME() {
		return TRAININGNAME;
	}
	public void setTRAININGNAME(String TRAININGNAME) {
		this.TRAININGNAME = TRAININGNAME;
	}	
	public String getVENUE() {
		return VENUE;
	}
	public void setVENUE(String VENUE) {
		this.VENUE = VENUE;
	}	
	public Date getSTARTDATE() {
		return STARTDATE;
	}
	public void setSTARTDATE(Date STARTDATE) {
		this.STARTDATE = STARTDATE;
	}	
	public Date getENDDATE() {
		return ENDDATE;
	}
	public void setENDDATE(Date ENDDATE) {
		this.ENDDATE = ENDDATE;
	}	
	public Time getSTARTTIME() {
		return STARTTIME;
	}
	public void setSTARTTIME(Time STARTTIME) {
		this.STARTTIME = STARTTIME;
	}	
	public Time getENDTIME() {
		return ENDTIME;
	}
	public void setENDTIME(Time ENDTIME) {
		this.ENDTIME = ENDTIME;
	}	
}
