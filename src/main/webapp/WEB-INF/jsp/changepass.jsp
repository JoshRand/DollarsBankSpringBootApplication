<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<html>
<head>
<title>password change</title>
<meta charset="ISO-8859-1">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  <link rel="stylesheet" href="/CSS/style.css">

<style >


</style>

</head>

<body>
<nav class="navbar navbar-expand-sm  navbar-dark" style="margin-top:-10px;background-color:#34ccff; ">
  <ul class="navbar-nav mr-auto" >
    <li class="nav-item">
      <a class="nav-link disabled" href="/welcome-page">Home</a>
    </li>
  		<li class="nav-item dropdown  active">
    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">Manage Account </a>
    <div class="dropdown-menu" style="background-color:#34ccff;">
      <a class="dropdown-item" href="/transactions-page" style="color: white;">Deposit/Transfer/Withdraw</a>
      <a class="dropdown-item" href="/transactions-history" style="color: white">Transaction History</a>
      <a class="dropdown-item" href="#" style="color: white">Change Password</a>
      <div class="dropdown-divider"></div>
      <a class="dropdown-item" href="#">Separated link</a>
    </div>
  </li>
    <li class="nav-item">
     <a class="nav-link" href="/account-details">Account Details</a>
    </li>
    <!-- <li class="nav-item">
      <a class="nav-link disabled" href="#">Disabled</a>
    </li> -->
  </ul>
  <a style="color: White;" >Signed in as ${name}</a>
   <a class="nav-link" href="/logout" style="">Logout</a>
</nav>
<h1>Change Password</h1>
	<form method="post"   style="padding: 20px;text-align:center;margin-left:0px">
			
			<h6 style="margin-left: -150px; color:black" ><u>Current Password :</u></h6> 
			<input type="text" name="prevpassword" placeholder="" style="margin-left: -10px" required/>
		
			<h6 style="margin-left: -125px; color:black"><u>New Password :</u></h6> 
			<input type="text" name="newpassword" placeholder="" style="margin-left: -10px"required/><br> 
			
			<h6 style="margin-left: -125px; color:black"><u>New Password Repeat :</u></h6> 
			<input type="text" name="newpasswordrepeat" placeholder="" style="margin-left: -10px"required/><br> 
			
			
			</br>
			<input type="submit" class= "btn btn-info" style="margin-left: -10px"/>
			<br>
			<br>
			<% 
			Object param = request.getAttribute("errorMessage");		
			if(param == null){%>
			<%}else{ %>
			<font color="red">[${errorMessage}]</font> 
			<%} %>
			<br>
			<br>
			
		</form>
	<footer>
		<div class="fixed-footer" style="background: #34ccff; opacity: 70%;">
			<h4 style="text-align: center; color: black">Copyright ©
				DollarsBank 2020</h4>
		</div>
	</footer>
</body>
</html>