<%@page import="model.Flight"%>
<%@page import="dao.FlightDetailsDaoImpl"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Flight List </title>

</head>

<%
	FlightDetailsDaoImpl fdao = new FlightDetailsDaoImpl();
	List<Flight> flightList = fdao.showAllFlights();
	request.setAttribute("list",flightList); 
%>

<body>
	<jsp:include page="/header.jsp" />
	<div class="container">
		<h2 class="text-center text-uppercase text-primary font-weight-bold">All Flight Details</h2>
	<form action="FlightController"  method="post">
	
		<a href = "addFlight.jsp"> 
		<button type="button" class="btn btn-primary btn-sm">Add Flight</button>
		</a>
		<a href = "addAirline.jsp"> 
		<button type="button" class="btn btn-primary btn-sm">Add Airline</button>
		</a>
		<a href = "addAirport.jsp"> 
		<button type="button" class="btn btn-primary btn-sm">Add Airport</button>
		</a>
<br/>
<br/>
<table class ="table table-striped" border="1" width="100%" >  
<thead class="thead-dark">
<tr>
<th>Airline</th><th>Flight No<th>Departure date</th><th>Source</th><th>Destination</th><th>TravelClass</th>  
<th>Fare</th><th>Total Seats</th> <th> Booked Seats</th><th>Seats Available</th>
<th>Flight Duration</th><th>Edit</th><th>Delete</th>
</tr> 
</thead>
 
<c:forEach items="${list}" var="f">
<tr><td>${f.getAirlineName().getAirlineName()}</td>
<td>${f.getFlightNo()}</td>
<td>${f.getDepatureDate()}</td>
<td>${f.getSource().getName()}</td>
<td>${f.getDest().getName()}</td>  
<td>${f.getTravelClass()}</td>
<td>${f.getFare()}</td>
<td>${f.getTotalSeats()}</td>  
<td>${f.getBookedSeats()}  </td>
<td>${f.getavailableSeats()}</td>
<td>${f.getFlightDuration()}</td>

<td><a href="editFlightDetails.jsp?no=${f.getFlightNo()}&date=${f.getDepatureDate()}&class=${f.getTravelClass()}">Edit</a></td>  
<td><a href="deletFlightDetails.jsp?no=${f.getFlightNo()}&date=${f.getDepatureDate()}&class=${f.getTravelClass()}">Delete</a></td></tr>  

</c:forEach>  
</table>  
</form>
</div>
<footer>
	<jsp:include page="/footer.jsp" />
	<style type="text/css">
	.container {
		position: relative;
		z-index: 2;
		width: fit-content;
		max-width: fit-content;
		margin: 50px auto;
		padding: 20px;
		background: white;
	} 
</style>
</footer>
</body>
</html>