<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%   
  
    int id=(int)(session.getAttribute("ID")==null?0:session.getAttribute("ID"));  
    String Usertype=(String)session.getAttribute("USERTYPE");
    if(id<=0 || !Usertype.equals("ADMIN"))  
    {
    	response.sendRedirect("index.jsp");
    }
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="css/App.css">
</head>
<body style="background-color:#fff !important;">
<%@include file="AdminHeader.html" %>

<button onclick="addcmp()" style="width:auto;background-color: moccasin;" class="modalbutton">Add Company</button>

<div id="id01" class="modal">
  
</div>
        <%@page import="com.dbproperties.pkg.Cmp,com.model.pkg.CompanyM,java.util.*"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
  
<h1>Company Registered</h1>  
  
<%  
List<Cmp> list=CompanyM.getAllRecords();  
request.setAttribute("list",list);  
%>  
  
<table border="1">  
<tr><th>COMPANYID</th><th>COMPANYNAME</th><th>PHONE</th><th>Email</th>  
<th>ADRESS</th><th>Edit</th><th>Delete</th></tr>  
<c:forEach items="${list}" var="u">  
<tr><td>${u.getCOMPANYID()}</td><td>${u.getCOMPANYNAME()}</td><td>${u.getPHONE()}</td>  
<td>${u.getEMAIL()}</td><td>${u.getADRESS()}</td>  
<td><button onclick="editcmp(${u.getId()})" style="background-color:transparent; border-color:transparent;"> 
  <img src="icons/icons8-pencil-filled-52.png" height="20"/>
</button></td>  
<td><button onclick="confirmdelete(this)" style="background-color:transparent; border-color:transparent;"> 
  <img src="icons/icons8-trash-52.png" height="20"/>
</button></td>
<td colspan="2" style="display:none;text-align: -webkit-center;background-color: #cd4737;">
<button onmouseout="normalImg(this)" onclick="deletejob(${u.getId()})" style="background-color:transparent; border-color:transparent; width:100%; height:100%;color: white; font-size: 13pt; border-width: 3.5px;"> 
 Delete?
</button></td>
</tr>  
</c:forEach>  
</table>

<script>
// Get the modal
var modal = document.getElementById('id01');

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}


function addcmp() {
	  var xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	    	debugger;
	      document.getElementById("id01").innerHTML =
	      this.responseText;
	      document.getElementById('id01').style.display='block';
	    }
	  };
	  xhttp.open("GET", "AddCompany.jsp", true);
	  xhttp.send(); 
	  
	}

function editcmp(id) {
	  var xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	    	debugger;
	      document.getElementById("id01").innerHTML =
	      this.responseText;
	      document.getElementById('id01').style.display='block';
	    }
	  };
	  xhttp.open("GET", "EditCompany.jsp?id="+id, true);
	  xhttp.send(); 
	  
	}
function deletejob(id) {
	  var xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200 && this.responseText==1) {
	    	location.reload();
	    		    }
	  };
	  xhttp.open("DELETE", "Company?id="+id, true);
	  xhttp.send(); 
	  
	  
}
function confirmdelete(d) {
	  d.parentElement.parentElement.cells[5].style.display = "none";
	  d.parentElement.parentElement.cells[6].style.display = "none";
	  d.parentElement.parentElement.cells[7].style.display = "";

}
function normalImg(d) {
	  d.parentElement.parentElement.cells[5].style.display = "";
	  d.parentElement.parentElement.cells[6].style.display = "";
	  d.parentElement.parentElement.cells[7].style.display = "none";

}
</script>
</body>
</html>