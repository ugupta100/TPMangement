package com.model.pkg;
import java.sql.*;  
import java.util.ArrayList;  
import java.util.List;  
import com.dbproperties.pkg.Cmp;
public class CompanyM {
		  
	public static Connection getConnection(){  
	    Connection con=null;  
	    try{  
	        Class.forName("com.mysql.jdbc.Driver");  
	        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/TPManagement","root","root");  
	    }catch(Exception e){System.out.println(e);}  
	    return con;  
	}  
	public static int save(Cmp u){  
	    int status=0;  
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement(  
	"INSERT INTO COMPANY(COMPANYID, COMPANYNAME, PHONE, EMAIL, ADRESS, CREATEDBY)VALUES(?,?,?,?,?,?);");  
	        ps.setString(1,u.getCOMPANYID());  
	        ps.setString(2,u.getCOMPANYNAME());   
	        ps.setString(3,u.getPHONE());  
	        ps.setString(4,u.getEMAIL()); 
	        ps.setString(5,u.getADRESS());  
	        ps.setInt(6,u.getCREATEDBY()); 
	        status=ps.executeUpdate();  
	    }catch(Exception e){System.out.println(e);}  
	    return status;  
	}  
	public static int update(Cmp u){  
	    int status=0;  
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement(  
	"update COMPANY set PHONE=?, EMAIL=?, ADRESS=? where COMPANYID=?");  
	        ps.setString(1,u.getPHONE());  
	        ps.setString(2,u.getEMAIL()); 
	        ps.setString(3,u.getADRESS()); 
	        ps.setString(4,u.getCOMPANYID());  
	        status=ps.executeUpdate();  
	    }catch(Exception e){System.out.println(e);}  
	    return status;  
	}  
	public static int delete(Cmp u){  
	    int status=0;  
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement("update COMPANY set ISDELETED=1 where ID=?");  
	        ps.setInt(1,u.getId());  
	        status=ps.executeUpdate();  
	    }catch(Exception e){System.out.println(e);}  
	  
	    return status;  
	}  
	public static List<Cmp> getAllRecords(){  
	    List<Cmp> list=new ArrayList<Cmp>();  
	      
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement("select * from COMPANY where ISDELETED=0");  
	        ResultSet rs=ps.executeQuery();  
	        while(rs.next()){  
	        	Cmp u=new Cmp();  
	            u.setId(rs.getInt("ID"));  
	            u.setCOMPANYID(rs.getString("COMPANYID"));  
	            u.setCOMPANYNAME(rs.getString("COMPANYNAME"));  
		        u.setEMAIL(rs.getString("EMAIL"));   
		        u.setPHONE(rs.getString("PHONE"));  
		        u.setADRESS(rs.getString("ADRESS"));
	            list.add(u);  
	        }  
	    }catch(Exception e){System.out.println(e);}  
	    return list;  
	}  
	public static Cmp getRecordById(int id){  
		Cmp u=null;  
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement("select * from COMPANY where id=?");  
	        ps.setInt(1,id);  
	        ResultSet rs=ps.executeQuery();  
	        while(rs.next()){  
	            u=new Cmp();  
	            u.setId(rs.getInt("ID"));  
	            u.setCOMPANYID(rs.getString("COMPANYID"));  
	            u.setCOMPANYNAME(rs.getString("COMPANYNAME"));  
		        u.setEMAIL(rs.getString("EMAIL"));   
		        u.setPHONE(rs.getString("PHONE"));  
		        u.setADRESS(rs.getString("ADRESS")); 
	        }  
	    }catch(Exception e){System.out.println(e);}  
	    return u;  
	}
	
}
