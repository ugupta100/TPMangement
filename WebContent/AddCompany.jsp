<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
  <form class="modal-content animate" action="Company" method="post">
    <div class="imgcontainer">
      <span onclick="document.getElementById('id01').style.display='none'" class="close" title="Close Modal">&times;</span>
      <img src="img_avatar2.png" alt="Avatar" class="avatar">
    </div>

    <div class="container">
      <label for="cid"><b>Company ID</b></label>
      <input type="text" class="modalinput" placeholder="Enter Company ID" name="cid" required>

      <label for="cname"><b>Company Name</b></label>
      <input type="text" class="modalinput" placeholder="Enter Company Name" name="cname" required>
      
      <label for="pno"><b>Phone No</b></label>
      <input type="text" class="modalinput" placeholder="Enter Phone No" name="pno" pattern="^\d{10}$" maxlength="10" required>
      
      <label for="email"><b>Email</b></label>
      <input type="text" class="modalinput" placeholder="Enter Email" name="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" required>
      
      <label for="address"><b>Address</b></label>
      <input type="text" class="modalinput" placeholder="Enter Address" name="address" required>
              
      
      <div class="container">
      <button type="button" onclick="document.getElementById('id01').style.display='none'" class="cancelbtn modalbutton">Cancel</button>
      <button type="submit" style="float:right;background-color:#4caf50d6;" class="modalbutton">Add</button>
    </div>
    </div>
  </form>