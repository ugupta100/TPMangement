<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="com.dbproperties.pkg.Train,com.model.pkg.TrainingM,java.util.*"%>  
 <%  
 String id=request.getParameter("id");  
Train u=TrainingM.getRecordById(Integer.parseInt(id));  
request.setAttribute("Train",u);  
%>  
<form class="modal-content animate">
    <div class="imgcontainer">
      <span onclick="document.getElementById('id01').style.display='none'" class="close" title="Close Modal">&times;</span>
      <img src="img_avatar2.png" alt="Avatar" class="avatar">
    </div>

    <div class="container">
      <label for="trid"><b>Training ID</b></label>
      <input type="text" class="modalinput" placeholder="Enter Training ID" name="trid" value="<%= u.getTRID()%>" readonly disabled>

      <label for="trainingname"><b>Training Name</b></label>
      <input type="text" class="modalinput" placeholder="Enter Training Name" name="trainingname" value="<%= u.getTRAININGNAME()%>" readonly disabled>
      
      <label for="stdate"><b>Start Date</b></label>
      <input type="date" class="modalinput" placeholder="Enter Start Date" name="stdate" value="<%= u.getSTARTDATE()%>" required>
      
      <label for="eddate"><b>End Date</b></label>
      <input type="date" class="modalinput" placeholder="Enter End Date" name="eddate" value="<%= u.getENDDATE()%>" required>
      
      <label for="sttime"><b>Start Time</b></label>
      <input type="time" class="modalinput" placeholder="Enter Start Time" name="sttime" value="<%= u.getSTARTTIME()%>" required>
      
      <label for="edtime"><b>End Time</b></label>
      <input type="time" class="modalinput" placeholder="Enter End Time" name="edtime" value="<%= u.getENDTIME()%>" required>
      
      <label for="venue"><b>Venue</b></label>
      <input type="text" class="modalinput" placeholder="Enter Venue" name="venue" value="<%= u.getVENUE()%>" required>
      
      <div class="container">
      <button type="button" onclick="document.getElementById('id01').style.display='none'" class="cancelbtn modalbutton">Cancel</button>
      <input type="button" onclick="editjob()" style="float:right;background-color:#4caf50d6;" class="modalbutton" value="Update">
    </div>
    </div>
  </form>
  