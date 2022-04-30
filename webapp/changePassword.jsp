<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Change Password</title>

</head>
<script type="text/javascript">
var check = function() {
  if (document.getElementById('password').value ==
    document.getElementById('confirm_password').value) {
    document.getElementById('message').style.color = 'green';
    document.getElementById('message').innerHTML = 'Password matching';
  } else {
    document.getElementById('message').style.color = 'red';
    document.getElementById('message').innerHTML = 'Password not matching';
  }
}
  </script>
<body>
<jsp:include page="/header.jsp" />
<div class="container">
	<h2>  Change Password </h2>
	  <form method="post" action="ChangePassword">
	    <label for="usrname">Email Address </label>
	    <input type="text" id="emailId" name="emailId" required>
	
	    <label for="psw">Password</label>
	    <input type="password" id="password" name="password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" 
	    	title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" 
	    required>
	    <label for="psw">Confirm Password</label>
	    <input type="password" id="confirm_password" name="confirm_password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" 
	    	title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" 
	    required onkeyup='check();'>
	    <span id='message'></span>
	      
	     <input class="btn, btn-success btn-lg .btn-block" type="submit"
			name="Reset" value="Reset Password" > 
			
		<a class="action-label btn, .btn-link"
			href="homePage.jsp">Back to Home Page</a> 
	     <div style="color:green">${changePasswordMsg}</div>
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