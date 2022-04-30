<%@page import="model.Flight"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Booking Confirmation </title>
</head>
<body>
<jsp:include page="/header.jsp" />
	<div class="container">
	<h2>Booking Confirmed</h2>
		<table class ="table table-borderless table-striped"  width="100%" > 
	<tr><th>Booking Id </th><th>Flight no </th><th>Airline</th><th>Departure date</th><th>Source</th><th>Destination</th><th>Travel Class</th>
	<th>Number of Passengers</th>  
	<th>Total fare</th>
	
	</tr>  
	<tr>
	<td>${bookinId} </td>
	<td>${flightObj.getFlightNo()}</td>
	<td>${flightObj.getAirlineName().getAirlineName()}</td>
	<td>${flighObj.getDepatureDate()}</td>
	<td>${flighObj.getSource().getName()}</td>
	<td>${flighObj.getDest().getName()}</td>  
	<td>${flighObj.getTravelClass()}</td>
	<td>${noOfPassengers} </td>
	<td>${totalFare}</td>
	</tr>
	
	</table>
	<table class ="table table-borderless table-striped"  width="100%" > 
	<tr>
	<th>Name</th>
	<th>Email id </th>
	<th>Contact Number</th>
	</tr>
	<c:forEach items="${passengerList}" var="p">
	<tr>
	<td>${p.getFirstName()}</td>
	<td>${p.getEmailId()}</td>
	<td>${p.getPhoneNum()}</td>
	</tr>
	</c:forEach>
	  
	</table>
	
		<a href="searchFlights.jsp">
				<button type="button" class="btn btn-primary btn-lg">Continue shopping</button>
		</a>
		
</div>
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
</body>
</html>