package com.model.pkg;
 
import java.sql.*;  
import java.util.ArrayList;  
import java.util.List;  
import com.dbproperties.pkg.User;  
public class LoginM {  
  
public static Connection getConnection(){  
    Connection con=null;  
    try{  
        Class.forName("com.mysql.jdbc.Driver");  
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/TPManagement","root","root");  
    }catch(Exception e){System.out.println(e);}  
    return con;  
}  
public static int save(User u){  
    int status=0;  
    try{  
        Connection con=getConnection();  
        PreparedStatement ps=con.prepareStatement( "CALL REGISTER_CANDIDATE(?,?)");  
        ps.setString(1,u.getName());  
        ps.setString(2,u.getPassword());   
        ResultSet rs=ps.executeQuery();  
        rs.next();
        status=rs.getInt("ID");
    }catch(Exception e){System.out.println(e);}  
    return status;  
}  
public static int update(User u){  
    int status=0;  
    try{  
        Connection con=getConnection();  
        PreparedStatement ps=con.prepareStatement(  
"update USER_LOGIN set USERNAME=?,PASWORD=? where ID=?");  
        ps.setString(1,u.getName());  
        ps.setString(2,u.getPassword());   
        ps.setInt(3,u.getId());  
        status=ps.executeUpdate();  
        
    }catch(Exception e){System.out.println(e);}  
    return status;  
}  
public static int delete(User u){  
    int status=0;  
    try{  
        Connection con=getConnection();  
        PreparedStatement ps=con.prepareStatement("delete from USER_LOGIN where ID=?");  
        ps.setInt(1,u.getId());  
        status=ps.executeUpdate();  
    }catch(Exception e){System.out.println(e);}  
  
    return status;  
}  
public static List<User> getAllRecords(){  
    List<User> list=new ArrayList<User>();  
      
    try{  
        Connection con=getConnection();  
        PreparedStatement ps=con.prepareStatement("select * from USER_LOGIN");  
        ResultSet rs=ps.executeQuery();  
        while(rs.next()){  
            User u=new User();  
            u.setId(rs.getInt("ID"));  
            u.setName(rs.getString("USERNAME"));  
            u.setPassword(rs.getString("PASWORD"));  
            list.add(u);  
        }  
    }catch(Exception e){System.out.println(e);}  
    return list;  
}  
public static User getRecordById(int id){  
    User u=null;  
    try{  
        Connection con=getConnection();  
        PreparedStatement ps=con.prepareStatement("select * from USER_LOGIN where id=?");  
        ps.setInt(1,id);  
        ResultSet rs=ps.executeQuery();  
        while(rs.next()){  
            u=new User();  
            u.setId(rs.getInt("ID"));  
            u.setName(rs.getString("USERNAME"));  
            u.setPassword(rs.getString("PASWORD"));  
        }  
    }catch(Exception e){System.out.println(e);}  
    return u;  
}
public User validate(User u){  
		try{  
        Connection con=getConnection();  
        PreparedStatement ps=con.prepareStatement("select ID,USERTYPE,USERNAME from USER_LOGIN where USERNAME=? and PASWORD=?");  
        ps.setString(1,u.getName()); 
        ps.setString(2,u.getPassword()); 
        ResultSet rs=ps.executeQuery();  
        while(rs.next()){  
            u=new User();  
            u.setId(rs.getInt("ID"));  
            u.setName(rs.getString("USERNAME"));  
            u.setUSERTYPE(rs.getString("USERTYPE"));  
            u.setPassword(null); 
        }        
    }catch(Exception e){System.out.println(e);    }
		return u;
} 
}  
