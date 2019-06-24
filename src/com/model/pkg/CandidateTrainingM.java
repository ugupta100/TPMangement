package com.model.pkg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dbproperties.pkg.Train;

public class CandidateTrainingM {
	public static Connection getConnection(){  
	    Connection con=null;  
	    try{  
	        Class.forName("com.mysql.jdbc.Driver");  
	        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/TPManagement","root","root");  
	    }catch(Exception e){System.out.println(e);}  
	    return con;  
	}  
	public static int save(int trainingid,int loginid){  
	    int status=0;  
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement(  "INSERT INTO CANDIDATE_TRAINING(TRAININGID, CANDIDATEID, CREATEDBY)VALUES(?,(SELECT C.ID FROM CANDIDATE C WHERE C.ROLLNO=(SELECT D.USERNAME FROM USER_LOGIN D WHERE D.ID=?)), ?);");  
	        ps.setInt(1,trainingid);  
	        ps.setInt(2,loginid);   
	        ps.setInt(3,loginid);
	        status=ps.executeUpdate();
	    }catch(Exception e){System.out.println(e);}  
	    return status;  
	}  
	public static int update(int id,int allotment){  
	    int status=0;  
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement(  
	"update CANDIDATE_TRAINING set ISALLOTTED=?  where ID=?");  
	        ps.setInt(1,allotment);  
	        ps.setInt(2,id); 
	        status=ps.executeUpdate();  
	    }catch(Exception e){System.out.println(e);}  
	    return status;  
	}  
	public static List<Train> getAllRecords(int id){  
	    List<Train> list=new ArrayList<Train>();  
	      
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement("call TRAINING_FOR_CANDIDATE(?)");  
	        ps.setInt(1,id);  
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
	public static List<Train> getAllAllotment(){  
	    List<Train> list=new ArrayList<Train>();  
	      
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement("select CT.ID,concat(C.NAME,' applied For ',T.TRAININGNAME,' at ',T.VENUE) TRAININGNAME from CANDIDATE_TRAINING CT inner join TRAINING T on T.id=CT.TRAININGID inner join CANDIDATE C on C.id=CT.CANDIDATEID where CT.ISALLOTTED is null");   
	        ResultSet rs=ps.executeQuery();  
	        while(rs.next()){  
	        	Train u=new Train();  
	            u.setId(rs.getInt("ID"));
	            u.setTRAININGNAME(rs.getString("TRAININGNAME"));
	            list.add(u);  
	        }  
	    }catch(Exception e){System.out.println(e);}  
	    return list;  
	}  
}
