<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Result Page</title>
</head>
<body>
<jsp:include page="/header.jsp" />
<div class="container">
	<table class ="table table-striped" border="1" width="100%" >  
		<thead class="thead-dark">
			<tr>
				<th>Airline</th><th>Departure date</th><th>Source</th><th>Destination</th><th>Travel Class</th>  
				<th>Fare Per Seat(USD)</th><th>Seats Available</th>
				<th>Flight Duration (HRS)</th><th>Book</th>
			</tr>  
		</thead>
		<c:forEach items="${flightlist}" var="f">
			<tr><td>${f.getAirlineName().getAirlineName()}</td>
				<td>${f.getDepatureDate()}</td>
				<td>${f.getSource().getName()}</td>
				<td>${f.getDest().getName()}</td>  
				<td>${f.getTravelClass()}</td>
				<td>${f.getFare()}</td>
				<td>${f.getavailableSeats()}</td>
				<td>${f.getFlightDuration()}</td>
			
				<td>
					<a href="passengerDetails.jsp?no=${f.getFlightNo()}&date=${f.getDepatureDate()}&travelClass=${f.getTravelClass()}">
						<button type="button" class="btn btn-primary btn-sm">BookFlight</button>
					</a>
				</td> 
			</tr>
		</c:forEach>  
	</table>  
		
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