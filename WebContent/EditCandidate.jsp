<%@ page language="java" contentType="text/html; charset=UTF-8"
     pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
     <sql:setDataSource var="ds" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/TPManagement" user="root" password="root"/>
     <sql:query dataSource="${ds}" var="result">
    SELECT DEPARTMENTCODE `key`,DEPARTMENT `value` from DEPARMENT where ISACTIVE=1;
</sql:query>
     <%@page import="com.dbproperties.pkg.Cand,com.model.pkg.CandidateM,java.util.*"%>  
 <%  
 String id=request.getParameter("id");  
 Cand u=CandidateM.getRecordById(Integer.parseInt(id));  
request.setAttribute("Cmp",u);  
%>  
  <form class="modal-content animate" action="CandidateC" method="GET">
    <div class="imgcontainer">
      <span onclick="document.getElementById('id01').style.display='none'" class="close" title="Close Modal">&times;</span>
      <img src="img_avatar2.png" alt="Avatar" class="avatar">
    </div>

    <div class="container">
      <label for="rno"><b>Roll No</b></label>
      <input type="text" class="modalinput" placeholder="Enter Roll No" name="rno" value="<%= u.getROLLNO()%>" readonly>

      <label for="name"><b>Name</b></label>
      <input type="text" class="modalinput" placeholder="Enter Name" name="name" value="<%= u.getNAME()%>" readonly>
      
      <label for="phno"><b>Phone No</b></label>
      <input type="text" class="modalinput" placeholder="Enter Phone No" name="phno" value="<%= u.getPHONENO()%>" required>
      
      <label for="dpt"><b>Department</b></label>
      <select name="dpt" class="modalinput">
      <option value=''>--Select--</option>
      <c:forEach var="row" items="${result.rows}">
      <option value='<c:out value="${row.key}"/>' ${item.key == u.getDEPARTMENTCODE() ? 'selected="selected"' : ''}><c:out value="${row.value}"/></option>
</c:forEach>
</select>
      <label for="email"><b>Email</b></label>
      <input type="text" class="modalinput" placeholder="Enter Email Address" name="email" value="<%= u.getEMAIL()%>"  required>
      
      <label for="sem"><b>Semester</b></label>
      <input type="number" class="modalinput" placeholder="Enter Semester" name="sem" value="<%= u.getSEMESTER()%>"  required>
      
      <div class="container">
      <button type="button" onclick="document.getElementById('id01').style.display='none'" class="cancelbtn modalbutton">Cancel</button>
      <button type="submit" style="float:right;background-color:#4caf50d6;" class="modalbutton">Update</button>
    </div>
    </div>
  </form>
