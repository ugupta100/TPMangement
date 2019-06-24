<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%   
  
    int id=(int)(session.getAttribute("ID")==null?0:session.getAttribute("ID"));  
    String Usertype=(String)session.getAttribute("USERTYPE");
    if(id<=0 || !Usertype.equals("CANDIDATE"))  
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
<%@include file="CandidateHeader.html" %>

<div id="id01" class="modal">
  
</div>
        <%@page import="com.dbproperties.pkg.Train,com.model.pkg.CandidateTrainingM,java.util.*"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
  
<h1>Training Available</h1>  
  
<%  
List<Train> list=CandidateTrainingM.getAllRecords(id);  
request.setAttribute("list",list);  
%>  
  
<table id="myTd" border="1">  
<tr><th>Training ID</th><th>Training NAME</th><th>START DATE</th><th>End DATE</th>  
<th>Start Time</th><th>End Time</th><th>Venue</th><th>Register</th></tr>  
<c:forEach items="${list}" var="u">  
<tr><td>${u.getTRID()}</td><td>${u.getTRAININGNAME()}</td><td>${u.getSTARTDATE()}</td>  
<td>${u.getENDDATE()}</td><td>${u.getSTARTTIME()}</td><td>${u.getENDTIME()}</td><td>${u.getVENUE()}</td>
<td><button onclick="confirmdelete(this)" style="background-color:transparent; border-color:transparent;"> 
  <img src="icons/icons8-submit-resume-52.png" height="20"/>
</button></td>
<td style="display:none;text-align: -webkit-center;background-color: #4CAF50;">
<button onmouseout="normalImg(this)" onclick="deletejob(${u.getId()})" style="background-color:transparent; border-color:transparent; width:100%; height:100%;color: white; font-size: 13pt; border-width: 3.5px;"> 
 Register?
</button></td>
</tr>  
</c:forEach>  
</table>
<script>
// Get the modal
var modal = document.getElementById('id01');
//var y="jid=J2&jtype=new2&skill=BCA&minexp=0&maxexp=1&vdate=2019-04-16&vacancy=100"
// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }

}




function deletejob(id) {
	  var xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200 && this.responseText==1) {
	    	location.reload();
	    		    }
	  };
	  xhttp.open("GET", "CandidateTrainingC?trid="+id, true);
	  xhttp.send(); 
	  
	  
}
  function confirmdelete(d) {
	  d.parentElement.parentElement.cells[8].style.display = "";
	  d.parentElement.parentElement.cells[7].style.display = "none";

}
  function normalImg(d) {
	  d.parentElement.parentElement.cells[8].style.display = "none";
	  d.parentElement.parentElement.cells[7].style.display = "";

}
</script>
</body>
</html>