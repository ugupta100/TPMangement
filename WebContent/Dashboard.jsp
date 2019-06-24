<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%   
  
int id=(int)(session.getAttribute("ID")==null?0:session.getAttribute("ID"));  
String Usertype=(String)session.getAttribute("USERTYPE");
if(id<=0 || !Usertype.equals("ADMIN"))  
{
	response.sendRedirect("index.jsp");
}
  
%>  
<style>
.w3-third {
float:left;width:23.5%;padding:0 8px;
margin-top:16px!important;
margin-bottom:16px!important;
flex: 1;
}
.w3-container {
padding:0.01em 16px;
color:#000!important;
background-color:#fff!important;
}
.w3-theme {
color:#000 !important; 
background-color:#fff !important;
padding:0 8px;
display: flex;
}
.w3-card-4{
box-shadow:0 4px 10px 0 rgba(0,0,0,0.2),0 4px 20px 0 rgba(0,0,0,0.19)
}
</style>
</head>
<body style="background-color:#fff !important;">
<%@include file="AdminHeader.html" %>
<div class="w3-theme">
<div class="w3-third">
<div class="w3-card-4">
<img src="img_5terre.jpg" style="width:100%">
<div class="w3-container">
<h4>Cinque Terre</h4>
<p>The Cinque Terre (five lands) is a portion of the Italian Riviera. The coastline with five villages: Monterosso, Vernazza, Corniglia, Manarola, and Riomaggiore
is a UNESCO World Heritage Site.</p>
</div>
</div>
</div>

<div class="w3-third">
<div class="w3-card-4">
<img src="img_monterosso.jpg" style="width:100%">
<div class="w3-container">
<h4>Monterosso</h4>
<p>Monterosso al Mare is located at the center of a small natural gulf, protected by a small artificial reef,
in the Riviera of La Spezia. It is the northernmost village of the Cinque Terre.</p>
</div>
</div>
</div>

<div class="w3-third">
<div class="w3-card-4">
<img src="img_vernazza.jpg" style="width:100%">
<div class="w3-container">
<h4>Vernazza</h4>
<p>Vernazza is another of the five towns in the region. Vernazza is the fourth town heading north. It has no car traffic, and is one of the truest
"fishing villages" on the Italian Riviera.
</div>
</div>
</div>

<div class="w3-third">
<div class="w3-card-4">
<img src="img_monterosso.jpg" style="width:100%">
<div class="w3-container">
<h4>Monterosso</h4>
<p>Monterosso al Mare is located at the center of a small natural gulf, protected by a small artificial reef,
in the Riviera of La Spezia. It is the northernmost village of the Cinque Terre.</p>
</div>
</div>
</div>
</div>
</body>
</html>