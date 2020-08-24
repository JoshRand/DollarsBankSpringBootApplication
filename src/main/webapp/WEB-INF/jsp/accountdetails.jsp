<html>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>

<meta charset="ISO-8859-1">
<title>account details</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  <link rel="stylesheet" href="/CSS/style.css">

<style>

@-webkit-keyframes mymove {
  from {top: 100%;}
  to {top: 0%;}
}


</style>

</head>
<body>
<nav class="navbar navbar-expand-sm  navbar-dark" style="margin-top:-10px;background-color:#34ccff; ">
  <ul class="navbar-nav mr-auto" >
    <li class="nav-item">
      <a class="nav-link" href="/welcome-page">Home</a>
    </li>
  		<li class="nav-item dropdown">
    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">Manage Account </a>
    <div class="dropdown-menu" style="background-color:#34ccff;">
      <a class="dropdown-item" href="/transactions-page" style="color: white;">Deposit/Transfer/Withdraw</a>
      <a class="dropdown-item" href="/transactions-history" style="color: white">Transaction History</a>
      <a class="dropdown-item" href="/password" style="color: white">Change Password</a>
      <div class="dropdown-divider"></div>
      <a class="dropdown-item" href="#">Separated link</a>
    </div>
  </li>
    <li class="nav-item active">
      <a class="nav-link" href="#">Account Details</a>
    </li>
    <!-- <li class="nav-item">
      <a class="nav-link disabled" href="#">Disabled</a>
    </li> -->
  </ul>
  <a style="color: White;" >Signed in as ${name}</a>
   <a class="nav-link" href="/logout" style="">Logout</a>
</nav>
<h1 >Account Details</h1>
<!-- style="margin-left: 20px" align="center" -->
<div id="details" class="container" style="margin-top:3%;position: relative;animation: mymove 0.5s; animation-timing-function:ease;">
	<table class="table table-striped" style="background: lightblue">
    <thead>
      <tr>
      	<th>UserName</th>
      	<th>Password</th>
        <th>Full Name</th>
        <th>Address</th>
        <th>Phone#</th>
        <th>Balance</th>
        
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>${cust.userId }</td>
        <td>${cust.password }</td>
        <td>${cust.custName }</td>
        <td>${cust.custAddress }</td>
        <td>${cust.contactNumber }</td>
        <td>$${String.format("%.2f",cust.balance) }</td>
      </tr>
    
    </tbody>
  </table>
</div>
<footer>
		<div class="fixed-footer" style="background:#34ccff;opacity:70%;" >
		<h4 style="text-align: center;color: black">Copyright © DollarsBank 2020</h4>
		</div >
	</footer>
</body>
</html>