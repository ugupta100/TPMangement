<%@ page language="java" contentType="text/html; charset=UTF-8"
     pageEncoding="UTF-8"%>
     
  <form class="modal-content animate" action="TrainingC" method="post">
    <div class="imgcontainer">
      <span onclick="document.getElementById('id01').style.display='none'" class="close" title="Close Modal">&times;</span>
      <img src="img_avatar2.png" alt="Avatar" class="avatar">
    </div>

    <div class="container">
      <label for="trid"><b>Training ID</b></label>
      <input type="text" class="modalinput" placeholder="Enter Training ID" name="trid" required>

      <label for="trainingname"><b>Training Name</b></label>
      <input type="text" class="modalinput" placeholder="Enter Training Name" name="trainingname" required>
      
      <label for="stdate"><b>Start Date</b></label>
      <input type="date" class="modalinput" placeholder="Enter Start Date" name="stdate" required>
      
      <label for="eddate"><b>End Date</b></label>
      <input type="date" class="modalinput" placeholder="Enter End Date" name="eddate" required>
      
      <label for="sttime"><b>Start Time</b></label>
      <input type="time" class="modalinput" placeholder="Enter Start Time" name="sttime" required>
      
      <label for="edtime"><b>End Time</b></label>
      <input type="time" class="modalinput" placeholder="Enter End Time" name="edtime" required>
      
      <label for="venue"><b>Venue</b></label>
      <input type="text" class="modalinput" placeholder="Enter Venue" name="venue" required>
      
      <div class="container">
      <button type="button" onclick="document.getElementById('id01').style.display='none'" class="cancelbtn modalbutton">Cancel</button>
      <button type="submit" style="float:right;background-color:#4caf50d6;" class="modalbutton">Add</button>
    </div>
    </div>
  </form>
