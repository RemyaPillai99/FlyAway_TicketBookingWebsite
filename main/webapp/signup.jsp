<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

</head>

<body>
	<h2> Sign In</h2>
	<jsp:include page="/header.jsp" />
		<div class="container">
			<form method="post" action="SignInController">
				<label for="usrname">Email Id </label> <input type="text"
					id="emailId" name="emailId" required> <label for="psw">Password</label>
				<input type="password" id="psw" name="password"
					pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"
					title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters"
					required> 
				
				<input class="btn, btn-success btn-lg .btn-block" type="submit"
				name="SignUp" value="Sign Up" > 
				
				<div style="color:red">${errMessageSignIn}</div>
			</form>
		</div>
	
</body>
<footer>

<jsp:include page="/footer.jsp" />
<style>
/* Style all input fields */
 label, .action-label {
	font-size: x-large;
	color: black;
}

input {
	width: 100%;
	padding: 12px;
	border: 3px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
	margin-top: 6px;
	margin-bottom: 16px;
} 

/* Style the submit button */
/* input[type=submit] {
	font-size: x-large;
	background-color: #04AA6D;
	color: white;
} */

/* Style the container for inputs */
.container {
	/* width: 50%;
	margin-left: 25%;
	margin-top: 8% */
	position: relative;
	z-index: 2;
	width: 500px;
	margin: 50px auto;
	padding: 20px;
	background: white;
	opacity: 90%;
}
 
/* .main-content {
	background-image: url('static/images/background/airplane.jpg');
	background-repeat: no-repeat;
	padding: 20px;
	width: 30%;
	height: 40%;
	margin-left: 30%;
} */
.btn {
	background-color: #04AA6D;
	color: #0099CC;
	border: 2px solid #0099CC;
	border-radius: 6px;
	text-transform: uppercase;
}


</style>
</footer>
</html>
