<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%   
    int id=(int)(session.getAttribute("ID")==null?0:session.getAttribute("ID"));  
    String Usertype=(String)session.getAttribute("USERTYPE");
    if(id>0 && Usertype.equals("ADMIN"))  
    {
    	response.sendRedirect("Dashboard.jsp");
    }
    else if(id>0 && Usertype.equals("CANDIDATE")) 
    {
    	response.sendRedirect("CandidateDashboard.jsp");
    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
<style>
.alert {
 margin: 10px;    background-color: lightcoral;     text-align: center; 
}

.closebtn {
  margin-left: 15px;
  color: white;
  font-weight: bold;
  float: right;
  font-size: 22px;
  line-height: 20px;
  cursor: pointer;
  transition: 0.3s;
}

.closebtn:hover {
  color: black;
}

</style>
<title>Login V6</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->
<link rel="icon" type="image/png" href="images/icons/favicon.ico" />
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="fonts/iconic/css/material-design-iconic-font.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/select2/select2.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="css/util.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
<!--===============================================================================================-->
</head>
<body>

	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100 p-t-85 p-b-20">
				<form class="login100-form validate-form" onsubmit="return register()">
					<span class="login100-form-title p-b-70"> Welcome </span> 
					<span
						class="login100-form-avatar"> <img
						src="images/avatar-01.jpg" alt="AVATAR">
					</span>
					<div class="wrap-input100 validate-input m-t-85 m-b-35"
						data-validate="Enter username">
						<input id="roll" class="input100" type="text" name="rno"> <span
							class="focus-input100" data-placeholder="Roll No"></span>
					</div>
					<div class="wrap-input100 validate-input m-b-50"
						data-validate="Enter password">
						<input id="pass1" class="input100" type="password" name="pass1"> <span
							class="focus-input100" data-placeholder="Password"></span>
					</div>
					<div class="wrap-input100 validate-input m-b-50"
						data-validate="Enter password">
						<input id="pass2" class="input100" type="password" name="pass2"> <span
							class="focus-input100" data-placeholder="Password"></span>
					</div>

					<div class="container-login100-form-btn">
					
						<button class="login100-form-btn" type="submit">Register</button>
					</div>
										<div id="errors" class="alert" style="display: none;">
</div>		
<div id="success" class="alert"  style="display: none;    background-color: lightblue;">
<span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span> 
Login Created Successfully <input style="background-color: transparent; color: aliceblue;" type='button' value='Click here to Login' onclick="window.location.href='index.jsp'"></div>
					<ul class="login-more p-t-190">
						<li class="m-b-8"><span class="txt1"> Forgot </span> <a
							href="#" class="txt2"> Username / Password? </a></li>

						<li><span class="txt1"> Already have an account? </span> <a
							href="index.jsp" class="txt2">Login Here</a></li>
					</ul>
				</form>
			</div>
		</div>
	</div>


	<div id="dropDownSelect1"></div>

	<!--===============================================================================================-->
	<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
	<!--===============================================================================================-->
	<script src="vendor/animsition/js/animsition.min.js"></script>
	<!--===============================================================================================-->
	<script src="vendor/bootstrap/js/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
	<!--===============================================================================================-->
	<script src="vendor/select2/select2.min.js"></script>
	<!--===============================================================================================-->
	<script src="vendor/daterangepicker/moment.min.js"></script>
	<script src="vendor/daterangepicker/daterangepicker.js"></script>
	<!--===============================================================================================-->
	<script src="vendor/countdowntime/countdowntime.js"></script>
	<!--===============================================================================================-->
	<script src="js/main.js"></script>

</body>
<script>

function register(){
	document.getElementById('success').style.display="none";
	document.getElementById('errors').style.display="";
	var status;
	if(document.getElementById('pass1').value==document.getElementById('pass2').value && document.getElementById('pass1').value!="" && document.getElementById('roll').value!=""){
		  var xhttp = new XMLHttpRequest();
		  xhttp.onreadystatechange = function() {
		    if (this.readyState == 4 && this.status == 200) {
		    	
		    	status =this.responseText;
				if(status==1){
				    document.getElementById('success').style.display="";
					}
				else if(status==0){
				    document.getElementById('errors').innerHTML="Roll No. Dosen't Exists";
				    document.getElementById('errors').style.display="";
					}
				else if(status==-1){
				    document.getElementById('errors').innerHTML="Roll No. already Registerd";
				    document.getElementById('errors').style.display="";
					}
		     
		    }
		  };
		  xhttp.open("PUT", "Login?rno="+document.getElementById('roll').value+"&pass1="+document.getElementById('pass1').value, true);
		  xhttp.send();

	}
	else{
	    document.getElementById('errors').innerHTML="Password Dosent Match";
	    document.getElementById('errors').style.display="";
	}
return false;
}

</script>
</html>