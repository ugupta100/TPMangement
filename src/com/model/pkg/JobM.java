package com.model.pkg;
import java.sql.*;  
import java.util.ArrayList;  
import java.util.List;  
import com.dbproperties.pkg.Job;

public class JobM {
	public static Connection getConnection(){  
	    Connection con=null;  
	    try{  
	        Class.forName("com.mysql.jdbc.Driver");  
	        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/TPManagement","root","root");  
	    }catch(Exception e){System.out.println(e);}  
	    return con;  
	}  
	public static int save(Job u){  
	    int status=0;  
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement(  
	"INSERT INTO JOB(JOBID, COMPANYID, JOBTYPE, SKILL, MINEXP, MAXEXP, VALIDDATE, VACANCY, CREATEDBY) VALUES(?,(select id from COMPANY A where A.COMPANYID=?),?,?,?,?,?,?,?);");  

	        ps.setString(1,u.getJOBID());  
	        ps.setString(2,u.getCOMPANYID());   
	        ps.setString(3,u.getJOBTYPE());  
	        ps.setString(4,u.getSKILL()); 
	        ps.setInt(5,u.getMINEXP()); 
	        ps.setInt(6,u.getMAXEXP()); 
	        ps.setDate(7,u.getVALIDDATE()); 
	        ps.setInt(8,u.getVACANCY());  
	        ps.setInt(9,u.getCREATEDBY()); 
	        status=ps.executeUpdate();  
	    }catch(Exception e){System.out.println(e);}  
	    return status;  
	}  
	public static int update(Job u){  
	    int status=0;  
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement(  
	"update JOB set JOBTYPE=?, SKILL=?, MINEXP=? ,MAXEXP=?, VALIDDATE=? ,VACANCY=? where JOBID=?");  
	        ps.setString(1,u.getJOBTYPE());  
	        ps.setString(2,u.getSKILL()); 
	        ps.setInt(3,u.getMINEXP()); 
	        ps.setInt(4,u.getMAXEXP()); 
	        ps.setDate(5,u.getVALIDDATE()); 
	        ps.setInt(6,u.getVACANCY());  
	        ps.setString(7,u.getJOBID()); 
	        status=ps.executeUpdate();  
	    }catch(Exception e){System.out.println(e);}  
	    return status;  
	}  
	public static int delete(Job u){  
	    int status=0;  
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement("update JOB set ISDELETED=1 where ID=?");  
	        ps.setInt(1,u.getId());  
	        status=ps.executeUpdate();  
	    }catch(Exception e){System.out.println(e);}  
	  
	    return status;  
	}  
	public static List<Job> getAllRecords(){  
	    List<Job> list=new ArrayList<Job>();  
	      
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement("select ID, JOBID, (select COMPANYNAME from COMPANY A where A.ID=B.COMPANYID) COMPANYNAME, JOBTYPE, SKILL, MINEXP, MAXEXP, VALIDDATE, VACANCY from JOB B where ISDELETED=0");  
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
	public static Job getRecordById(int id){  
		Job u=null;  
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement("select  ID, JOBID, (select COMPANYNAME from COMPANY A where A.ID=B.COMPANYID) COMPANYNAME, JOBTYPE, SKILL, MINEXP, MAXEXP, VALIDDATE, VACANCY  from JOB B where id=?");  
	        ps.setInt(1,id);  
	        ResultSet rs=ps.executeQuery();  
	        while(rs.next()){  
	            u=new Job();  
	            u.setId(rs.getInt("ID"));  
	            u.setJOBID(rs.getString("JOBID"));  
	            u.setCOMPANYNAME(rs.getString("COMPANYNAME"));  
		        u.setJOBTYPE(rs.getString("JOBTYPE"));   
		        u.setSKILL(rs.getString("SKILL"));  
		        u.setMINEXP(rs.getInt("MINEXP"));
	            u.setMAXEXP(rs.getInt("MAXEXP"));  
	            u.setVALIDDATE(rs.getDate("VALIDDATE"));  
	            u.setVACANCY(rs.getInt("VACANCY")); 
	        }  
	    }catch(Exception e){System.out.println(e);}  
	    return u;  
	}

}
