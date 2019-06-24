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
	<style>
.w3-bar{width:100%;overflow:hidden} .w3-bar{display:inline-block;}
.w3-bar{float:left;border:none;display:block;outline:0}
.w3-bar{position:static;float:left}
.w3-bar{white-space:normal}
.w3-bar:before,.w3-bar:after{content:"";display:table;clear:both}
.w3-ul{list-style-type:none;padding:0;margin:0;overflow-y: -webkit-paged-x;}.w3-ul li{border-bottom:1px solid #ddd}.w3-ul li:last-child{border-bottom:none}
.w3-ul{box-shadow:0 4px 10px 0 rgba(0,0,0,0.2),0 4px 20px 0 rgba(0,0,0,0.19)}
</style>
</head>
<body style="background-color:#fff !important;">
<%@include file="AdminHeader.html" %>

        <%@page import="com.dbproperties.pkg.Train,com.model.pkg.CandidateTrainingM,java.util.*"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
  
<h1>Training Available</h1>  
  
<%  
List<Train> list=CandidateTrainingM.getAllAllotment();  
request.setAttribute("list",list);  
%>  
  
<ul class="w3-ul">
<c:forEach items="${list}" var="u">  
<li class="w3-bar">
<div style="display: flex;">
<img src="images/img_avatar2.png" class="w3-bar-item w3-circle w3-hide-small" style="width: 45px;height: 45px;border-radius: 50%;    border-radius: 50%;padding: 2.5px;">
<span style="align-items: center;display: flex;flex: 1;height:50px;padding-left: 10px;"> ${u.getTRAININGNAME()}</span>
<button onclick="trainingallotment(${u.getId()},1)" style="float:right;background-color:#4caf50d6; border-color:transparent; width:10%; font-size: 13pt; border-width: 3.5px;"> 
Accept
</button>
<button onclick="trainingallotment(${u.getId()},0)" style="float:right;background-color:#f44336d4; border-color:transparent; width:10%; font-size: 13pt; border-width: 3.5px;"> 
Reject
</button>
</div>
</li>
</c:forEach>  
</ul>
<script>

function trainingallotment(id,allotment) {
	  var xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200 && this.responseText==1) {
	    	location.reload();
	    		    }
	  };
	  xhttp.open("PUT", "CandidateTrainingC?id="+id+"&allotment="+allotment, true);
	  xhttp.send(); 
	  
	  
}

</script>
</body>
</html>