<html>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>

<title>Welcome Page</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  
<style>

body {
  background-color: rgb(88, 88, 88); /* For browsers that do not support gradients */
  background-image: linear-gradient(-45deg,lightblue,white); /* Standard syntax (must be last) */
  background-size: 300%;
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
h1 {
  position: relative;
  animation: mymove 1s;
  animation-timing-function:ease;
  text-align: center;
  color:black;
}
h3 {
  position: relative;
  animation: mymove 1s;
  animation-timing-function:ease;
  text-align: center;
  color:black;
}
img {
  position: relative;
  animation: mymove 1s;
  animation-timing-function:ease;
  margin-left:60%;
  align-content:center;
  color:black;
}
@-webkit-keyframes mymove {
  from {left: 100%;}
  to {left: 0%;}
}
div{

}

td {
	border-right: 5px solid #000;
	border-color: silver;
}
.navbar-nav>li {
	border-right: 1px solid #000;
	border-bottom: 1px solid #000;
	border-color: white;
}
.navbar-nav>li:last-child {

	
	border-bottom: 1px solid #000;
	border-color: white;
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
</style>

</head>

<body>

<c:set var="name" value="${name}" scope="request"/>

<nav class="navbar navbar-expand-sm  navbar-dark" style="margin-top:-10px;background-color:#34ccff; ">
  <ul class="navbar-nav mr-auto" >
    <li class="nav-item active">
      <a class="nav-link disabled" href="#">Home</a>
    </li>
  		<li class="nav-item dropdown">
    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">Manage Account </a>
    <div class="dropdown-menu" style="background-color:#34ccff;">
      <a class="dropdown-item" href="/transactions-page" style="color: white;">Deposit/Transfer/Withdraw</a>
      <a class="dropdown-item" href="#" style="color: white">Transaction History</a>
      <a class="dropdown-item" href="#" style="color: white">Change Password</a>
      <div class="dropdown-divider"></div>
      <a class="dropdown-item" href="#">Separated link</a>
    </div>
  </li>
    <li class="nav-item">
      <a class="nav-link" href="/account-details?name=${name}">Account Details</a>
    </li>
    <!-- <li class="nav-item">
      <a class="nav-link disabled" href="#">Disabled</a>
    </li> -->
  </ul>
  <a style="color: White;" >Signed in as ${name}</a>
   <a class="nav-link" href="/logout" style="">Logout</a>
</nav>
<!-- style="margin-left: 20px" align="center" -->
<h1 >Welcome to your DollarsBank Account</h1>
<h3 >Enjoy your stay!</h3>
<a>things</a>
<a>things</a>
<a>things</a>
<a>things</a>
<img src="/img/gp.png" style="width:200px;">
	<%-- <c:param name="name" value="${name}"/> <a href="/list-todos" style="margin-left: 20px">${clickhere}</a> ${statement} --%>
	<footer>
		<div class="fixed-footer" style="background:#34ccff;opacity:70%;" >
		<h4 style="text-align: center;color: black">Copyright © DollarsBank 2020</h4>
		</div >
	</footer>
</body>

</html>