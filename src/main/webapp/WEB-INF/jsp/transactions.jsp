<html>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>

<title>Transactions Page</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  
<style>
<c:url value="/img/gp.png" var = "gp" />
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
h1 {
  position: relative;
  animation: mymove 0.5s;
  animation-timing-function:ease;
  text-align: center;
  color:black;
}
h3 {
  position: relative;
  animation: mymove 0.5s;
  animation-timing-function:ease;
  text-align: center;
  color:black;
}

@-webkit-keyframes mymove {
  from {left: 100%;}
  to {left: 0%;}
}
div{

}

.navbar-nav>li {
	border-right: 1px solid #000;
	border-bottom: 1px solid #000;
	border-color: white;
}
td {
	border-right: 5px solid #000;
	border-color: silver;
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
    
.buttons {
  	width:47%;
    margin:auto;
    margin-top:1%;
  }
  .transactions {
  	width:47%;
    margin:auto;
    margin-top:1%;
  }
.button{
  	align-content:center;
  	 margin:auto;
  }
</style>

</head>

<body>

<c:set var="name" value="${name}" scope="request"/>

<nav class="navbar navbar-expand-sm  navbar-dark" style="margin-top:-10px;background-color:#34ccff; ">
  <ul class="navbar-nav mr-auto" >
    <li class="nav-item">
      <a class="nav-link" href="/welcome-page">Home</a>
    </li>
  		<li class="nav-item active dropdown">
    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">Manage Account </a>
    <div class="dropdown-menu" style="background-color:#34ccff;">
      <a class="dropdown-item" href="/transactions-page" style="color: white;">Deposit/Transfer/Withdraw</a>
      <a class="dropdown-item" href="/transactions-history?name=${name}" style="color: white">Transaction History</a>
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

<h1 >Welcome to Transactions, ${name}!</h1>
<h3>Current Balance ${balance}</h3>
<%String option = "default";%>
<div class="buttons" style="background:white;border: 10px solid;border-color: lightblue">

<button  class="btn btn-info" onclick="showDeposit()" style="background: #34ccff">Deposit</button>
<button class="btn btn-info" onclick="showWithdraw()" style="background: #34ccff">Withdraw</button>
<button class="btn btn-info" onclick="showTransfer()"style="background: #34ccff">Transfer</button>
</div>
<div class="transactions" style="background:white;border: 10px solid;border-color: lightblue">
	<script>
		var showDeposit = function(){
			  document.getElementById("depositForm").style.display = '';
			  document.getElementById("withdrawForm").style.display = 'none';
			  document.getElementById("transferForm").style.display = 'none';
			  
			}
		var showWithdraw = function(id){
			 document.getElementById("depositForm").style.display = 'none';
			  document.getElementById("withdrawForm").style.display = '';
			  document.getElementById("transferForm").style.display = 'none';
			  
			}
		var showTransfer = function(id){
			 document.getElementById("depositForm").style.display = 'none';
			  document.getElementById("withdrawForm").style.display = 'none';
			  document.getElementById("transferForm").style.display = '';			  
			}
		
	</script>
	
	<form:form  id="depositForm" method="post" style="display:none">
	<h4 style="text-align:center">How much are you depositing?</h4>
	<input type="number" step="any" min="0" name="amount" placeholder="Amount" required/>
	<input type="text" name="name" value="${name}" style="display:none" />
	<input type="text" name="option" value="deposit" style="display:none" />
	<input type="text" name="transferTo" value="" style="display:none" />
	<input type="submit" class= "btn btn-info"/>
	</form:form>
	
	<form:form  id="withdrawForm" action="" style="display:none">
	<h4 style="text-align:center">How much are you withdrawing?</h4>
	<input type="number" step="any" min="0" name="amount" placeholder="Amount" required/>
	<input type="text" name="name" value="${name}" style="display:none" />
	<input type="text" name="option" value="withdraw" style="display:none" />
	<input type="text" name="transferTo" value="" style="display:none" />
	<input type="submit" class= "btn btn-info"/>
	</form:form>
	
	<form:form  id="transferForm" action="" style="display:none">
	<h4 style="text-align:center">How much do you want to transfer?</h4>
	<input type="number" step="any" min="0" name="amount" placeholder="Amount" required/>
	<h4 style="text-align:center">Who do you want to transfer to?</h4>
	<input type="text" name="name" value="${name}" style="display:none" />
	<input type="text" name="option" value="transfer" style="display:none" />
	<input type="text" name="transferTo"  style="display:" />
	<input type="submit" class= "btn btn-info"/>
	</form:form>
	
	
		<h6>Please Select an option!  ${message}</h6>
		
		
</div>





	<footer>
		<div class="fixed-footer" style="background:#34ccff;opacity:70%;" >
		<h4 style="text-align: center;color: black">Copyright © DollarsBank 2020</h4>
		</div >
	</footer>
</body>

</html>