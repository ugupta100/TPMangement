package com.model.pkg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dbproperties.pkg.Train;

public class TrainingM {
	public static Connection getConnection(){  
	    Connection con=null;  
	    try{  
	        Class.forName("com.mysql.jdbc.Driver");  
	        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/TPManagement","root","root");  
	    }catch(Exception e){System.out.println(e);}  
	    return con;  
	}  
	public static int save(Train u){  
	    int status=0;  
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement(  
	"INSERT INTO TRAINING(TRID, TRAININGNAME, STARTDATE, ENDDATE, STARTTIME, ENDTIME, VENUE, CREATEDBY) VALUES(?,?,?,?,?,?,?,?);");  

	        ps.setString(1,u.getTRID());  
	        ps.setString(2,u.getTRAININGNAME());   
	        ps.setDate(3,u.getSTARTDATE());  
	        ps.setDate(4,u.getENDDATE()); 
	        ps.setTime(5,u.getSTARTTIME()); 
	        ps.setTime(6,u.getENDTIME()); 
	        ps.setString(7,u.getVENUE()); 
	        ps.setInt(8,u.getCREATEDBY()); 
	        status=ps.executeUpdate();  
	    }catch(Exception e){System.out.println(e);}  
	    return status;  
	}  
	public static int update(Train u){  
	    int status=0;  
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement(  
	"update TRAINING set STARTDATE=?, ENDDATE=?, STARTTIME=? ,ENDTIME=?, VENUE=?  where TRID=?");  
	        ps.setDate(1,u.getSTARTDATE());  
	        ps.setDate(2,u.getENDDATE()); 
	        ps.setTime(3,u.getSTARTTIME()); 
	        ps.setTime(4,u.getENDTIME()); 
	        ps.setString(5,u.getVENUE()); 
	        ps.setString(6,u.getTRID());  
	        status=ps.executeUpdate();  
	    }catch(Exception e){System.out.println(e);}  
	    return status;  
	}  
	public static int delete(Train u){  
	    int status=0;  
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement("update TRAINING set ISDELETED=1 where ID=?");  
	        ps.setInt(1,u.getId());  
	        status=ps.executeUpdate();  
	    }catch(Exception e){System.out.println(e);}  
	  
	    return status;  
	}  
	public static List<Train> getAllRecords(){  
	    List<Train> list=new ArrayList<Train>();  
	      
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement("select ID, TRID, TRAININGNAME, STARTDATE, ENDDATE, STARTTIME, ENDTIME, VENUE from TRAINING B where ISDELETED=0");  
	        ResultSet rs=ps.executeQuery();  
	        while(rs.next()){  
	        	Train u=new Train();  
	            u.setId(rs.getInt("ID"));  
	            u.setTRID(rs.getString("TRID"));  
	            u.setTRAININGNAME(rs.getString("TRAININGNAME"));  
		        u.setSTARTDATE(rs.getDate("STARTDATE"));   
		        u.setENDDATE(rs.getDate("ENDDATE"));  
		        u.setSTARTTIME(rs.getTime("STARTTIME"));
	            u.setENDTIME(rs.getTime("ENDTIME"));  
	            u.setVENUE(rs.getString("VENUE"));  
	            list.add(u);  
	        }  
	    }catch(Exception e){System.out.println(e);}  
	    return list;  
	}  
	public static Train getRecordById(int id){  
		Train u=null;  
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement("select ID, TRID, TRAININGNAME, STARTDATE, ENDDATE, STARTTIME, ENDTIME, VENUE from TRAINING B where id=?");  
	        ps.setInt(1,id);  
	        ResultSet rs=ps.executeQuery();  
	        while(rs.next()){  
	            u=new Train();  
	            u.setId(rs.getInt("ID"));  
	            u.setTRID(rs.getString("TRID"));  
	            u.setTRAININGNAME(rs.getString("TRAININGNAME"));  
		        u.setSTARTDATE(rs.getDate("STARTDATE"));   
		        u.setENDDATE(rs.getDate("ENDDATE"));  
		        u.setSTARTTIME(rs.getTime("STARTTIME"));
	            u.setENDTIME(rs.getTime("ENDTIME"));  
	            u.setVENUE(rs.getString("VENUE")); 
	        }  
	    }catch(Exception e){System.out.println(e);}  
	    return u;  
	}
}
