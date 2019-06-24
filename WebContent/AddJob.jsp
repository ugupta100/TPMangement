<%@ page language="java" contentType="text/html; charset=UTF-8"
     pageEncoding="UTF-8"%>
     
  <form class="modal-content animate" action="JobC" method="post">
    <div class="imgcontainer">
      <span onclick="document.getElementById('id01').style.display='none'" class="close" title="Close Modal">&times;</span>
      <img src="img_avatar2.png" alt="Avatar" class="avatar">
    </div>

    <div class="container">
      <label for="jid"><b>JOB ID</b></label>
      <input type="text" class="modalinput" placeholder="Enter Company ID" name="jid" required>

      <label for="cid"><b>Company ID</b></label>
      <input type="text" class="modalinput" placeholder="Enter Company Name" name="cid" required>
      
      <label for="jtype"><b>Job Type</b></label>
      <input type="text" class="modalinput" placeholder="Enter Phone No" name="jtype" required>
      
      <label for="skill"><b>Skill</b></label>
      <input type="text" class="modalinput" placeholder="Enter Email" name="skill" required>
      
      <label for="minexp"><b>Min Exp</b></label>
      <input type="text" class="modalinput" placeholder="Enter Address" name="minexp" required>
      
      <label for="maxexp"><b>Max Exp</b></label>
      <input type="text" class="modalinput" placeholder="Enter Address" name="maxexp" required>
      
      <label for="vdate"><b>Valid Date</b></label>
      <input type="date" class="modalinput" placeholder="Enter Address" name="vdate" required>
      
      <label for="vacancy"><b>Vacancy</b></label>
      <input type="text" class="modalinput" placeholder="Enter Address" name="vacancy" required>
      
      <div class="container">
      <button type="button" onclick="document.getElementById('id01').style.display='none'" class="cancelbtn modalbutton">Cancel</button>
      <button type="submit" style="float:right;background-color:#4caf50d6;" class="modalbutton">Add</button>
    </div>
    </div>
  </form>
