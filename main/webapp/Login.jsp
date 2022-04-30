<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Login</title>
</head>

<body>
	<c:choose>
       <c:when test="${empty username}">
          <jsp:include page="/headerNoLogout.jsp" />
       </c:when>
       <c:otherwise>
       	<jsp:include page="/header.jsp" />
       </c:otherwise>
     </c:choose>
	
	<div class="container">
		<form method="post" action="LoginController">
			<label for="usrname">Email Address</label>
			 <input type="text"
				id="emailId" name="emailId" required> 
				
			<label for="psw">Password</label>
			<input type="password" id="psw" name="password"
				pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"
				required> 
				
			<input class="btn, btn-success btn-lg .btn-block" type="submit"
				name="Login" value="Login" > 
				
			<a class="action-label btn, .btn-link"
				href="changePassword.jsp">Change Password</a> 
				&ensp;&ensp;&ensp;
			<a class="action-label btn, .btn-link" href="signup.jsp">Sign Up, its free</a>
			<div style="color:red">${errorMessage}</div>
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