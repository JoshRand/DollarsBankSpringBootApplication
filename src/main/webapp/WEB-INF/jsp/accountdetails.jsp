<html>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>

<meta charset="ISO-8859-1">
<title>account details</title>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>


<style>
body {
 /*black or silver, which is best*/
  /*  background-color: rgb(88, 88, 88);*/
  background-color: rgb(88, 88, 88); /* For browsers that do not support gradients */
  background-image: linear-gradient(-45deg,rgb(88, 88, 88),black); /* Standard syntax (must be last) */
  background-size: 800%;
  -webkit-animation-name: change;
  -webkit-animation-duration: 15s;
  -webkit-animation-iteration-count: infinite;
  -webkit-animation-direction: alternate;
 
}
@-webkit-keyframes mymove {
  from {top: 100%;}
  to {top: 0%;}
}
div{
   position: relative;
  animation: mymove 0.5s;
  animation-timing-function:ease;
  
 
}
@-webkit-keyframes change {
	
	  from {
   background-position: 20%;
 }
 to {
   background-position: 60%;
 }
}

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

</style>

</head>
<body>
<%-- <jsp:attribute name="username" value="${name }"></jsp:attribute> --%>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item"><a class="nav-link" method="post"
				href="/welcome-page">Home</a></li>
			<li class="nav-item"><a class="nav-link" href="/list-todos">View
					Todos</a></li>
			<li class="nav-item active"><a class="nav-link disabled" href="">Account
					Details</a></li>
			<!-- <li class="nav-item"><a class="nav-link disabled" href="#">Disabled</a>
			</li> -->

		</ul>
		<a style="color: silver">Signed in as ${name}</a> <a
			class="nav-link" href="/logout">Logout</a>
	</nav>
	<br/>

<div class="container">
	<table class="table table-dark table-striped">
    <thead>
      <tr>
      	<th>UserName</th>
      	<th>Password</th>
        <th>Firstname</th>
        <th>Lastname</th>
        
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>${user.uName }</td>
        <td>${user.password }</td>
        <td>${user.firstName }</td>
        <td>${user.lastName}</td>
      </tr>
    
    </tbody>
  </table>
</div>

</body>
</html>