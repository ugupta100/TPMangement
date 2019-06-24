package com.model.pkg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dbproperties.pkg.Cand;

public class CandidateM {
	public static Connection getConnection(){  
	    Connection con=null;  
	    try{  
	        Class.forName("com.mysql.jdbc.Driver");  
	        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/TPManagement","root","root");  
	    }catch(Exception e){System.out.println(e);}  
	    return con;  
	}  
	public static int save(Cand u){  
	    int status=0;  
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement( "INSERT INTO CANDIDATE(ROLLNO, NAME, PHONENO, DEPARTMENTCODE, EMAIL, SEMESTER, CREATEDBY)VALUES(?,?,?,?,?,?,?);");  

	        ps.setString(1,u.getROLLNO());  
	        ps.setString(2,u.getNAME());   
	        ps.setString(3,u.getPHONENO());  
	        ps.setString(4,u.getDEPARTMENTCODE()); 
	        ps.setString(5,u.getEMAIL()); 
	        ps.setInt(6,u.getSEMESTER()); 
	        ps.setInt(7,u.getCREATEDBY()); 
	        status=ps.executeUpdate();  
	    }catch(Exception e){System.out.println(e);}  
	    return status;  
	}  
	public static int update(Cand u){  
	    int status=0;  
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement(  
	"update CANDIDATE set NAME=?, PHONENO=?, DEPARTMENTCODE=?, EMAIL=? ,SEMESTER=? where ROLLNO=?");  
	        ps.setString(1,u.getNAME());  
	        ps.setString(2,u.getPHONENO()); 
	        ps.setString(3,u.getDEPARTMENTCODE()); 
	        ps.setString(4,u.getEMAIL()); 
	        ps.setInt(5,u.getSEMESTER());  
	        ps.setString(6,u.getROLLNO()); 
	        status=ps.executeUpdate();  
	    }catch(Exception e){System.out.println(e);}  
	    return status;  
	}  
	public static int delete(Cand u){  
	    int status=0;  
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement("update CANDIDATE set ISDELETED=1 where ID=?");  
	        ps.setInt(1,u.getId());  
	        status=ps.executeUpdate();  
	    }catch(Exception e){System.out.println(e);}  
	  
	    return status;  
	}  
	public static List<Cand> getAllRecords(){  
	    List<Cand> list=new ArrayList<Cand>();  
	      
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement("select ID, ROLLNO, NAME, PHONENO, DEPARTMENTCODE, EMAIL, SEMESTER from CANDIDATE B where ISDELETED=0");  
	        ResultSet rs=ps.executeQuery();  
	        while(rs.next()){  
	        	Cand u=new Cand();  
	            u.setId(rs.getInt("ID"));  
	            u.setROLLNO(rs.getString("ROLLNO"));  
	            u.setNAME(rs.getString("NAME"));  
		        u.setPHONENO(rs.getString("PHONENO"));   
		        u.setDEPARTMENTCODE(rs.getString("DEPARTMENTCODE"));  
		        u.setEMAIL(rs.getString("EMAIL"));
	            u.setSEMESTER(rs.getInt("SEMESTER"));   
	            list.add(u);  
	        }  
	    }catch(Exception e){System.out.println(e);}  
	    return list;  
	}  
	public static Cand getRecordById(int id){  
		Cand u=null;  
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement("select  ID,ROLLNO, NAME, PHONENO, DEPARTMENTCODE, EMAIL, SEMESTER  from CANDIDATE B where id=?");  
	        ps.setInt(1,id);  
	        ResultSet rs=ps.executeQuery();  
	        while(rs.next()){  
	            u=new Cand();  
	            u.setId(rs.getInt("ID"));  
	            u.setROLLNO(rs.getString("ROLLNO"));  
	            u.setNAME(rs.getString("NAME"));  
		        u.setPHONENO(rs.getString("PHONENO"));   
		        u.setDEPARTMENTCODE(rs.getString("DEPARTMENTCODE"));  
		        u.setEMAIL(rs.getString("EMAIL"));
	            u.setSEMESTER(rs.getInt("SEMESTER"));   
	        }  
	    }catch(Exception e){System.out.println(e);}  
	    return u;  
	}

}
