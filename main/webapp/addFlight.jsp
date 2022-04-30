<%@page import="model.TravelClass"%>
<%@page import="model.City"%>
<%@page import="dao.CityDaoImpl"%>
<%@page import="java.util.List"%>
<%@page import="dao.AirlineDaoImpl"%>
<%@page import="model.Airline"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="dao.FlightDetailsDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Flight</title>
</head>


<%
AirlineDaoImpl airlineDao = new AirlineDaoImpl();
List<Airline> Alist = airlineDao.showAllAirLine();
request.setAttribute("Alist", Alist);

CityDaoImpl cityDao = new CityDaoImpl();
List<City> CityList = cityDao.showAllCity();
request.setAttribute("CityList", CityList);

request.setAttribute("classEnum", TravelClass.values());
%>

</head>
<body>
<jsp:include page="/header.jsp" />
	<div class="container">
<h2>Add Flight Details</h2>
	<form action="FlightController" method="post">
		<table>
			<tr>
				<td>Airline</td>
				<td>
					<!-- <input type="text" name="airlineName" size="30"/></td> --> <select
					name="airlineCategory">
						<c:forEach items="${Alist}" var="al">
							<option value="${al.getAirlineName()}">${al.getAirlineName()}</option>
						</c:forEach>
				</select>
				</td>
			</tr>
			<tr>
				<td>From</td>
				<td>
					<!-- <input type="text" name="source" size="30" /> --> <select
					name="sourceCategory">
						<c:forEach items="${CityList}" var="city">
							<option value="${city.getName()}">${city.getName()}</option>
						</c:forEach>
				</select>
				</td>
			</tr>
			<tr>
				<td>Destination</td>
				<td><select name="destCategory">
						<c:forEach items="${CityList}" var="city">
							<option value="${city.getName()}">${city.getName()}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>Departure Date</td>
				<td><input type="text" name="depatureDate" id="depatureDate"
					size="30" /></td>
			</tr>
			<tr>
				<td>Flight duration</td>
				<td><input type="text" name="flightDuration" size="30" />&ensp;hrs</td>
			</tr>
			<tr>
				<td>Travel Class</td>
				<td>
					<!-- <input type="text" name="travelClass" size="30" /> --> <select
					name="travelClassCategory">
						<c:forEach items="${classEnum}" var="entry">
							<%-- <li>(${entry})</li> --%>
							<option>${entry}</option>
						</c:forEach>
				</select>
				</td>
			</tr>
			<tr>
				<td>Total Seats</td>
				<td><input type="text" name="totalSeats" size="30" /></td>
			</tr>
			<tr>
				<td>Booked seats</td>
				<td><input type="text" name="bookedSeats" size="30" /></td>
			</tr>
			<tr>
				<td>Fare</td>
				<td><input type="text" name="fare" size="30" />&ensp;(USD)</td>
			</tr>




			
		</table>
		<input class="btn, btn-success btn-lg .btn-block" type="submit"
				name="addFlight" value="Add flight to database" > 
	</form>
	</div>
</body>
<footer>
	<jsp:include page="/footer.jsp" />
	<script>
	$(function() {
		$("#depatureDate").datepicker({
			dateFormat: 'yy-mm-dd',
	        changeMonth: true,
	        changeYear: true,
	        inline: true,
			minDate: 0
		});
	});
</script>	

	<style type="text/css">
	.container {
		/* width: 50%;
		margin-left: 25%;
		margin-top: 8% */
		position: relative;
		z-index: 2;
		width: fit-content;
		margin: 50px auto;
		padding: 20px;
		background: white;
	} 
</style>
</footer>
</html>