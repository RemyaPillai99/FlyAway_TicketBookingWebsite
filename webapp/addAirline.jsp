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
<title>Add Airline</title>
</head>

<%
AirlineDaoImpl airlineDao = new AirlineDaoImpl();
List<Airline> Alist = airlineDao.showAllAirLine();
request.setAttribute("Alist", Alist);
%>
<body>
	<jsp:include page="/header.jsp" />

	<form action="FlightController" method="post">

		<div class="container">
			<h2>Add Airline</h2>
			<br />
			<div style="color: blue">${messageAirline}</div>
			<table>
				<tr>
					<td><label for="AirlineName"
						class="text-dark font-weight-bold">Airline Name</label></td>
					<td><input name="airlineName" type="text"
						class="form-control " id="airlineName" required="required">
					</td>
				</tr>
			</table>
			<br/>
			<table class="table table-borderless table-striped" width="100%">
				<h2>Airline List</h2>
				<c:forEach items="${Alist}" var="Al">
					<tr>
						<td>${Al.getAirlineName()}</td>
					</tr>
				</c:forEach>
			</table>

			<input class="btn, btn-success btn-lg btn-block" type="submit"
				name="AddAirline" value="Add Airline"> 
				<a href="listFlights.jsp">Back </a>

		</div>
	</form>
</body>
<footer>
	<jsp:include page="/footer.jsp" />
	<style type="text/css">
		.container {
			position: relative;
			z-index: 2;
			width: 400px; 
			margin: 50px auto;
			padding: 20px;
			background: white;
}
</style>
</footer>
</html>