<html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
<title>First Web Application</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  
<style>

<c:url value="/img/Gold_bar.png" var = "bar" />
<c:url value="/img/gp.png" var = "gp" />
.navbar-nav>li {
	border-right: 1px solid #000;
	border-color: silver;
}
td {
	border-right: 5px solid #000;
	border-color: silver;
}
.navbar-nav>li:last-child {
	border: none;
}

body {
  background-color: rgb(88, 88, 88); /* For browsers that do not support gradients */
  background-image: linear-gradient(-45deg,lightblue,white); /* Standard syntax (must be last) */
  background-size: 200%;
  -webkit-animation-name: change;
  -webkit-animation-duration: 5s;
  -webkit-animation-iteration-count: infinite;
  -webkit-animation-direction: alternate;
 
}
@-webkit-keyframes change {
	  from {
   background-position: 10%;
 }
 to {
   background-position: 80%;
 }
} 
div{
/* position: relative; */

}
.fixed-footer{
 		width: 100%;
        position: fixed;        
        background: #333;
        padding: 10px 0;
        color: #fff;
}
.fixed-footer{
        bottom: 0;
    }

  .login {
  	width:47%;
    margin:auto;
    margin-top:1%;
  }

</style>

</head>

<body >
	
	<div style="background:#34ccff;opacity:70%" >
	
		<h1 style="text-align: center;color: black">Welcome to Dollars Bank</h1>
		
		<h4 style="text-align: center;color: black;padding-bottom:10px">Please login to view your Account</h4>
		
		</br>
		<h6 style="text-align:right;color: black; padding:10px;margin-top:-50px"><img class="mail" src="/img/mail.png" style="width:20px;">  DollarsBank@DollarsB.com      <img class="phone" src="/img/phone.png" style="width:20px;">     555-324-3214</h6>
	</div >
	
	<!-- <img class="Goldbar" src="/img/Gold_bar.png" style="width:100px;padding-top:8px;margin-left:49%;margin-right:49%;display:block;top:0;"> -->
	
	
	<div class="login" style="background:white;border: 10px solid;border-color: lightblue"><!-- margin-left:40%;margin-top:1%;margin-right:40%"> -->
		<form method="post"   style="padding: 20px;text-align:center;margin-left:0px">
			
			<h6 style="margin-left: -150px; color:black" ><u>Name :</u></h6> 
			<input type="text" name="name" placeholder="Enter Username" style="margin-left: -10px" required/>
		
			<h6 style="margin-left: -125px; color:black"><u>Password :</u></h6> 
			<input type="password" name="password" placeholder="Enter Password" style="margin-left: -10px"required/><br> 
			
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
			<a style="margin-left: -20px; color:black;" >Don't have an account?</a><a href="registration-page" style="margin-left: 10px ;color:blue" >Register Here</a>
		
		</form>
	
	</div>
		<img src="/img/gp.png" style="width:200px;margin-left:80%;display:block;top:0;">
	<footer>
		<div class="fixed-footer" style="background:#34ccff;opacity:70%;" >
		<h4 style="text-align: center;color: black">Copyright © DollarsBank 2020</h4>
		</div >
	</footer>
</body>

</html>