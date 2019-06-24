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

<button onclick="addjob()" style="width:auto;background-color: moccasin;" class="modalbutton">Add Training</button>

<div id="id01" class="modal">
  
</div>
        <%@page import="com.dbproperties.pkg.Train,com.model.pkg.TrainingM,java.util.*"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
  
<h1>Training Available</h1>  
  
<%  
List<Train> list=TrainingM.getAllRecords();  
request.setAttribute("list",list);  
%>  
  
<table id="myTd" border="1">  
<tr><th>Training ID</th><th>Training NAME</th><th>START DATE</th><th>End DATE</th>  
<th>Start Time</th><th>End Time</th><th>Venue</th><th>Edit</th><th>Delete</th></tr>  
<c:forEach items="${list}" var="u">  
<tr><td>${u.getTRID()}</td><td>${u.getTRAININGNAME()}</td><td>${u.getSTARTDATE()}</td>  
<td>${u.getENDDATE()}</td><td>${u.getSTARTTIME()}</td><td>${u.getENDTIME()}</td><td>${u.getVENUE()}</td>
<td><button onclick="editjobmodal(${u.getId()})" style="background-color:transparent; border-color:transparent;"> 
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
// var y="jid=J2&jtype=new2&skill=BCA&minexp=0&maxexp=1&vdate=2019-04-16&vacancy=100"
// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }

}

function addjob() {
	  var xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	    	
	      document.getElementById("id01").innerHTML =
	      this.responseText;
	      document.getElementById('id01').style.display='block';
	    }
	  };
	  xhttp.open("GET", "AddTraining.jsp", true);
	  xhttp.send(); 
	  
	}

function editjobmodal(id) {
	  var xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	    
	      document.getElementById("id01").innerHTML =
	      this.responseText;
	      document.getElementById('id01').style.display='block';
	    }
	  };
	  xhttp.open("GET", "EditTraining.jsp?id="+id, true);
	  xhttp.send(); 
	  
  }
function editjob() {
	  var xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200 && this.responseText==1) {
	    	location.reload(true);
	    		    }
	  };
	  var y="";
	var x=document.getElementsByTagName("form")[0];
	  for(var i=0;i<x.length;i++)
	  {
		  y=y+x[i].name+"="+x[i].value+"&";
		  };
	  xhttp.open("PUT", "TrainingC?"+y, true);
	  xhttp.send(); 
	  
}
function deletejob(id) {
	  var xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200 && this.responseText==1) {
	    	location.reload();
	    		    }
	  };
	  xhttp.open("DELETE", "TrainingC?id="+id, true);
	  xhttp.send(); 
	  
	  
}
  function confirmdelete(d) {
	  d.parentElement.parentElement.cells[8].style.display = "none";
	  d.parentElement.parentElement.cells[7].style.display = "none";
	  d.parentElement.parentElement.cells[9].style.display = "";

}
  function normalImg(d) {
	  d.parentElement.parentElement.cells[8].style.display = "";
	  d.parentElement.parentElement.cells[7].style.display = "";
	  d.parentElement.parentElement.cells[9].style.display = "none";

}
</script>
</body>
</html>