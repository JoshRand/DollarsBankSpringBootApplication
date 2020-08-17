<html>

<head>
<title>First Web Application</title>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<style>


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
 /*black or silver, which is best*/
  /*  background-color: rgb(88, 88, 88);*/
  background-color: rgb(88, 88, 88); /* For browsers that do not support gradients */
  background-image: linear-gradient(-45deg,grey,white); /* Standard syntax (must be last) */
  background-size: 800%;
  -webkit-animation-name: change;
  -webkit-animation-duration: 15s;
  -webkit-animation-iteration-count: infinite;
  -webkit-animation-direction: alternate;
 
}
@-webkit-keyframes change {
	/* 0% {background-position: 0 50%;} 
	50% {background-position: 100% 50%;}
	100% {background-position: 0 50%;}
	 */
	  from {
   background-position: 20%;
 }
 to {
   background-position: 60%;
 }
} 
div{
position: relative;

}
</style>

</head>



<!-- <h1 style="margin-left: 20px" style="margin-top:20px">Welcome to the Login page</h1>
	<h4 style="margin-left: 40px">Please login to view Todos</h4>
	 -->

<body >
	
	<div style="background:#34ccff;opacity:70%" >
		<h1 style="text-align: center;color: black">Welcome to Dollars Bank</h1>
		<h4 style="text-align: center;color: black">Please login to view your Account</h4>
		</br>
	
	</div >
		<form method="post"  style="padding: 20px;text-align:center;margin-left: -240px">
		
		<h6 style="margin-left: -150px; color:black" ><u>Name :</u></h6> <input type="text" name="name" placeholder="Enter Username" style="margin-left: 10px"/>
	
		<h6 style="margin-left: -125px; color:black"><u>Password :</u></h6> <input type="password" name="password" placeholder="Enter Password" style="margin-left: 10px"/><br> 
		</br>
		<input type="submit" class= "btn btn-Danger" style="margin-left: -100px"/>
	
		<font color="red">${errorMessage}</font> 
		<br>
		<br>
		<a style="margin-left: 70px; color:black" >Don't have an account?</a><a href="registration-page" style="margin-left: 10px ;color:blue" >Register Here</a>
	
	</form>
	
</body>

</html>