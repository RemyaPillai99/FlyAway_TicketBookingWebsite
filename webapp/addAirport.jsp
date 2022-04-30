<%@page import="model.City"%>
<%@page import="dao.CityDaoImpl"%>
<%@page import="model.Airline"%>
<%@page import="java.util.List"%>
<%@page import="dao.AirlineDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Airport</title>
</head>

<%
CityDaoImpl cityDao = new CityDaoImpl();
List<City> CityList = cityDao.showAllCity();
request.setAttribute("CityList", CityList);
%>
<body>
	<jsp:include page="/header.jsp" />
	
	<form action="FlightController" method="post">
		
	<div class="container">
	<h2>Add Airport Location </h2>
		
	<br/>
	<div style="color: blue">${messageAirport}</div>
	<table>
	<tr>
	<td>
	
		<label for="AirPortName" class="text-dark font-weight-bold">Airport Name</label> 
		</td>
		<td>
		<input name="airportName" type="text" class="form-control " 
				id="airportName" required="required">
		
						
	</td>
	</tr>
	
	</table>
	<br/>
<input class="btn, btn-success btn-lg btn-block" type="submit"
						name="AddAirport" value="Add Airport">
	
	<br/>			
<table class ="table table-borderless table-striped"  width="100%" > 
<h2> AirPort List</h2>
<c:forEach items="${CityList}" var="city">
<tr>
	<td>${city.getName()}
	</td>
</tr>
</c:forEach>
</table>
<a href="listFlights.jsp">Back</a>


	<%-- <a href="}&travelClass=${">
				<button type="button" class="btn btn-primary btn-sm">BookFlight</button>
			</a> --%>
			
		
	</div>
</form>
</body>
<footer>
	<jsp:include page="/footer.jsp" />
	<style type="text/css">
	.container {
		position: relative;
		z-index: 2;
		width: 400px;/* fit-content; */
		margin: 50px auto;
		padding: 20px;
		background: white;
	} 
</style>
</footer>
</html>