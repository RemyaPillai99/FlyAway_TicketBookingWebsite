<%@page import="model.Flight"%>
<%@page import="dao.FlightDetailsDaoImpl"%>
<%@page import="java.text.ParseException"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="model.IDProof"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Passenger Details</title>
</head>

<%
request.setAttribute("IDProofEnum", IDProof.values());
out.print(session.getAttribute("noOfPassengers"));

String id = request.getParameter("no");

out.print(request.getParameter("date"));
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

String sd = request.getParameter("date");
Date depatureDate = null;
try {
	depatureDate = sdf.parse(sd);

} catch (ParseException e) {
	e.printStackTrace();
}
FlightDetailsDaoImpl flightDetailsDaoImpl = new FlightDetailsDaoImpl();
Flight f = flightDetailsDaoImpl.getFlightDetailsById(Integer.valueOf(request.getParameter("no")), depatureDate,
		request.getParameter("travelClass"));

session.setAttribute("flightObj", f);
%>


<body>
	<jsp:include page="/header.jsp" />
	<div class="container">
		<form action="PassengerController" method="post">
			<table>
				<c:forEach var="i" begin="1" end="${noOfPassengers}">
					<tr>
						<td><h3>Enter Passenger Details :</h3></td>
					</tr>
					<tr>
						<td>First Name:</td>
						<td><input type="text" name="firstName<c:out value="${i}"/>"
							size="30" required="required" /></td>
					</tr>
					<tr>
						<td>Last Name:</td>
						<td><input type="text" name="lastName<c:out value="${i}"/>"
							size="30" required="required" /></td>
					</tr>
					<tr>
						<td>Gender</td>
						<td><input type="radio" value="0"
							name="gender<c:out value="${i}"/>"/>Male <input
							type="radio" value="1" name="gender" />Female</td>
					</tr>
					<tr>
						<td>Email:</td>
						<td><input type="text" name="emailId<c:out value="${i}"/>"
							size="30" /></td>
					</tr>
					<tr>
						<td>Date of Birth:</td>
						<td><input class ="dateClass" type="text" placeHolder = "yyyy-MM-dd" name="dob<c:out value="${i}"/>"
							id="dob" size="30" /></td>
					</tr>
					<tr>
						<td>Identification</td>
						<td><select name="IDProofCategory<c:out value="${i}"/>" >
								<c:forEach items="${IDProofEnum}" var="entry">
									<option>${entry}</option>
								</c:forEach>
						</select> <input type="text" name="IdProof_no<c:out value="${i}"/>"
							size="13.2" /></td>
					</tr>
					<tr>
						<td>Phone Number:</td>
						<td><input type="text" name="phoneNum<c:out value="${i}"/>"
							size="30" /></td>
					</tr>
					<tr>
						<td>Country:</td>
						<td><input type="text" name="country<c:out value="${i}"/>"
							size="30" /></td>
					</tr>
					<tr>
						<td>Address:</td>
						<td><textarea id="address"
								name="address<c:out value="${i}"/>" rows="4" cols="33"></textarea></td>
					</tr>
				</c:forEach>
				
			</table>
			
			<input class="btn, btn-success btn-lg btn-block btn-group-justified" type="submit"
					 value="Save Details">
		</form>
	</div>
</body>
<footer>
	<jsp:include page="/footer.jsp" />
		
	<style type="text/css">
	.container {
		/* width: 50%;
		margin-left: 25%;
		margin-top: 8% */
		position: relative;
		z-index: 2;
		width: auto;
		margin: 50px auto;
		padding: 20px;
		background: white;
	} 
</style>
</footer>
</html>