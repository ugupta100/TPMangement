<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="com.dbproperties.pkg.Job,com.model.pkg.JobM,java.util.*"%>  
 <%  
 String id=request.getParameter("id");  
Job u=JobM.getRecordById(Integer.parseInt(id));  
request.setAttribute("Cmp",u);  
%>  
<form class="modal-content animate">
    <div class="imgcontainer">
      <span onclick="document.getElementById('id01').style.display='none'" class="close" title="Close Modal">&times;</span>
      <img src="img_avatar2.png" alt="Avatar" class="avatar">
    </div>

    <div class="container">
      <label for="jid"><b>JOB ID</b></label>
      <input type="text" class="modalinput" placeholder="Enter Job ID" name="jid" value="<%= u.getJOBID()%>" readonly disabled>

      <label for="cid"><b>Company Name</b></label>
      <input type="text" class="modalinput" placeholder="Enter Company Name" name="cid" value="<%= u.getCOMPANYNAME()%>" readonly disabled>
      
      <label for="jtype"><b>Job Type</b></label>
      <input type="text" class="modalinput" placeholder="Enter job type" name="jtype" value="<%= u.getJOBTYPE()%>" required>
      
      <label for="skill"><b>Skill</b></label>
      <input type="text" class="modalinput" placeholder="Enter skill required" name="skill" value="<%= u.getSKILL()%>" required>
      
      <label for="minexp"><b>Min Exp</b></label>
      <input type="text" class="modalinput" placeholder="Enter min experience required" name="minexp" value="<%= u.getMINEXP()%>" required>
      
      <label for="maxexp"><b>Max Exp</b></label>
      <input type="text" class="modalinput" placeholder="Enter max experience required" name="maxexp" value="<%= u.getMAXEXP()%>" required>
      
      <label for="vdate"><b>Valid Date</b></label>
      <input type="date" class="modalinput" placeholder="Enter valid till date" name="vdate" value="<%= u.getVALIDDATE()%>" required>
      
      <label for="vacancy"><b>Vacancy</b></label>
      <input type="text" class="modalinput" placeholder="Enter no of vacancies" name="vacancy" value="<%= u.getVACANCY()%>" required>
      
      <div class="container">
      <button type="button" onclick="document.getElementById('id01').style.display='none'" class="cancelbtn modalbutton">Cancel</button>
      <input type="button" onclick="editjob()" style="float:right;background-color:#4caf50d6;" class="modalbutton" value="Update">
    </div>
    </div>
  </form>
  