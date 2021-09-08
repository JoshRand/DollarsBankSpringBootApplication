<html>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<link rel="stylesheet" href="/CSS/style.css">
<meta charset="ISO-8859-1">
<title>Registration page</title>
<style>

div {
	position: relative;
}


td {
	border-right: 5px solid #000;
	border-color: silver;
}

.navbar-nav>li:last-child {
	border: none;
}


.register {
	width: 47%;
	margin: auto;
	margin-top: 1%;
}

</style>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

</head>
<body style="background-color: rgb(88, 88, 88)">

	<div style="background: #34ccff; opacity: 70%">
		<h1 style="text-align: center; color: black">Welcome to the
			Registration Page</h1>
		<h4 style="text-align: center;padding-bottom:10px; color: black">Fill in the required
			fields</h4>
		<br>
<h6 style="text-align:right;color: black; padding:10px;margin-top:-50px"><img class="mail" src="/img/mail.png" style="width:20px;">  DollarsBank@DollarsB.com      <img class="phone" src="/img/phone.png" style="width:20px;">     555-324-3214</h6>

	</div>

	<div class="register"
		style="background: white; border: 10px solid; border-color: lightblue">
		<form:form method="post" modelAttribute="cust"
			style="padding: 20px; text-align:center; margin-left:0">

			<h6 style="margin-left: -150px; color: black">
				<u>Username :</u>
			</h6>
			<form:input path="userId" type="text" placeholder="Enter Username"
				style="margin-left: 10px" required="required"/>

			<h6 style="margin-left: -150px; color: black">
				<u>Password :</u>
			</h6>
			<!-- 1!2Rw41Q34E -->
			<form:input path="password" type="password" placeholder="Enter Password"
				style="margin-left: 10px" pattern="(?=.*\d)(?=.*[!@#$%^&*])(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters"
				required="required"/>
			<h6 style="margin-left: -150px; color: black">
				<u>Full Name :</u>
			</h6>
			<form:input path="custName" type="text"
				placeholder="Enter First Name" style="margin-left: 10px" required="required"/>
			<h6 style="margin-left: -150px; color: black">
				<u>Address :</u>
			</h6>
			<form:input path="custAddress" type="text"
				placeholder="Enter Address" style="margin-left: 10px" />
			<h6 style="margin-left: -150px; color: black">
				<u>Number :</u>
			</h6>
			<form:input path="contactNumber" id="mobile" type="tel"
				pattern="[0-9]{3}-[0-9]{3}-[0-9]{4}"
				placeholder="222-222-2222" style="margin-left: 10px" />
			<h6 style="margin-left: -150px; color: black">
				<u>Initial Deposit :</u>
			</h6>
			<form:input path="balance" type="number" min="0" step="any"
				placeholder="Enter Initial Balance" style="margin-left: 10px" required="required"/>


			<br>
			<br>
			<input type="submit" class="btn btn-info" style="margin-left: 0px" />

			<br>
			<br>
			<a style="margin-left: 0px; color: black">Already have an
				account?</a>
			<a href="login" style="margin-left: 10px; color: blue">Login Here</a><br>
			
		</form:form>
	</div>
	<%
		Object param = request.getAttribute("errorMessage");
	if (param == null)
	{
	%>
	<%
		} else
	{
	%>
	<font color="red">[${errorMessage}]</font>
	<%
		}
	%>
	<footer>
		<div class="fixed-footer" style="background: #34ccff; opacity: 70%;">
			<h4 style="text-align: center; color: black">Copyright ©
				DollarsBank 2020</h4>
		</div>
	</footer>
</body>
</html>