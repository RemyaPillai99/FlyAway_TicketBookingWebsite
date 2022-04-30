<%@page import="model.TravelClass"%>
<%@page import="model.City"%>
<%@page import="dao.CityDaoImpl"%>
<%@page import="model.Airline"%>
<%@page import="java.util.List"%>
<%@page import="dao.AirlineDaoImpl"%>
<%@page import="model.Flight"%>
<%@page import="dao.FlightDetailsDaoImpl"%>
<%@page import="java.text.ParseException"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Flight </title>
</head>
<%
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
			request.getParameter("class"));
	
	%>
	
<body>
	<jsp:include page="/header.jsp" />
	<div class="container">
	
	<form action="FlightController" method="post">
	<h2>Delete flight Details</h2>
		<table class ="table table-borderless table-striped"  width="100%" > 
	
			<tr>
				<td>Flight no</td>
				<td>
					<input type="text" name="flightNo" size="20" value = "<%= f.getFlightNo() %>"readOnly />
				</td> 
			</tr>
			<tr>
				<td>Airline</td>
				<td>
					<input type="text" name="airLineName" size="20" value = "<%= f.getAirlineName().getAirlineName() %>"readOnly />
					 
				</td>
			</tr>
			<tr>
				<td>From</td>
				<td>
					<input type="text" name="source" size="20" value = "<%= f.getSource().getName() %>"readOnly />
				</td>
			</tr>
			<tr>
				<td>Destination</td>
				<td>
					<input type="text" name="source" size="20" value = "<%= f.getDest().getName()%>"readOnly />
				</td>
			</tr>
			<tr>
				<td>Departure Date</td>
				<td><input type="text" name="depatureDate" id="depatureDate"
					size="20" value = "<%=f.getDepatureDate() %>" readonly /></td>
			</tr>
			<tr>
				<td>Flight duration</td>
				<td><input type="text" name="flightDuration" size="20"
					value="<%=f.getFlightDuration()%>" readOnly/> hrs</td>
			</tr>
			<tr>
				<td>Travel Class</td>
				<td>
					 <input type="text" name="travelClass" size="20" value= "<%= f.getTravelClass()%>" readonly />
					
				</td>
			</tr>
			<tr>
				<td>Total Seats</td>
				<td><input type="text" name="totalSeats" size="20"
					value="<%=f.getTotalSeats()%>" readOnly/></td>
			</tr>
			<tr>
				<td>Booked seats</td>
				<td><input type="text" name="bookedSeats" size="20"
					value="<%=f.getBookedSeats()%>" readOnly/></td>
			</tr>
	
			<tr>
				<td>Fare</td>
				<td><input type="text" name="fare" size="20"
					value="<%=f.getFare()%>" readOnly/> USD</td>
			</tr>

		</table>
		<input class="btn, btn-success btn-lg btn-block btn-group-justified" type="submit"
				name="deleteFlight"	 value="Confirm Deletion">
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