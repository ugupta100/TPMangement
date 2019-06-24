package com.dbproperties.pkg;

public class Cand {
		private int ID,CREATEDBY,SEMESTER;  
		private String ROLLNO,NAME,PHONENO,DEPARTMENTCODE,EMAIL;
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
		public int getSEMESTER() {
			return SEMESTER;
		}
		public void setSEMESTER(int SEMESTER) {
			this.SEMESTER = SEMESTER;
		}
		public String getROLLNO() {
			return ROLLNO;
		}
		public void setROLLNO(String ROLLNO) {
			this.ROLLNO = ROLLNO;
		}
		public String getNAME() {
			return NAME;
		}
		public void setNAME(String NAME) {
			this.NAME = NAME;
		}	
		public String getPHONENO() {
			return PHONENO;
		}
		public void setPHONENO(String PHONENO) {
			this.PHONENO = PHONENO;
		}	
		public String getDEPARTMENTCODE() {
			return DEPARTMENTCODE;
		}
		public void setDEPARTMENTCODE(String DEPARTMENTCODE) {
			this.DEPARTMENTCODE = DEPARTMENTCODE;
		}	
		public String getEMAIL() {
			return EMAIL;
		}
		public void setEMAIL(String EMAIL) {
			this.EMAIL = EMAIL;
		}	
}
