<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="com.dbproperties.pkg.Cmp,com.model.pkg.CompanyM,java.util.*"%>  
 <%  
 String id=request.getParameter("id");  
Cmp u=CompanyM.getRecordById(Integer.parseInt(id));  
request.setAttribute("Cmp",u);  
%>  
  <form class="modal-content animate" action="EditUser.jsp" method="post">
    <div class="imgcontainer">
      <span onclick="document.getElementById('id01').style.display='none'" class="close" title="Close Modal">&times;</span>
      <img alt="Avatar" class="avatar">
    </div>

    <div class="container">
      <label for="cid"><b>Company ID</b></label>
      <input type="text" class="modalinput" placeholder="Enter Company ID" name="cid" value="<%= u.getCOMPANYID()%>" readonly>

      <label for="cname"><b>Company Name</b></label>
      <input type="text" class="modalinput" placeholder="Enter Company Name" name="cname" value="<%= u.getCOMPANYNAME()%>" readonly>
      
      <label for="pno"><b>Phone No</b></label>
      <input type="text" class="modalinput" placeholder="Enter Phone No" name="pno" value="<%= u.getPHONE()%>" pattern="^\d{10}$" maxlength="10" required>
      
      <label for="email"><b>Email</b></label>
      <input type="text" class="modalinput" placeholder="Enter Email" name="email" value="<%= u.getEMAIL()%>" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" required>
      
      <label for="address"><b>Address</b></label>
      <input type="text" class="modalinput" placeholder="Enter Address" name="address" value="<%= u.getADRESS()%>" required>
      <div class="container">
      <button type="button" onclick="document.getElementById('id01').style.display='none'" class="cancelbtn modalbutton">Cancel</button>
      <button type="submit" style="float:right;background-color:#4caf50d6;" class="modalbutton">Update</button>
    </div>
    </div>
  </form>
