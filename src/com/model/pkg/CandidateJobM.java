package com.model.pkg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dbproperties.pkg.Job;

public class CandidateJobM {
	public static Connection getConnection(){  
	    Connection con=null;  
	    try{  
	        Class.forName("com.mysql.jdbc.Driver");  
	        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/TPManagement","root","root");  
	    }catch(Exception e){System.out.println(e);}  
	    return con;  
	}  
	public static int save(int jobid,int loginid){  
	    int status=0;  
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement(  "INSERT INTO CANDIDATE_JOB(JOBID, CANDIDATEID, CREATEDBY)VALUES(?,(SELECT C.ID FROM CANDIDATE C WHERE C.ROLLNO=(SELECT D.USERNAME FROM USER_LOGIN D WHERE D.ID=?)), ?);");  
	        ps.setInt(1,jobid);  
	        ps.setInt(2,loginid);   
	        ps.setInt(3,loginid);
	        status=ps.executeUpdate();
	    }catch(Exception e){System.out.println(e);}  
	    return status;  
	}  
//	public static int update(Job u){  
//	    int status=0;  
//	    try{  
//	        Connection con=getConnection();  
//	        PreparedStatement ps=con.prepareStatement(  
//	"update TRAINING set STARTDATE=?, ENDDATE=?, STARTTIME=? ,ENDTIME=?, VENUE=?  where TRID=?");  
//	        ps.setDate(1,u.getSTARTDATE());  
//	        ps.setDate(2,u.getENDDATE()); 
//	        ps.setTime(3,u.getSTARTTIME()); 
//	        ps.setTime(4,u.getENDTIME()); 
//	        ps.setString(5,u.getVENUE()); 
//	        ps.setString(6,u.getTRID());  
//	        status=ps.executeUpdate();  
//	    }catch(Exception e){System.out.println(e);}  
//	    return status;  
//	}  
	public static List<Job> getAllRecords(int id){  
	    List<Job> list=new ArrayList<Job>();  
	      
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement("call JOB_FOR_CANDIDATE(?)");  
	        ps.setInt(1,id);  
	        ResultSet rs=ps.executeQuery();  
	        while(rs.next()){  
	        	Job u=new Job();  
	            u.setId(rs.getInt("ID"));  
	            u.setJOBID(rs.getString("JOBID"));  
	            u.setCOMPANYNAME(rs.getString("COMPANYNAME"));  
		        u.setJOBTYPE(rs.getString("JOBTYPE"));   
		        u.setSKILL(rs.getString("SKILL"));  
		        u.setMINEXP(rs.getInt("MINEXP"));
	            u.setMAXEXP(rs.getInt("MAXEXP"));  
	            u.setVALIDDATE(rs.getDate("VALIDDATE"));  
	            u.setVACANCY(rs.getInt("VACANCY"));  
	            list.add(u);  
	        }  
	    }catch(Exception e){System.out.println(e);}  
	    return list;  
	}  
}
